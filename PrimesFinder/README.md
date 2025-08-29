# PrimesFinder: Parallel Prime Number Generation

## Description
This project focuses on efficiently finding prime numbers up to a given integer `n` by implementing and comparing different parallel algorithms. It provides a robust framework for exploring the performance benefits of multithreading in prime number generation. Developers and researchers interested in parallel computing and number theory will find this project useful for understanding and benchmarking different approaches to this classic problem.

## Features
*   Parallel prime number generation using the Chunks Method.
*   Parallel prime number generation using the Sieve of Eratosthenes.
*   Abstract `PrimesFinder` class for easy extensibility with new algorithms.
*   Designed for performance analysis and comparison of different parallel approaches.

## Technologies
*   Java 21
*   Maven
*   JUnit 4.13.2 (for testing)
*   Java Multithreading (Thread and Runnable)

## Installation
To get this project up and running locally, follow these steps:

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/PrimesFinder.git
    cd PrimesFinder
    ```
2.  **Build the project using Maven:**
    ```bash
    mvn clean install
    ```

## Usage
### Required Installations

Before you begin, ensure you have the following installed:

*   **Java Development Kit (JDK) 21 or higher:** You can download it from the [Oracle website](https://www.oracle.com/java/technologies/downloads/).
*   **IntelliJ IDEA:** Download the Community or Ultimate edition from the [JetBrains website](https://www.jetbrains.com/idea/download/).
*   **Maven:** While IntelliJ IDEA often bundles Maven, it's good practice to have it installed separately. Download it from the [Maven website](https://maven.apache.org/download.cgi).

### Running the Project in IntelliJ IDEA

1.  **Open the Project:**
    *   Launch IntelliJ IDEA.
    *   Select `File` > `Open` and navigate to the `PrimesFinder` directory. Select the `pom.xml` file and click `Open`.
    *   IntelliJ IDEA should automatically detect it as a Maven project and import it. If not, right-click on `pom.xml` in the `Project` tool window and select `Maven` > `Reload Project`.

2.  **Build the Project:**
    *   Once the project is imported, IntelliJ IDEA will automatically download the necessary Maven dependencies.
    *   You can manually build the project by going to `Build` > `Build Project` in the IntelliJ menu.

3.  **Run the Tests:**
    *   The project provides test classes for `ChunksMethod` and `SieveOfEratosthenes`.
    *   To run the `ChunksMethod` tests, navigate to `src/test/java/TestChunksMethod/TestChunksMethod.java`.
    *   To run the `SieveOfEratosthenes` tests, navigate to `src/test/java/TestSieveOfEratosthenes/TestSieveOfEratosthenes.java`.
    *   Right-click on the desired test file in the `Project` tool window and select `Run 'TestChunksMethod'` or `Run 'TestSieveOfEratosthenes'` respectively.
    *   Alternatively, you can click the green play icon next to the test class or individual test methods in the editor and select the appropriate run option.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
