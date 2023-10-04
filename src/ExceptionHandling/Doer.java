package ExceptionHandling;

import java.io.NotActiveException;
import java.util.Random;

public class Doer {
    public void doSomething() {
        int a = 1/0;
    }

    public Object findStudentbyRollNo (int rollNo) throws ClassNotFoundException, NotActiveException, EvenNumberException{
        if(rollNo < 30){
            return new Object();
        }

        Random random = new Random();
        int r = random.nextInt();

        if(r % 2 == 0){
            throw new EvenNumberException();
        }
        throw new ClassNotFoundException();
    }
}

// check exception : Class
// unchcekd exception : Nullpointer
