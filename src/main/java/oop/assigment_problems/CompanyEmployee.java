package oop.assigment_problems;

// M5: Instance vs static members.
// The task calls this class Employee, but M3 already uses that name in this
// package, so this one is named CompanyEmployee.
public class CompanyEmployee {

    // Instance fields: every employee has their own copy
    String empName;
    double salary;

    // Static fields: ONE copy shared by all employees
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // runs once for every object created
    }

    // Static method: belongs to the class, so it cannot use empName or salary
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee first = new CompanyEmployee("Divya", 65000);
        CompanyEmployee second = new CompanyEmployee("Arjun", 0);
        CompanyEmployee third = new CompanyEmployee("Meera", 72000);

        // Called through the class name, not through an object
        CompanyEmployee.printCompanyInfo();
    }
}