import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNumber = random.nextInt(100) + 1; 
        // Random number between 1 and 100
        int guess;
        int attempts = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");

        // Game loop
        while (true) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again. 🔼");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again. 🔽");
            } else {
                System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                break; // Exit the loop
            }
        }

        scanner.close();
    }
}
//LMK IF YOU WIN, LOL.
//Send a screenshot and output to my Github inbox for a mystery PRIZE 🧙🏽🪄