package FunctionLayer;

import DBAccess.UsersMapper;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static Useres login(String email, String password ) throws LoginSampleException {
        return UsersMapper.login( email, password );
    } 

    public static Useres createUser(String email, String password ) throws LoginSampleException {
        Useres useres = new Useres(email, password, "customer");
        UsersMapper.createUser(useres);
        return useres;
    }

}
