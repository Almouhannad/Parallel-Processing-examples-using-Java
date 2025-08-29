# ImageRecolor: Parallel Image Recoloring

## Description
This project demonstrates parallel image recoloring using two distinct methods: the Blocks Method and the Slices Method. It aims to showcase the performance benefits of parallel processing for image manipulation tasks by comparing the execution times of different threading strategies for each method. The application is built with Java and Maven, providing a clear and efficient way to recolor images.

## Features
*   **Image Recoloring:** Transform image colors based on predefined logic.
*   **Blocks Method:** A parallel processing approach where the image is divided into rectangular blocks, and each block is processed concurrently by a separate thread.
*   **Slices Method:** A parallel processing approach where the image is divided into horizontal slices, and each slice is processed concurrently by a separate thread.
*   **Performance Analysis:** Includes performance data and graphs for both methods across various thread counts, illustrating the impact of parallelization.
*   **Image I/O:** Functionality to open source images and save the recolored results.

## Technologies
*   **Java 21:** The core programming language used for the project.
*   **Maven:** A build automation tool used for project management and dependency handling.
*   **JUnit 4.13.2:** A framework for writing and running automated tests.

## Running the Project with IntelliJ IDEA

To run this project using IntelliJ IDEA, follow these steps:

1.  **Prerequisites:**
    *   **Java Development Kit (JDK) 21:** Ensure you have JDK 21 installed on your system.
    *   **IntelliJ IDEA:** Download and install IntelliJ IDEA (Community or Ultimate edition).

2.  **Clone the Repository:**
    ```bash
    git clone https://github.com/Almouhannad/Parallel-Processing-examples-using-Java.git
    cd Parallel-Processing-examples-using-Java/ImageRecolor
    ```

3.  **Open Project in IntelliJ IDEA:**
    *   Open IntelliJ IDEA.
    *   Select "Open" and navigate to the `Parallel-Processing-examples-using-Java/ImageRecolor` directory.
    *   Select the `pom.xml` file and click "Open". IntelliJ will recognize it as a Maven project.

4.  **Build the Project:**
    *   Once the project is loaded, IntelliJ IDEA will automatically download the necessary Maven dependencies.
    *   You can manually build the project by going to `Build` > `Build Project` in the IntelliJ menu.

5.  **Run the Application:**
    *   The project does not have a single main entry point. Instead, it provides `BlocksImageRecolorMethod` and `SlicesImageRecolorMethod` which can be extended and used in your own `main` method.
    *   To run the tests, navigate to `src/test/java/BlocksImageRecolorMethod/TestBlocksImageRecolorMethod.java` or `src/test/java/SlicesImageRecolorMethod/TestSlicesImageRecolorMethod.java`.
    *   Right-click on the test file and select `Run 'TestBlocksImageRecolorMethod'` or `Run 'TestSlicesImageRecolorMethod'` to execute the tests.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.