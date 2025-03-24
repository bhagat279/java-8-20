package java_8_20.emp_department;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String depName;
    private List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.depName = name;
        this.employees = employees;
    }

    public String getDepName() {
        return depName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

public class Company {
    public static void main(String[] args) {
        // Create employees
        Employee emp1 = new Employee("Alice", 60000);
        Employee emp2 = new Employee("Bob", 70000);
        Employee emp3 = new Employee("Charlie", 80000);
        Employee emp4 = new Employee("David", 90000);
        Employee emp5 = new Employee("Eve", 100000);

        // Create departments and assign employees
        Department dep1 = new Department("IT", Arrays.asList(emp1, emp2, emp3));
        Department dep2 = new Department("HR", Arrays.asList(emp4, emp5));
        Department dep3 = new Department("Finance", Arrays.asList(emp3, emp5));

        // List of departments
        List<Department> departments = Arrays.asList(dep1, dep2, dep3);

        // use this way=================================================================================================
       Department department = departments.stream().max(Comparator.comparing(dep->dep.getEmployees().stream().mapToDouble(emp->emp.getSalary()).average().getAsDouble())
        ).get();

        double avgSal = department.getEmployees().stream().mapToDouble(emp -> emp.getSalary()).average().getAsDouble();

        System.out.println(department.getDepName()+":"+avgSal);


        //==============================================================================================================
       /* Map<String,Double> eachDepAvgSal = departments.stream().collect(Collectors.toMap(department ->
                        department.getDepName(),
                department -> department.getEmployees()
                        .stream().mapToDouble(employee -> employee.getSalary())
                        .average()
                        .orElse(0.0)
        ));

        String highestSalDepartment = eachDepAvgSal.entrySet().stream()
                .max(Comparator.comparingDouble(entry->entry.getValue()))
                .map(entry->entry.getKey())
                .orElse("no department found");

        Double hisghestAvgSal = eachDepAvgSal.get(highestSalDepartment);

        System.out.println(highestSalDepartment+":"+hisghestAvgSal);*/

    }
}
