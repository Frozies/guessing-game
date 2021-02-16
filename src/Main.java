/*
* Java guessing game by Davin Young.
* Florida Gulf Coast University
* Project started 2/15/2021
* COP 2006
*
* PHASE 0:
* Create a random number 1-15
* TODO:
* TODO: calculate a score on attempts array
*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a random number 1-15
        int randNumber = (int) (Math.random()*15);
        int userGuesses[];
        float userGuessAccuracy;

        // Start the program by asking the user for input and comparing the guess to the randomly generated number.
        compareGuess(getUserInput(),randNumber);

    }

    // This method asks for a user input for an integer. Returns the integer.
    static int getUserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select a number between 1 - 15: ");
        return scan.nextInt();
    }

    // This method compares the user input and the randomly generated number.
    static void compareGuess(int currentGuess, int answer) {
        if(currentGuess == answer) {
            System.out.println("You guessed correctly!!");
        } else if(currentGuess>answer) {
            System.out.println("Your guess was too high! Try again.");
            compareGuess(getUserInput(),answer); // A loop to keep trying
        } else if (currentGuess<answer) {
            System.out.println("Your guess was too low! Try again.");
            compareGuess(getUserInput(),answer); // A loop to keep trying
        }
        return;
    }
}
