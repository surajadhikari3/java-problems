package practisequestions.designpattern.builder.builder;

public class Student {
    private long id;
    private String name;
    private String address;
    private String grade;

    public Student(StudentBuilder studentBuilder){
        this.id = studentBuilder.id;
        this.name = studentBuilder.name;
        this.address = studentBuilder.address;
        this.grade = studentBuilder.grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public static class StudentBuilder{
        private long id;
        private String name;
        private String address;
        private String grade;


        public StudentBuilder setId(long id){
            this.id = id;
            return this;
        }

        public StudentBuilder setName(String name){
            this.name = name;
            return this;
        }

        public StudentBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public StudentBuilder setGrade(String grade){
            this.grade = grade;
            return this;
        }

        public Student build(){
            return new Student(this);
        }

    }

    public static void main(String[] args) {
        Student build = new StudentBuilder().setAddress("Mississauga")
                .setGrade("A")
                .build();

        StudentBuilder studentBuilder = new StudentBuilder().setId(1);
        Student build1 = studentBuilder.setGrade("A").build();

        System.out.println(build);
        System.out.println(build1);
    }
}
