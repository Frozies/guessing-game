import java.util.Scanner;

public class User {
    /* User Information */
    private static String fullName; // First M Last
    private static int birthYear; // YYYY
    private static int birthMonth; // MM
    private static int birthDay; // DD


    private static String askUsersName(Scanner scanner) {
        return Utilities.askForString(scanner, "What is your full name?");
    }

    private static int askUsersBirthYear(Scanner scanner){
        return Utilities.askForInt(scanner, "What is your birth year?");
    }

    private static int askUsersBirthMonth(Scanner scanner){
        return Utilities.askForInt(scanner, "What is your birth Month?");
    }

    private static int askUsersBirthDay(Scanner scanner){
        return Utilities.askForInt(scanner, "What is your birth Day?");
    }

    public static void askUserInformation(){
        Scanner scanner = new Scanner(System.in);

        askUsersName(scanner);
        askUsersBirthYear(scanner);
        askUsersBirthMonth(scanner);
        askUsersBirthDay(scanner);
    }

    public static String getFullName() {
        return fullName;
    }

    public static int getBirthYear() {
        return birthYear;
    }

    public static int getBirthMonth() {
        return birthMonth;
    }

    public static int getBirthDay() {
        return birthDay;
    }
}
