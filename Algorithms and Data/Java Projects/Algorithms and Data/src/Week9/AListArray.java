package Week9;

import java.time.temporal.ValueRange;
import java.util.Arrays;

public class AListArray<T> implements ListInterface<T> {

    private T[] list;
    private int numberOfEntries;
    private int capacity;
    private final int DEFAULT_SIZE = 100;

    private void addCapacity() {
        capacity += DEFAULT_SIZE;
        list = Arrays.copyOf(list, capacity + 1);
    }

    public AListArray() {
        T[] tempList = (T[]) new Object[DEFAULT_SIZE + 1];
        numberOfEntries = 0;
        list = tempList;
        capacity = DEFAULT_SIZE;
    }

    public void add(T newEntry) {
        if (numberOfEntries == capacity) addCapacity();
        numberOfEntries++;
        list[numberOfEntries] = newEntry;

    }
    /* Adds a new entry to the end of this list.
    Entries currently in the list are unaffected
    The list's size is increased by 1.

    @param newEntry the object to be added as a new list entry
     */

    public void add(int newPosition, T newEntry) {
        if (newPosition >= 1 && newPosition <= numberOfEntries + 1) {
            if (numberOfEntries == capacity) addCapacity();
            for (int i = numberOfEntries; i >= newPosition; i--) list[i + 1] = list[i];
            list[newPosition] = newEntry;
            numberOfEntries++;
            } else throw new IndexOutOfBoundsException("New entry position is out of bounds");
    }
    /* Adds a new entry to a specified position within this list.
    Entries originally at and above the specified position
    are at the next higher position within the list.
    The list's size is increased by 1.

    @param newPosition An integer that specifies the desired position of the new entry.

    @param newEntry The objet to be added as a new entry.

    @throws IndexOutOfBoundsException if either newPosition < 1 or newPosition > getLength() + 1
     */

    public T remove(int position) {
        if (position >= 1 && position <= numberOfEntries) {
            T valueToReturn = list[position];
            for (int i = position; i < numberOfEntries; i++) list[i] = list[i + 1];
            numberOfEntries--;
            return valueToReturn;
        } else throw new IndexOutOfBoundsException("Remove position is out of bounds");

    }
    /* Removes the entry at the given position from the list
    Entries originally at positions higher than the given position
    are at the next lower position within the list and the list's size is decreased by 1.

    @param position An integer that indicates the position of the entry to be removed.

    @return A reference to the removed entry

    @throws IndexOutOfBounds if either position < 1 or position > getLength()
     */

    public void clear() {
        numberOfEntries = 0;
    }
    /* Removes all entries from this list
     */

    public T replace(int position, T newEntry) {
        if (position >= 1 && position <= numberOfEntries) {
            T valueToReturn = list[position];
            list[position] = newEntry;
            return valueToReturn;
        } else throw new IndexOutOfBoundsException("Replace position is out of bounds");
    }
    /* Replaces the entry at the given position in this list

    @param position An integer that indicates the position of the entry to be removed.

    @param newEntry The object to be added as a new entry.

    @return The original entry that was replaced

    @throws IndexOutOfBounds if either position < 1 or position > getLength()
     */

    public T getEntry(int position) {
        if (position >= 1 && position <= numberOfEntries) {
            return list[position];
        } else throw new IndexOutOfBoundsException("Get entry position is out of bounds");
    }
    /* Retrieves the entry at the given position in this list.

    @param position An integer that indicates the position of the entry to be returned.

    @return a reference to the desired entry.

    @throws IndexOutOfBounds if either position < 1 or position > getLength()
     */

    public T[] toArray() {
        T[] arr = (T[]) new Object[numberOfEntries];
        System.arraycopy(list, 1, arr, 0, numberOfEntries);
        return arr;
    }
    /*  Retrieves all entries in this list in the order in which they appear in the list.

    @return A newly allocated array of all the entries in the list. If the list is empty, the returned array is empty.
     */

    public boolean contains(T anEntry) {
        boolean found = false;
        int i = 1;
        while (i <= numberOfEntries && !found)
            if (list[i++].equals(anEntry)) found = true;
        return found;
    }
    /* Check whether this list contains a given entry

    @param anEntry The object that is the desired entry

    @return true if the list contains anEntry, false otherwise
     */

    public int getLength() {
        return numberOfEntries;
    }
    /* Gets the length of this list

    @return The integer number of entries in this list
     */

    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }
    /* Check whether this list is empty.

    @return True of getLength() == 0, false otherwise;
     */

}
