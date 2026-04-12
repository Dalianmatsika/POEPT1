import java.util.Scanner;

class Login {

    private String storedUsername;
    private String storedPassword;

    // 1. Username check: must contain underscore (_) and be <= 5 characters
    public boolean checkUserName(String username) {
        // Added null check to prevent crashes
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // 2. Password complexity check
    public boolean checkPasswordComplexity(String password) {
        return password != null &&
                password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[^a-zA-Z0-9].*");
    }

    // 3. Cell phone check
    public boolean checkCellPhoneNumber(String phone) {
        return phone != null && phone.matches("^\\+27\\d{1,10}$");
    }

    // 4. Register user
    public String registerUser(String username, String password, String phone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.storedUsername = username;
        this.storedPassword = password;
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    public String returnLoginStatus(boolean success, String firstName, String lastName) {
        if (success) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("--- Registration ---");
        System.out.print("Enter First Name: ");
        String fName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lName = scanner.nextLine();

        System.out.print("Enter Username (max 5 chars, must have _): ");
        String user = scanner.nextLine();

        System.out.print("Enter Password (8+ chars, Upper, Number, Special): ");
        String pass = scanner.nextLine();

        System.out.print("Enter Cell (+27123456789): ");
        String cell = scanner.nextLine();

        String regStatus = login.registerUser(user, pass, cell);
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