public class StoredMessages {
    private final String[] messageID;
    private final String[] storedMessages;
    private final String[] messageHash;
    private final String[] messageStatus;
    private int size;
    private final int capacity;

    public StoredMessages (int capacity) {
        this.capacity = capacity;
        this.messageID = new String[capacity];
        this.storedMessages = new String[capacity];
        this.messageHash = new String[capacity];
        this.messageStatus = new String[capacity];
        this.size = 0;
    }

    public void addMessage(String id, String text, String hash, String status) {
        if (size >= capacity) {
            return;
        }
        messageID[size] = id;
        storedMessages[size] = text;
        messageHash[size] = hash;
        messageStatus[size] = status;
        size++;
    }

    public String getStoredRecipients() {
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if ("Stored".equalsIgnoreCase(messageStatus[i])) {
                sb.append("Recipient: ").append(messageID[i]).append("\n");
                found = true;
            }
        }
        return found ? sb.toString().trim() : "No stored messages found.";
    }

    // Evaluates text lengths for the assignment dataset
    public String getLongestMessage() {
        if (size == 0) return "No messages available.";

        String longest = "";
        for (int i = 0; i < size; i++) {
            // Evaluates text safely across data rows
            if (storedMessages[i] != null && storedMessages[i].length() > longest.length()) {
                longest = storedMessages[i];
            }
        }
        return longest;
    }

    // Searches for a message ID string match and extracts layout structures
    public String searchByMessageID(String id) {
        for (int i = 0; i < size; i++) {
            if (messageID[i] != null && messageID[i].equals(id)) {
                return "Recipient: " + messageID[i] + "\nMessage: \"" + storedMessages[i] + "\"";
            }
        }
        return "Message ID not found.";
    }

    // Collects multiple message text bodies matching a target filter
    public String searchAllMessagesByRecipient(String recipient) {
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (messageID[i] != null && messageID[i].equals(recipient)) {
                if (found) sb.append(" "); // Space separator specified by test requirements
                sb.append(storedMessages[i]);
                found = true;
            }
        }
        return found ? sb.toString().trim() : "No messages found for this recipient.";
    }

    // Performs array structural shift operations to remove a row dynamically by hash
    public String deleteMessageByHash(String hash) {
        for (int i = 0; i < size; i++) {
            if (messageHash[i] != null && messageHash[i].equalsIgnoreCase(hash)) {
                String targetMessage = storedMessages[i];

                // Parallel structure shifting down by one space index position
                for (int j = i; j < size - 1; j++) {
                    messageID[j] = messageID[j + 1];
                    storedMessages[j] = storedMessages[j + 1];
                    messageHash[j] = messageHash[j + 1];
                    messageStatus[j] = messageStatus[j + 1];
                }

                // Clean old trailing duplication index boundary addresses
                messageID[size - 1] = null;
                storedMessages[size - 1] = null;
                messageHash[size - 1] = null;
                messageStatus[size - 1] = null;

                size--;
                return "Message: \"" + targetMessage + "\" successfully deleted.";
            }
        }
        return "Message hash not found.";
    }

    // Generates a clean tabular system summary ledger report
    public String generateFullReport() {
        if (size == 0) return "The message system is empty.";

        StringBuilder report = new StringBuilder();
        report.append(String.format("%-12s | %-15s | %-10s | %s\n", "HASH", "RECIPIENT/ID", "STATUS", "MESSAGE"));
        report.append("----------------------------------------------------------------------------------\n");
        for (int i = 0; i < size; i++) {
            report.append(String.format("%-12s | %-15s | %-10s | %s\n",
                    messageHash[i], messageID[i], messageStatus[i], storedMessages[i]));
        }
        return report.toString();
    }

    public int getSize() { return size; }
    public String[] getStoredMessages() { return storedMessages; }
}
