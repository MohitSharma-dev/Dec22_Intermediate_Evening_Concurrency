package multithreadedMergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(8, 1 , 6 , 2 , 3 , 9 ,7 , 5);

        ExecutorService ex = Executors.newCachedThreadPool();

        Sorter x = new Sorter(arrayToSort,ex);
        Future<List<Integer>> sortedArrayFuture = ex.submit(x);

        List<Integer> sortedArray = sortedArrayFuture.get();

        for (Integer in: sortedArray) {
            System.out.println(in);
        }

    }


}
