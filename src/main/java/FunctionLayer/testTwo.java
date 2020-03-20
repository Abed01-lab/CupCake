package FunctionLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import static DBAccess.UsersMapper.addUserBalance;
import static DBAccess.UsersMapper.createUserList;

public class testTwo {

    public static void main(String[] args) {
        ArrayList<ReturnedUseres> list = null;
        try {
            list = createUserList();
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < list.size(); i++){
            System.out.println(i);
            System.out.println(list.get(i));
        }

        try {
            addUserBalance(700, "eko@test.dk");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
