package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static DBAccess.CupcakeMapper.getBottom;
import static DBAccess.CupcakeMapper.getTopping;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        ServletContext servletContext = request.getServletContext();

        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        Useres useres = LogicFacade.login( email, password );

        HttpSession session = request.getSession();

        session.setAttribute( "user", useres);
        session.setAttribute( "role", useres.getRole() );
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke


        //Denne kode viser varianterne
        try {
            servletContext.setAttribute("toppingList", (ArrayList<BottomAndTopping>) getTopping());
            servletContext.setAttribute("bottomList", (ArrayList<BottomAndTopping>) getBottom());
        } catch (CupcakeException e) {
            e.printStackTrace();
        }



        return "WEB-INF/Forside";
    }

}
