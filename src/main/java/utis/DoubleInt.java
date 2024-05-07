package utis;

public class DoubleInt {

    private int a = 0;
    private int b = 0;

    public DoubleInt(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void add(int a, int b){
        this.a += a;
        this.b += b;
    }
    public void addDoubleInt(DoubleInt di){
        this.a += di.getA();
        this.b += di.getB();
    }
    public void enforceRange(int lowest, int highest){
        if(a < lowest){
            a = lowest;
        } else if (a > highest) {
            a = highest;
        }
        if(b < lowest){
            b = lowest;
        } else if (b > highest) {
            b = highest;
        }

    }
    public String outputAsString(){
        return a + ";" + b;
    }
}
