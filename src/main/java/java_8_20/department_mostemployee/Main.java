package java_8_20.department_mostemployee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "HR"),
                new Employee("Charlie", "HR"),
                new Employee("Diana", "Engineering"),
                new Employee("Eve", "Sales"),
                new Employee("Frank", "Engineering"),
                new Employee("Grace", "Engineering")
        );

        Map<String, Long> map = employees.stream().collect(Collectors.groupingBy(
                employee -> employee.department,
                Collectors.counting()
        ));


        Map.Entry<String, Long> stringLongEntry = map.entrySet().stream().max(Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue())
                .thenComparing(e->e.getKey())
        ).get();


        System.out.println(stringLongEntry.getKey());
    }
}
// Write a program to find the Department with the most employees, and print the department name along with the number of employees