package practisequestions.designpattern.builder.builder.practise;

public class Employee {
    private int id;
    private String name;

    public Employee(EmployeeBuilder employeeBuilder){
        this.id = employeeBuilder.id;
        this.name = employeeBuilder.name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static class EmployeeBuilder{
        private int id;
        private String name;

        public EmployeeBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setName(String name){
            this.name = name;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

    public static void main(String[] args) {
     Employee takken = new EmployeeBuilder().setId(1).setName("Takken").build();
        System.out.println( takken);
    }
}
