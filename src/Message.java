import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Message {
    private static int totalMessagesSent = 0;
    private static int totalMessagesStored = 0;
    private static final StringBuilder sentMessagesLog = new StringBuilder();

    private final String messageId;
    private final String recipientNumber;
    private final String messageText;
    private final String messageHash;

    public Message(String recipientNumber, String messageText) {
        this.recipientNumber = recipientNumber;
        this.messageText = messageText;
        this.messageId = generateMessageId();
        this.messageHash = createMessageHash();
    }

    // will generate a random 10-digit number as a string ID
    private String generateMessageId() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public boolean checkMessageID() {
        return this.messageId != null && this.messageId.length() <= 10;
    }

    public String checkRecipientCell() {
        if (recipientNumber != null && recipientNumber.startsWith("+") && recipientNumber.length() <= 12) {
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    // This is to make sure that the message text length matches what's required  assignment constraints
    public String checkMessageLength() {
        if (messageText == null || messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int exceededBy = messageText.length() - 250;
            return "Message exceeds 250 characters by " + exceededBy + "; please reduce the size.";
        }
    }

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

    public static String printMessages() {
        if (sentMessagesLog.isEmpty()) {
            return "No messages sent yet.";
        }
        return sentMessagesLog.toString();
    }

    // returnTotalMessagess()
    public static int returnTotalMessagess() {
        return totalMessagesSent;
    }

    // Updated storeMessage() method will save to valid JSON array format
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

        String finalJsonOutput = getString(fileContent);

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

        if (trimmedExisting.isEmpty() || trimmedExisting.equals("[]")) {

            finalJsonOutput = "[\n" + newJsonBlock + "\n]";
        } else {

            if (trimmedExisting.endsWith("]")) {
                trimmedExisting = trimmedExisting.substring(0, trimmedExisting.length() - 1).trim();
            }

            finalJsonOutput = trimmedExisting + ",\n" + newJsonBlock + "\n]";
        }
        return finalJsonOutput;
    }

    public String getMessageId() { return messageId; }
    public String getMessageHash() { return messageHash; }
}