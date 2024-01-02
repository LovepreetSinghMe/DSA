package priorityqueues;

public class MaxPQ<Key extends Comparable<Key>> {
    private int N;

    private Key[] pq;

    public MaxPQ(int capacity) {
        N = 0;

        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {
        Key item = pq[1];
        exch(1, N--);
        sink(1);
//        prevent loitering
        pq[N+1] = null;
        return item;
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;

            if(j < N && less(j, j + 1) ) j++;

            if(less(j, k)) break;

            exch(j, k);

            k = j;
        }
    }

    private boolean less(int one, int two) {
        return pq[one].compareTo(pq[two]) < 0;
    }

    private void exch(int one, int two) {
        Key temp = pq[one];
        pq[one] = pq[two];
        pq[two] = temp;
    }
}
