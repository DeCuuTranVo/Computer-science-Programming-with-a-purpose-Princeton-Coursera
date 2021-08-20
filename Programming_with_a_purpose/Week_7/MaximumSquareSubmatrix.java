public class MaximumSquareSubmatrix {

    // // Returns the size of the largest contiguous square submatrix
    // // of a[][] containing only 1s.
    public static int size(int[][] a) {
        // Create a cache of the array a
        int[][] cache = new int[a.length][a[0].length];
        int max_subsquare_size = 0;
        // for (int i = 0; i < cache.length; i++) {
        //     for (int j = 0; j < cache[0].length; j++) {
        //         System.out.print(cache[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if ((i==0)||(j==0)) {
                    cache[i][j] = a[i][j];

                    if (cache[i][j] > max_subsquare_size) {
                        max_subsquare_size = cache[i][j];
                    }
                    continue;
                }

                if (a[i][j] == 0) {
                    cache[i][j] = 0;

                    if (cache[i][j] > max_subsquare_size) {
                        max_subsquare_size = cache[i][j];
                    }
                    continue;
                }

                cache[i][j] = 1 + Math.min(Math.min(cache[i][j-1], cache[i-1][j-1]), cache[i-1][j]);
                if (cache[i][j] > max_subsquare_size) {
                    max_subsquare_size = cache[i][j];
                }
                
            }
        }

        // for (int i = 0; i < cache.length; i++) {
        //     for (int j = 0; j < cache[0].length; j++) {
        //         System.out.print(cache[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        return max_subsquare_size;
       
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        // Input
        int n = StdIn.readInt();

        int[][] my_array = new int[n][n];

        for (int i = 0; i < n; i ++) {
            for (int j =0; j < n; j++) {
                my_array[i][j]=StdIn.readInt();
            }
        }

        // Process
        int array_size = size(my_array);


        // // Output
        // for (int i = 0; i < n; i ++) {
        //     for (int j =0; j < n; j++) {
        //         System.out.print(my_array[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println("");

        System.out.println(array_size);

    }
}