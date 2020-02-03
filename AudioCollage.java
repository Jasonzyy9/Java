/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] b = a;

        for (int i = 0; i < b.length; i++) {
            b[i] = alpha * b[i];
        }
        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = a;
        int j = b.length;
        for (int i = 0; i < b.length; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[i + a.length] = b[i];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] c;
        double[] d;
        if (a.length < b.length) {
            c = new double[b.length];
            d = new double[b.length];
            for (int i = 0; i < a.length; i++) {
                d[i] = a[i];
            }
            for (int i = 0; i < c.length; i++) {
                c[i] = d[i] + b[i];
            }
            return c;
        }
        else if (a.length > b.length) {
            c = new double[a.length];
            d = new double[a.length];
            for (int i = 0; i < b.length; i++) {
                d[i] = b[i];
            }
            for (int i = 0; i < c.length; i++) {
                c[i] = a[i] + d[i];
            }
            return c;
        }
        else {
            c = new double[a.length];
            for (int i = 0; i < c.length; i++) {
                c[i] = a[i] + b[i];
            }
            return c;
        }

        // for (int i = 0; i < c.length; i++) {
        //     c[i] = a[i] + b[i];
        // }
        // return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int N = (int) (a.length * alpha);
        double[] b = new double[N + 1];
        for (int i = 0; i <= N; i++) {
            b[i] = a[i];
        }
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] a = StdAudio.read("piano.wav");
        double[] b = StdAudio.read("beatbox.wav");
        double[] c = StdAudio.read("harp.wav");
        double[] d = StdAudio.read("singer.wav");
        double[] e = StdAudio.read("exposure.wav");

        double[] n1 = merge(d, e);
        StdAudio.play(n1);

        double[] n2 = reverse(d);
        StdAudio.play(n2);

        double[] n3 = amplify(merge(a, b), 2);
        StdAudio.play(n3);

        double[] n4 = mix(a, d);
        StdAudio.play(n4);

        StdAudio.close();
    }
}
