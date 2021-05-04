/*
* Java guessing game by Davin Young.
* Florida Gulf Coast University
* Project started 2/15/2021
* COP 2006
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello & welcome to the guessing game!");

        System.out.println("The current top 5 high scores are: "); //TODO

//        User.askUserInformation();
//        Game.mainGame();
       Score.addScore("John Cena", 150);
       Score.addScore("dfasdf", 600);
       Score.addScore("ggggg", 900);
       Score.addScore("Jqqqq", 100);
       Score.addScore("Jovvv", 200);

        System.out.println("Unsorted: " + Score.allScores);



        //TODO: Save user's score map to file
    }









}
