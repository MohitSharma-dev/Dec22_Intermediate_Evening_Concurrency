package producerConsumer;

public class Producer implements Runnable{
    private Store store;
    Producer(Store st) {
        this.store = st;
    }
    @Override
    public void run() {
        while(true){
//            System.out.println("Incoming");
//                System.out.println("Outside production check " + store.getItems().size() + " " + store.getMaxSize());
//            synchronized (store) {
                if(store.getItems().size() < store.getMaxSize()) {
                    System.out.println("Cleared production check");
                    store.addItem();
                }
//            }
        }
    }
}
