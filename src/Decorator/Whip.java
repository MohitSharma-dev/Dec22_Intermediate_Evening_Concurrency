package Decorator;

public class Whip implements Bevarage{
    Bevarage cb;

    Whip(Bevarage b){
        this.cb = b;
    }
    @Override
    public double getCost() {
        return 20.0 + cb.getCost();
    }
}
