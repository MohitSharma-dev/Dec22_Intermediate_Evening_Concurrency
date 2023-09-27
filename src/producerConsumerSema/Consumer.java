package producerConsumerSema;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Store store;
    private Semaphore prodSema;
    private Semaphore consSema;

    Consumer(Store st, Semaphore prodSema, Semaphore consSema){
       this.store = st;
       this.prodSema = prodSema;
       this.consSema = consSema;
    }
    @Override
    public void run() {
        while(true){
//            synchronized (store) {
//                System.out.println("Outside consumption check " + store.getItems().size());
            try {
                consSema.acquire();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//                if(store.getItems().size() > 0){

                    store.removeItem();
//                }
//            }
            prodSema.release();
        }
    }
}
