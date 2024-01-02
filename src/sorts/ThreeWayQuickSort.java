package sorts;

public class ThreeWayQuickSort {

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int lt = lo, gt = hi;
        int i = lo;

        while (i <= gt) {
            int cmp = a[i].compareTo(a[lo]);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void sort(Comparable[] a) {
//       TODO randomize here

        sort(a, 0, a.length - 1);
    }
}
