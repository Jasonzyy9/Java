/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {
    private static void pole4(int n, String from, String temp1, String temp2, String to) {

        if (n == 0) return;
        if (n % 2 != 0) pole4(n - 1, from, to, temp2, temp1);
        else pole4(n - 1, from, temp1, to, temp2);

        System.out.println("Move disc " + n + " from " + from + " to " + to);

        if (n % 2 != 0) pole4(n - 1, temp1, from, temp2, to);
        else pole4(n - 1, temp2, temp1, from, to);

    }

    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == 0) return;
        hanoi(n - 1, k, from, to, temp);
        System.out.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        pole4(k, "A", "C", "D", "B");
        hanoi((n - k), k, "A", "C", "D");
        pole4(k, "B", "A", "C", "D");
    }
}
