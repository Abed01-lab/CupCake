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


        if ((List<CupCake>)servletContext.getAttribute("kurv") == null){
            List<CupCake> kurv = new ArrayList<>();
            servletContext.setAttribute("kurv", kurv);
        }

        CupCake cupCake = new CupCake(bund, top);

        for (CupCake a : ((List<CupCake>) servletContext.getAttribute("kurv"))) {
            if (cupCake.getBund() == a.getBund()){
                if (cupCake.getTop() == a.getTop()){
                    a.plusAntal();
                    return "/WEB-INF/" + "kurv";
                }
            }
        }

        ((List<CupCake>) servletContext.getAttribute("kurv")).add(cupCake);
        return "/WEB-INF/" + "kurv";
    }
}
