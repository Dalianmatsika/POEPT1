import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UnitTest {

    Login login = new Login();

    @Test
    public void testUsernameCorrectlyFormatted() {
        String expected = "Cell phone number incorrectly formatted or does not contain international code.";
        String actual = login.registerUser("kyl_1", "Password123!", "Kyle", "Smith");

        assertEquals(expected, actual);
    }
    @Test
    public void testUsernameIncorrectlyFormatted() {
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = login.registerUser("kyle!!!!!!!", "Password123!", "Kyle", "Smith");
        assertEquals(expected, actual);
    }
    @Test
    public void testPasswordMeetsComplexity() {
        boolean actual = login.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue("Password should be complex enough", actual);
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        boolean actual = login.checkPasswordComplexity("password");
        assertFalse("Password should not meet complexity requirements", actual);
    }

    @Test
    public void testLoginStatus() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertFalse(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertFalse(login.loginUser("wrong_user", "wrong_pass"));
    }

    @Test
    public void testUsernameFormatBoolean() {
        assertTrue(login.checkUserName("kyl_1"));
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }
}