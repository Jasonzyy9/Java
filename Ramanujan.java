/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int smallcube = (int) Math.cbrt(n);
        int count = 0;

        // StdOut.println(smallcube);
        for (int i = 1; i <= smallcube; i++) {
            double b = Math.cbrt(n - i * i * i);
            if (i < b) {
                if (b % 1 == 0) {
                    count++;
                    // StdOut.println(i + " " + b);
                }
            }
        }
        // StdOut.println(a);
        // StdOut.println(count);
        if (count >= 2) return true;
        else return false;

    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.print(isRamanujan(n));
    }
}
