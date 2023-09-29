package Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(10);
        s.add(5);
        s.add(50);
        s.add(15);
        s.add(13);
        for(Integer x : s){
            System.out.println(x);
        }

        Set<Integer> s1 = new LinkedHashSet<>();
        s1.add(10);
        s1.add(5);
        s1.add(50);
        s1.add(15);
        s1.add(13);
        for(Integer x : s1){
            System.out.println(x);
        }

        Payment p = new Payment();
        p.status = PaymentStatus.AWAITING_BANK_CONFIRMATION;

//        paymentStatusList.add(PaymentStatus.FAILURE);
//        paymentStatusList.add(PaymentStatus.PENDING);
//        paymentStatusList.add(PaymentStatus.SUCCESS);
//        paymentStatusList.add(PaymentStatus.AWAITING_BANK_CONFIRMATION);
        Set<PaymentStatus> paymentStatusList = EnumSet.allOf(PaymentStatus.class);
        for(PaymentStatus p1 : paymentStatusList){
            System.out.println(p1);
        }

        Set<PaymentStatus> p2 = new HashSet<>();
        for(PaymentStatus p3 : PaymentStatus.values())
        {
            p2.add(p3);
        }
        for(PaymentStatus p1 : p2){
            System.out.println(p1);
        }

        PriorityQueue<String> queue=new PriorityQueue<>();
        queue.add("Amit");
        queue.add("Vijay");
        queue.add("Karan");
        queue.add("Jai");
        queue.add("Rahul");

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.poll();
        }

        List<Student> students = new ArrayList<>(List.of(
                new Student(1, 25, "Mohit", 75),
                new Student(2, 27, "Ayushi", 90),
                new Student(3, 24, "Vidushi", 85)
        ));

        Collections.sort(students,(o1, o2) -> {
            if(o1.age == o2.age){
                return 0;
            } else if(o1.age < o2.age){
                return -1;
            }
            return 1;
        });

        System.out.println("Hey!");
    }
}
