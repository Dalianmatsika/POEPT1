import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTest {

    Login login = new Login();

    @Test
    public void testUsernameCorrectlyFormatted() {
        // FIXED: Using valid phone data so it doesn't fail on the phone check
        String expected = "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+2783896", "Smith");
        assertEquals(expected, actual);
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = login.registerUser("kyle!!!!!!!", "Password123!", "+2783896", "Smith");
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue("Password should be complex enough", login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertFalse("Password should not meet complexity requirements", login.checkPasswordComplexity("password"));
    }

    @Test
    public void testLoginStatus() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+2783896", "Smith");
        // Should be true if credentials match
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
}