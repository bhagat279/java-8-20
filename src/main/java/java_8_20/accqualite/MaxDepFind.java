package java_8_20.accqualite;

import java.util.*;
import java.util.stream.Collectors;

public class MaxDepFind {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, 103, "SE"),
                new Employee(1, 103, "SE3"),
                new Employee(2, 102, "SE3"),
                new Employee(3, 101, "SE"),
                new Employee(4, 101, "Manager"),
                new Employee(5, 101, "Manager"),
                new Employee(6, 102, "SE3"),
                new Employee(7, 101, "Manager")
        );

        List<Department> departments = Arrays.asList(
                new Department(101, "Kolkata"),
                new Department(102, "Delhi")
        );

        Map<Integer,String>depMap = departments.stream().collect(Collectors.toMap(
                dep->dep.depId,
                dep->dep.city
        ));
        Map<Integer,Map<String, Long>> empByDepId = employees.stream().collect(Collectors.groupingBy(
                emp->emp.depId,

                Collectors.groupingBy(
                        emp->emp.designation,
                        Collectors.counting()
                )
		  ));


        empByDepId.forEach((depId,degCount)->{

            Map.Entry<String,Long> entry = degCount.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();

            String city = depMap.get(depId);

            if(city!=null)
            System.out.println(entry.getKey()+":"+city);

        });

    }
}
