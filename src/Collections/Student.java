package Collections;

public class Student implements Comparable<Student>{
    int id;
    int age;
    String name;
    double psp;

    Student(int id, int age, String name, double psp){
        this.id = id;
        this.name = name;
        this.age = age;
        this.psp = psp;
    }

    // two objects
    // this  vs  other
    // this < other => return -1
    // this > other => return 1
    @Override
    public int compareTo(Student other) {
        // return 0 if the two objects are equal
        // return negative if this object is smaller than the other object
        // return positive if this object is greater than the other object
        if(this.name.equals(other.name)){
            return 0;
        }
        if(this.name.compareTo(other.name) < 0){
            return -1;
        }
        return 1;
    }
}
