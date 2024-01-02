package sorts;

public class InsertionSort {
    public static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if(a[j] < a[j-1]) {
                    exch(a, j, j-1);
                } else break;
            }
        }
        return a;
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
