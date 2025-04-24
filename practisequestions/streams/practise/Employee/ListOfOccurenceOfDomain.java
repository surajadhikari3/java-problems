package practisequestions.streams.practise.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOfOccurenceOfDomain {
    public static void main(String[] args) {
        Employee suraj = new Employee("Suraj", "Suraj@gmail.com");
        Employee ramesh = new Employee("Ramesh", "Ramesh@hotmail.com");
        Employee chang = new Employee("Chang", "Chang@gmail.com");

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(suraj);
        employees.add(ramesh);
        employees.add(chang);

        List<String> domainList = employees.stream().map(employee -> employee.getEmail().substring(employee.getEmail().indexOf("@"))).toList();
        System.out.println(domainList);

        Map<String, Long> collect = domainList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect);


    }
}
