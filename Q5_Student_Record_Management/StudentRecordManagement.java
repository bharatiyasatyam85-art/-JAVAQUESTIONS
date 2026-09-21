import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    String branch;
    double cgpa;

    Student(int rollNumber, String name, String branch, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    void display() {
        System.out.println(
                "Roll No: " + rollNumber +
                ", Name: " + name +
                ", Branch: " + branch +
                ", CGPA: " + cgpa
        );
    }
}

public class StudentRecordManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "Rahul", "CSE", 8.7));
        students.add(new Student(102, "Priya", "CSE", 9.1));
        students.add(new Student(103, "Aman", "Cyber Security", 7.8));
        students.add(new Student(104, "Neha", "AI/ML", 8.5));
        students.add(new Student(105, "Rohit", "ECE", 7.9));

        System.out.println("All Student Records:");
        System.out.println("-----------------------------");

        for (Student student : students) {
            student.display();
        }

        System.out.println("\nSearch Student");
        System.out.print("Enter Roll Number: ");
        int searchRoll = sc.nextInt();

        boolean found = false;

        for (Student student : students) {
            if (student.rollNumber == searchRoll) {
                System.out.println("Student Found:");
                student.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found.");
        }

        System.out.println("\nRemove Student");
        System.out.print("Enter Roll Number to Remove: ");
        int removeRoll = sc.nextInt();

        boolean removed = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).rollNumber == removeRoll) {
                students.remove(i);
                removed = true;
                System.out.println("Student Removed Successfully.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student Not Found.");
        }

        System.out.println("\nStudents Having CGPA Greater Than 8.0:");
        System.out.println("-----------------------------");

        for (Student student : students) {
            if (student.cgpa > 8.0) {
                student.display();
            }
        }

        sc.close();
    }
}
