package Week10;

public interface ListInterface<T> {

    public void add(T newEntry);
    /* Adds a new entry to the end of this list.
    Entries currently in the list are unaffected
    The list's size is increased by 1.

    @param newEntry the object to be added as a new list entry
     */

    public void add(int newPosition, T newEntry);
    /* Adds a new entry to a specified position within this list.
    Entries originally at and above the specified position
    are at the next higher position within the list.
    The list's size is increased by 1.

    @param newPosition An integer that specifies the desired position of the new entry.

    @param newEntry The objet to be added as a new entry.

    @throws IndexOutOfBoundsException if either newPosition < 1 or newPosition > getLength() + 1
     */

    public T remove(int position);
    /* Removes the entry at the given position from the list
    Entries originally at positions higher than the given position
    are at the next lower position within the list and the list's size is decreased by 1.

    @param position An integer that indicates the position of the entry to be removed.

    @return A reference to the removed entry

    @throws IndexOutOfBounds if either position < 1 or position > getLength()
     */

    public void clear();
    /* Removes all entries from this list
     */

    public T replace(int position, T newEntry);
    /* Replaces the entry at the given position in this list

    @param position An integer that indicates the position of the entry to be removed.

    @param newEntry The object to be added as a new entry.

    @return The original entry that was replaced

    @throws IndexOutOfBounds if either position < 1 or position > getLength()
     */

    public T getEntry(int position);
    /* Retrieves the entry at the given position in this list.

    @param position An integer that indicates the position of the entry to be returned.

    @return a reference to the desired entry.

    @throws IndexOutOfBounds if either position < 1 or position > getLength()
     */

    public T[] toArray();
    /*  Retrieves all entries in this list in the order in which they appear in the list.

    @return A newly allocated array of all the entries in the list. If the list is empty, the returned array is empty.
     */

    public boolean contains(T anEntry);
    /* Check whether this list contains a given entry

    @param anEntry The object that is the desired entry

    @return true if the list contains anEntry, false otherwise
     */

    public int getLength();
    /* Gets the length of this list

    @return The integer number of entries in this list
     */

    public boolean isEmpty();
    /* Check whether this list is empty.

    @return True of getLength() == 0, false otherwise;
     */

}
