package practisequestions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentCourse {

    Map<Integer, Student> studentMap = new HashMap<>();


    public void findCourses() {
        studentMap
                .values()
                .stream()
                .flatMap(s -> s.getCourses().stream())
                .map(course -> course.getName())
                .forEach(System.out::println);
    }
}
