
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("--- Registration ---");
        System.out.println("Enter First Name: ");
        String fName = scanner.nextLine();

        System.out.println("Enter Last Name: ");
        String lName = scanner.nextLine();

        System.out.println("Enter Username (max 5 chars, must have _): ");
        String user = scanner.nextLine();

        System.out.println("Enter Password (8+ chars, Upper, Number, Special): ");
        String pass = scanner.nextLine();

        System.out.println("Enter Cell (+27123456789): ");
        String cell = scanner.nextLine();

        String regStatus = login.registerUser(user, pass, cell, "Smith");
        System.out.println("\n" + regStatus);

        if (regStatus.contains("successfully added")) {
            System.out.println("\n--- Login ---");
            System.out.print("Enter Username: ");
            String loginUser = scanner.nextLine();

            System.out.print("Enter Password: ");
            String loginPass = scanner.nextLine();

            // FIXED: Added 'boolean' type declaration here
            boolean isSuccess = login.loginUser(loginUser, loginPass);

            System.out.println(login.returnLoginStatus(isSuccess, fName, lName));
        }
        scanner.close();
    }
}














































