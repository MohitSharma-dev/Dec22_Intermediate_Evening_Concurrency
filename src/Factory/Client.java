package Factory;

import Factory.Components.Button.Button;

public class Client {
    public static void main(String[] args) {
        Flutter f = new Flutter();
        UIFactory factory = f.createUIfactory("Android");
        Button b = factory.createButton();
        b.getSize();

        FlutterI fI = new Android();
        UIFactory fact = fI.createUIfactory();
        System.out.println("hey!");
    }
}
//
// Android class
// IOS class

// andriod = new Andriod()