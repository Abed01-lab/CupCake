package PresentationLayer;

import FunctionLayer.CupcakeException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import DBAccess.CupcakeMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static DBAccess.CupcakeMapper.getAllOrders;

public class GoToOrders extends Command {



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        try {
            ArrayList<Order> orderList = getAllOrders();
            session.setAttribute("listOfOrders", orderList);
        } catch (CupcakeException e) {
            e.printStackTrace();
        }

        return "/WEB-INF/adminListOfOrders";
    }
}