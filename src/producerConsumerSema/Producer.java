package producerConsumerSema;

import java.util.concurrent.Semaphore;

public class  faProducer implements Runnable{
    private Store store;
    private Semaphore prodSema;
    private Semaphore consSema;
    Producer(Store st, Semaphore prodSema, Semaphore consSema) {
        this.store = st;
        this.prodSema = prodSema;
        this.consSema = consSema;
    }
    @Override
    public void run() {
        while(true){
//            System.out.println("Incoming");
//                System.out.println("Outside production check " + store.getItems().size() + " " + store.getMaxSize());
//            synchronized (store) {
            try {
                prodSema.acquire();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//                if(store.getItems().size() < store.getMaxSize()) {
//                    System.out.println("Cleared production check");
                    store.addItem();
                    consSema.release();
//                }
//            }
        }
    }
}
