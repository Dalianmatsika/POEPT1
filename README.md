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

| Feature | Implementation Detail |
| :--- | :--- |
| **Username Validation** | Enforces a max of 5 characters and the inclusion of an underscore (`_`). |
| **Security Standards** | Enforces "Strong Password" rules (8+ chars, Uppercase, Numbers, Special Chars) via Regex. |
| **Internationalization** | Uses Regex (`^\\+27...`) to validate South African cell phone formats. |
| **Error Handling** | Returns specific, user-friendly error messages that match requirements exactly. |
| **Authentication** | Compares real-time login attempts against previously "captured" registration data. |

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