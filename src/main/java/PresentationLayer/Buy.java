package PresentationLayer;

import FunctionLayer.CupCake;
import FunctionLayer.CupcakeException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Useres;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

import static DBAccess.CupcakeMapper.insertOrderLine;
import static DBAccess.UsersMapper.updateUserBalance;

public class Buy extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        ArrayList<CupCake> cupCakes = (ArrayList<CupCake>) session.getAttribute("kurvListe");
        Useres user = (Useres) session.getAttribute("user");
        try {
            System.out.println("virker");
            insertOrderLine(user,cupCakes);
        } catch (CupcakeException e) {
            System.out.println("insert init failed");
            e.printStackTrace();
        }
        int totalSum = 0;
        for (int i = 0; i < cupCakes.size(); i++) {
            totalSum += cupCakes.get(i).getSum();
        }
        try {
            updateUserBalance(totalSum, user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ((ArrayList<CupCake>) session.getAttribute("kurvListe")).clear();

        return "WEB-INF/kundeBestillingBekræftigelse";
    }
}
