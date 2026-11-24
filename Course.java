import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String code;
    private final String title;
    private final int credits;
    private Instructor instructor;
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public Instructor getInstructor() { return instructor; }

    public void assignInstructor(Instructor instructor) {
        this.instructor = instructor;
        instructor.addCourse(this);
    }

    void addEnrollment(Enrollment e) { enrollments.add(e); }
    public List<Enrollment> getEnrollments() { return enrollments; }

    @Override
    public boolean equals(Object o) {
        return o instanceof Course && ((Course) o).code.equals(code);
    }
    @Override
    public int hashCode() { return code.hashCode(); }

    @Override
    public String toString() { return code + " - " + title + " (" + credits + " cr)"; }
}
