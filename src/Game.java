import java.util.Scanner;

public class Game {
    /* Game Information */
    static int currentScore = 0; // Points
    static int totalScore = 0; // Points
    static int initialAttempts = 10; // "Lives"
    static int currentAttempts = initialAttempts;
    static boolean nextGame = false;
    static int guessRange = 15;

    /* Points system weights */
    static int wrongAnswerWeight = -1; // Points

    // Gameplay loop
    public static void mainGame() {
        int randNumber = (int) (Math.random()*guessRange); // Create a random number 1 and the set range
        nextGame = false;
        currentAttempts = initialAttempts;

        /* Start Game */
        while(currentAttempts!=0 && !nextGame){
            // Start the program by asking the user for input and comparing the guess to the randomly generated number.
            compareGuess(askUserGuess(), randNumber);
        }

        // Check if the player has any lives/attempts left.
        if (currentAttempts <= 0) {
            System.out.println("You lose!");
            System.out.println("The correct number was: " + randNumber);
        }

        setTotalScore(totalScore,currentAttempts);
        restartGame();
    }

    private static void restartGame() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to play again? y/n");

        if (scan.next().startsWith("y")) {
            System.out.println("Starting another game!");
            mainGame(); // Starts another game!
        } else if (scan.next().startsWith("n")) {
            System.out.println("Your Total score is: " + totalScore);
            System.out.println("Exiting game...");
            System.exit(0);
        } else {
            System.out.println("Please enter a valid input. y or n");
            restartGame();
        }
    }

    // This method asks for a user input for an integer. Returns the integer.
    static int askUserGuess() {
        boolean validGuess = false;
        int userGuess = 0;
        Scanner scan = new Scanner(System.in);

        while (!validGuess){
            System.out.println("Select a number between 1 - " + guessRange + ". You have " + currentAttempts + " tries: ");
            userGuess = scan.nextInt(); //TODO: input a string then parse it after with validateGuess
            validGuess = validateGuess(userGuess, guessRange);
        }
        return userGuess;
    }

    // This method compares the user input and the randomly generated number.
    static void compareGuess(int currentGuess, int randNumber) {
        if(currentGuess == randNumber) {
            System.out.println("You guessed correctly!!");
            nextGame = true;

        } else if(currentGuess>randNumber) {
            currentAttempts += wrongAnswerWeight;
            System.out.println("Your guess was too high! Try again.");

        } else {
            currentAttempts += wrongAnswerWeight;
            System.out.println("Your guess was too low! Try again.");
        }
    }

    static boolean validateGuess(int currentGuess, int guessRange){
        if ((currentGuess < 1 || currentGuess > guessRange)){
            System.out.println("You're guess is out of range!");
            return false;
        } else
            return true;
    };

    public static void setTotalScore(int totalScore, int currentScore) {
        Game.totalScore = totalScore += currentScore;
        System.out.println("Your current score is: " + totalScore);
    }
}
