package stacksqueues;
import java.util.Iterator;

public class LinkedListStack<Item> implements Iterable<Item> {

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { return current != null; }

        public Item next() {
            Item item = current.value;
            current = current.next;

            return item;
        }
    }

    private Node first = null;

    private class Node {
        Item value;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.value = item;

        first.next = oldFirst;
    }

    public Item pop() {
        Item item = first.value;

        first = first.next;

        return item;
    }
}
