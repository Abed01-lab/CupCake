package FunctionLayer;

import DBAccess.Connector;

import java.sql.*;
import java.util.ArrayList;

import static DBAccess.CupcakeMapper.getAllOrders;
import static DBAccess.CupcakeMapper.getOrders;
import static DBAccess.CupcakeMapper.deleteOrder;
import static DBAccess.UsersMapper.*;

public class testTwo {


    public static void main(String[] args) throws CupcakeException {
        System.out.println("eko");


        //ArrayList<Order> orderList = getAllOrders();
        //for(int i = 0; i <orderList.size(); i++){
          //  System.out.println(orderList.get(i));
    //    }

        try {
            System.out.println(getBalance(2));
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }
    }


    }



