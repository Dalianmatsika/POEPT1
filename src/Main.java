import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();


            System.out.println("\nWelcome to QuickChat.");

            System.out.print("How many messages do you want to send? ");
            int numMessages = Integer.parseInt(scanner.nextLine());

            int messageCount = 0;
            boolean running = true;

            while (running) {
                System.out.println("\n1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.print("Choose an option: ");
                int menuChoice = Integer.parseInt(scanner.nextLine());

                switch (menuChoice) {
                    case 1:
                        if (messageCount >= numMessages) {
                            System.out.println("You have reached your message limit.");
                            break;
                        }

                        // Increment the counter to track limits
                        messageCount++;

                        System.out.print("Enter recipient number: ");
                        String recipient = scanner.nextLine();

                        String messageBody = "";
                        Message tempMsg = null;

                        // Validation loop using your Message logic
                        while (true) {
                            System.out.print("Enter message (max 250 chars): ");
                            messageBody = scanner.nextLine();

                            // Because checkMessageLength() requires an instantiated object,
                            // we make a quick temp instance to test your exact logic constraints
                            tempMsg = new Message(recipient, messageBody);
                            String lengthCheck = tempMsg.checkMessageLength();

                            System.out.println(lengthCheck);
                            if (lengthCheck.equals("Message ready to send.")) break;
                        }

                        // Print details from your verified object
                        System.out.println("Message ID: " + tempMsg.getMessageId());
                        System.out.println("Message Hash: " + tempMsg.getMessageHash());
                        System.out.println(tempMsg.checkRecipientCell());

                        System.out.println("\n1) Send Message");
                        System.out.println("2) Disregard Message");
                        System.out.println("3) Store Message");
                        System.out.print("Choose: ");
                        int sendChoice = Integer.parseInt(scanner.nextLine());

                        // Fixed casing to call your 'SentMessage'
                        System.out.println(tempMsg.SentMessage(sendChoice));

                        System.out.println("\n--- Message Details ---");
                        System.out.println("Message ID: " + tempMsg.getMessageId());
                        System.out.println("Message Hash: " + tempMsg.getMessageHash());
                        System.out.println("Recipient: " + tempMsg.checkRecipientCell()); // or use getter if added
                        System.out.println("Message: " + messageBody);
                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            }

            System.out.println("\nTotal messages sent: " + Message.returnTotalMessagess());
            System.out.println("\n--- All Sent Messages ---");
            System.out.println(Message.printMessages());
        }
    }
