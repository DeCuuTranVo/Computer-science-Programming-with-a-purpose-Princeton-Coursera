public class TrinomialDP {
    
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        int full = 300;
        int half = full / 2;
        long[][] coefficients = new long[full+1][full+1];

        //coefficients[50][50] = 1;

        // for (int i = 0; i < full; i++) {
        //     for (int j = 0; j < full; j++) {
        //         StdOut.println("current n: " + i + ", k: " + j);

        //         if ((i == 0) && (j == 0)) {
        //             coefficients[i][j] = 1;
        //         }

        //         if ((j < -i) || (j > i)) {
        //             coefficients[i][j] = 0;
        //         }

        //         coefficients[i][j] =   coefficients[i-1][j-1] +  coefficients[i-1][j] +  coefficients[i-1][j+1]; 
        //     }
        // }        

        for (int i = -half; i < half; i++) {
            for (int j = -half; j < half; j++) {
                //StdOut.println("current n: " + i + ", k: " + j);
                if ((i == 0) && (j == 0)) {
                    coefficients[i+ half][j+half] = 1;
                    //StdOut.println("current n: " + (i+ half) + ", k: " + (j+half) + " = " + 1);
                } else if ((j < -i) || (j > i)) {
                    coefficients[i + half][j + half] = 00;
                } else {
                    coefficients[i + half][j+half] = coefficients[i-1 + half][j-1 + half] + coefficients[i-1 + half][j + half] + coefficients[i-1 + half][j+1 + half];
                }
            }
        }

        // for (int i = 0; i < full +1; i++) {
        //     for (int j = 0; j < full +1; j++) {
        //         System.out.print(coefficients[i][j] + "\t");
        //     }
        //     System.out.println();
        // }
        return coefficients[n+half][k+half];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));


    }
}
