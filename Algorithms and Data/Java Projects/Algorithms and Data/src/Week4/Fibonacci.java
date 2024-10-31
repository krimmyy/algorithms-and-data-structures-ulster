package Week4;

public class Fibonacci {

    private static int[] callCounts = new int [21];

    private static int fibonacci(int n) {
        callCounts[n]++;

        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int result = fibonacci(20);
        System.out.println("Fibonacci(20) = " + result);
        System.out.println();

        for (int i = 20; i >= 0; i--) {
            System.out.println(callCounts[i] + " calls to fibonacci(" + i + ")");
        }
    }
}
