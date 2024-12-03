package Week10;

import java.util.Arrays;
import java.util.Random;

public class Searching {

    public static <T> boolean inArray(T[] arr, T entry) {
        boolean found = false;
        int index = 0;

        while (!found && index < arr.length) {
            if (arr[index++].equals(entry)) found = true;
        }
        return found;
    }

    public static <T> boolean inArray_r(T[] arr, int first, int last, T entry) {
        if (first > last) return false;
        else if (arr[first].equals(entry)) return true;
        else return inArray_r(arr, first + 1, last, entry);
    }

    public static <T extends Comparable<T>> boolean binarySearch(T[] anArray, int first, int last, T searchValue) {
        int mid = (first + last) / 2;

        if (first > last) return false;
        else if (anArray[mid].equals(searchValue)) return true;
        else if (searchValue.compareTo(anArray[mid]) < 0)
            return binarySearch(anArray, first, mid - 1, searchValue);
        else return binarySearch(anArray, mid + 1, last, searchValue);
    }

    public static Integer[] getRandomAscendingArray(int size, int limit) {
        Random random = new Random();
        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (Integer)random.nextInt(limit);
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Integer[] arr =getRandomAscendingArray(100, 1000);
            int searchValue = random.nextInt(1000);
            System.out.println("Array: " + Arrays.toString(arr));
            System.out.println("Looking for " + searchValue + "... ");
            System.out.println(binarySearch(arr, 0, arr.length - 1, searchValue));
            System.out.println();
        }
//        Integer[] integerArray = { 1, 3, 5, 7, 9 };
//        String[] stringArray = { "one", "three", "five", "seven", "nine"};
//        AListChain myListInteger = new AListChain();
//        AListChain myListString = new AListChain();
//
//        System.out.println("5 in integerArray is " + inArray(integerArray, 5));
//        System.out.println("6 in integerArray is " + inArray(integerArray, 6));
//        System.out.println("9 in integerArray is " + inArray(integerArray, 9));
//        System.out.println();
//
//        System.out.println("five in stringArray is " + inArray(stringArray, "five"));
//        System.out.println("six in stringArray is " + inArray(stringArray, "six"));
//        System.out.println("nine in stringArray is " + inArray(stringArray, "nine"));
//        System.out.println();
//
//        System.out.println("5 in_r integerArray is " + inArray_r(integerArray, 0, integerArray.length - 1, 5));
//        System.out.println("6 in_r integerArray is " + inArray_r(integerArray, 0, integerArray.length - 1, 6));
//        System.out.println("9 in_r integerArray is " + inArray_r(integerArray, 0, integerArray.length - 1, 9));
//        System.out.println();
//
//        System.out.println("five in_r stringArray is " + inArray_r(stringArray, 0, stringArray.length - 1, "five"));
//        System.out.println("six in_r stringArray is " + inArray_r(stringArray, 0, stringArray.length - 1, "six"));
//        System.out.println("nine in_r stringArray is " + inArray_r(stringArray, 0, stringArray.length - 1, "nine"));
//        System.out.println();
//
//        myListInteger.add(1);
//        myListInteger.add(3);
//        myListInteger.add(5);
//        myListInteger.add(7);
//        myListInteger.add(9);
//
//        System.out.println("5 in myListInteger is " + myListInteger.contains_r(5));
//        System.out.println("6 in myListInteger is " + myListInteger.contains_r(6));
//        System.out.println("9 in myListInteger is " + myListInteger.contains_r(9));
//        System.out.println();
//
//        myListString.add("one");
//        myListString.add("three");
//        myListString.add("five");
//        myListString.add("seven");
//        myListString.add("nine");
//
//        System.out.println("five in myListString is " + myListString.contains_r("five"));
//        System.out.println("six in myListString is " + myListString.contains_r("six"));
//        System.out.println("nine in myListString is " + myListString.contains_r("nine"));
//        System.out.println();
    }
}
