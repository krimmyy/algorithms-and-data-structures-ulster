package Week2;

public final class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private boolean initialised = false;
    private static final int MAX_CAPACITY = 10000;

    private boolean isArrayFull() {
        return (bag.length == numberOfEntries);
    }

    private void checkInitialisation() {
        if (!initialised)
            throw new SecurityException("Week2.ArrayBag object is not initialised properly!");
    }

    private T removeElementAt(int index) {
        T result = null;
        if (!isEmpty() && index >= 0 && index < numberOfEntries) {
            result = bag[index];
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity) {
        if (capacity <= MAX_CAPACITY) {
            T[] tempBag = (T[]) new Object[capacity];
            bag = tempBag;
            numberOfEntries = 0;
            initialised = true;
        }else throw new IllegalStateException("Attempt to create a bag where the capacity exceeds the maximum");
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return (numberOfEntries == 0);

    }

    public boolean addNewEntry(T newEntry) {
        checkInitialisation();
        if (isArrayFull()) return false;
        else {
            bag[numberOfEntries++] = newEntry;
            return true;
        }

    }
    /* test for spare capacity in the bag and if it exists, add the new
    element and increment the number of elements in the bag

    @param (T) newEntry - the item to be added to the bag

    @return - (boolean) true if the item is added, false otherwise
     */

    public T remove() {
        checkInitialisation();
        return removeElementAt(numberOfEntries -1);
    }
    /* remove any element from the bag, if one is available, and decrement the number of elements.
    return the remove element or null if none is available.

    @return - (T) the element removed from the bag, or null
     */

    public boolean remove(T anEntry) {
        boolean found = false;
        int index = 0;
        while (!found && index < numberOfEntries)
            if (bag[index].equals(anEntry)) found = true;
            else index++;
        if (found) removeElementAt(index);
        return found;

    }
    /* remove the specified element from the bag, if it is present, and decrement
    the number of elements

    @return - (boolean) true if the element is available, false otherwise
     */

    public void clear() {
        while(!isEmpty()) remove();
    }
    /* empty the bag - set the number of elements to zero
     */
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for (int i = 0; i < numberOfEntries; i++)
            if (bag[i].equals(anEntry)) count++;
        return count;
    }
    /* count how many times a given element appears in the bag

    @param (T) anEntry - the element to look for in the bag

    @return - (int) the number of times that the given element appears
     */

    public boolean contains(T anEntry) {
        boolean found = false;
        int index = 0;
        while(!found && index < numberOfEntries)
            if (bag[index++].equals(anEntry)) found = true;
        return found;
    }
    /* check for the presence of a specified element in the bag

    @param (T) anEntry - the item to look for in the bag

    @return - (boolean) true if the bag contains the element, false otherwise
     */

    public T[] toArray() {
        T[] resultArray = (T[]) new Object[numberOfEntries];
        System.arraycopy(bag, 0, resultArray, 0, numberOfEntries);
        return resultArray;
    }

    public String toString() {
        String strResult = "Bag[";
        for (int i = 0; i < numberOfEntries; i++)
            strResult += bag[i] + " ";
        strResult += "]";
        return strResult;
    }

    public void display() {
        System.out.println("\n*** Displaying the Bag ***");
        displayArray(0, numberOfEntries - 1);
        System.out.println("******\n");
    }

    private void displayArray(int first, int last) {
        System.out.println(bag[first]);
        if (first < last) displayArray(first + 1, last);
    }

    public static void main(String[] args) {
        ArrayBag<String> bagOfNames = new ArrayBag<String>(5);

        System.out.println("Adding Adrian... " + bagOfNames.addNewEntry("Adrian"));
        System.out.println("Adding Mary... " + bagOfNames.addNewEntry("Mary"));
        System.out.println("Adding Zoe... " + bagOfNames.addNewEntry("Zoe"));

        Object[] arrayOfNames = bagOfNames.toArray();
        for (Object name : arrayOfNames) System.out.print(name + "...");
        System.out.println();

        System.out.println("Adding John... " + bagOfNames.addNewEntry("John"));
        System.out.println("Adding Siobhan... " + bagOfNames.addNewEntry("Siobhan"));
        System.out.println("Adding Patrick... " + bagOfNames.addNewEntry("Patrick"));

        Object[] arrayOfNames2 = bagOfNames.toArray();
        for (Object name : arrayOfNames2) System.out.print(name + "...");
        System.out.println();
    }
}
