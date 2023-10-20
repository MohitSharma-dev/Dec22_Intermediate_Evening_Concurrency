package Factory;

public class Android implements FlutterI{
    @Override
    public AndroidUIFactory createUIfactory() {
        return new AndroidUIFactory();
    }
}
