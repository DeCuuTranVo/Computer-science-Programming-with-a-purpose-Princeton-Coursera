package Programming_with_a_purpose.Week_3;

class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length -1];
        
        int[] s = new int[a.length];
        int[] result = new int[m];

        for (int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(args[i+1]);
        }

        int sum = 0;
        for (int j = 0; j < s.length; j++) {
            sum += a[j];
            s[j] = sum;
        }

        for (int k = 0; k < result.length; k++){
            int guess = (int) (Math.random() * sum);
            int result_item = 0;
            for (int j = 0; j < s.length; j++) {
                if ((s[j] <= guess ) && ( s[j+1] > guess )) {
                    result_item = j + 1;
                }
            }
            result[k] = result_item + 1;
        }

        for (int k = 0; k < result.length; k++) {
            System.out.print(result[k] + " ");
        }
        // for (int k = 0; k < m; k++) {

        // }

        // System.out.println(m);
        // for (int i = 0; i < a.length; i++) {
        //     System.out.print(a[i] + " ");
        // }

        // System.out.println();
        // for (int i = 0; i < a.length; i++) {
        //     System.out.print(s[i] + " ");
        // }



        
        
        


    }
}