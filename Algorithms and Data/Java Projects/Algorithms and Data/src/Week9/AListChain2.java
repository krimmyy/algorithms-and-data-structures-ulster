package Week9;

public class AListChain2<T> implements ListInterface<T> {
    private MyNode2 firstNode, lastNode;
    private int numberOfEntries;

    private MyNode2 getNodeAt(int position) {
        if (position >= 1 && position <= numberOfEntries) {
            MyNode2 currentNode = firstNode;
            for (int i = 1; i < position; i++)
                currentNode = currentNode.getNext();
            return currentNode;
        } else return null;
    }

    public AListChain2() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    public void add(T newEntry) {
        MyNode2 newNode = new MyNode2<T>(newEntry);
        if (numberOfEntries == 0) {
            firstNode = newNode;
            lastNode = newNode;
        }
        else {
            lastNode.setNext(newNode);
            newNode.setPrevious(lastNode);
            lastNode = newNode;
        }
        numberOfEntries++;
    }

    public void add(int newPosition, T newEntry) {
        if (newPosition >= 1 && newPosition <= numberOfEntries + 1) {
            MyNode2 newNode = new MyNode2<T>(newEntry);
            if (numberOfEntries == 0) {
                firstNode = newNode;
                lastNode = newNode;
            }
            else if (newPosition == 1) {
                firstNode.setPrevious(newNode);
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else if (newPosition == numberOfEntries + 1) {
                newNode.setPrevious(lastNode);
                lastNode.setNext(newNode);
                lastNode = newNode;
            } else {
                MyNode2 nodeBefore = getNodeAt(newPosition - 1);
                MyNode2 nodeAfter = nodeBefore.getNext();
                newNode.setNext(nodeAfter);
                newNode.setPrevious(nodeBefore);
                nodeBefore.setNext(newNode);
                nodeAfter.setPrevious(newNode);
            }
            numberOfEntries++;
        } else throw new IndexOutOfBoundsException("New entry position is out of bounds");
    }

    public T remove(int position) {
        T result = null;
        if (position >= 1 && position <= numberOfEntries) {
            if (numberOfEntries == 1) {
                result = (T)firstNode.getData();
                firstNode = null;
                lastNode = null;
            } else if (position == 1) {
                result = (T)firstNode.getData();
                firstNode.getNext().setPrevious(null);
                firstNode = firstNode.getNext();
            } else if (position == numberOfEntries) {
                result = (T)lastNode.getData();
                lastNode = lastNode.getPrevious();
                lastNode.setNext(null);
            }
            else {
                MyNode2 nodeBefore = getNodeAt(position - 1);
                MyNode2 nodeToRemove = nodeBefore.getNext();
                MyNode2 nodeAfter = nodeToRemove.getNext();
                result = (T)nodeToRemove.getData();
                nodeBefore.setNext(nodeAfter);
                nodeAfter.setPrevious(nodeBefore);
            }
            numberOfEntries--;
            return result;
        } else throw new IndexOutOfBoundsException("Remove position is out of bounds");

    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    public T replace(int position, T newEntry) {
        if (position >= 1 && position <= numberOfEntries) {
            MyNode2 currentNode = getNodeAt(position);
            T dataValue = (T)currentNode.getData();
            currentNode.setData(newEntry);
            return dataValue;
        } else throw new IndexOutOfBoundsException("Replace position is out of bounds");
    }

    public T getEntry(int position) {
        if (position >= 1 && position <= numberOfEntries) {
            MyNode2 currentNode = getNodeAt(position);
            return (T)currentNode.getData();
        } else throw new IndexOutOfBoundsException("Get entry position is out of bounds");
    }

    public T[] toArray() {
        T[] arr = (T[]) new Object[numberOfEntries];
        MyNode2 currentNode = firstNode;
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

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }

}
