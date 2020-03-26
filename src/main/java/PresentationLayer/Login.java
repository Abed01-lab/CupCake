package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static DBAccess.CupcakeMapper.getBottom;
import static DBAccess.CupcakeMapper.getTopping;
import static DBAccess.UsersMapper.createUserList;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException, ServletException, IOException {
        ServletContext servletContext = request.getServletContext();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Useres useres = LogicFacade.login(email, password);

        HttpSession session = request.getSession();

        session.setAttribute("user", useres);
        session.setAttribute("role", useres.getRole());
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke


        //Denne kode viser varianterne
        try {
            servletContext.setAttribute("toppingList", (ArrayList<BottomAndTopping>) getTopping());
            servletContext.setAttribute("bottomList", (ArrayList<BottomAndTopping>) getBottom());
        } catch (CupcakeException e) {
            e.printStackTrace();
        }

        ArrayList<ReturnedUseres> list = createUserList();
        System.out.println(list.size());
        boolean found = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getEmail().equals(email) && !(list.get(i).getPassword().equals(password))){
                request.getRequestDispatcher("index").forward(request,response);
            }
            if(list.get(i).getEmail().equals(email)){
                found = true;
            }
        }

        if(found = false){
            request.getRequestDispatcher("index").forward(request,response);
        }

        if (session.getAttribute("role").equals("admin")) {
            session.setAttribute("customerList", list);
            return "WEB-INF/adminLoggetInd";
        }

        //ArrayList<ReturnedUseres> arrayList = createUserList();
        //for (int i = 0; i < arrayList.size(); i++) {
        //    if (arrayList.get(i).getEmail().equals(email) && arrayList.get(i).getPassword().equals(password)) {
        //        return "WEB-INF/Forside";
        //    } else if (arrayList.get(i).getEmail().equals(email)) {
        //        throw new LoginSampleException( "Indtast korrekt password." );
        //    }
        //}

        return "WEB-INF/Forside";
    }
}
