/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        double H = 0;
        if (x < 0) {
            H = 0;
        }
        else if (x == 0) {
            H = 0.5;
        }
        else if (x > 0) {
            H = 1;
        }
        else {
            H = Double.NaN;
        }
        return H;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        double s;
        s = 1 / (1 + Math.exp(x * (-1)));
        return s;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        double t;
        t = (Math.exp(x) - Math.exp(x * (-1))) / (Math.exp(x) + Math.exp(x * (-1)));
        return t;
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        double s;
        if (x == Double.NaN) {
            s = Double.NaN;
            return s;
        }

        s = x / (1 + Math.abs(x));
        return s;
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        double S;
        if (x < 0) {
            if (x <= -2) {
                S = -1;
            }
            else {
                S = x + x * x / 4;
            }
        }
        else if (x >= 2) {
            S = 1;
        }
        else {
            S = x - x * x / 4;
        }
        return S;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("tanh(" + x + ") = " + tanh(x));
        System.out.println("softsign(" + x + ") = " + softsign(x));
        System.out.println("sqnl(" + x + ") = " + sqnl(x));
    }
}
