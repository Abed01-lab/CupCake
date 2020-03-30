package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The purpose of Connector is to...
 *
 * @author kasper
 */
public class Connector {

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;


    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
            setDBCredentials();
            Class.forName("com.mysql.cj.jdbc.Driver");
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

    public static void setDBCredentials() {

        String deployed = System.getenv("DEPLOYED");

        if (deployed != null) {
            // PROD: HENT VARIABLER FRA setenv.sh
            URL = System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
        } else {
            //LOCALHOST
            URL = "jdbc:mysql://localhost:3306/cupcakeproject";
            USERNAME = "root";
            PASSWORD = "";
        }
    }
}
