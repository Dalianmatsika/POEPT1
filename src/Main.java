
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

        System.out.println("Enter Username (Must include “_” and be 5 characters long.): ");
        String user = scanner.nextLine();

        System.out.println("Enter Password (Min 8 chars, with uppercase, number, and special character.): ");
        String pass = scanner.nextLine();

        System.out.println("Enter Cell (Include country code (e.g., +27), then up to 10 digits): ");
        String cell = scanner.nextLine();

        String regStatus = login.registerUser(user, pass, cell, "Smith");
        System.out.println("\n" + regStatus);

        if (regStatus.contains("successfully added")) {
            boolean isSuccess = false;

            // Loop until the user logs in successfully
            while (!isSuccess) {
                System.out.println("\n--- Login ---");
                System.out.print("Enter Username: ");
                String loginUser = scanner.nextLine();

                System.out.print("Enter Password: ");
                String loginPass = scanner.nextLine();

                isSuccess = login.loginUser(loginUser, loginPass);

                if (isSuccess) {
                    System.out.println(login.returnLoginStatus(isSuccess, fName, lName));
                } else {
                    // Specific error feedback
                    System.out.println("\n[!] Login Failed.");

                    // Logic to tell the user WHERE they made an error
                    // This assumes your Login class has access to the stored credentials
                    if (!loginUser.equals(user)) {
                        System.out.println("-> The username you entered does not match our records.");
                    } else if (!loginPass.equals(pass)) {
                        System.out.println("-> The password you entered is incorrect.");
                    }

                    System.out.println("Please try again.");
                }
            }
        }

    }
}














































