package FunctionLayer;

import java.util.ArrayList;

public class OverCustomer {

    public int id;
    public String name;
    public ArrayList<OverOrder> orders;

    public OverCustomer(int id, String name) {
        this.id = id;
        this.name = name;
        orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<OverOrder> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<OverOrder> orders) {
        this.orders = orders;
    }
}
