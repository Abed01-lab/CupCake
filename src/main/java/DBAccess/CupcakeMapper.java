package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class CupcakeMapper {

    public static List<BottomAndTopping> getBottom () throws CupcakeException {
        ArrayList<BottomAndTopping> bottom = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcakeproject.bottom";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ResultSet rs = ps.executeQuery();
            while (rs.next() ) {
                int id = rs.getInt("bottomId");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                BottomAndTopping bottomAndToppingInstance = new BottomAndTopping(id, name, price);
                bottom.add(bottomAndToppingInstance);
            }
            return bottom;
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CupcakeException(ex.getMessage());
        }
    }


    public static List<BottomAndTopping> getTopping () throws CupcakeException {
        ArrayList<BottomAndTopping> topping = new ArrayList<>();
        try {
        Connection con = Connector.connection();
        String SQL = "SELECT * FROM cupcakeproject.topping";
        PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ResultSet rs = ps.executeQuery();
            while (rs.next() ) {
                int id = rs.getInt("toppingId");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                BottomAndTopping bottomAndTopping = new BottomAndTopping(id, name, price);
                topping.add(bottomAndTopping);
            }
            return topping;
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CupcakeException(ex.getMessage());
        }
    }

    public void insertOrder (){

    }

    public List getOrder(){
        ArrayList<CupCake> orderList = new ArrayList<CupCake>();
        return orderList;
    }

}
