import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    private Login login;

    // Test Data variables matching assignment screens exactly
    private final String msg1Recipient = "+27718693002";
    private final String msg1Content = "Hi Mike, can you join us for dinner tonight?";

    private final String msg2Recipient = "08575975889"; // Lacks '+' and is 11 digits
    private final String msg2Content = "Hi Keegan, did you receive the payment?";

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    // ================ POE PART 1: LOGIN & REGISTRATION TESTS ========================

    @Test
    public void testUsernameCorrectlyFormatted() {
        String expected = "Username successfully captured.\n" +
                "Password successfully captured.\n" +
                "Cell phone number successfully added.";
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27813325670", "Smith");
        assertEquals(expected, actual, "The registration message should indicate success for valid data.");
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = login.registerUser("kyle!!!!!!!", "Password123!", "+27813325670", "Smith");
        assertEquals(expected, actual, "The system should reject invalid usernames.");
    }

    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"), "Password should meet complexity requirements.");
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertFalse(login.checkPasswordComplexity("password"), "Simple password should fail complexity check.");
    }

    @Test
    public void testLoginStatus() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27813325670", "Smith");
        boolean loginResult = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(loginResult, "Login should succeed with correct credentials.");
    }

    // ==================== POE PART 2: TEST =========================

    // --- Rule 1: Message Character Length Verification ---
    @Test
    public void testMessageLength_Success() {
        Message msg1 = new Message(msg1Recipient, msg1Content);
        String expected = "Message ready to send.";
        String actual = msg1.checkMessageLength();
        assertEquals(expected, actual, "Should return success for valid lengths.");
    }

    @Test
    public void testMessageLength_Failure() {
        String longMessage = "a".repeat(255);
        Message massiveMsg = new Message(msg1Recipient, longMessage);

        String expected = "Message exceeds 250 characters by 5; please reduce the size.";
        String actual = massiveMsg.checkMessageLength();
        assertEquals(expected, actual, "Should return calculation variance error layout.");
    }

    // Recipient Formatting Verification
    @Test
    public void testRecipientNumber_Success() {
        Message msg1 = new Message(msg1Recipient, msg1Content);
        String expected = "Cell phone number successfully captured.";
        String actual = msg1.checkRecipientCell();
        assertEquals(expected, actual);
    }

    @Test
    public void testRecipientNumber_Failure() {
        Message msg2 = new Message(msg2Recipient, msg2Content);
        String expected = "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        String actual = msg2.checkRecipientCell();
        assertEquals(expected, actual);
    }

    @Test
    public void testMessageHash_Correct() {
        Message msg1 = new Message(msg1Recipient, msg1Content);
        String actual = msg1.getMessageHash();
        assertNotNull(actual);
        assertTrue(actual.startsWith("00:0:"));
    }

    @Test
    public void testMessageHash_LoopRemainder() {
        Message[] messageLoop = {
                new Message(msg1Recipient, msg1Content),
                new Message(msg2Recipient, msg2Content)
        };

        for (Message msg : messageLoop) {
            String hash = msg.getMessageHash();
            assertNotNull(hash, "Loop iteration hashes should correctly resolve safely.");
            assertTrue(hash.startsWith("00:0:"), "Hash output structure remains standard.");
        }
    }

    @Test
    public void testMessageId_Created() {
        Message msg1 = new Message(msg1Recipient, msg1Content);
        assertTrue(msg1.checkMessageID(), "The generated random 10-digit ID should pass constraint evaluation.");
        assertNotNull(msg1.getMessageId());
    }

    // User Input Action Routes & Total Counter Tracking
    @Test
    public void testMessageSent_ActionResponses() {
        Message testMsg = new Message(msg1Recipient, msg1Content);

        assertEquals("Message successfully sent.", testMsg.SentMessage(1));
        assertEquals("Press 0 to delete the message.", testMsg.SentMessage(2));
        assertEquals("Message successfully stored.", testMsg.SentMessage(3));
    }

    @Test
    public void testReturnTotalNumberSent_Tracking() {
        int baseline = Message.returnTotalMessagess();

        Message msg1 = new Message(msg1Recipient, msg1Content);
        Message msg2 = new Message(msg2Recipient, msg2Content);

        msg1.SentMessage(1);
        msg2.SentMessage(2);

        assertEquals(baseline + 1, Message.returnTotalMessagess(), "Total sent calculation count tracker mismatch.");
    }
}