package Prototype;

public class IntelligentStudent extends Student{
    int iq;
    IntelligentStudent(){

    }
    IntelligentStudent(IntelligentStudent s){
        super(s);
        this.iq = s.iq;
    }
    @Override
    public IntelligentStudent clone() {
        return new IntelligentStudent(this);
    }
}
