import static org.junit.Assert.*;

public class Test {

    // 1. Test Username Formatting
    @org.junit.Test
    public void testCheckUserNameCorrect() {
        Login login = new Login();
        // Should return true: contains "_" and length is 5
        assertTrue(login.checkUserName("ky_le"));
    }

    @org.junit.Test
    public void testCheckUserNameIncorrect() {
        Login login = new Login();
        // Should return false: no underscore
        assertFalse(login.checkUserName("kyle1"));
        // Should return false: more than 5 characters
        assertFalse(login.checkUserName("kyle_matsika"));
    }

    // 2. Test Password Complexity
    @org.junit.Test
    public void testCheckPasswordComplexitySuccess() {
        Login login = new Login();
        // Should return true: 8+ chars, Cap, Num, Special
        assertTrue(login.checkPasswordComplexity("Ch4ck3r!"));
    }

    @org.junit.Test
    public void testCheckPasswordComplexityFailure() {
        Login login = new Login();
        // Should return false: too short and no special character
        assertFalse(login.checkPasswordComplexity("pass"));
    }

    // 3. Test Registration and Login Logic
    @org.junit.Test
    public void testRegistrationAndLogin() {
        Login login = new Login();

        // Register a user first
        String status = login.registerUser("ky_le", "Ch4ck3r!", "+27123456789");
        assertTrue(status.contains("successfully captured"));

        // Test login with correct credentials
        assertTrue(login.loginUser("ky_le", "Ch4ck3r!"));

        // Test login with wrong credentials
        assertFalse(login.loginUser("ky_le", "WrongPass123"));
    }
}