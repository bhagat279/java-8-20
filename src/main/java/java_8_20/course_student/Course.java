package java_8_20.course_student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Course {
    String course;
    List<Students> studentsList;

    public Course(String course, List<Students> studentsList) {
        this.course = course;
        this.studentsList = studentsList;
    }

    public String getCourse() {
        return course;
    }

    public List<Students> getStudentsList() {
        return studentsList;
    }

    public static void main(String[] args) {
        Students s1 = new Students("ravi");
        Students s2 = new Students("smith");
        Students s3 = new Students("sachin");
        Students s4 = new Students("head");

        Course c1 = new Course("java", Arrays.asList(s1, s2, s3));
        Course c2 = new Course("python", Arrays.asList(s2, s3));
        Course c3 = new Course("spring", Arrays.asList(s1, s2, s3, s4));

        List<Course> courseList = Arrays.asList(c1, c2, c3);

       Course course= courseList.stream().max(Comparator.comparingInt(c -> c.getStudentsList().size())).get();


        System.out.println(course.getCourse()+":"+course.getStudentsList().size());

    }
}
