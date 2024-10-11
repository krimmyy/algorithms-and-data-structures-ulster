package Week3;

import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T> {

    private MyNode<T> topNode;

    public Stack() {
        topNode = null;
    }

    public void push(T newEntry) {
        MyNode<T> newNode = new MyNode<T>(newEntry);
        newNode.setNext(topNode);
        topNode = newNode;
    }
    /* add a new entry to the top of the stack
    @param (T) newEntry - the entry to be added
     */

    public T pop() {
        T dataToReturn = peek();
        topNode = topNode.getNext();
        return dataToReturn;
    }
    /* remove an entry from the top of the stack
    throw EmptyStackException if called on an empty stack
    @return (T) - the value that was on the top of the stack
     */

    public T peek() {
        if (topNode == null) throw new EmptyStackException();
        else return topNode.getData();
    }
    /* return but don't remove the entry on the top of the stack
    throw EmptyStackException if called on an empty stack
    @return (T) - the value at the top of the stack
     */

    public boolean isEmpty() {
        return (topNode == null);
    }
    /* return true if the stack is empty, false otherwise
     */

    public void clear() {
        topNode = null;
    }
    /* remove all elements from the stack
     */

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (int i = 1; i < 4; i++) {
            try {
                System.out.println("Peek = " + stack.peek());
                System.out.println("Pop = " + stack.pop());
            } catch(EmptyStackException e) {
                System.out.println("Exception thrown!");
            }
        }
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("Stack empty is " + stack.isEmpty());
        stack.clear();
        System.out.println("Stack empty is " + stack.isEmpty());

    }

}
