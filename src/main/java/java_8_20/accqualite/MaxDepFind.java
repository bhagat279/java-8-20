package Java8.accqualite;

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


        Map<Integer, Map<String, Long>> map = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.depId,
                        Collectors.groupingBy(
                                e -> e.designation,
                                Collectors.counting()
                        )
                ));

        //collect dep in map
        Map<Integer, String> depMap = departments.stream().collect(Collectors.toMap(
                department -> department.depId,
                department -> department.city
        ));

        Map<String,String> desgCity = new HashMap<>();

        map.forEach((depid,freq)->{

            Map.Entry<String, Long> maxDesignationEntry = freq.entrySet().stream().max(Comparator.comparingLong(e -> e.getValue())).get();

          //  Department department1 = departments.stream().filter(department -> department.depId == depid).findFirst().orElse(new Department(105,"goa"));

            if(depMap.get(depid)!=null) {
                //System.out.println(depMap.get(depid) + ":" + maxDesignationEntry.getKey());
                desgCity.put(depMap.get(depid),maxDesignationEntry.getKey());
            }

           /* if(department1!=null)
            {
                desgCity.put(department1.city,maxDesignationEntry.getKey());
            }*/

        });

        System.out.println(map);
        System.out.println(desgCity);
    }
}
