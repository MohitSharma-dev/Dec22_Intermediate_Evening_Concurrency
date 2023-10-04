package ExceptionHandling;

import java.io.NotActiveException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, EvenNumberException, NotActiveException{
        Doer doer = new Doer();
//        doer.doSomething();
        try{
            doer.findStudentbyRollNo(20);
            return;
        } finally {
            System.out.println("We have reached to the finally");
//            throw new EvenNumberException();
//            System.out.println("We have reached to the finally again");
        }

//        System.out.println("Outside the try cathc block");

    }
}
//Animal a = new Dog();
// Exception ex = new ClassNotFoundException();

// A-> B -> C -> D
// wrong way
//catch (A) {}
//catch (B) {}
//catch (C) {}
//catch (D) {}

// right way
//        catch (D) {}
//        catch (C) {}
//        catch (B) {}
//        catch (A) {}