package LambdasAndStreams;

public class AdditionOperation implements MathematicalOperation{
    @Override
    public Integer operate(Integer op1, Integer op2) {
        return op1 + op2;
    }
}
