package stacksqueues;

public class ResizingArrayStack<Item> {
    Item[] stack;
    int pointer;

    public ResizingArrayStack() {
        stack = (Item[]) new Object[1];
        pointer = 0;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public void push(Item item) {
        if(pointer == stack.length) resize(2 * stack.length);

        stack[pointer++] = item;
    }

    public Item pop() {
        Item item = stack[--pointer];
        stack[pointer] = null;

        if(pointer > 0 && pointer <= stack.length / 4) resize(stack.length / 2);
        return item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        for(int i = 0; i < pointer; i++) {
            copy[i] = stack[i];
        }

        stack = copy;
    }
}
