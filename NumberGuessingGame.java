import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1; // Set your lower bound here
        int upperBound = 100; // Set your upper bound here
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int numberOfAttempts = 0;
        int userGuess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between " + lowerBound + " and " + upperBound + ".");
        
        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low. Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high. Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + numberOfAttempts + " attempts.");
            }
        } while (userGuess != numberToGuess);
    }
}