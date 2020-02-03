/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        double h = 0;
        int[] b = new int[m + 1];
        double[] pct = new double[m + 1];
        int count = 0;

        while (!StdIn.isEmpty()) {

            int p = StdIn.readInt();
            if (p >= 1 && p <= m) {
                b[p]++;
                count++;

            }
        }
        for (int i = 1; i <= m; i++) {
            pct[i] = (double) b[i] / (double) count;
            if (pct[i] != 0) {
                double a = pct[i] * ((Math.log(pct[i]) / Math.log(2)));
                h = h + a;
                // System.out.println(a);
            }
        }

        // System.out.println(pct[5] + " " + (Math.log(pct[5]) / Math.log(2)));
        // System.out.println(count + " " + b[1] + " " + b[2] + " " + h);
        StdOut.printf("%.4f\n", h * (-1));
    }
}
