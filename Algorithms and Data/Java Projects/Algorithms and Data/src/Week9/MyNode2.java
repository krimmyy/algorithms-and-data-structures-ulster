package Week9;

public class MyNode2<T> {
    private T data;
    private MyNode2<T> next;
    private MyNode2<T> previous;


    public MyNode2(T dataValue) {
        data = dataValue;
        next = null;
        previous = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T dataValue) {
        data = dataValue;
    }

    public MyNode2<T> getNext() {
        return next;
    }

    public void setNext(MyNode2<T> nextNode) {
        next = nextNode;
    }

    public MyNode2<T> getPrevious() {
        return previous;
    }

    public void setPrevious(MyNode2<T> previousNode) {
        previous = previousNode;
    }
}


