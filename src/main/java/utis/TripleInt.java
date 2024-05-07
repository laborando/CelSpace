package utis;

public class TripleInt {

    private int a = 0;
    private int b = 0;
    private int c = 0;

    public TripleInt(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
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

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    public void add(int a, int b, int c){
        this.a += a;
        this.b += b;
        this.c += c;
    }
    public void addTripleInt(TripleInt ti){
        this.a += ti.getA();
        this.b += ti.getB();
        this.c += ti.getC();
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
        if(c < lowest){
            c = lowest;
        } else if (c > highest) {
            c = highest;
        }

    }
    public String outputAsString(){
        return a + ";" + b + ";" + c;
    }
    public TripleInt returnCopy(){
        return new TripleInt(a,b,c);
    }
}
