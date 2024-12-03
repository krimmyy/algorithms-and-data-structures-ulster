package Week9;

import java.util.Arrays;

public class AListChain<T> implements ListInterface<T> {
    private MyNode firstNode;
    private int numberOfEntries;

    private MyNode getNodeAt(int position) {
        if (position >= 1 && position <= numberOfEntries) {
            MyNode currentNode = firstNode;
            for (int i = 1; i < position; i++)
                currentNode = currentNode.getNext();
            return currentNode;
        } else return null;
    }

    public AListChain() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public void add(T newEntry) {
        MyNode newNode = new MyNode<T>(newEntry);
        if (numberOfEntries == 0) firstNode = newNode;
        else {
            MyNode lastNode = getNodeAt(numberOfEntries);
            lastNode.setNext(newNode);
        }
        numberOfEntries++;
    }
    /* Adds a new entry to the end of this list.
    Entries currently in the list are unaffected
    The list's size is increased by 1.

    @param newEntry the object to be added as a new list entry
     */

    public void add(int newPosition, T newEntry) {
        if (newPosition >= 1 && newPosition <= numberOfEntries + 1) {
            MyNode newNode = new MyNode<T>(newEntry);
            if (newPosition == 1) {
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else {
                MyNode nodeBefore = getNodeAt(newPosition - 1);
                MyNode nodeAfter = nodeBefore.getNext();
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);
            }
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
        T result = null;
        if (position >= 1 && position <= numberOfEntries) {
            if (position == 1) {
                result = (T)firstNode.getData();
                firstNode = firstNode.getNext();
            } else {
                MyNode nodeBefore = getNodeAt(position - 1);
                MyNode nodeToRemove = nodeBefore.getNext();
                MyNode nodeAfter = nodeToRemove.getNext();
                result = (T)nodeToRemove.getData();
                nodeBefore.setNext(nodeAfter);
            }
            numberOfEntries--;
            return result;
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
        firstNode = null;
        numberOfEntries = 0;
    }
    /* Removes all entries from this list
     */

    public T replace(int position, T newEntry) {
        if (position >= 1 && position <= numberOfEntries) {
            MyNode currentNode = getNodeAt(position);
            T dataValue = (T)currentNode.getData();
            currentNode.setData(newEntry);
            return dataValue;
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
            MyNode currentNode = getNodeAt(position);
            return (T)currentNode.getData();
        } else throw new IndexOutOfBoundsException("Get entry position is out of bounds");
    }
    /* Retrieves the entry at the given position in this list.

    @param position An integer that indicates the position of the entry to be returned.

    @return a reference to the desired entry.

    @throws IndexOutOfBounds if either position < 1 or position > getLength()
     */

    public T[] toArray() {
        T[] arr = (T[]) new Object[numberOfEntries];
        MyNode currentNode = firstNode;
        int i = 0;
        while (i < numberOfEntries && currentNode != null) {
            arr[i++] = (T)currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return arr;
    }
    /*  Retrieves all entries in this list in the order in which they appear in the list.

    @return A newly allocated array of all the entries in the list. If the list is empty, the returned array is empty.
     */

    public boolean contains(T anEntry) {
        boolean found = false;
        int i = 1;
        while (i <= numberOfEntries && !found)
            if (getEntry(i++).equals(anEntry)) found = true;
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
