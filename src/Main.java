// Press Shift twice to open the Find Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace in your code.
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        playGame(1, 100);
    }

    public static void playGame(int minRange, int maxRange) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        int attempts = 0;
        int score = 100; // You can initialize the score according to your preferences.

        System.out.println("Welcome to the number guessing game!");
        System.out.println("Guess the number From " + minRange + " TO " + maxRange);

        while (true) {
            System.out.print("Enter your estimate: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                break;
            } else if (userGuess < generatedNumber) {
                System.out.println("Higher! Try again.");
            } else {
                System.out.println("Lower! Try again.");
            }

            if (attempts >= 5) {
                System.out.println("Oops, you have reached the maximum number of attempts!");
                break;
            }
        }

// Calculate the score based on the number of attempts (you can change this scoring logic as needed).
        score = 100 - (attempts * 5);

        System.out.println("Game over!");
        System.out.println("Your score: " + score);

// Ask the user if they want to play another round.
        System.out.print("Play again? (yes/no): ");
        String playAgain = scanner.next();

        if (playAgain.equalsIgnoreCase("yes")) {
            playGame(minRange, maxRange);
        } else {
            System.out.println("Thank you for playing!");
        }

        scanner.close();
    }
}