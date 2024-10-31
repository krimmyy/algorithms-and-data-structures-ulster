package Week2;

import java.util.Random;

public class BagComplexityTest {
    public static void main(String[] args) {

        LinkedBag<Integer> bag = new LinkedBag<Integer>();
        Random rand = new Random();

        int[] sizes = { 10, 10, 100, 1000, 10000, 100000 };
        long[] addTimes = new long [sizes.length];
        long[] removeTimes = new long [sizes.length];

        long startTime, endTime, totalTime;

        for (int i = 0; i < sizes.length; i++) {
            totalTime = 0;
            for (int j = 0; j < sizes[i]; j++) {
                startTime = System.nanoTime();
                bag.addNewEntry(rand.nextInt(sizes[i] * 10));
                endTime = System.nanoTime();
                totalTime = totalTime + (endTime - startTime);
            }
            addTimes[i] = totalTime;

            totalTime = 0;
            for (int j = 0; j < sizes[i]; j++) {
                startTime = System.nanoTime();
                bag.addNewEntry(rand.nextInt(sizes[i] * 10));
                endTime = System.nanoTime();
                totalTime = totalTime + (endTime - startTime);
            }
            removeTimes[i] = totalTime;
        }

        System.out.println("\n LinkedBag Performance Analysis (times in ns)");
        System.out.println("--------------------------------------------\n");

        System.out.printf("%20s \t %20s \t %20s \t %20s \t %20s \n",
                "LinkedBag Size", "Total Time to Add", "Avg Time to Add", "Total Time to add", "Avg Time to Remove");
        for (int i = 1; i < sizes.length; i++) {
            System.out.printf("%20d \t %20d \t %20d \t %20d \t %20d \n",
                    sizes[i], addTimes[i], addTimes[i] / sizes[i], removeTimes[i], removeTimes[i] / sizes[i]);
        }
    }
}
