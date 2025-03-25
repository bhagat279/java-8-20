package java_8_20.student_grade;

import java.util.*;
import java.util.stream.Collectors;

class Subject {
    String name;
    double grade;

    Subject(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

class Student {
    String name;
    List<Subject> subjects;

    Student(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}

public class StudentGrades {
    public static void main(String[] args) {
        // Creating sample data
        List<Student> students = Arrays.asList(
                new Student("Alice", Arrays.asList(
                        new Subject("Math", 85.5),
                        new Subject("Physics", 92.3),
                        new Subject("Chemistry", 89.7))),
                new Student("Bob", Arrays.asList(
                        new Subject("Math", 75.2),
                        new Subject("Physics", 99.4),
                        new Subject("Chemistry", 72.5))),
                new Student("Bob", Arrays.asList(
                        new Subject("Math", 90.5),
                        new Subject("Physics", 100),
                        new Subject("Chemistry", 88.9)))
        );


        Map<String, Subject> subjectAccordingToGrade = students.stream().collect(Collectors.toMap(
                student -> student.getName(),
                student -> student.getSubjects().stream().max(
                        Comparator.comparing(subject -> subject.grade)).get(),
        (sub1,sub2)->sub1.grade>sub2.grade?sub1:sub2,
                LinkedHashMap::new
        ));


        subjectAccordingToGrade.forEach((studentName, subject) -> {
             System.out.println(studentName + ":" + subject.getName() + ":" + subject.getGrade());
        });

    }
}
// Alice's highest grade is in Physics with grade: 92.3