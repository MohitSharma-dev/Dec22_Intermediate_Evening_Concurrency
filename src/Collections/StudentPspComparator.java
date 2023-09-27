package Collections;

import java.util.Comparator;

public class StudentPspComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.psp == o2.psp) {
            return 0;
        } else if(o1.psp < o2.psp){
            return 1;
        }
        return -1;
    }
}
