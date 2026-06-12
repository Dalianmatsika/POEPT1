# Executive Report: QuickChat Application
### Full POE Integration (Parts 1, 2 & 3)

---

## 1. Executive Summary
This project outlines the development of a secure, robust, and interactive Java desktop application handling user identity management, validation, and an automated backend communications engine called **QuickChat**. Developed across three sequential phases, the application showcases strict **input validation**, **Object-Oriented Programming (OOP)** architectures, **advanced array-shifting data structures**, and **Test-Driven Development (TDD)**.

By keeping core business validation and data manipulation entirely separated from the user interface console layer, the system guarantees high data integrity, robust protection against crash states, and smooth execution metrics.

---

## 2. Technical Architecture
The application utilizes a clean, decoupled, four-tier class structure engineered inside the IntelliJ IDEA environment to maximize the separation of concerns:

* **Identity Engine (`Login.java`)**
    * Serves as the security gatekeeper for user profile creation and credential authorization.
    * Utilizes **Regular Expressions (Regex)** for swift, standardized formatting evaluations.
    * Leverages strict encapsulation rules via private variables to safeguard user profile components.
* **Validation Engine (`Message.java`)**
    * Manages immediate message creation boundaries, character length caps, and recipient phone constraints.
    * Tracks global system statistics across execution sessions utilizing **static counters**.
* **Data Storage & Management Engine (`StoredMessage.java`)**
    * Introduced in the final phase to serve as an in-memory database using synchronized **parallel arrays** (`messageID`, `storedMessages`, `messageHash`, `messageStatus`).
    * Houses core database algorithms for searching, filtering records, finding length variations, and performing dynamic row deletions via **index shifting elements**.
* **User Interface (`Main.java`)**
    * Orchestrates runtime execution menus and reads user inputs sequentially via a single `Scanner`.
    * Employs string-parsing strategies (`Integer.parseInt(scanner.nextLine())`) to isolate inputs and completely protect the console from infinite menu loops or unexpected alphanumeric crash states.
* **Quality Assurance (`UnitTest.java`)**
    * Formulates a comprehensive test suite powered by the **JUnit framework**.
    * Validates success/failure paths, data filtering lookups, string lengths, and structural array manipulation to ensure absolute predictability.

---

## 3. Key Functional Features

| Feature | Scope | Implementation Detail |
| :--- | :---: | :--- |
| **Username Validation** | Part 1 | Enforces a maximum of 5 characters and requires the inclusion of an underscore (`_`). |
| **Security Standards** | Part 1 | Enforces strong password rules (8+ chars, uppercase, number, special character) via Regex. |
| **Internationalization** | Part 1 | Validates cell numbers targeting South African international formatting rules via a `^\+27` pattern. |
| **Authentication Flow** | Part 1 | Cross-checks real-time login prompts against securely held registration profile variables. |
| **Length Validation** | Part 2 | Checks if text body is under 250 characters and dynamically calculates exact overflow values upon failure. |
| **Recipient Verification**| Part 2 | Performs formatting evaluations on active batch recipient cell number entry lines. |
| **Batch Processing** | Part 2 | Prompts user for a precise message count to run an execution sequence loop. |
| **Console Safeguards** | Part 2/3 | Captures inputs entirely as strings to clear out junk terminal lines and prevent runtime freezes. |
| **In-Memory Ledger Storage**| Part 3 | Populates parallel tracking arrays with distinct Message IDs, Body Text, Hashes, and Status flags. |
| **Status State Tracking** | Part 3 | Flags records dynamically as `"Sent"`, `"Stored"`, or `"Disregard"` based on real-time user selections. |
| **Algorithmic Search** | Part 3 | Performs linear lookups to locate record summaries by unique Message IDs or accumulate text strings by recipient phone numbers. |
| **Dynamic Record Deletion**| Part 3 | Wipes records by hash key and utilizes an array shifting loop to collapse empty gaps and preserve data sorting order. |
| **Tabular Report Auditing** | Part 3 | Uses explicit string formatting (`String.format()`) to produce structured, tabular data reports of the archive. |

---

## 4. Feature Progression Across Phases

### 🔹 Added in Part 2 (Messaging Core)
* **Interactive Main Menu:** Built a persistent workflow directing users between staging messages, viewing archives, and closing the app.
* **Message Object Integration:** Created the object blueprint to construct ID tokens, hash strings, and run local text size constraints.
* **Static Session Tracking:** Tied an atomic accumulator counter to the class definition to keep a session metric record of sent items.

### 🔹 Added in Part 3 & Final POE (Storage & Management Layer)
* **Parallel Array Database (`StoredMessage`):** Replaced static mock placeholders with a live database management class that handles parallel tracking arrays bound by a customizable storage cap.
* **Targeted Recipient and ID Queries:** Developed linear search loops. Searching an ID extracts a precise recipient/text breakdown; searching a phone number collects all associated text records into a single combined layout string.
* **Longest Record Assessment:** Added an evaluation sequence that iterates across the data cache rows to discover and return the single longest string block.
* **Array-Shifting Deletion Engine:** Implemented a secure row removal mechanism. When a specific hash is targeted for deletion, the system finds the index, slides all subsequent data entries down by one slot to cover the gap, and cleans out the trailing index duplicates by setting them back to `null`.
* **Tabular Audit Reporter:** Created a complete report summary engine that renders every element in the system within aligned, structured columns complete with clean borders and column headers.

---

## 5. Meeting the Rubric Criteria

* **Code Complexity / Defensive Design:** Complex conditions are streamlined down into predictable switch-case pathways, clean validation rules, and explicit loop exits. Input fields swallow invalid tokens gracefully without exposing stack traces.
* **Data Structuring & Encapsulation:** Array lengths, internal indices, and data states are fiercely encapsulated. Classes interact purely through well-defined public methods, protecting underlying arrays from direct, unauthorized manipulation.
* **Data Manipulation & Sorting Preservation:** The deletion module handles manual index tracking and array compaction perfectly, ensuring that when data is removed, the remaining rows stay organized, tightly packed, and clear of broken pointer indexes.
* **Testability / Automation:** The architecture isolates logic returns from printing calls. Every method returns distinct data layouts or status strings, allowing JUnit tests to rigorously verify array shifts, deletions, searches, and edge cases.

---

## 6. Video Demonstrations

Comprehensive video archives have been compiled showing the application operating seamlessly across all core phases. The presentations cover registration, runtime execution, data entry validation, search capabilities, hash-based row deletions, and a successful sweep of the automated unit test suite.

* **Phase 1 Walkthrough:** [POEPT1 Video Demonstration](https://youtu.be/HKKzuWHZvcM)
* **Phase 2 & 3 Integration Walkthrough:** [POEPT2 Video Demonstration](https://youtu.be/VQE_41y0aE4?si=01ImzTrse69jDP8G)

--- 

## 7. Final Outcome
The completed QuickChat Application successfully functions as an integrated software suite. It flows smoothly from a strict, validation-locked **Identity Verification Phase** directly into an advanced **QuickChat Management Engine**. Under this space, users are fully empowered to send messages, securely store communication logs within bounded parallel arrays, perform linear database searches, delete entries via data-shifting loops, and generate perfectly formatted tabular system audit reports.

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
