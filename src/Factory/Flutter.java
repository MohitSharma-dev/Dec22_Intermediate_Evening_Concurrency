package Factory;

public class Flutter {
    void setRefreshRate(){
        System.out.println("Setting refresh rate");
    }

    void setTheme(){
        System.out.println("Setting theme");
    }

    public UIFactory createUIfactory(String platform){
        return UIFactortFactory.getUIfactorybyPlatform(platform);
    }
}
