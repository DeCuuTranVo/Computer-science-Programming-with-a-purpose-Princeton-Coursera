import java.util.ArrayList;

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        // long limit = (long) Math.pow(n, 1.0/3.0);
        long count = 0;
        // boolean[] met = new boolean[2*((int)n +1)];
        ArrayList<Long> met = new ArrayList<Long>();

        for (int i = 0; i < Math.round(Math.cbrt(n)); i++) {
            double pow_i = Math.pow(i, 3);
            double substraction = n - pow_i;
            double third_sqrt = Math.cbrt(substraction);

            

            if ( third_sqrt == (long) third_sqrt) {
                

                // System.out.println("i: " + i);
                // System.out.println("third_sqrt: " + third_sqrt);
                // System.out.println("third_sqrt: " + (long) third_sqrt);

                if (met.contains((long)i) || met.contains((long)third_sqrt)) {
                    continue;
                } else {
                    met.add((int)count,(long)i);
                    met.add((int)count,(long)third_sqrt);

                    count ++;
                    // System.out.println("count: " + count);
                }  
            } 

            
        }

        if (count >= 2) {
            return true;
        }
        
        return false;
        
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);

        System.out.println(isRamanujan(n));

    }
}