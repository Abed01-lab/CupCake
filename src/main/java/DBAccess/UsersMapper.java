package DBAccess;

import FunctionLayer.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UsersMapper {

    public static void createUser( Useres useres) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO customer (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, useres.getEmail() );
            ps.setString( 2, useres.getPassword() );
            ps.setString( 3, useres.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            useres.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static Useres login(String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT customerId, role FROM customer "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "customerId" );
                Useres useres = new Useres( email, password, role );
                useres.setId( id );
                return useres;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<ReturnedUseres> createUserList() throws LoginSampleException {
        ArrayList<ReturnedUseres> users = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcakeproject.customer "
                    + "WHERE role = 'customer'";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customerId");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                int balance = rs.getInt("balance");
                ReturnedUseres user = new ReturnedUseres(id, email, password, role, balance);
                users.add(user);

            }
            return users;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void addUserBalance(int balanceToAdd, String email) throws SQLException {
        int balance = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcakeproject.customer "
                    + "WHERE email = '" + email + "'";

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                balance = rs.getInt("balance");
            }

            balance = balance + balanceToAdd;

            String SQLTwo = "UPDATE customer SET balance = '" + balance + "' WHERE email = '" + email + "'";
            ps = con.prepareStatement(SQLTwo, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex){
            throw new SQLException(ex.getMessage());
        }
    }

    public static ArrayList<OverCustomer> getCustomers() throws CupcakeException {
        ArrayList<OverCustomer> customers = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcakeproject.customer";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int customerId = rs.getInt("customerId");
                String email = rs.getString("email");
                OverCustomer customer = new OverCustomer(customerId, email);
                String SQL2 = "SELECT * FROM cupcakeproject.orders " +
                        "WHERE customerId = '" + customerId + "'";
                PreparedStatement ps2 = con.prepareStatement(SQL2, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs2 = ps2.executeQuery();
                while(rs2.next()){
                    int ordersId = rs2.getInt("ordersId");
                    OverOrder newOverOrder = new OverOrder(customerId, ordersId);
                    customer.getOrders().add(newOverOrder);
                }
                customers.add(customer);
            }
            return customers;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CupcakeException(ex.getMessage());
        }
    }


}
