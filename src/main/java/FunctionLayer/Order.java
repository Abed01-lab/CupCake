package FunctionLayer;

public class Order {

    String bottom;
    String topping;
    int orderlineId;
    int quantity;
    int toppingId;
    int bottomId;
    int sumNumber;

    public Order(int orderlineId, int quantity, int toppingId, int bottomId, int sumNumber) {
        this.orderlineId = orderlineId;
        this.quantity = quantity;
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.sumNumber = sumNumber;
        switch(toppingId) {
            case 1:
                topping = "Chocolate";
                break;
            case 2:
                topping = "Blueberry";
                break;
            case 3:
                topping = "Rasberry";
                break;
            case 4:
                topping = "Crispy";
                break;
            case 5:
                topping = "Strawberry";
                break;
            case 6:
                topping = "Rum/Raisin";
                break;
            case 7:
                topping = "Orange";
                break;
            case 8:
                topping = "Lemon";
                break;
            case 9:
                topping = "Blue cheese\t";
                break;
        }

        switch(bottomId){
            case 1:
                bottom = "Chocolate";
                break;
            case 2:
                bottom = "Vanilla";
                break;
            case 3:
                bottom = "Nutmeg";
                break;
            case 4:
                bottom = "Pistacio";
                break;
            case 5:
                bottom = "Almond";
                break;
        }


    }

    @Override
    public String toString() {
        return "Order{" +
                "orderlineId=" + orderlineId +
                ", quantity=" + quantity +
                ", toppingId=" + toppingId +
                ", bottomId=" + bottomId +
                ", sumNumber=" + sumNumber +
                '}';
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getOrderlineId() {
        return orderlineId;
    }

    public void setOrderlineId(int orderlineId) {
        this.orderlineId = orderlineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public int getSumNumber() {
        return sumNumber;
    }

    public void setSumNumber(int sumNumber) {
        this.sumNumber = sumNumber;
    }
}
