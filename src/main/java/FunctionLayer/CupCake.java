package FunctionLayer;

public class CupCake {

    private String top;
    private String bund;
    private int antal;
    private int pris;
    
    public CupCake(String bund, String top, int antal){
        this.bund = bund;
        this.top = top;
        this.antal = antal;
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

    @Override
    public String toString() {
        return "CupCake" +
                ", top " + top +
                ", bund " + bund +
                ", antal " + antal +
                ", pris " + pris +
                '}';
    }
}
