package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

    private static final String URL = "jdbc:mysql://localhost:3306/cupcakeproject";
    private static final String USERNAME = "root";
<<<<<<< HEAD
    private static final String PASSWORD = "Fokken9797";
=======
<<<<<<< HEAD
    private static final String PASSWORD = "Mathias1501clausen";
=======
    private static final String PASSWORD = "";
>>>>>>> 41cff53b3306ae35ea3549038b9d04bc084ae210
>>>>>>> c0a166a46bdad500b318ab23cf12af224c88212d

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

}
