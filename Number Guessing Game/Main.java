import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        try{
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int correctNumber = rand.nextInt(100) + 1; // Random number between 1-100
        int attempts = 5;
        String numberRegex = "^[1-9][0-9]?$|^100$"; // Matches numbers 1-100

        System.out.println("\n----------------- Welcome to the Number Guessing Game!---------------");
        System.out.println(" Try to guess a number between 1 and 100.");
        System.out.println(" You have " + attempts + " chances to guess correctly.\n");

        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            String input = sc.nextLine();

            if (!input.matches(numberRegex)) {
                System.out.println("❌ Invalid input! Please enter a number between 1 and 100.\n");
                continue;
            }
// variable to store user value
            int guess = Integer.parseInt(input);

            if (guess == correctNumber) {
                System.out.println("🎉 Congratulations! You guessed the right number: " + correctNumber);
                break;
            } else if (guess < correctNumber) {
                System.out.println("📉 Too low! Try again.");
            } else {
                System.out.println("📈 Too high! Try again.");
            }

            attempts--;

            if (attempts == 0) {
                System.out.println("\n😢 Game Over! You've used all your chances.");
                System.out.println("✅ The correct number was: " + correctNumber);
            } else {
                System.out.println("💡 Attempts left: " + attempts + "\n");
            }
        }

        sc.close();
    } catch (InputMismatchException e) {

        System.out.println("Invaild Input, Try again ");
    }
    }
}
