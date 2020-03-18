package DBAccess;

import FunctionLayer.*;

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

    public static void insertOrderLine(Useres user, List<CupCake> cupcakeList) throws CupcakeException {
        try {
            insertOrder(user);
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcakeproject.ordersline (ordersId, quantity, sumNumber, toppingId, bottomId) VALUES (?,?,?,?, ?)";
            for (CupCake cup : cupcakeList) {
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, user.getId());
                ps.setInt(2, cup.getQuantity());
                ps.setInt(3, cup.getSum());
                ps.setInt(4, cup.getTopping().getId());
                ps.setInt(5, cup.getBottom().getId());
                ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CupcakeException(ex.getMessage());
        }
    }

    public static void getOrderLine() {

    }


    public static void insertOrder(Useres user) throws CupcakeException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cupcakeproject.orders (customerId) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getId());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CupcakeException(ex.getMessage());
        }
    }

    public static int getOrderId(Useres user) throws CupcakeException {
        int id = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT ordersId FROM cupcakeproject.orders WHERE customerId = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet ids = ps.executeQuery();
            ids.next();
            id = ids.getInt(1);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CupcakeException(ex.getMessage());
        }
        return id;
    }


}
