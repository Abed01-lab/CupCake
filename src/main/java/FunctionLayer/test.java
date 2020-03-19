package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

import static DBAccess.CupcakeMapper.*;
import static DBAccess.UsersMapper.login;

public class test {
    public static void main(String[] args) throws CupcakeException {
        CupCake cupCake = new CupCake(getBottom().get(1), getTopping().get(1), 2);
        CupCake cupCake1 = new CupCake(getBottom().get(2), getTopping().get(3), 4);
        CupCake cupCake2 = new CupCake(getBottom().get(0), getTopping().get(0), 5);

        ArrayList<CupCake> cupCakes = new ArrayList();
        cupCakes.add(cupCake);
        cupCakes.add(cupCake1);
        cupCakes.add(cupCake2);
        Useres user = null;
        try {
            user = login("eko@test.dk", "eko");
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }

        for (CupCake c: cupCakes) {
            System.out.println(c.toString());
        }
        insertOrderLine(user,cupCakes);

    }
}
