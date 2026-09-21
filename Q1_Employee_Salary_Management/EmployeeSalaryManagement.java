class Employee {
    int employeeId;
    String name;
    double basicSalary;

    Employee(int employeeId, String name, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Final Salary: " + calculateSalary());
        System.out.println("-----------------------------");
    }
}

class Developer extends Employee {
    double projectAllowance;

    Developer(int employeeId, String name, double basicSalary,
              double projectAllowance) {
        super(employeeId, name, basicSalary);
        this.projectAllowance = projectAllowance;
    }

    @Override
    double calculateSalary() {
        return basicSalary + projectAllowance;
    }
}

class Manager extends Employee {
    double managementAllowance;

    Manager(int employeeId, String name, double basicSalary,
            double managementAllowance) {
        super(employeeId, name, basicSalary);
        this.managementAllowance = managementAllowance;
    }

    @Override
    double calculateSalary() {
        return basicSalary + managementAllowance;
    }
}

class Intern extends Employee {
    double stipend;

    Intern(int employeeId, String name, double basicSalary,
           double stipend) {
        super(employeeId, name, basicSalary);
        this.stipend = stipend;
    }

    @Override
    double calculateSalary() {
        return stipend;
    }
}

public class EmployeeSalaryManagement {

    public static void main(String[] args) {

        Employee employee;

        employee = new Developer(101, "Rahul", 50000, 10000);
        employee.displayDetails();

        employee = new Manager(102, "Priya", 60000, 15000);
        employee.displayDetails();

        employee = new Intern(103, "Aman", 15000, 12000);
        employee.displayDetails();
    }
}
