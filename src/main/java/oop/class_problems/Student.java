package oop.class_problems;

// M5: Instance vs static members
public class Student {

    // Instance fields: every student has their own copy
    String name;
    double attendance;

    // Static fields: ONE copy shared by all students
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++; // runs once for every object created
    }

    // Static method: belongs to the class, so it cannot use name or attendance
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Student first = new Student("Ravi", 92.5);
        Student second = new Student("Anitha", 88.0);

        // Called through the class name, not through an object
        Student.printCollegeInfo();
    }
}