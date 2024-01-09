package priorityqueues;
public class MinPQ<T extends Comparable<T>> {
    private T[] pq;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MinPQ() {
        pq = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    public MinPQ(int initialCapacity) {
        pq = (T[]) new Comparable[initialCapacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(T item) {
        if (size == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++size] = item;
        swim(size);
    }

    public T deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        T min = pq[1];
        exchange(1, size--);
        sink(1);
        pq[size + 1] = null; // avoid loitering
        if (size > 0 && size == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        return min;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exchange(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Comparable[capacity];
        for (int i = 1; i <= size; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
}
