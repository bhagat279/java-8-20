package java_8_20.course_student2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

//Given a list of Student and Course objects, write a program to find the course that has the highest total grades and
// print the course name along with the total grades.

public class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }
}

class Course {

    String courseName;
    List<Student> students;

    public Course(String courseName, List<Student> students) {
        this.courseName = courseName;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getStudents() {
        return students;
    }
}

class Main {
    public static void main(String[] args) {
        // Creating some student objects
        Student student1 = new Student("Alice", 85);
        Student student2 = new Student("Bob", 90);
        Student student3 = new Student("Charlie", 80);
        Student student4 = new Student("David", 95);
        Student student5 = new Student("Eve", 70);

        // Creating courses with students
        Course course1 = new Course("Math", Arrays.asList(student1, student2, student3));
        Course course2 = new Course("Science", Arrays.asList(student2, student3, student4));
        Course course3 = new Course("History", Arrays.asList(student1, student4, student5));

        // List of courses
        List<Course> courses = Arrays.asList(course1, course2, course3);

        Course courseWithMaxGrade = courses.stream().max(Comparator.comparing(course ->
                course.getStudents().stream().mapToDouble(student -> student.getGrade()).sum()
        )).get();

       double totalGrade = courseWithMaxGrade.getStudents().stream().mapToDouble(st->st.getGrade()).sum();

        System.out.println(courseWithMaxGrade.getCourseName()+":"+totalGrade);

    }
}
