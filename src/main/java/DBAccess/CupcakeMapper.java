package DBAccess;

import FunctionLayer.BottomAndTopping;
import FunctionLayer.CupCake;
import FunctionLayer.CupcakeException;
import FunctionLayer.Useres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class CupcakeMapper {

    public static List<BottomAndTopping> getBottom() throws CupcakeException {
        ArrayList<BottomAndTopping> bottom = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcakeproject.bottom";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bottomId");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                BottomAndTopping bottomAndToppingInstance = new BottomAndTopping(id, name, price);
                bottom.add(bottomAndToppingInstance);
            }
            return bottom;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CupcakeException(ex.getMessage());
        }
    }


    public static List<BottomAndTopping> getTopping() throws CupcakeException {
        ArrayList<BottomAndTopping> topping = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcakeproject.topping";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("toppingId");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                BottomAndTopping bottomAndTopping = new BottomAndTopping(id, name, price);
                topping.add(bottomAndTopping);
            }
            return topping;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CupcakeException(ex.getMessage());
        }
    }

    public static void insertOrderLine(Useres user, ArrayList<CupCake> cupcakeList) throws CupcakeException {
        int orderId = insertOrder(user);
        try {
            System.out.println("virker");
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcakeproject.ordersline (ordersId, quantity, sumNumber, toppingId, bottomId) VALUES (?,?,?,?, ?)";
            for (CupCake cup : cupcakeList) {
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, orderId);
                ps.setInt(2, cup.getQuantity());
                ps.setInt(3, cup.getSum());
                ps.setInt(4, cup.getTopping().getId());
                ps.setInt(5, cup.getBottom().getId());
                ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("insert to orderline db failed");
            throw new CupcakeException(ex.getMessage());
        }
    }



    public static int insertOrder(Useres user) throws CupcakeException {
        int id = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcakeproject.orders (customerId) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getId());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            id = ids.getInt(1);
            return id;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("insert to orders database failed");
            throw new CupcakeException(ex.getMessage());
        }
    }
}
