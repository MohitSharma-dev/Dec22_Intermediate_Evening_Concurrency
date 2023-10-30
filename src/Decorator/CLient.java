package Decorator;

public class CLient {
    public static void main(String[] args) {
        Bevarage b = new Decaf();
        b = new Mocha(b);
        b = new Mocha(b);
        b = new Whip(b);
        System.out.println(b.getCost());
    }
}
