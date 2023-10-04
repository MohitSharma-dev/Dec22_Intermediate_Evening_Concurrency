package LambdasAndStreams;

import javax.sound.midi.SysexMessage;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // wawy - 1
        SomethingDoer some = new SomethingDoer();
//        Thread t = new Thread(some);
//        t.start();
        // way - 2
        Runnable r = () -> {
            System.out.println("I am doing");
        };
        Thread t = new Thread(r);
        t.start();

        // way - 3
        Thread t3 = new Thread(() -> {
            System.out.println("I am doing");
        });

        Thread t4 = new Thread(() -> System.out.println("This is something"));

        MathematicalOperation addition = (x , y) -> x + y;

        MathematicalOperation subtraction = (x , y) -> x - y;

        MathematicalOperation multiplication = (x , y) -> x * y;

        Integer ans = addition.operate(2 , 3);

        List<Integer> x = new ArrayList<>();
        x.add(2);
        x.add(1);
        x.add(3);
        x.add(4);
        x.add(5);
        x.add(6);

        Stream<Integer> s = x.stream();
        // filter

        List<Integer> list1 = s.filter((element) -> element % 2 == 0).collect(Collectors.toList());

        // a stream is closed by a terminal operation and you can't use
        // the stream again to do anything

        Stream<Integer> s1 = x.stream();
        Optional<Integer> x4 = s1.filter((element) -> {
                    System.out.println("Data in filter " + element);
                    return element % 2 == 0;
                })
                .sorted()
                .map((elem) -> {
                    System.out.println("Data in Map " + elem);
                    return elem * 5;
                })
                .findFirst();

        if(x4.isPresent()){
            System.out.println(x4.get());
        }




//        System.out.println(list);
//        for(Integer y : x){
//            System.out.println(y);
//        }

        // Intermediate operations => filter(), map(), sorted()
        // Terminal operations => count(), foreach() , findfirst()
        List<String> lis1 = Arrays.asList("apple", "banana");
        List<String> lis2 = Arrays.asList("orange", "grape");

        List<List<String>> listOfLists = Arrays.asList(lis1, lis2);
        System.out.println(listOfLists);
        // Using flatMap to flatten the list of lists
        List<String> flattenedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flattenedList);
    }
}


//// filter
//for(int i = 0 -> size ){
//    if(data is even){
//        ans gets the data
//        }
//        }
//// map
// for(int i =0 -> ans.size()){
//      data = data * 5;
// }
//// findfirst
// return ans[0]

// for(int i = 0 ;i < size; i++){
// if (data is even){
// return data * 5;
// }
// }


