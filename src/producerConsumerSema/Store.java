package producerConsumerSema;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    private int maxSize;
    private Vector<Object> items;

    Store(int maxSize){
        this.maxSize = maxSize;
        this.items = new Vector<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public Vector<Object> getItems() {
        return items;
    }

    public void addItem() {
        System.out.println("Producer production time, current size " + this.items.size());
        this.items.add(new Object());
//        System.out.println("Producer produced time, current size " + this.items.size());
    }

    public void removeItem() {
        System.out.println("Consumer consuming time, current size " + this.items.size());
//        total produced = 5
        // consumer 1 remove(5 - 1)
        // consumer 2 remove(5 - 1)
        this.items.remove(0);
//        System.out.println("Consumer item, current size " + this.items.size());
    }
}

// += i => 3 commands
