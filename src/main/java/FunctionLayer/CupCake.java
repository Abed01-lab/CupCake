package FunctionLayer;

public class CupCake {

    private BottomAndTopping topping;
    private BottomAndTopping bottom;
    private int quantity;
    private int sum;
    
    public CupCake(BottomAndTopping bottom, BottomAndTopping topping, int quantity){
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
    }

    public BottomAndTopping getTopping() {
        return topping;
    }

    public BottomAndTopping getBottom() {
        return bottom;
    }

    public int getQuantity(){
        return quantity;
    }

    public  int getSum(){
        return calculateSum();
    }

    private int calculateSum(){
        return (bottom.getPrice() + topping.getPrice()) * quantity;
    }

    @Override
    public String toString() {
        return "CupCake{" +
                "topping=" + topping +
                ", bottom=" + bottom +
                ", quantity=" + quantity +
                ", sum=" + sum +
                '}';
    }
}
