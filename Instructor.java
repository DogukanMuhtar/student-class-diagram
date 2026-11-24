import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person {
    private String title;
    private final List<Course> courses = new ArrayList<>();

    public Instructor(int id, String name, String email, String title) {
        super(id, name, email);
        this.title = title;
    }

    public String getTitle() { return title; }
    public List<Course> getCourses() { return courses; }
    void addCourse(Course c) { courses.add(c); }

    @Override
    public String getRole() { return "Instructor"; }
}
