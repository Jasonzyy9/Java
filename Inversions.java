public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int count = 0;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i < j && a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        if (n < 0) return null;
        if (k < 0 || k > ((n * (n - 1)) / 2)) return null;
        int[] a = new int[n];
        int[] sub = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        for (int i = 0; i < n; i++) {
            sub[i] = i;
        }

        if (k <= (n - 1)) {
            int b = a[n - 1];
            for (int i = n - 1; i > (n - 1 - k); i--) {
                a[i] = a[i - 1];
            }
            a[(int) ((n - 1) - k)] = b;
        }
        else {
            int subtract = (int) k;
            int count = 0;
            int save = 0;
            for (int i = n - 1; subtract > 0; i--) {
                subtract = subtract - a[i];
                count++;
                if (subtract < 0) {
                    save = a[i];
                }
            }
            if (subtract < 0) {
                subtract = save - Math.abs(subtract);
            }
            if (subtract > 0) {
                for (int i = 0; i < count - 1; i++) {
                    a[i] = sub[(n - 1) - i];
                }
                for (int i = n - 1; i >= (count - 1); i--) {
                    a[i] = i - count + 1;
                }

                int b = a[n - 1];
                a[(n - 1) - subtract] = b;
                for (int i = 1; ((n - 1) - subtract + i) <= (n - 1); i++) {
                    int c = a[(n - 1) - subtract - 1];
                    a[(n - 1) - subtract + i] = c + i;
                }
            }
            else {
                for (int i = 0; i < count; i++) {
                    a[i] = sub[(n - 1) - i];
                }
                for (int i = 0; (i + count) <= (n - 1); i++) {
                    int c = sub[i];
                    a[i + count] = c;
                }
            }
        }
        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int[] p = generate(n, k);
        for (int i = 0; i < n; i++) {
            StdOut.print(p[i] + " ");
        }
    }
}
