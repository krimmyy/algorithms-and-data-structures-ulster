package Week4;

public class SumOf {

    private static int sumOf(int n) {
        if (n == 1) return 1;
        else return n + sumOf(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("The sum of the integers up to 3 is " + sumOf(3));
        System.out.println("The sum of the integers up to 5 is " + sumOf(5));
        System.out.println("The sum of the integers up to 10 is " + sumOf(10));
    }
}
