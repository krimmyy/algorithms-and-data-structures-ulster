package Week6;
import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static int numComparisons = 0, numSwaps = 0, numUpdates = 0;

    public static void bubbleSort_slow(int[] arr) {
        int lastPos = arr.length -1;
        int innerLastPos = lastPos;
        int temp;

        for (int i = 0; i < lastPos; i++) {
            for (int j = 0; j < innerLastPos; j++) {
                numComparisons++;
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    numSwaps++;
                }
            }
            innerLastPos--;
            System.out.println("Pass " + (i+1) + ": " + Arrays.toString(arr));
        }
    }

    public static void bubbleSort(int[] arr) {
        int firstPos = 0, lastPos = arr.length - 1;
        int temp, lastSwapPos;

        while (firstPos < lastPos) {
            lastSwapPos = firstPos;
            for (int j = firstPos; j < lastPos; j++) {
                numComparisons++;
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    numSwaps++;
                    lastSwapPos = j;
                }
            }
            lastPos = lastSwapPos;
            //System.out.println("Pass: " + Arrays.toString(arr));
        }
    }

    public static int[] randomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

//    public static void main(String[] args) {
//        int[] arr;
//        long startTime, endTime;
//        int[] arraySizes = { 100, 200, 400, 800, 1600, 3200, 6400 };
//
//        for (int arraySize : arraySizes) {
//            startTime = System.currentTimeMillis();
//            for (int i = 0; i < 1000; i++) {
//                arr = randomArray(arraySize);
//                bubbleSort(arr);
//            }
//            endTime = System.currentTimeMillis();
//            System.out.println(arraySize + "\t" + (endTime - startTime));
//        }
//    }

    public static void selectionSort(int[] arr) {
        int firstPos = 0, lastPos = arr.length - 1;
        int temp, smallestPos;

        for (int i = firstPos; i < lastPos; i++) {
            smallestPos = i;
            for (int j = i+1; j < lastPos; j++) {
                numComparisons++;
                if (arr[j] < arr[smallestPos]) {
                    smallestPos = j;
                }
            }
            temp = arr[smallestPos];
            arr[smallestPos] = arr[i];
            arr[i] = temp;
            numSwaps++;
            System.out.println("Pass " + (i+1) + ": " + Arrays.toString(arr));
        }
    }

    public static void selectionSort_r(int[] arr, int firstPos, int lastPos) {
        int temp, smallestPos;

        numComparisons++;
        if (firstPos < lastPos) {
            smallestPos = firstPos;
            for (int j = firstPos+1; j < lastPos; j++) {
                numComparisons++;
                if (arr[j] < arr[smallestPos]) {
                    smallestPos = j;
                }
            }
            temp = arr[smallestPos];
            arr[smallestPos] = arr[firstPos];
            arr[firstPos] = temp;
            numSwaps++;
            System.out.println("Pass: " + Arrays.toString(arr));
            selectionSort_r(arr, firstPos+1, lastPos);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 9, 2, 7, 1, 10, 3, 6, 4, 5, 8 };
        //int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        //int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println("Before: " + Arrays.toString(arr));
        selectionSort_r(arr, 0, arr.length - 1);
        System.out.println("After: " + Arrays.toString(arr));
        System.out.println("There were " + numComparisons + " comparisons and " + numSwaps + " updates.");
    }

//      public static void main(String[] args) {
//          int[] arr;
//          long startTime, endTime;
//          int[] arraySizes = { 100, 200, 400, 800, 1600, 3200, 6400 };
//          long[] sortTimes = new long[arraySizes.length];
//          long[] r_sortTimes = new long[arraySizes.length];
//
//          for (int a = 0; a < arraySizes.length; a++) {
//              startTime = System.currentTimeMillis();
//              for (int i = 0; i < 1000; i++) {
//                  arr = randomArray(arraySizes[a]);
//                  insertionSort(arr);
//              }
//              endTime = System.currentTimeMillis();
//              sortTimes[a] = endTime - startTime;
//          }
//
//          for (int a = 0; a < arraySizes.length; a++) {
//              startTime = System.currentTimeMillis();
//              for (int i = 0; i < 1000; i++) {
//                  arr = randomArray(arraySizes[a]);
//                  insertionSort_r(arr, 0, arr.length - 1);
//              }
//              endTime = System.currentTimeMillis();
//              r_sortTimes[a] = endTime - startTime;
//          }
//
//          for (int a = 0; a < arraySizes.length; a++) {
//              System.out.println(arraySizes[a] + "\t" + sortTimes[a] + "\t" + r_sortTimes[a]);
//          }
//      }
}
