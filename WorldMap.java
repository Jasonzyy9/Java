/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        String name = "";
        int v = 0;

        while (!StdIn.isEmpty()) {

            name = StdIn.readString();
            v = StdIn.readInt();
            double[] x = new double[v];
            double[] y = new double[v];
            int j = 0;
            while (v != 0) {
                x[j] = StdIn.readDouble();
                y[j] = StdIn.readDouble();

                v--;
                if (v == 0) {
                    StdDraw.polygon(x, y);

                }
                j++;
            }

        }

        StdDraw.show();
    }
}
