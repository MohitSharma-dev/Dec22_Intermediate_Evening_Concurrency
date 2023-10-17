package Singleton;

public class DBconnection {
    private static DBconnection dBconnection = null;
    private DBconnection(){
    }

    public static DBconnection getInstance() {
        if(dBconnection == null){
            synchronized (DBconnection.class) {
                if(dBconnection == null){
                    dBconnection = new DBconnection();
                }
            }

        }
        return dBconnection;
    }
}
