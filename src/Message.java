import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Message {
    // Static counters to track application states
    private static int totalMessagesSent = 0;
    private static int totalMessagesStored = 0;
    private static final StringBuilder sentMessagesLog = new StringBuilder();

    // Instance fields
    private final String messageId;
    private final String recipientNumber;
    private final String messageText;
    private final String messageHash;

    // Constructor
    public Message(String recipientNumber, String messageText) {
        this.recipientNumber = recipientNumber;
        this.messageText = messageText;
        this.messageId = generateMessageId();
        this.messageHash = createMessageHash();
    }

    // Helper to generate a random 10-digit number as a string ID
    private String generateMessageId() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    // Boolean: checkMessageID()
    public boolean checkMessageID() {
        return this.messageId != null && this.messageId.length() <= 10;
    }

    // String: checkRecipientCell() - checks formatting and length
    public String checkRecipientCell() {
        if (recipientNumber != null && recipientNumber.startsWith("+") && recipientNumber.length() <= 12) {
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    // Method to validate message text length explicitly matching assignment constraints
    public String checkMessageLength() {
        if (messageText == null || messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int exceededBy = messageText.length() - 250;
            return "Message exceeds 250 characters by " + exceededBy + "; please reduce the size.";
        }
    }

    // String: createMessageHash()
    public String createMessageHash() {
        String cleanText = "";
        if (messageText != null) {
            cleanText = messageText.replaceAll("[^a-zA-Z]", "").toUpperCase();
            if (cleanText.length() > 8) {
                cleanText = cleanText.substring(0, 8);
            }
        }
        return "00:0:" + cleanText;
    }

    // String: SentMessage(int choice)
    public String SentMessage(int choice) {
        switch (choice) {
            case 1:
                totalMessagesSent++;
                String details = "Message ID: " + messageId + ", Message Hash: " + messageHash +
                        ", Recipient: " + recipientNumber + ", Message: " + messageText + "\n";
                sentMessagesLog.append(details);
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                totalMessagesStored++;
                storeMessage();
                return "Message successfully stored.";
            default:
                return "Invalid choice option.";
        }
    }

    // String: printMessages()
    public static String printMessages() {
        if (sentMessagesLog.isEmpty()) {
            return "No messages sent yet.";
        }
        return sentMessagesLog.toString();
    }

    // Int: returnTotalMessagess()
    public static int returnTotalMessagess() {
        return totalMessagesSent;
    }

    // Updated storeMessage() method saving to valid JSON array format
    public void storeMessage() {
        File fileObj = new File("stored_messages.json");
        StringBuilder fileContent = new StringBuilder();

        // 1. Read existing content if file exists
        if (fileObj.exists() && fileObj.length() > 0) {
            try (Scanner fileScanner = new Scanner(fileObj)) {
                while (fileScanner.hasNextLine()) {
                    fileContent.append(fileScanner.nextLine()).append("\n");
                }
            } catch (IOException e) {
                System.out.println("Error reading JSON file: " + e.getMessage());
            }
        }

        // 2. Prepare the new single message block
        String finalJsonOutput = getString(fileContent);

        // 4. Overwrite file completely with the correctly bound array string
        try (FileWriter file = new FileWriter(fileObj, false)) {
            file.write(finalJsonOutput);
        } catch (IOException e) {
            System.out.println("Error storing message into JSON file: " + e.getMessage());
        }
    }

    private String getString(StringBuilder fileContent) {
        String cleanMessageText = messageText != null ? messageText.replace("\"", "\\\"") : "";
        String newJsonBlock = "  {\n" +
                "    \"messageId\": \"" + messageId + "\",\n" +
                "    \"recipientNumber\": \"" + recipientNumber + "\",\n" +
                "    \"messageHash\": \"" + messageHash + "\",\n" +
                "    \"message\": \"" + cleanMessageText + "\"\n" +
                "  }";

        String finalJsonOutput;
        String trimmedExisting = fileContent.toString().trim();

        // 3. Splice the data inside an array wrapper safely
        if (trimmedExisting.isEmpty() || trimmedExisting.equals("[]")) {
            // First item going into the file
            finalJsonOutput = "[\n" + newJsonBlock + "\n]";
        } else {
            // Remove the previous outer closing array bracket ']' to merge strings
            if (trimmedExisting.endsWith("]")) {
                trimmedExisting = trimmedExisting.substring(0, trimmedExisting.length() - 1).trim();
            }
            // Combine with a comma separator and seal the array bracket back down
            finalJsonOutput = trimmedExisting + ",\n" + newJsonBlock + "\n]";
        }
        return finalJsonOutput;
    }

    // Getters for testing assertions
    public String getMessageId() { return messageId; }
    public String getMessageHash() { return messageHash; }
}