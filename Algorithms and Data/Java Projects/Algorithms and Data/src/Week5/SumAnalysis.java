package Week5;

public class SumAnalysis {
    public static void main(String[] args) {
        int[] times = {1, 1, 10, 100, 1000, 10000, 100000, 1000000};
        long[] sumA = new long[times.length];
        long[] sumB = new long[times.length];
        long[] sumC = new long[times.length];

        long startTime, endTime, sum;

        for (int i = 0; i < times.length; i++) {
            startTime = System.nanoTime();
            sum = SumIntegers.sum_A(times[i]);
            endTime = System.nanoTime();
            sumA[i] = endTime - startTime;
        }

        for (int i = 0; i < times.length; i++) {
            startTime = System.nanoTime();
            sum = SumIntegers.sum_B(times[i]);
            endTime = System.nanoTime();
            sumB[i] = endTime - startTime;
        }

        for (int i = 0; i < times.length; i++) {
            startTime = System.nanoTime();
            sum = SumIntegers.sum_C(times[i]);
            endTime = System.nanoTime();
            sumC[i] = endTime - startTime;
        }
        System.out.printf("%15s \t %15s \t %15s \t %15s \n", "Num elements", "Algorithm A", "Algorithm B", "Algorithm C");
        for (int i = 1; i < times.length; i++) {
            System.out.printf("%15d \t %15d \t %15d \t %15d \n", times[i], sumA[i], sumB[i], sumC[i]);
        }
    }
}
