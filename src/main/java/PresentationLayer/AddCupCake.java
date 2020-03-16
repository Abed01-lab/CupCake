package PresentationLayer;

import FunctionLayer.CupCake;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddCupCake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        ServletContext servletContext = request.getServletContext();

        String bund = request.getParameter("bundTopping");
        String top = request.getParameter("topTopping");
        String antal = request.getParameter("antal");

        CupCake cupcake = new CupCake("chokolade", "chokolade", 1);
        CupCake cupCake1 = new CupCake("chokolade", "chokolade", 1);
        CupCake cupCake2 = new CupCake("chokolade", "chokolade", 1);

        try {
            if ((List<CupCake>) servletContext.getAttribute("kurvListe") == null) {
                List<CupCake> kurvListe = new ArrayList<>();
                kurvListe.add(cupcake);
                kurvListe.add(cupCake1);
                kurvListe.add(cupCake2);
                servletContext.setAttribute("kurvListe", kurvListe);
            }

            CupCake cupCake = new CupCake(bund, top, Integer.parseInt(antal));
            ((List<CupCake>) servletContext.getAttribute("kurvListe")).add(cupCake);

            for (CupCake c: ((List<CupCake>) servletContext.getAttribute("kurvListe"))) {
                System.out.println(c.toString());
            }

        } catch (Exception e){
            System.out.println("kunne ikke tilføge cupcake til Kurv");
            request.setAttribute("besked", "noget gik galt");
            return "index";
        }


        return "/WEB-INF/" + "kurv";
    }
}
