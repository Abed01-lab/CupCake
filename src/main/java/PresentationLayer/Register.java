package PresentationLayer;

import FunctionLayer.ReturnedUseres;
import FunctionLayer.Useres;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static DBAccess.UsersMapper.createUserList;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        ArrayList<ReturnedUseres> users = createUserList();

       for(int i = 0; i < users.size(); i++){
           if(users.get(i).getEmail().equals(email)){
               throw new LoginSampleException("Der findes allerede en bruger med denne email.");
           }
       }
       if ( password1.equals( password2 ) ) {
            Useres useres = LogicFacade.createUser( email, password1 );
            HttpSession session = request.getSession();

            session.setAttribute("email",email);
            session.setAttribute( "user", useres);
            session.setAttribute( "role", useres.getRole() );
            request.setAttribute("besked1", "Bruger oprettet!");
            return "index";
        } else {
            throw new LoginSampleException( "De to passwords er ikke ens." );
        }
    }

}
