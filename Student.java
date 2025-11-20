package studentgrade;
public class Student {
    String name;
    double[] marks;
    double total;
    double average;
    char grade;

    
    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
        calculateResult();
    }

  
    void calculateResult() {
        total = 0;
        for (double m : marks) {
            total += m;
        }
        average = total / marks.length;

        if (average >= 90) grade = 'A';
        else if (average >= 75) grade = 'B';
        else if (average >= 60) grade = 'C';
        else if (average >= 40) grade = 'D';
        else grade = 'F';
    }
}
