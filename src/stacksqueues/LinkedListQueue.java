package stacksqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<Value> implements Iterable<Value> {
    private int size = 0;
    private Node first = null;
    private Node last = null;
    private class Node {
        Value value;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
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

        size++;
    }

    public Value dequeue() {
        Value item = first.value;

        first = first.next;

        if(isEmpty()) {
            last = null;
        }

        size--;
        return item;
    }

    public Iterator<Value> iterator() {
        return new QueueIterator(first);
    }

    private class QueueIterator implements Iterator<Value> {
        private Node current;

        QueueIterator(Node first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Value next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Value item = current.value;
            current = current.next;
            return item;
        }
    }

}
