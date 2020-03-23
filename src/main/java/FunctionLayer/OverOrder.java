package FunctionLayer;

import java.util.ArrayList;

public class OverOrder {

    public int customerId;
    public int ordersId;
    public ArrayList<Order> orderline;

    public OverOrder(int customerId, int orderslineId) {
        this.customerId = customerId;
        this.ordersId = orderslineId;
        orderline = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public ArrayList<Order> getOrderline() {
        return orderline;
    }

    @Override
    public String toString() {
        return "OverOrder{" +
                "customerId=" + customerId +
                ", ordersId=" + ordersId +
                ", orderline=" + orderline +
                '}';
    }
}
