public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        int[] x_array = new int[m]; 
        double[] p_array = new double[m];
        double[] p_log_array = new double[m];
        //if sequence of integer > m or < 1?
        int count = 0;
        while (!StdIn.isEmpty())
        {
            int x = StdIn.readInt();
            x_array[x-1]++;
            count++;
            //StdOut.print(x + " ");  
        }
        
        for (int i = 0; i < m; i++) {
            p_array[i] = (double)x_array[i]/(double)count;
        }
        
        for (int i = 0; i < m; i++) {
            if (p_array[i] == 0) {
                p_log_array[i] = 0;
            } else {
                p_log_array[i] = - p_array[i]*(Math.log(p_array[i])/Math.log(2));
            }
        }

        double sum_entropy = 0;
        for (int i = 0; i < m; i++) {
            sum_entropy += p_log_array[i];
        }

        // for (int i = 0; i < m; i++) {
        //     StdOut.print(x_array[i] + " ");  
        // }
        // StdOut.println();
        // //StdOut.println(count);
        // for (int i = 0; i < m; i++) {
        //     StdOut.print(p_array[i] + " ");  
        // }
        // StdOut.println();

        // for (int i = 0; i < m; i++) {
        //     StdOut.print(p_log_array[i] + " ");  
        // }
        // StdOut.println();

        StdOut.printf("%.4f\n",sum_entropy);
    }
}
