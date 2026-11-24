public class Main {
    public static void main(String[] args) {
        Department cs = new Department("Computer Engineering");

        Instructor inst = new Instructor(1, "Doğukan Muhtar", "dogukan.muhtar@uni.edu", "Assoc. Prof.");
        Course oop = new Course("CSE201", "Object Oriented Programming", 4);
        Course db = new Course("CSE301", "Databases", 3);
        oop.assignInstructor(inst);
        db.assignInstructor(inst);
        cs.addCourse(oop);
        cs.addCourse(db);

        Student s = new Student(100, "Doğukan Muhtar", "dogukan.muhtar@uni.edu", "2024001");
        cs.addStudent(s);

        s.enroll(oop).setGrade(Grade.AA);
        s.enroll(db).setGrade(Grade.BB);

        System.out.println(s);
        for (Enrollment e : s.getEnrollments()) System.out.println("  " + e);
        System.out.printf("GPA: %.2f%n", s.calculateGPA());
        System.out.println("Instructor: " + inst + " teaches " + inst.getCourses().size() + " courses");
    }
}
