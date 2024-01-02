package stacksqueues;

public class LinkedListQueue<Value> {
    private Node first = null;
    private Node last = null;
    private class Node {
        Value value;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Value value) {
        Node oldLast = last;
        last = new Node();
        last.value = value;
        last.next = null;

        if(isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public Value dequeue() {
        Value item = first.value;

        first = first.next;

        if(isEmpty()) {
            last = null;
        }

        return item;
    }
}
