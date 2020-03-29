package PresentationLayer;

import FunctionLayer.CupcakeException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OverOrder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static DBAccess.CupcakeMapper.deleteOrder;
import static DBAccess.CupcakeMapper.getOrders;

public class DeleteOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        HttpSession session = request.getSession();
        int rowId = Integer.parseInt(request.getParameter("rowId"));
        try {
            deleteOrder(rowId);
        } catch (CupcakeException e) {
            e.printStackTrace();
        }
        try {
            ArrayList<OverOrder> orderList = getOrders();
            session.setAttribute("listOfOrders", orderList);
        } catch (CupcakeException e) {
            e.printStackTrace();
        }
        return "WEB-INF/adminListOfOrdersTwo";
    }
}
