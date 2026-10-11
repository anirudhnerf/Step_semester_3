package oop.class_problems;

// M4: One-Time College Setup, Many Students - static block runs once
public class SrmStudent {

    static String collegeName;
    static String academicYear;

    // Runs exactly once, when the class is first loaded - never per object
    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026-27";
        System.out.println("College info loaded");
    }

    String name;

    public SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + name);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String n : names) {
            new SrmStudent(n);
        }
    }
}