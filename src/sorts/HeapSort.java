package sorts;

public class HeapSort {
    public static void sort(Comparable[] pq) {
        int N = pq.length - 1;
        for (int k = (N / 2); k >= 0; k--) {
            sink(pq, k, N);
        }

        while (N > 0) {
            exch(pq, 0, N);
            sink(pq, 0, --N);
        }
    }

    private static void sink(Comparable[] pq, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;

            if(j < N && less(pq, j, j + 1) ) j++;

            if(less(pq, j, k)) break;

            exch(pq, j, k);

            k = j;

            if(k == 0) break;
        }
    }

    private static boolean less(Comparable[] pq, int one, int two) {
        return pq[one].compareTo(pq[two]) < 0;
    }

    private static void exch(Comparable[] pq, int one, int two) {
        Comparable temp = pq[one];
        pq[one] = pq[two];
        pq[two] = temp;
    }
}
