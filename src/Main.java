/*
* Java guessing game by Davin Young.
* Florida Gulf Coast University
* Project started 2/15/2021
* COP 2006
*/

import java.util.Scanner;

public class Main {
    /* Game Information */
    static int currentScore = 0; // Points
    static int totalScore; // Points
    static int attempts = 3; // "Lives"
    static boolean nextGame = false;


    /* User Information */
    static String fullName; // First M Last
    static int birthYear; // YYYY
    static int birthMonth; // MM
    static int birthDay; // DD

    /* Points system adjustments */
    static int correctAnswerWeight = 10; // Points
    static int wrongAnswerWeight = 10; // Points

    /* TODO */
    /* User input
    * Single rounds -> multi-round keeping player information in memory.
    * Per round score
    * Save score using a Map name:totalScore
    * Finish Game loop
    * Prettify game start user experience
    * Check if input is correct (an int, or a string, or whatever)
    */

    public static void main(String[] args) {
        /* Setup a new game*/
        nextGame = false;
        int randNumber = (int) (Math.random()*15); // Create a random number 1-15

        /* Start Game */
        while(attempts!=0 && !nextGame){
            // Start the program by asking the user for input and comparing the guess to the randomly generated number.
            compareGuess(getUserInput(), randNumber);
        }

        /* Finish Current Game */
        /* Recalculate Score */
        /* End game if no attempts left */
        if (attempts <= 0) {
            System.out.println("You've run out of attempts!");
        } else {

        }



        // Would you like to continue?
        // if so, requeue game
        // If not, save current total scores
    }

    // This method asks for a user input for an integer. Returns the integer.
    static int getUserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select a number between 1 - 15: ");
        return scan.nextInt();
    }

    // This method compares the user input and the randomly generated number.
    static void compareGuess(int currentGuess, int randNumber) {
        if(currentGuess == randNumber) {
            System.out.println("You guessed correctly!!");
            nextGame = true;

        } else if(currentGuess>randNumber) {
            System.out.println("Your guess was too high! Try again.");

        } else if (currentGuess<randNumber) {
            System.out.println("Your guess was too low! Try again.");
        }
        return;
    }
}
