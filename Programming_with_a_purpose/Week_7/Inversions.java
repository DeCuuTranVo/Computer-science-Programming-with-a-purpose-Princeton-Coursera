public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count_inversion = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count_inversion++;
                }
            }
        }

        return count_inversion;
    }

    // private static int[] inverse(int[] a, int i) {
    //     int temp = a[i];
    //     a[i] = a[i-1];
    //     a[i-1] = temp;
    //     return a;
    // }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] generated_array = new int[n];
        int limit = 0;
        // int count_loop = 0;
        
        for (int i = 0; i < n; i++) {
            generated_array[i] = i;
        }

        for (int i = n-1; i >= limit; i--) {
            // count_loop++;
            if (count(generated_array) >= k) {
                break;
            }
            
            if (i == limit) {
                i = n-1;
                limit++;
            }
            //generated_array = inverse(generated_array, i);  

            int temp = generated_array[i];
            generated_array[i] = generated_array[i-1];
            generated_array[i-1] = temp;
                        
            // System.out.print("With loop: " + count_loop  + "| the array is: ");
            // for (int j = 0; j < generated_array.length; j++) {
            //     System.out.print(generated_array[j] + " ");
            // }
            // System.out.println();
        }

        // long count_invesion = count(generated_array);
        // System.out.println("count inversion: " + count_invesion);
        return generated_array;

    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] generated_array = generate(n, k);

        for (int i = 0; i < generated_array.length; i++) {
            System.out.print(generated_array[i] + " ");
        }
        System.out.println();
    }
}