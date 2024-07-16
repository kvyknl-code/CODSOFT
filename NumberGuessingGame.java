package CODSOFT;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        
        while (true) {
            boolean guessedCorrectly = playGame(scanner);
            if (guessedCorrectly) {
                score++;
            }
            
            System.out.println("Your score: " + score);
            if (!askPlayAgain(scanner)) {
                break;
            }
        }
        
        System.out.println("Thanks for playing! Final score: " + score);
        scanner.close();
    }

    // Method to play a single game
    private static boolean playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int maxAttempts = 3;
        int attempts = 0;
        
        System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");
        
        while (attempts < maxAttempts) {
            int userGuess = getUserGuess(scanner);
            attempts++;
            
            if (userGuess == numberToGuess) {
                System.out.println("You guessed it! The number was " + numberToGuess + ". Attempts: " + attempts);
                return true;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        
        System.out.println("Out of attempts! The number was " + numberToGuess);
        return false;
    }

    // Method to get the user's guess
    private static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        return scanner.nextInt();
    }

    // Method to ask the user if they want to play again
    private static boolean askPlayAgain(Scanner scanner) {
        System.out.print("Play again? (yes/no): ");
        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }
}

