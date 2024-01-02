package stacksqueues;

public class ArrayQueue<Item> {
    Item[] queue;
    int pointer;

    public ArrayQueue() {
        queue = (Item[]) new Object[1];
        pointer = 0;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public void enqueue(Item item) {
        if(pointer == queue.length) resize(2 * queue.length);

        queue[pointer++] = item;
    }

    public Item dequeue() {
        Item item = queue[--pointer];
        queue[pointer] = null;

        if(pointer > 0 && pointer <= queue.length / 4) resize(queue.length / 2);
        return item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        for (int i = 0; i < pointer; i++) {
            copy[i] = queue[i];
        }

        queue = copy;
    }
}
