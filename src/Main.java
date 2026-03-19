import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    // These would typically be set during a registration process
    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;

    // 1. Check Username: Contains (_) and is <= 5 characters
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // 2. Check Password Complexity
    public boolean checkPasswordComplexity(String password) {
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (password.length() < 8) return false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return hasUpper && hasDigit && hasSpecial;
    }

    // 3. Check Cell Phone Number (Regex)
    // Criteria: Starts with international code (+27) and total length <= 10
    public boolean checkCellPhoneNumber(String cellNumber) {
        String regex = "^\\+27[0-9]{7}$"; // Starts with +27 followed by 7 digits = 10 chars
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cellNumber);
        return matcher.matches();
    }

    // 4. Register User Messaging
    public String registerUser(String username, String password, String cell, String fName, String lName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cell)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        // Success - Store data
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.firstName = fName;
        this.lastName = lName;

        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }

    // 5. Login User Verification
    public boolean loginUser(String loginUsername, String loginPassword) {
        return loginUsername.equals(this.registeredUsername) && loginPassword.equals(this.registeredPassword);
    }

    // 6. Return Login Status Messaging
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}