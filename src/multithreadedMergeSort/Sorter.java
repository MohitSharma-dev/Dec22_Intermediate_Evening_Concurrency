package multithreadedMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    ExecutorService es;
    Sorter(List<Integer> x, ExecutorService y){
        arrayToSort = x;
        es = y;
    }

    public List<Integer> call() throws Exception {
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }
        int size = arrayToSort.size();

        int mid = size/ 2;

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for(int i =0 ; i < mid; ++i){
            leftArray.add(arrayToSort.get(i));
        }

        for(int i = mid ; i < size; ++i){
            rightArray.add(arrayToSort.get(i));
        }

//        ExecutorService es = Executors.newCachedThreadPool();

        Sorter leftArraySortingTask = new Sorter(leftArray, es);
        Sorter rightArraySortingTask = new Sorter(rightArray, es);

        Future<List<Integer>> sortedLeftArrayFuture = es.submit(leftArraySortingTask);
        Future<List<Integer>> sortedRightArrayFuture = es.submit(rightArraySortingTask);

        List<Integer> sortedLeftArray = sortedLeftArrayFuture.get();
        List<Integer> sortedRightArray = sortedRightArrayFuture.get();


        int i= 0;
        int j = 0;

        List<Integer> sortedArray = new ArrayList<>();

        while (i < sortedLeftArray.size() && j < sortedRightArray.size()) {
            if (sortedLeftArray.get(i) <= sortedRightArray.get(j)) {
                sortedArray.add(sortedLeftArray.get(i));
                i += 1;
            } else {
                sortedArray.add(sortedRightArray.get(j));
                j += 1;
            }
        }

        while (i < sortedLeftArray.size()) {
            sortedArray.add(sortedLeftArray.get(i));
            i += 1;
        }

        while (j < sortedRightArray.size()) {
            sortedArray.add(sortedRightArray.get(j));
            j += 1;
        }

        return sortedArray;
    }
}
