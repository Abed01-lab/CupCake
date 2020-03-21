package PresentationLayer;

import FunctionLayer.BottomAndTopping;
import FunctionLayer.CupCake;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class DeleteCupcake extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {

        HttpSession session = request.getSession();

        int rowNumber = Integer.parseInt(request.getParameter("rowNumber"));

        ArrayList<CupCake> kurvListe = (ArrayList<CupCake>) session.getAttribute("kurvListe");

        kurvListe.remove(rowNumber);


        return "/WEB-INF/kurv";


    }
}
