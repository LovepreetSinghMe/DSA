package sorts2;

public class KeyIndexedSort {
    static public void sort(int[] a) {
        int n = a.length;
        int r = 6;
        int[] count = new int[r + 1];
        int[] aux = new int[n];

        for (int i = 0; i < n; i++) {
            count[a[i] + 1]++;
        }

        for (int i = 0; i < r; i++) {
            count[i + 1] += count[i];
        }

        for (int i = 0; i < n; i++) {
            aux[count[a[i]]++] = a[i];
        }

        System.out.println();
    }
}
