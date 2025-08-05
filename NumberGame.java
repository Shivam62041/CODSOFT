import java.util.*;
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalRounds = 0;
        int score = 0;
        System.out.println("\n******** WELCOME TO THE NUMBER GAME ********");
        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("\nRound: " + (totalRounds + 1));
            System.out.println("System has generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number. Good Luck!");
            totalRounds++;
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.println("\nAttempt: " + (attempts + 1) + "/" + maxAttempts);
                System.out.print("Enter your guess => ");
                // Input validation for non-integer inputs
                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    scanner.next(); // clear invalid input
                    System.out.print("Enter your guess => ");
                }
                int userGuess = scanner.nextInt();
                scanner.nextLine();  // consume the newline
                // Validate range
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number between " + minRange + " and " + maxRange + "!");
                    continue;
                }
                if (userGuess < generatedNumber) {
                    System.out.println("It's too low!");
                } else if (userGuess > generatedNumber) {
                    System.out.println("It's too high!");
                } else {
                    System.out.println("Congrats! You guessed the right one.");
                    guessedCorrectly = true;
                    score++;
                }
                attempts++;
            }
            if (!guessedCorrectly) {
                System.out.println("\nOops! You have used up all your attempts.");
                System.out.println("The correct number was: " + generatedNumber);
            }
            System.out.print("\nWould you like to play this game again? (Y/N) => ");
            String playAgainResponse = scanner.nextLine();
            if (!playAgainResponse.equalsIgnoreCase("yes") && !playAgainResponse.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }
        System.out.println("\nGame over! Your score is: " + score + " out of " + totalRounds + " rounds");
        System.out.println("Thanks for playing!");
    }
}
https://github.com/Shivam62041/CODSOFT.git