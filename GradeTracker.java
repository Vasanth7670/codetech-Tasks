import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Double> grades;
    
    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }
    
    // Add a grade
    public void addGrade(double grade) {
        grades.add(grade);
    }
    
    // Calculate average grade
    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return grades.isEmpty() ? 0 : sum / grades.size();
    }
    
    // Determine letter grade based on average
    public String getLetterGrade() {
        double average = calculateAverage();
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    // Determine GPA based on average
    public double getGPA() {
        double average = calculateAverage();
        if (average >= 90) {
            return 4.0;
        } else if (average >= 80) {
            return 3.0;
        } else if (average >= 70) {
            return 2.0;
        } else if (average >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
    
    // Display student info
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + calculateAverage());
        System.out.println("Letter Grade: " + getLetterGrade());
        System.out.println("GPA: " + getGPA());
    }
}

public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input student name
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        Student student = new Student(name);

        // Input grades
        while (true) {
            System.out.print("Enter grade (or -1 to finish): ");
            double grade = scanner.nextDouble();
            if (grade == -1) {
                break;
            }
            student.addGrade(grade);
        }
        
        // Display student grade information
        student.displayInfo();
        
        scanner.close();
    }
}
