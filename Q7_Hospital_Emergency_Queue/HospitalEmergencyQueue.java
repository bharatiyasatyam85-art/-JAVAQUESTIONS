import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Patient {
    int patientId;
    String patientName;
    int priority;

    Patient(int patientId, String patientName, int priority) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.priority = priority;
    }

    void display() {
        System.out.println(
                "Patient ID: " + patientId +
                ", Name: " + patientName +
                ", Priority: " + priority
        );
    }
}

public class HospitalEmergencyQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Patient> emergencyQueue =
                new PriorityQueue<>(
                        Comparator.comparingInt(patient -> patient.priority)
                );

        emergencyQueue.add(new Patient(101, "Rahul", 3));
        emergencyQueue.add(new Patient(102, "Priya", 1));
        emergencyQueue.add(new Patient(103, "Aman", 4));
        emergencyQueue.add(new Patient(104, "Neha", 2));
        emergencyQueue.add(new Patient(105, "Rohit", 1));

        System.out.println("Emergency Treatment Order:");
        System.out.println("-----------------------------");

        while (!emergencyQueue.isEmpty()) {
            Patient patient = emergencyQueue.poll();

            System.out.println("Treating Patient:");
            patient.display();
            System.out.println("-----------------------------");
        }

        sc.close();
    }
}
