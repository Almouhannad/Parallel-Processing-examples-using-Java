package TestSieveOfEratosthenes;

import PrimesFinder.Abstractions.IPrimesFinder;
import PrimesFinder.SieveOfEratosthenes.SieveOfEratosthenes;
import junit.framework.TestCase;

public class TestSieveOfEratosthenes extends TestCase {

    public void testSieveOfEratosthenesOutput() {
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
            IPrimesFinder finder = new SieveOfEratosthenes(nValues[i], 1);
            int primeCount = finder.getPrimesCount();
            assertEquals(expectedPrimeCounts[i], primeCount);
//            System.out.println("N= " + nValues[i]);
//            System.out.println("p= " + primeCount);
        }
    }

    public void testSieveOfEratosthenesPerformanceOn1e7() {
        int[] nValues = {10000000};
        int[] threadCounts = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
        int numRuns = 10;

        for (int n : nValues) {
            System.out.println("N = " + n);
            for (int threads : threadCounts) {
                System.out.println("  Threads: " + threads);
                long totalTime = 0;
                for (int i = 0; i < numRuns; i++) {
                    IPrimesFinder finder = new SieveOfEratosthenes(n, threads);
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

    public void testSieveOfEratosthenesPerformanceOn1e8() {
        int[] nValues = {100000000};
        int[] threadCounts = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
        int numRuns = 5;

        for (int n : nValues) {
            System.out.println("N = " + n);
            for (int threads : threadCounts) {
                System.out.println("  Threads: " + threads);
                long totalTime = 0;
                for (int i = 0; i < numRuns; i++) {
                    IPrimesFinder finder = new SieveOfEratosthenes(n, threads);
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
