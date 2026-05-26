## Executive Report: QuickChat Application (Part 1 & Part 2 Integrated)

---

## 1. Executive Summary
This project is a secure, interactive Java application that handles user registration, authentication, and an automated batch-messaging system called QuickChat. The focus of this development was on strict **input validation**, **Object-Oriented Programming (OOP)** design, and **Test-Driven Development (TDD)**. By keeping the core business logic completely separate from the user interface, the application ensures data integrity, safety from crashes, and a smooth, robust user experience.

---

## 2. Technical Architecture
The application uses a clean, three-tier separated class structure built within the IntelliJ IDEA environment:

### **Logic Engine (`Login.java`)**
* Acts as the primary **"Decision Maker"** for identity management.
* Handles complex validation using **Regular Expressions (Regex)** for speed, security standards, and accuracy.
* Protects sensitive user details using **private instance variables** to enforce encapsulation.

### **Messaging Engine (`Message.java`)**
* Manages message creation, length checks, and recipient validation rules.
* Keeps a global count of successfully sent messages across the entire application session using **static tracking**.

### **User Interface (`Main.java`)**
* Manages user interactions and menu flows in the console via `Scanner`.
* Heavily updated in Part 2 to read choices strictly as Strings (`scanner.nextLine().trim()`), completely preventing infinite menu duplication bugs and crashes caused by unexpected user input.
* Implements a persistent flow to guide the user dynamically based on authentication and batch-processing loops.

### **Quality Assurance (`UnitTest.java`)**
* Uses the **JUnit framework** to run automated unit tests.
* Automates both success and failure scenarios using assertions, ensuring both the login logic and messaging system produce correct, predictable outputs.

---

## 3. Key Functional Features

| Feature                  | Scope  | Implementation Detail                                                                                     |
|:-------------------------|:-------|:----------------------------------------------------------------------------------------------------------|
| **Username Validation** | Part 1 | Enforces a maximum of 5 characters and requires the inclusion of an underscore (`_`).                      |
| **Security Standards** | Part 1 | Enforces "Strong Password" rules (8+ chars, Uppercase, Numbers, Special Chars) using Regex.               |
| **Internationalization** | Part 1 | Validates South African cell phone formats using a `^\+27` Regex pattern.                                 |
| **Authentication Flow** | Part 1 | Compares real-time login entries against previously "captured" and saved registration data.               |
| **Length Validation** | Part 2 | Checks if a message is under the 250-character limit and shows the exact character count overflow if it fails. |
| **Recipient Verification**| Part 2 | Validates that batch recipient numbers meet the required phone format rules.                              |
| **Report Generation** | Part 2 | Creates a complete message summary displaying a unique Message ID, Message Hash, and recipient data.      |
| **Batch Processing** | Part 2 | Allows users to process multiple messages in a single run using a structured loop.                        |
| **Console Safeguards** | Part 2 | Prevents endless console loops by reading inputs as strings and instantly consuming unexpected text blocks. |

---

## 4. Updates and Changes Made in Part 2
The following features and critical fixes were added to expand on the original registration system:
* **Interactive Main Menu:** Added a persistent post-login menu that gives users three clear choices: 1) Send Messages, 2) Show recently sent messages (Coming Soon), and 3) Quit.
* **Message Object Integration:** Created a dedicated `Message` class to handle recipient numbers, text data, unique ID generation, and character limits safely.
* **Batch Processing Loop:** Added a prompt asking users how many messages they want to enter. The system loops through that exact number, letting the user format and check each message sequentially.
* **Static Metric Tracking:** Implemented a static method (`Message.returnTotalMessagess()`) that keeps an accurate, continuous count of all successfully sent messages across the entire application session.
* **Critical Input Fix (Endless Loop Protection):** Removed all direct calls to `scanner.nextInt()` for menu choices and replaced them with `scanner.nextLine().trim()`. If a user accidentally enters text or multi-line data into a numeric menu prompt, the program safely consumes the entire block at once, displays a single error message, and waits calmly for the correct input without looping indefinitely.

