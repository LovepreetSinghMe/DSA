package sorts;

public class ShellSort {
    public static int[] sort(int[] a) {
        int h = 1;

        while(h < (a.length / 3)) h = 3 * h + 1;

        while(h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && a[j-h] > a[j]; j -= h) {
                    int temp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = temp;
                }
            }

            h = (int) (double) (h / 3);
        }

        return a;
    }
}
