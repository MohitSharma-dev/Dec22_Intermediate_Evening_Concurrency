package Factory;

public class IOS implements FlutterI{
    @Override
    public IOSUIFactory createUIfactory() {
        return new IOSUIFactory();
    }
}
