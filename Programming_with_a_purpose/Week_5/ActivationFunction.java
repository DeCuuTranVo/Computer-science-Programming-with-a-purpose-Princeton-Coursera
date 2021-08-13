public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.valueOf(x).isNaN()) {
            return Double.NaN;
        }

        if (x < 0) {
            return 0;
        } else if (x == 0) {
            return 0.5;
        } else {
            return 1;
        }
    }

    // // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.valueOf(x).isNaN()) {
            return Double.NaN;
        }
        return 1/ (1 + Math.exp(-x));
    }

    // // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.valueOf(x).isInfinite()) {
            if (Double.valueOf(x) >0) {
                return 1.0; 
            } else {
                return -1.0;
            }        
        }

        if (Math.abs(Double.valueOf(x)) == Double.MAX_VALUE) {
            if (Double.valueOf(x) >0) {
                return 1.0; 
            } else {
                return -1.0;
            }        
        }

        if (Double.valueOf(x).isNaN()) {
            return Double.NaN;
        }
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x)); 
    }

    // // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.valueOf(x).isInfinite()) {
            if (Double.valueOf(x) >0) {
                return 1.0; 
            } else {
                return -1.0;
            }        
        }

        if (Math.abs(Double.valueOf(x)) == Double.MAX_VALUE) {
            if (Double.valueOf(x) >0) {
                return 1.0; 
            } else {
                return -1.0;
            }        
        }

        if (Double.valueOf(x).isNaN()) {
            return Double.NaN;
        }
        return x/(1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.valueOf(x).isNaN()) {
            return Double.NaN;
        }
        if (x <= -2) {
            return -1;
        } else if (x < 0) {
            return x + Math.pow(x,2)/4;
        } else if (x < 2) {
            return x - Math.pow(x,2)/4;
        } else {
            return 1;
        }
    }

    // // Takes a double command-line argument x and prints each activation
    // // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double heaviside_result = heaviside(x);
        double sigmoid_result = sigmoid(x);
        double tanh_result = tanh(x);
        double softsign_result = softsign(x);
        double sqnl_result = sqnl(x);
        StdOut.println("heaviside(" + x + ") = " + heaviside_result);
        StdOut.println("  sigmoid(" + x + ") = " + sigmoid_result);
        StdOut.println("     tanh(" + x + ") = " + tanh_result);
        StdOut.println(" softsign(" + x + ") = " + softsign_result);
        StdOut.println("     sqnl(" + x + ") = " + sqnl_result);

        
        // StdOut.println("tanh = " + tanh(-Double.MAX_VALUE));
        // StdOut.println("softsign = " + softsign(Double.MAX_VALUE));
    }

    // heaviside(0.0) = 0.5
    //   sigmoid(0.0) = 0.5
    //      tanh(0.0) = 0.0
    //  softsign(0.0) = 0.0
    //      sqnl(0.0) = 0.0
}