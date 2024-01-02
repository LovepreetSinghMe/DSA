package sorts;

public class MergeSort {

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if(lo >= hi) return;

        int mid = (int) Math.floor((lo + hi) / 2);

        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);

        if(less(a[mid], a[mid + 1])) return;

        merge(a, aux, lo, mid, hi);
    }
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];

        sort(a, aux, 0, a.length - 1);
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
