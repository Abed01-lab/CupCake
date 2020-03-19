package PresentationLayer;

import FunctionLayer.CupCake;
import FunctionLayer.CupcakeException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Useres;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static DBAccess.CupcakeMapper.insertOrderLine;

public class Buy extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        ArrayList<CupCake> cupCakes = (ArrayList<CupCake>) session.getAttribute("kurvListe");
        Useres user = (Useres) session.getAttribute("user");
        try {
            insertOrderLine(user,cupCakes);
        } catch (CupcakeException e) {
            System.out.println("insert init failed");
            e.printStackTrace();
        }
        return "WEB-INF/kundeBestillingBekræftigelse";
    }
}
