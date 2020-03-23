package PresentationLayer;

import FunctionLayer.CupcakeException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import DBAccess.CupcakeMapper;
import FunctionLayer.OverOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static DBAccess.CupcakeMapper.getAllOrders;
import static DBAccess.CupcakeMapper.getOrders;

public class GoToOrdersTwo extends Command {



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        try {
            ArrayList<OverOrder> orderList = getOrders();
            session.setAttribute("listOfOrders", orderList);
        } catch (CupcakeException e) {
            e.printStackTrace();
        }

        return "/WEB-INF/adminListOfOrdersTwo";
    }
}