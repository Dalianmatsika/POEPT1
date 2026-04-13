# Project Part1: Registration and Login feature

---

## 1. Executive Summary
I developed a secure, testable Java application that manages user registration and authentication. The project focuses on strict **input validation**, **Object-Oriented Programming (OOP)** principles, and **Test-Driven Development (TDD)**. By separating logic from the user interface, I created a robust system that ensures data integrity and high security.

---

## 2. Technical Architecture
The project is built using a three-tier structure within the IntelliJ environment:

### **Logic Engine (`Login.java`)**
* Acts as the primary **"Decision Maker"**.
* Handles complex validation using **Regular Expressions (Regex)** for speed and accuracy.
* Protects user data using **private instance variables**.

### **User Interface (`Main.java`)**
* Manages the console interaction via `Scanner`.
* Implements a **`while` loop** to ensure a persistent login flow until the user succeeds.
* Provides dynamic, personalized feedback based on stored registration data.

### **Quality Assurance (`UnitTest.java`)**
* Uses the **JUnit framework**.
* Automates the testing of success and failure scenarios using `assertEquals`, `assertTrue`, and `assertFalse`.

---

## 3. Key Functional Features

| Feature                  | Implementation Detail                                                                     |
|:-------------------------|:------------------------------------------------------------------------------------------|
| **Username Validation**  | Enforces a max of 5 characters and the inclusion of an underscore (`_`).                  |
| **Security Standards**   | Enforces "Strong Password" rules (8+ chars, Uppercase, Numbers, Special Chars) via Regex. |
| **Internationalization** | Uses Regex (`^\\+27...`) to validate South African cell phone formats.                    |
| **Error Handling**       | Returns specific, user-friendly error messages that match requirements exactly.           |
| **Authentication**       | Compares real-time login attempts against previously "captured" registration data.        |

---

## 4. Meeting the Rubric Criteria
* **Code Complexity:** By using Regex and a clean method-based structure, I kept the cyclomatic complexity low and the readability high.
* **Documentation:** Every method is clearly named and commented to explain the logic behind the validation checks.
* **Testability:** The `Login` class was specifically designed to be "testable," allowing for automated assertions that guarantee the system returns the correct strings every time.

---

## 5. Video Demonstration
I have recorded a comprehensive video walkthrough of this project, demonstrating the registration process, the validation logic in action, and the successful execution of all Unit Tests.

**Watch the demonstration here:**
[Insert Your YouTube Link Here]

---

## 6. Final Outcome
The system successfully transitions from a **Registration Phase** to a **Login Phase**, only allowing access if the credentials match the stored profile perfectly. It provides a personalized welcome message upon success, as required by the module specifications.

---

## 7. References
   Farrell, J. (2023). Java Programming. 10th ed. Boston: Cengage Learning.

(Primary textbook reference for general Java logic, class structures, and loops.)

Oracle. (2026). Class Scanner (java.util). [Online]. Available at: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html [Accessed 7 April 2026].

(Official documentation for handling console input in the Main class.)

Oracle. (2026). Lesson: Regular Expressions. [Online]. Available at: https://docs.oracle.com/javase/tutorial/essential/regex/ [Accessed 7 April 2026].

(Documentation used for implementing the Password and Cell Phone validation logic.)

W3Schools. (2026). Java User Input (Scanner). [Online]. Available at: https://www.w3schools.com/java/java_user_input.asp [Accessed 7 April 2026].

(Technical guide for implementing interactive user prompts.)

W3Schools. (2026). Java RegEx. [Online]. Available at: https://www.w3schools.com/java/java_regex.asp [Accessed 7 April 2026].

(Reference used for simplifying the validation patterns for security requirements.)

JUnit.org. (2026). JUnit 5 User Guide. [Online]. Available at: https://junit.org/junit5/docs/current/user-guide/ [Accessed 7 April 2026].

(Standard reference for the UnitTest class and automated assertion methods.)

YouTube. (2026). Unit Testing in IntelliJ with JUnit. [Online]. Available at: https://youtu.be/vZm0lHciFsQ?si=E1dygZPf2UgP85Ni [Accessed 7 April 2026].

(Video guide used for setting up the testing environment and writing test cases.)