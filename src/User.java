import java.util.Scanner;

public class User {
    /* User Information */
    static String fullName; // First M Last
    static int birthYear; // YYYY
    static int birthMonth; // MM
    static int birthDay; // DD


    static String getUsersName(Scanner scanner) {
        return Utilities.askForString(scanner, "What is your full name?");
    }

    static int getUsersBirthYear(Scanner scanner){
        return Utilities.askForInt(scanner, "What is your birth year?");
    }

    static int getUsersBirthMonth(Scanner scanner){
        return Utilities.askForInt(scanner, "What is your birth Month?");
    }

    static int getUsersBirthDay(Scanner scanner){
        return Utilities.askForInt(scanner, "What is your birth Day?");
    }

    static void getUserInformation(){
        Scanner scanner = new Scanner(System.in);

        getUsersName(scanner);
        getUsersBirthYear(scanner);
        getUsersBirthMonth(scanner);
        getUsersBirthDay(scanner);
    }
}
