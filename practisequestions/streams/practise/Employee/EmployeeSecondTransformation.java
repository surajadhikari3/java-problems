package practisequestions.streams.practise.Employee;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeSecondTransformation {
    public static void main(String[] args) {
        EmployeeSecond employeeSecond = new EmployeeSecond("suraj", "IT", 3000);
        EmployeeSecond employeeSecond1 = new EmployeeSecond("prem", "IT", 2000);
        EmployeeSecond employeeSecond2 = new EmployeeSecond("hari", "IT", 1000);
        EmployeeSecond employeeSecond6 = new EmployeeSecond("abhi", "accounting", 2000);
        EmployeeSecond employeeSecond3 = new EmployeeSecond("praney", "accounting", 1000);
        EmployeeSecond employeeSecond4 = new EmployeeSecond("pumpkin", "management", 4000);
        EmployeeSecond employeeSecond5 = new EmployeeSecond("sina", "management", 3000);
        ArrayList<EmployeeSecond> employees = new ArrayList<>();
        employees.add(employeeSecond);
        employees.add(employeeSecond1);
        employees.add(employeeSecond2);
        employees.add(employeeSecond6);
        employees.add(employeeSecond3);
        employees.add(employeeSecond4);
        employees.add(employeeSecond5);

        Map<String, Double> collect = employees.stream().collect(Collectors.groupingBy(EmployeeSecond::getDepartment, Collectors.averagingInt(EmployeeSecond::getSalary)));
        System.out.println(collect);
    }
}
