import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class UnitTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        // UPDATED: Now matches the actual return string exactly
        String expected = "Username successfully captured.\n" +
                "Password successfully captured.\n" +
                "Cell phone number successfully added.";

        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27813325670", "Smith");
        assertEquals("The registration message should indicate success for valid data.", expected, actual);
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = login.registerUser("kyle!!!!!!!", "Password123!", "+27813325670", "Smith");
        assertEquals("The system should reject invalid usernames.", expected, actual);
    }

    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue("Password should meet complexity requirements.", login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertFalse("Simple password should fail complexity check.", login.checkPasswordComplexity("password"));
    }

    @Test
    public void testLoginStatus() {
        // Register first so the user exists in memory
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27813325670", "Smith");

        // Attempt login
        boolean loginResult = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue("Login should succeed with correct credentials.", loginResult);
    }
}