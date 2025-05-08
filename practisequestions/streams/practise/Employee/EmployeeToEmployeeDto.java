package practisequestions.streams.practise.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeToEmployeeDto {


    public static void main(String[] args) {
        Employee suraj = new Employee("Suraj", "Suraj@gmail.com");
        Employee ramesh = new Employee("Ramesh", "Ramesh@hotmail.com");
        Employee chang = new Employee("Chang", "Chang@gmail.com");

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(suraj);
        employees.add(ramesh);
        employees.add(chang);

        List<EmployeeDto> list = employees.stream().map(employee -> new EmployeeDto(employee.getName(), employee.getEmail())).toList();
        System.out.println(list);

    }
}
