package studentgrade;



import java.util.ArrayList;
import java.util.Scanner;

public class Analyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        
        System.out.print("Enter number of subjects: ");
        int subCount = sc.nextInt();
        sc.nextLine(); 

        String[] subjects = new String[subCount];
        for (int i = 0; i < subCount; i++) {
            System.out.print("Enter name of subject " + (i + 1) + ": ");
            subjects[i] = sc.nextLine();
        }

        
        System.out.print("\nEnter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            double[] marks = new double[subCount];
            for (int j = 0; j < subCount; j++) {
                System.out.print("Enter marks for " + subjects[j] + ": ");
                marks[j] = sc.nextDouble();
            }

            students.add(new Student(name, marks));
        }

        // --- Display Results ---
        System.out.println("\n--- STUDENT GRADE REPORT ---");
        double classTotal = 0;

        for (Student s : students) {
            classTotal += s.average;
            System.out.println("\nName: " + s.name);
            for (int j = 0; j < subjects.length; j++) {
                System.out.println(subjects[j] + ": " + s.marks[j]);
            }
            System.out.println("Total: " + s.total);
            System.out.println("Average: " + s.average);
            System.out.println("Grade: " + s.grade);
        }

        // --- Class Average ---
        double classAvg = classTotal / n;
        System.out.println("\nClass Average: " + classAvg);

        // --- Topper ---
        Student topper = students.get(0);
        for (Student s : students) {
            if (s.average > topper.average)
                topper = s;
        }
        System.out.println("\nTopper: " + topper.name + " with Average: " + topper.average + " (" + topper.grade + ")");

        
    }
}

