public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if ((a == 0) && (b == 0)) {
            return 0;
        }

        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = a;
            a = b;
            b = temp%b;
        }

        return a;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if ((a == 0) || (b == 0)) {
            return 0;
        }
        return (Math.abs(a)/gcd(a, b))*Math.abs(b);
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        if (gcd(a, b) == 1) {
            return true;
        }
        return false;
    }

    // // Returns the number of integers between 1 and n that are
    // // relatively prime with n.
    public static int totient(int n) {
        if (n <= 0) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (areRelativelyPrime(n, i)) {
                count++;
            }
        }
        return count;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int greatest_common_divisor = gcd(a, b); 
        int least_common_multiple = lcm(a, b);
        boolean are_relatively_prime = areRelativelyPrime(a, b); 
        int totient_a = totient(a);
        int totient_b = totient(b);

        StdOut.println("gcd(" + a + ", " + b + ") = " + greatest_common_divisor);
        StdOut.println("lcm(" + a + ", " + b + ") = " + least_common_multiple);
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + are_relatively_prime);
        StdOut.println("totient(" + a + ") = " + totient_a);
        StdOut.println("totient(" + b + ") = " + totient_b);
    }
// gcd(1440, 408) = 24
// lcm(1440, 408) = 24480
// areRelativelyPrime(1440, 408) = false
// totient(1440) = 384
// totient(408) = 128
}