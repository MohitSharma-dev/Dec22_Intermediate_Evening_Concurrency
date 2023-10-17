package Builder;

public class Student {
    int id;
    String name;
    double psp;
    int age;
    String univName;
    int gradYear;

//    Student(int id, String name .....){
//
//    }

    private Student(Builder builder){
//        // validations starts
//        if(builder.getAge() > 25){
//            throw new IllegalArgumentException();
//        }
//        // vaildation stops
        this.age = builder.getAge();
        this.name = builder.getName();
        this.gradYear = builder.getGradYear();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    static class Builder {
        int id;
        String name;
        double psp;
        int age;
        String univName;
        int gradYear;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public void setPsp(double psp) {
            this.psp = psp;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getUnivName() {
            return univName;
        }

        public void setUnivName(String univName) {
            this.univName = univName;
        }

        public int getGradYear() {
            return gradYear;
        }

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public Student build(){
            // validations starts
            if(age > 25){
                throw new IllegalArgumentException();
            }
            // vaildation stops
            return new Student(this);

        }
    }

}
