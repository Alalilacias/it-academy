package S1.T8.n3.exercise1.src.classes;

@SuppressWarnings("unused")
public class Student {
    private String name;
    private int age;
    private String course;
    private int grade;

    public Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.course = builder.course;
        this.grade = builder.grade;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCourse() {
        return course;
    }
    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

//    Chose builder for clarity of instantiation and because I wanted to try out the class
    public static class Builder {
        private String name = "No name assigned";
        private int age = 0;
        private String course = "No course assigned";
        private int grade = 0;

        public Builder(){
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder age (int age){
            this.age = age;
            return this;
        }
        public Builder course(String course){
            this.course = course;
            return this;
        }
        public Builder grade(int grade){
            this.grade = grade;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}
