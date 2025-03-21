package practisequestions;

import java.util.*;

/**
 * Given employee list, sort employees by City, Name, and Age and return it
 * Get me city name with maximum no of employees , if there are mutiple cities with same employees count, print the all the cites , employee count# alphabetically
 * Print the list of all the citees with total employee count
 * Find the youngest and oldest employee, print the name and age
 */

public class Employee {

    private long employeeId;
    private int age;
    private String name;
    private Date dob;
    private double salary;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phone;
    private String email;
    private Date joiningDate;

    public Employee(int age, String name, String city, Long employeeId, Date joiningDate) {
        this.age = age;
        this.name = name;
        this.city = city;
        this.employeeId = employeeId;
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeId=" + employeeId +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }


    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }


    public static void main(String[] args) {
        Employee employee = new Employee(18, "ram", "Toronto", 1l, new Date("2022/01/02"));
        Employee employee1 = new Employee(20, "shyam", "Mississauga", 2l, new Date("2021/01/02"));
        Employee employee2 = new Employee(35, "shriya", "Mississauga", 3l, new Date("2022/02/02"));
        Employee employee3 = new Employee(27, "diya", "Mississauga", 3l, new Date("2022/01/03"));
        Employee employee4 = new Employee(29, "charles", "Brampton", 4l, new Date("2023/06/02"));
        Employee employee5 = new Employee(30, "tina", "Brampton", 4l, new Date("2024/01/02"));


        List<Employee> employeeList = new ArrayList<>(List.of(employee, employee1, employee2,
                employee3, employee4, employee5));

        //Problem no.21
        checkDuplicatesIdAndReassignId(employeeList);

        //1. Given employee list, sort employees by City, Name, and Age and return it

        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getCity)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getAge, Comparator.reverseOrder()))
                .forEach(System.out::println);


/*
 2. Get me city name with maximum no of employees , if there are multiple cities with same employees count,
 print the all the cites , employee count# alphabetically
*/
        Map<String, Integer> cityCount = new HashMap<>();
        ArrayList<String> cityWithMaxEmployee = new ArrayList<>();
        int max = 0;

        for (Employee emp : employeeList) {
            cityCount.put(emp.getCity(), cityCount.getOrDefault(emp.getCity(), 0) + 1);
            int count = cityCount.get(emp.getCity());
            if (max < count) {
                max = cityCount.get(emp.getCity());
                cityWithMaxEmployee.clear();
                cityWithMaxEmployee.add(emp.getCity());
            } else if (max == count) {
                cityWithMaxEmployee.add(emp.getCity());
            }
        }

        System.out.println("Max count of employee is : " + max + " City is" + cityWithMaxEmployee.toString());


//    3. Print the list of all the citiees with total employe count

        cityCount.forEach((key, value) -> System.out.println("City Name is : " + key + " and  the count is: " + value));


//       4. Find the youngest and oldest employee, print the name and age

        employeeList.stream()
                .max(Comparator.comparing(Employee::getAge))
                .ifPresent(emp -> System.out.println("Oldest employee is " + emp.getName() + " " + emp.getAge()));

        employeeList.stream()
                .min(Comparator.comparing(Employee::getAge))
                .ifPresent(emp -> System.out.println("Youngest employee is " + emp.getName() + " " + emp.getAge()));
//

    }

    /*
    * 21. Say you have list of employees based on the above class , now some of the employees were assigned duplicate
    employee id due to system error.
    *
    * Assign the new employee id's to the duplicate employee based on the order of the joining date and it
    should be following proper number sequence
    * */

    public static void checkDuplicatesIdAndReassignId(List<Employee> employee) {
        //For the duplicate elements we can use the hashset with the java streams....
        HashSet<Long> employeeIds = new HashSet<>();

        List<Employee> duplicateList = employee.stream()
                .filter(emp -> !employeeIds.add(emp.employeeId))
                .sorted(Comparator.comparing(Employee::getJoiningDate))
                .toList();

        duplicateList.forEach(emp -> System.out.println("Before Duplicate ids: " + emp.employeeId));

        long id = employee.size() + 1;

        for (Employee emp : duplicateList) {
            if (employeeIds.contains(id)) ++id;
            emp.setEmployeeId(id);
            employeeIds.add(id);
        }
        duplicateList.forEach(emp -> System.out.println("After New Ids assigned: " + emp.employeeId));


    }


}

