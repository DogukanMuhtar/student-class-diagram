import java.util.ArrayList;
import java.util.List;

/** Student inherits Person (generalization). Has many Enrollments (association). */
public class Student extends Person {
    private final String studentNumber;
    private Department department;
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Student(int id, String name, String email, String studentNumber) {
        super(id, name, email);
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber() { return studentNumber; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    public List<Enrollment> getEnrollments() { return enrollments; }

    /** Enrolls the student in a course. */
    public Enrollment enroll(Course course) {
        for (Enrollment e : enrollments) {
            if (e.getCourse().equals(course)) {
                throw new IllegalStateException("Already enrolled in " + course.getCode());
            }
        }
        Enrollment enrollment = new Enrollment(this, course);
        enrollments.add(enrollment);
        course.addEnrollment(enrollment);
        return enrollment;
    }

    /** Credit-weighted GPA on a 4.0 scale (only graded courses). */
    public double calculateGPA() {
        double points = 0;
        int credits = 0;
        for (Enrollment e : enrollments) {
            if (e.getGrade() != null) {
                points += e.getGrade().getPoints() * e.getCourse().getCredits();
                credits += e.getCourse().getCredits();
            }
        }
        return credits == 0 ? 0.0 : points / credits;
    }

    @Override
    public String getRole() { return "Student"; }
}
