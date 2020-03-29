package FunctionLayer;

import DBAccess.Connector;

import java.sql.*;
import java.util.ArrayList;

import static DBAccess.CupcakeMapper.getAllOrders;
import static DBAccess.CupcakeMapper.getOrders;
import static DBAccess.UsersMapper.addUserBalance;
import static DBAccess.UsersMapper.createUserList;
import static DBAccess.CupcakeMapper.deleteOrder;

public class testTwo {


    public static void main(String[] args) throws CupcakeException {
        System.out.println("eko");

        deleteOrder(6);

        //ArrayList<Order> orderList = getAllOrders();
        //for(int i = 0; i <orderList.size(); i++){
          //  System.out.println(orderList.get(i));
    //    }

        ArrayList<OverOrder> orderList = getOrders();
        for(int i = 0; i < orderList.size(); i++){
            System.out.println(orderList.get(i));
        }
        System.out.println(orderList.get(1).getOrderline().get(0).getBottom());
        System.out.println(orderList.size());
    }


    }



