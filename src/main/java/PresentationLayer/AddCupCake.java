package PresentationLayer;

import FunctionLayer.CupCake;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddCupCake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        String bund = request.getParameter("bundTopping");
        String top = request.getParameter("topTopping");
        String antal = request.getParameter("antal");

        System.out.println(antal);
        if (antal == ""){
            System.out.println("if statement virker");
            request.setAttribute("besked", "Du har ikke valgt antal");
            return "WEB-INF/Forside";
        }

        try {
            if ((List<CupCake>) session.getAttribute("kurvListe") == null) {
                List<CupCake> kurvListe = new ArrayList<>();
                session.setAttribute("kurvListe", kurvListe);
                System.out.println("kurvlist init");
            }

            CupCake cupCake = new CupCake(bund, top, Integer.parseInt(antal));

            ((List<CupCake>) session.getAttribute("kurvListe")).add(cupCake);

            System.out.println("cupcake init");

        } catch (Exception e){
            System.out.println("kunne ikke tilføge cupcake til Kurv");
            request.setAttribute("besked", "noget gik galt");
            return "index";
        }


        return "/WEB-INF/" + "kurv";
    }
}
