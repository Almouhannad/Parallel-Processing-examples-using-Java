# Parallel Processing in Java

This repository contains two distinct parallel processing projects implemented in Java: `ImageRecolor` and `PrimesFinder`. Each sub-project demonstrates different parallelization techniques and their performance benefits for specific computational tasks.

## Projects

### 1. [ImageRecolor](ImageRecolor/README.md)
This project focuses on parallel image recoloring. It showcases how to apply image manipulation tasks concurrently using two different methods: the Blocks Method and the Slices Method. It includes performance analysis to illustrate the impact of parallelization on image processing.

### 2. [PrimesFinder](PrimesFinder/README.md)
This project explores efficient parallel prime number generation. It implements and compares various parallel algorithms, including the Chunks Method and the Sieve of Eratosthenes, to find prime numbers up to a given integer `n`. It provides a framework for benchmarking different parallel approaches to this classic problem.

## Technologies
*   **Java 21:** The core programming language used for both projects.
*   **Maven:** Used for project management and dependency handling.
*   **JUnit 4.13.2:** For automated testing within each sub-project.
*   **Java Multithreading:** Utilized extensively across both projects for parallel execution.

## Installation and Usage

To set up and run these projects, navigate to the respective sub-project directories (`ImageRecolor/` or `PrimesFinder/`) and follow the instructions in their `README.md` files. Each sub-project's `README.md` contains detailed information on building, running, and understanding its specific implementation.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
