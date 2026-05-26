import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        System.out.println("--- Registration ---");
        System.out.println("Enter First Name: ");
        String fName = scanner.nextLine();

        System.out.println("Enter Last Name: ");
        String lName = scanner.nextLine();

        System.out.println("Enter Username (Must include “_” and be 5 characters long.): ");
        String user = scanner.nextLine();

        System.out.println("Enter Password (Min 8 chars, with uppercase, number, and special character.): ");
        String pass = scanner.nextLine();

        System.out.println("Enter Cell (Include country code (e.g., +27), then up to 10 digits): ");
        String cell = scanner.nextLine();

        String regStatus = login.registerUser(user, pass, cell, "Smith");
        System.out.println("\n" + regStatus);

        if (regStatus.contains("successfully added")) {
            boolean isSuccess = false;

            // Loop until the user logs in successfully
            if (regStatus.contains("successfully added")) {

                System.out.println("\n--- Login ---");

                boolean Success = false;

                // Login
                while (!Success) {
                    System.out.print("Enter Username: ");
                    String loginUser = scanner.nextLine();

                    System.out.print("Enter Password: ");
                    String loginPass = scanner.nextLine();

                    Success = login.loginUser(loginUser, loginPass);

                    System.out.println(login.returnLoginStatus(Success, fName, lName));
                }
            }

                    // =============== Quickchat starts here ========================

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

                                // Increase the counter to track limits
                                messageCount++;

                                System.out.print("Enter recipient number: ");
                                String recipient = scanner.nextLine();

                                String messageBody = "";
                                Message tempMsg = null;

                                // Validation loop using your Message logic
                                while (true) {
                                    System.out.print("Please enter a message of less than 250 characters: ");
                                    messageBody = scanner.nextLine();

                                    tempMsg = new Message(recipient, messageBody);
                                    String lengthCheck = tempMsg.checkMessageLength();

                                    System.out.println(lengthCheck);
                                    if (lengthCheck.equals("Message ready to send.")) break;
                                }

                                System.out.println("Message ID: " + tempMsg.getMessageId());
                                System.out.println("Message Hash: " + tempMsg.getMessageHash());
                                System.out.println(tempMsg.checkRecipientCell());

                                System.out.println("\n1) Send Message");
                                System.out.println("2) Disregard Message");
                                System.out.println("3) Store Message");
                                System.out.print("Choose: ");
                                int sendChoice = Integer.parseInt(scanner.nextLine());

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
                    System.out.println("\n--- Message sent ---");
                    System.out.println(Message.printMessages());
                }
            }
        }

