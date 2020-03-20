package PresentationLayer;

import FunctionLayer.LoginSampleException;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "addCupCake", new AddCupCake());
        commands.put( "buy", new Buy());
        commands.put( "save", new Save());
        commands.put( "kundeBestillingBekræftigelse", new kundeBestillingBekræftigelse());
        commands.put("goBack", new GoBack());
        commands.put("logout", new Logout());
    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException, ServletException, IOException;

}
