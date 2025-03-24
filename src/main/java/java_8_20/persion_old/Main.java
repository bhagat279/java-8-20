package java_8_20.persion_old;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    String name;
    String city;
    int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", "New York", 30),
                new Person("Bob", "New York", 40),
                new Person("Charlie", "Los Angeles", 35),
                new Person("Diana", "Los Angeles", 45),
                new Person("Eve", "New York", 50),
                new Person("ravi", "Kolkata", 70)
        );

        Map<String, Person> persionByAge = people.stream().collect(Collectors.toMap(
                Person::getCity,
                persion -> persion,
                (p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2
        ));


        List<Map.Entry<String, Person>> list = persionByAge.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Person>::getKey))
                .toList();

        list.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue().getName()));

//=====================================================================================================================
       /* Map<String, Person> personByAge = people.stream().collect(Collectors.toMap(
                Person::getCity,
                person -> person,
                (p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2
        ));

        // Sort the map entries by city (key) in lexicographical order (case insensitive)
        List<Map.Entry<String, Person>> sortedList = personByAge.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey, String.CASE_INSENSITIVE_ORDER))
                .toList();

        // Print the sorted entries
        sortedList.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue().getName()));*/
//======================================================================================================================
    }
}
//Given a list of Person objects with fields name, city, and age, write a program that finds the oldest person in each city and prints the city along with the
//  oldest person's name.