---

## 5. Meeting the Rubric Criteria
* **Code Complexity / Defensive Design:** Kept the code readable, maintainable, and low in complexity by using simple switch-case branches and Regex. The interface handles bad data or accidental text entries gracefully without crashing or throwing stack trace errors.
* **Encapsulation:** All sensitive variables inside the `Login` and `Message` classes are kept private, meaning they can only be accessed or changed through secure constructors and getter methods.
* **Testability / Documentation:** Every method is clearly named and commented to explain the logic. Because the core components return clean, predictable strings, the entire application can be thoroughly verified using automated JUnit tests.

---

## 6. Video Demonstration
A comprehensive video walkthrough has been recorded to show the application working from start to finish. This includes the registration and login phase, batch message entry, input error handling, and a successful run of the automated unit tests for all classes (Main, Login, and Message).

**Watch the demonstration here:**
https://youtu.be/VQE_41y0aE4?si=01ImzTrse69jDP8G

---

## 7. Final Outcome
The system successfully transitions from a secure **Registration Phase** to a **Login Phase**, only granting entry if credentials match the stored profile perfectly. Upon success, it initializes the **QuickChat Messaging Engine**, allowing users to safely batch-process structured messages, generate validation reports, and track session metrics under a protected console environment.

---

## 8. References
Badri Khanal. (2019). Random Number in java, Generate a 10 digit phone number using the random number. [Online Video]. Available at: https://youtu.be/ar5Rk9JtOCk [Accessed 20 May 2026].

(Used to generate a 10 digit phone number using the random number.)

Farrell, J. (2023). Java Programming. 10th ed. Boston: Cengage Learning.

(Primary textbook reference for general Java logic, class structures, encapsulation, and loops.)

JUnit.org. (2026). JUnit 5 User Guide. [Online]. Available at: https://junit.org/junit5/docs/current/user-guide/ [Accessed 7 April 2026].

(Standard reference for the UnitTest class and automated assertion methods.)

Oracle. (2026a). Class Scanner (java.util). [Online]. Available at: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html [Accessed 7 April 2026].

(Official documentation for handling console input, handling text strings, and mitigating scanner crashes.)

Oracle. (2026b). Lesson: Regular Expressions. [Online]. Available at: https://docs.oracle.com/javase/tutorial/essential/regex/ [Accessed 7 April 2026].

(Documentation used for implementing the Password, Username, and South African Phone validation logic.)

Reewen. (2020). Java | How to get random numbers(int/double/long/etc)2020. [Online Video]. Available at: https://youtu.be/q9TouJpEYyM [Accessed 20 May 2026].

(Used for obtaining different types of random numbers.)

Scott Rowell. (2025). JSON in Java - Writing to Files. [Online Video]. Available at: https://youtu.be/pJt-AYrmopo [Accessed 10 May 2026].

(Video guide used for setting up the testing environment and writing robust test cases.)

W3Schools. (2026a). Java RegEx. [Online]. Available at: https://www.w3schools.com/java/java_regex.asp [Accessed 7 April 2026].

(Reference used for simplifying and testing the validation patterns for security requirements.)

W3Schools. (2026b). Java User Input (Scanner). [Online]. Available at: https://www.w3schools.com/java/java_user_input.asp [Accessed 7 April 2026].

(Technical guide for implementing interactive user prompts and menu choices safely.)

Web Dev Simplified. (2018). Learn JSON in 10 Minutes. [Online Video]. Available at: https://youtu.be/iiADhChRriM [Accessed 10 May 2026].

(Used for understanding the foundational concepts of JSON.)

YouTube. (2026). Unit Testing in IntelliJ with JUnit. [Online Video]. Available at: https://youtu.be/vZm0lHciFsQ?si=E1dygZPf2UgP85Ni [Accessed 7 April 2026].

(Video guide used for setting up the testing environment and writing robust test cases.)
