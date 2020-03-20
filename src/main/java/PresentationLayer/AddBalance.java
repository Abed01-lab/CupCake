package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.ReturnedUseres;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

import static DBAccess.UsersMapper.addUserBalance;
import static DBAccess.UsersMapper.createUserList;

public class AddBalance extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();

        String email = (String)request.getParameter("returnEmail");
        int balance = (Integer)Integer.parseInt(request.getParameter("balanceAmount"));

        try {
            addUserBalance(balance, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<ReturnedUseres> list = null;
        try {
            list = createUserList();
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }
        session.setAttribute("customerList", list);

        request.setAttribute("besked", "   Dit beløb på " + balance + " er blevet indsat.");
        return "WEB-INF/adminLoggetInd";
    }
}
