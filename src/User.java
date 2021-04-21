import java.util.Scanner;

public class User {
    /* User Information */
    static String fullName; // First M Last
    static int birthYear; // YYYY
    static int birthMonth; // MM
    static int birthDay; // DD

    static void setUsersName() {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your full name?");
        fullName = scan.next();
    }

    static void setUsersBirthdate() {
        Scanner scan = new Scanner(System.in);

        //TODO: Input validation.
        System.out.println("What is your birth year?");
        birthYear = scan.nextInt();

        System.out.println("What is your birth month?");
        birthMonth = scan.nextInt();

        System.out.println("What is your birth day?");
        birthDay = scan.nextInt();
    }

    static void setUserInformation(){
        setUsersName();
        setUsersBirthdate();
    }
}
