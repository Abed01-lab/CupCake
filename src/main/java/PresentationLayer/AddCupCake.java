package PresentationLayer;

import FunctionLayer.BottomAndTopping;
import FunctionLayer.CupCake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Useres;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static DBAccess.CupcakeMapper.insertOrderLine;

public class AddCupCake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();

        int bottom = Integer.parseInt(request.getParameter("bottom"));
        int topping = Integer.parseInt(request.getParameter("topping"));
        String quantity = request.getParameter("quantity");

        if (quantity == ""){
            request.setAttribute("besked", "Du har ikke valgt antal");
            return "WEB-INF/Forside";
        }

        try {
            if ((List<CupCake>) session.getAttribute("kurvListe") == null) {
                ArrayList<CupCake> kurvListe = new ArrayList<>();
                session.setAttribute("kurvListe", kurvListe);
            }

            CupCake cupCake = new CupCake(((ArrayList<BottomAndTopping>) servletContext.getAttribute("bottomList")).get(bottom), ((ArrayList<BottomAndTopping>) servletContext.getAttribute("toppingList")).get(topping), Integer.parseInt(quantity));
            ((List<CupCake>) session.getAttribute("kurvListe")).add(cupCake);


        } catch (Exception e){
            System.out.println("kunne ikke tilføge cupcake til Kurv");
            request.setAttribute("besked", "noget gik galt");
            return "index";
        }


        return "/WEB-INF/kurv";
    }
}
