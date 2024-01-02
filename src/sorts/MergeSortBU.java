package sorts;

public class MergeSortBU {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];

        for (int sz = 2; sz < a.length * 2; sz = 2 * sz) {
            for(int lo = 0; lo < a.length; lo += sz) {
                int high = Math.min(lo + sz - 1, a.length - 1);
                int mid = lo + (sz / 2) - 1;
                merge(a, aux, lo, mid, high);
            }
        }
    }

    public static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int hi) {
        assert isSorted(a, low, mid);
        assert isSorted(a, mid + 1, hi);

        for (int i = low; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = low, j = mid + 1;

        for (int k = low; k <= hi; k++) {

            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }

        assert isSorted(a, low, hi);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            if(less(a[lo + 1], a[lo])) return false;
        }

        return true;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
