import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class UnitTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login();
    }

    // ==========================================
    // EXISTING PART 1 TESTS (UNTOUCHED)
    // ==========================================
    @Test
    public void testUsernameCorrectlyFormatted() {
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
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27813325670", "Smith");
        boolean loginResult = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue("Login should succeed with correct credentials.", loginResult);
    }

    // ==========================================
    // PART 2 Unit test
    // ==========================================
    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message ready to send.", msg.checkMessageLength());
    }

    @Test
    public void testMessageLengthFailure() {
        StringBuilder longSb = new StringBuilder();
        for (int i = 0; i < 260; i++) { longSb.append("A"); }
        Message msg = new Message("+27718693002", longSb.toString());
        assertEquals("Message exceeds 250 characters by 10; please reduce the size.", msg.checkMessageLength());
    }

    @Test
    public void testRecipientNumberFormattingSuccess() {
        Message msg = new Message("+27718693002", "Valid message contents.");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    @Test
    public void testMessageHashGeneration() {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("00:0:HITONIGHT", msg.getMessageHash());
    }
}
































