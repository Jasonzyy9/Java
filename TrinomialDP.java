public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if ((n < (-1 * k)) || (k > n)) return 0;
        k = Math.abs(k);
        long[][] t = new long[n + 1][n + 2];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) t[i][j] = 1;
                else if ((j < (-1 * i)) || (j > i)) t[i][j] = 0;
                else {
                    if (j == 0) t[i][j] = t[i - 1][j + 1] + t[i - 1][j] + t[i - 1][j + 1];
                    else t[i][j] = t[i - 1][j - 1] + t[i - 1][j] + t[i - 1][j + 1];
                }
            }
        return t[n][k];

    }

    // Takes two integer command-line arguments n and k and prints T(n, k).

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));
    }
}
