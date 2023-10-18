package Prototype;

public class Student implements Prototype<Student> {
    private int age;
    private String name;
    private String batch;
    private double avgBatchPsp;
    private double studentPsp;

//    public int getAge() {
//        return age;
//    }

    public void setAge(int age) {
        this.age = age;
    }

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getBatch() {
//        return batch;
//    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

//    public double getAvgBatchPsp() {
//        return avgBatchPsp;
//    }

    public void setAvgBatchPsp(double avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

//    public double getStudentPsp() {
//        return studentPsp;
//    }

    public void setStudentPsp(double studentPsp) {
        this.studentPsp = studentPsp;
    }
    Student(){

    }
    Student(Student s){
        this.name = s.name;
        this.age = s.age;
        this.batch = s.batch;
        this.avgBatchPsp = s.avgBatchPsp;
        this.studentPsp = s.studentPsp;
    }
    @Override
    public Student clone() {
        return new Student(this);
    }
}
