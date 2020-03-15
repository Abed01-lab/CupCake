package FunctionLayer;

public class CupCake {

    String top;
    String bund;

    private int antal;
    int pris;
    
    public CupCake(String bund, String top){
        this.bund = bund;
        this.top = top;
    }

    public String getTop() {
        return top;
    }

    public String getBund() {
        return bund;
    }

    public int getAntal(){
        return antal;
    }

    public  int getPris(){
        return pris;
    }

    public void plusAntal(){
        antal =+1;
    }
}
