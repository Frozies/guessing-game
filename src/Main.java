/*
* Java guessing game by Davin Young.
* Florida Gulf Coast University
* Project started 2/15/2021
* COP 2006
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        Game game = new Game(); // Pass in user?

        System.out.println("Hello & welcome to the guessing game!");
        //TODO: Prettify introduction. explain rules, weights, etc.

//        user.setUserInformation();
        game.mainGame();

        //TODO: Save user's score map to file
        //TODO: separate into multiple classes
    }









}
