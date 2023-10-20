package Factory;

public class UIFactortFactory {
    public static UIFactory getUIfactorybyPlatform(String platform){
        if(platform.equals("Android")){
            return new AndroidUIFactory();
        } else if (platform.equals("IOS") ){
            return new IOSUIFactory();
        }
        return null;

    }
}
