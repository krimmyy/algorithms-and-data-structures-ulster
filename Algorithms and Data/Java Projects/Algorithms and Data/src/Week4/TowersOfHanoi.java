package Week4;

import java.util.Scanner;

public class TowersOfHanoi {

    private static final String SOURCE = "Source";
    private static final String SPARE = "Spare";
    private static final String TARGET = "Target";

    public static void solveTowers(int numberOfDisks, String source, String spare, String target) {
        if (numberOfDisks == 1)
            System.out.println(source + " => " + target);
        else {
            solveTowers(numberOfDisks - 1, source, target, spare);
            System.out.println(source + " => " + target);
            solveTowers(numberOfDisks - 1, spare, source, target);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of disks > ");
        int noOfDisks = scanner.nextInt();
        solveTowers(noOfDisks, SOURCE, SPARE, TARGET);
    }

}
