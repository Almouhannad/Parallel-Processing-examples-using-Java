package TestChunksMethod;

import Abstractions.PrimesFinder;
import ChunksMethod.ChunksMethod;
import TestConstants.TestConstants;
import junit.framework.TestCase;

public class TestChunksMethod extends TestCase {

    private final int[] threadCounts = TestConstants.threadCounts;
    private final int numberOfTries = TestConstants.numberOfTries;

    private void outputTestHelper(int threads) {

        int[] expectedPrimeCounts = TestConstants.outputTestExpectedAnswers;
        int[] nValues = TestConstants.outputTestNs;

        for (int i = 0; i < nValues.length; i++) {
            PrimesFinder finder = new ChunksMethod(nValues[i], threads);
            int primeCount = finder.getPrimesCount();
            assertEquals(expectedPrimeCounts[i], primeCount);
        }
    }

    private void performanceTestHelper(int[] nValues) {
        for (int n : nValues) {
            System.out.println("N = " + n);
            for (int threads : threadCounts) {
                System.out.println("  Threads: " + threads);
                long totalTime = 0;
                for (int i = 0; i < numberOfTries; i++) {
                    PrimesFinder finder = new ChunksMethod(n, threads);
                    long start = System.currentTimeMillis();
                    finder.getPrimesCount();
                    long end = System.currentTimeMillis();
                    long time = (end - start);
                    totalTime += time;
                }
                long averageTime = totalTime / numberOfTries;
                System.out.println("  Average Time: " + averageTime + "ms");
            }
            System.out.println();
        }
    }

    public void testChunksMethodOutput() {
        outputTestHelper(1);
        outputTestHelper(2);
        outputTestHelper(4);
    }

    public void testChunksMethodPerformanceOnSmallN() {
        int[] nValues = {100, 1000, 10000, 100000, 1000000};
        performanceTestHelper(nValues);
    }

    public void testChunksMethodPerformanceOn1e7() {
        int[] nValues = {10000000};
        performanceTestHelper(nValues);
    }

    public void testChunksMethodPerformanceOn1e8() throws InterruptedException {
        Thread.sleep(10000);
        int[] nValues = {100000000};
        performanceTestHelper(nValues);
    }

    public void testChunksMethodPerformanceOn1e8With32Threads() throws InterruptedException {

        // To connect with JConsole
        Thread.sleep(10000);

        int[] nValues = {100000000};
        int[] threadCounts = {32};
        int numRuns = 3;

        for (int n : nValues) {
            System.out.println("N = " + n);
            for (int threads : threadCounts) {
                System.out.println("  Threads: " + threads);
                long totalTime = 0;
                for (int i = 0; i < numRuns; i++) {
                    PrimesFinder finder = new ChunksMethod(n, threads);
                    long start = System.currentTimeMillis();
                    finder.getPrimesCount();
                    long end = System.currentTimeMillis();
                    long time = (end - start);
                    totalTime += time;
                }
                long averageTime = totalTime / numRuns;
                System.out.println("  Average Time: " + averageTime + "ms");
            }
            System.out.println();
        }
    }

}