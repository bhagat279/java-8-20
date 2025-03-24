package java_8_20.emp_sal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    int empId;
    String name;
    double salary;
    int depId;

    // Constructor
    public Employee(int empId, String name, double salary, int depId) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.depId = depId;
    }

    // Getters
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepId() {
        return depId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", depId=" + depId +
                '}';
    }
}

class Department {
    int depId;
    String depName;

    // Constructor
    public Department(int depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    // Getter
    public String getDepName() {
        return depName;
    }
}
public class Main {
    public static void main(String[] args) {
        // Sample data
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 50000, 1),
                new Employee(2, "Alice", 60000, 2),
                new Employee(3, "Bob", 70000, 1),
                new Employee(4, "Eve", 75000, 3),
                new Employee(5, "Charlie", 80000, 2),
                new Employee(6, "David", 65000, 3)
        );

        List<Department> departments = Arrays.asList(
                new Department(1, "HR"),
                new Department(2, "IT"),
                new Department(3, "Finance")
        );

        //================================================first way=====================================================
     Map<Integer,Employee>empByDepId= employees.stream().collect(Collectors.toMap(
               Employee::getDepId,
               emp->emp,
               (emp1,emp2)->emp1.getSalary()>emp2.getSalary()?emp1:emp2
       ));

         empByDepId.forEach((depId,emp)->{
         Department department = departments.stream().filter(dep -> dep.depId == depId).findFirst().get();

         System.out.println(department.depName+":"+emp.getName());

     });
    }
}
//Given a list of Employee objects, find out which employee has the highest salary in each department (depId), and print
// the department name along with the employee name