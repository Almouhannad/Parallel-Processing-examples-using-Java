package TestChunksMethod;

import PrimesFinder.Abstractions.IPrimesFinder;
import PrimesFinder.ChunksMethod.ChunksMethod;
import junit.framework.TestCase;

public class TestChunksMethod extends TestCase {

    public void testChunksMethodOutput() {
        int[] expectedPrimeCounts = {
                25, // n = 100
                168, // n = 1000
                1229, // n = 10000
                9592, // n = 100000
                78498, // n = 1000000
                664579 // n = 10000000
        };

        int[] nValues = {100, 1000, 10000, 100000, 1000000, 10000000};

        for (int i = 0; i < nValues.length; i++) {
            IPrimesFinder finder = new ChunksMethod(nValues[i], 1);
            int primeCount = finder.getPrimesCount();
            assertEquals(expectedPrimeCounts[i], primeCount);
        }
    }

    public void testChunksMethodPerformanceOnSmallN() {
        int[] nValues = {100, 1000, 10000, 100000, 1000000};
        int[] threadCounts = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};
        int numRuns = 10;

        for (int n : nValues) {
            System.out.println("N = " + n);
            for (int threads : threadCounts) {
                System.out.println("  Threads: " + threads);
                long totalTime = 0;
                for (int i = 0; i < numRuns; i++) {
                    IPrimesFinder finder = new ChunksMethod(n, threads);
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

    public void testChunksMethodPerformanceOn1e7() {
        int[] nValues = {10000000};
        int[] threadCounts = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384};
        int numRuns = 5;

        for (int n : nValues) {
            System.out.println("N = " + n);
            for (int threads : threadCounts) {
                System.out.println("  Threads: " + threads);
                long totalTime = 0;
                for (int i = 0; i < numRuns; i++) {
                    IPrimesFinder finder = new ChunksMethod(n, threads);
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

    public void testChunksMethodPerformanceOn1e8() {
        int[] nValues = {100000000};
        int[] threadCounts = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384};
        int numRuns = 3;

        for (int n : nValues) {
            System.out.println("N = " + n);
            for (int threads : threadCounts) {
                System.out.println("  Threads: " + threads);
                long totalTime = 0;
                for (int i = 0; i < numRuns; i++) {
                    IPrimesFinder finder = new ChunksMethod(n, threads);
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

    public void testChunksMethodPerformanceOn1e8With1024Threads() {
        try {
            // Wait some time to connect using JConsole
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int[] nValues = {100000000};
        int[] threadCounts = {1024};
        int numRuns = 1;

        for (int n : nValues) {
            System.out.println("N = " + n);
            for (int threads : threadCounts) {
                System.out.println("  Threads: " + threads);
                long totalTime = 0;
                for (int i = 0; i < numRuns; i++) {
                    IPrimesFinder finder = new ChunksMethod(n, threads);
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