import java.util.Scanner;

public class Game {
    /* Game Information */
    static int totalScore = User.getScore(); // Points
    static int initialAttempts = 10; // "Lives"
    static int currentAttempts = initialAttempts;
    static boolean nextGame = false;
    static int guessRange = 10;

    /* Points system weights */
    static int wrongAnswerWeight = -1; // Points

    // Gameplay loop
    public static void mainGame() {
        nextGame = false;
        currentAttempts = initialAttempts;
        int correctAnswer = setRandomAnswer();
        Scanner scanner = new Scanner(System.in);


        /* Start Game */
        while(currentAttempts!=0 && !nextGame){
            // Start the program by asking the user for input and comparing the guess to the randomly generated number.
            compareGuess(askUserGuess(scanner), correctAnswer);
        }

        // Check if the player has any lives/attempts left.
        if (currentAttempts <= 0) {
            System.out.println("You lose!");
            System.out.println("The correct number was: " + correctAnswer);
        }

        setTotalScore(totalScore,currentAttempts);
        restartGame(scanner);
        scanner.close();
    }

    private static int setRandomAnswer(){
        int randNumber = (int) (Math.random()*guessRange); // Create a random number 1 and the set range
        if (randNumber == 0) randNumber += 1; // Bug fix for randNumber == 0
        return randNumber;
    }

    private static void restartGame(Scanner scanner) {
        String userResponse = Utilities.askForString(scanner, "Would you like to play again? Type: yes or no");

        if (userResponse.startsWith("y")) {
            System.out.println("Starting another game!");
            mainGame(); // Starts another game!
        } else if (userResponse.startsWith("n")) {
            System.out.println("Your Total score is: " + totalScore);
            System.out.println("Exiting game...");
            System.exit(0);
        } else {
            System.out.println("Please enter a valid input. Type: yes or no");
            restartGame(scanner);
        }
    }

    // This method asks for a user input for an integer. Returns the integer.
    static int askUserGuess(Scanner scanner) {
        boolean validGuess = false;
        int userGuess = 0;

        while (!validGuess){
            userGuess = Utilities.askForInt( scanner, "Select a number between 1 - " + guessRange + ". You have " + currentAttempts + " tries: ");
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
    }

    public static void setTotalScore(int totalScore, int currentScore) {
        Game.totalScore = totalScore += currentScore;
        System.out.println("Your current score is: " + totalScore);
        User.setScore(totalScore);
    }

}
