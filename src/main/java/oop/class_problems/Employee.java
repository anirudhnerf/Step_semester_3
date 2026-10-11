package oop.class_problems;

// M2: Payroll Batch Bonus Round - resolving name clashes with this
public class Employee {

    String empId;
    double salary;

    // Parameter names are the same as the field names, so this. is required
    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    // Parameter "salary" is the bonus; this.salary is the employee's field
    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    void printFinalSalary() {
        System.out.println(empId + " | Final Salary: Rs " + salary);
    }

    public static void main(String[] args) {
        String[] ids = {"E-101", "E-102", "E-103", "E-104"};
        double[] salaries = {40000, 55000, 62000, 48000};

        Employee[] team = new Employee[ids.length];
        for (int i = 0; i < ids.length; i++) {
            team[i] = new Employee(ids[i], salaries[i]);
        }

        // Same bonus for everyone, one pass
        for (Employee e : team) {
            e.raiseSalary(5000);
            e.printFinalSalary();
        }
    }
}