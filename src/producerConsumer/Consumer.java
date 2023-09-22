package producerConsumer;

public class Consumer implements Runnable{
    private Store store;

    Consumer(Store st){
       this.store = st;
    }
    @Override
    public void run() {
        while(true){
//            synchronized (store) {
//                System.out.println("Outside consumption check " + store.getItems().size());
                if(store.getItems().size() > 0){

                    store.removeItem();
                }
//            }
        }
    }
}
