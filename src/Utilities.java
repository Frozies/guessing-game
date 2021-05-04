import java.util.*;

public final class Utilities {

    /** askForString(scanner, question) returns a string
     *
     * This method takes and input of a scanner created elsewhere, and a string as a question to output to console. It
     * checks if the user response is not null and is a valid string. If so, then return the input as a String.
     */
    public static String askForString(Scanner scanner, String question) {
        String input;
        do {
            System.out.println(question);
            while(!scanner.hasNext()){
                System.out.println("That's not a valid input!");
                scanner.next();
            }
            input = scanner.nextLine();
        } while (input == null);
        return input;
    }

    /** askForInt(scanner, question) returns an integer
     *
     * This method takes and input of a scanner created elsewhere, and a string as a question to output to console. It
     * checks if the user response is not less than or equal to zero, and is a valid integer. If so, then return the
     * input as an integer.
     */
    public static int askForInt(Scanner scanner, String question) {
        int number;
        do {
            System.out.println(question);
            while(!scanner.hasNextInt()){
                System.out.println("That's not a number!");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        return number;
    }
}
