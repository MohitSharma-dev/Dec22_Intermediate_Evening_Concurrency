package Builder;

public class Main {
    public static void main(String[] args) {
//        Builder builder = new Builder();
//        Builder builder = Student.getBuilder();
//        builder.setAge(27);
//        builder.setName("Mohit");
//        builder.setGradYear(2020);
//        Student s = builder.build();
//        Student s = new Student(builder);

        Student s1 = Student.getBuilder()
                        .setAge(25)
                        .setName("Mohit")
                        .setGradYear(2020)
                        .build();


        System.out.println(s1);

    }
}
