import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Taking marks obtained in each subject
        System.out.print("Enter the number of subjects: ");
        int numOfSubjects = scanner.nextInt();

        int totalMarks = 0;
        for (int i = 1; i <= numOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        // Calculate Total Marks
        System.out.println("Total Marks: " + totalMarks);

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numOfSubjects;
        System.out.println("Average Percentage: " + averagePercentage);

        // Grade Calculation
        char grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Method to calculate grade based on average percentage
    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else if (averagePercentage >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }
}
