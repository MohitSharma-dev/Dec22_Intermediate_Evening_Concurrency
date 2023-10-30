package Decorator;

public class Mocha implements Bevarage{
    Bevarage cb;
    Mocha(Bevarage b){
        this.cb = b;
    }
    @Override
    public double getCost() {
        return 25.0 + cb.getCost();
    }
}
