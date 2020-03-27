package PresentationLayer;

import FunctionLayer.CupcakeException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OverCustomer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static DBAccess.CupcakeMapper.getAllOrders;
import static DBAccess.UsersMapper.getCustomers;

public class GoToAddBalance extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        return "WEB-INF/adminLoggetInd";
    }

}