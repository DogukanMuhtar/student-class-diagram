import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String name;
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    public Department(String name) { this.name = name; }

    public String getName() { return name; }
    public List<Student> getStudents() { return students; }
    public List<Course> getCourses() { return courses; }

    public void addStudent(Student s) {
        students.add(s);
        s.setDepartment(this);
    }

    public void addCourse(Course c) { courses.add(c); }
}
