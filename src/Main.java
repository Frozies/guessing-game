/*
* Java guessing game by Davin Young.
* Florida Gulf Coast University
* Project started 2/15/2021
* COP 2006
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /* Game Information */
    static int currentScore = 0; // Points
    static int totalScore = 0; // Points
    static int initialAttempts = 10; // "Lives"
    static int currentAttempts = initialAttempts;
    static boolean nextGame = false;
    static int guessRange = 15;

    /* User Information */
    static String fullName; // First M Last
    static int birthYear; // YYYY
    static int birthMonth; // MM
    static int birthDay; // DD

    /* Points system weights */
    static int wrongAnswerWeight = -1; // Points

    public static void main(String[] args) {
        currentScore = 0;

        System.out.println("Hello & welcome to the guessing game!");
        //TODO: Prettify introduction. explain rules, weights, etc.

        //Start Game!
        getUsersName();
        mainGame();

        /* Recalculate Score */
        //TODO: Save user's score map to file

        //TODO: separate into multiple classes
    }

    static void getUsersName() {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your full name?");
        fullName = scan.next();

        // TODO: Validate these inputs
        // TODO: Fix the scanner input
        /*System.out.println("What is your birth year?");
        birthYear = scan.nextInt();

        System.out.println("What is your birth month?");
        birthMonth = scan.nextInt();

        System.out.println("What is your birth day?");
        birthDay = scan.nextInt();*/
    }

    //Gameplay loop
    static void mainGame() {
        int randNumber = (int) (Math.random()*guessRange); // Create a random number 1 and the set range
        nextGame = false;
        currentAttempts = initialAttempts;

        /* Start Game */
        while(currentAttempts!=0 && !nextGame){
            // Start the program by asking the user for input and comparing the guess to the randomly generated number.
            compareGuess(getUserGuess(), randNumber);
        }

        if (currentAttempts <= 0) {
            System.out.println("You've run out of tries!");
        }
        setTotalScore(totalScore,currentAttempts);
        restartGame();
    }

    static void restartGame() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to play again?");

        if (scan.next().startsWith("y")) {
            System.out.println("Starting another game!");
            mainGame(); // Starts another game!
        } else {
            /*TODO: Save total score*/
            System.out.println("Exiting game...");
            System.exit(0);
        }
    }

    // This method asks for a user input for an integer. Returns the integer.
    static int getUserGuess() {
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
        Main.totalScore = totalScore += currentScore;
        System.out.println("Your current score is: " + totalScore);
    }
}
