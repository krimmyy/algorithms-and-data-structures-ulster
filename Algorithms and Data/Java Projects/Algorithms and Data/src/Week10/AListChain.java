package Week10;

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


    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }


    public T replace(int position, T newEntry) {
        if (position >= 1 && position <= numberOfEntries) {
            MyNode currentNode = getNodeAt(position);
            T dataValue = (T)currentNode.getData();
            currentNode.setData(newEntry);
            return dataValue;
        } else throw new IndexOutOfBoundsException("Replace position is out of bounds");
    }


    public T getEntry(int position) {
        if (position >= 1 && position <= numberOfEntries) {
            MyNode currentNode = getNodeAt(position);
            return (T)currentNode.getData();
        } else throw new IndexOutOfBoundsException("Get entry position is out of bounds");
    }


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


    public boolean contains(T anEntry) {
        boolean found = false;
        int i = 1;
        while (i <= numberOfEntries && !found)
            if (getEntry(i++).equals(anEntry)) found = true;
        return found;
    }

    public boolean contains_r(T anEntry) {
        return contains_r_r(firstNode, anEntry);
    }

    private boolean contains_r_r(MyNode fromNode, T anEntry) {
        boolean found;
        if (fromNode == null) return false;
        else if (fromNode.getData().equals(anEntry)) found = true;
        else found = contains_r_r(fromNode.getNext(), anEntry);
        return found;
    }

    public int getLength() {
        return numberOfEntries;
    }


    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }

}
