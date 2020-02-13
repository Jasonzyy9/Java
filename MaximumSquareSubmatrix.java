/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int r = a.length;
        int c = a[0].length;
        int[][] s = new int[r][c];

        for (int i = 0; i < r; i++)
            s[i][0] = a[i][0];

        for (int j = 0; j < c; j++)
            s[0][j] = a[0][j];

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (a[i][j] == 1)
                    s[i][j] = Math.min(s[i][j - 1], Math.min(s[i - 1][j], s[i - 1][j - 1])) + 1;
                else
                    s[i][j] = 0;
            }
        }
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (max < s[i][j]) {
                    max = s[i][j];
                }
            }
        }
        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            int[][] a = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    a[i][j] = StdIn.readInt();
                }
            }
            StdOut.println(size(a));
            // for (int j = 0; j < n; j++) {
            //     for (int i = 0; i < n; i++) {
            //         StdOut.print(a[i][j] + " ");
            //     }
            //     StdOut.println();
            // }
        }

    }
}
