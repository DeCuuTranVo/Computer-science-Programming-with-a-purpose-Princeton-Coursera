package Programming_with_a_purpose.Week_3;

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] count = new int[1000];
        double[] fraction = new double[1000];
        int acumulate_sum = 0;

        for (int i = 0; i < trials; i++) {
            int num_person = 0; 
            boolean[] birthday_array = new boolean[n];
            while(true) {            
                int birthday = (int) (Math.random()*n);
                num_person++;
                if (birthday_array[birthday] == true) {
                    break;
                } else {
                    birthday_array[birthday] = true;
                }
            }
            count[num_person]++;
        }

        // System.out.println(count.length);
        // for (int i = 0; i < count.length; i++) {
        //     System.out.print(count[i] + " ");
        // }


        for (int i = 0; i < count.length; i++) {
            acumulate_sum += count[i];
            fraction[i] = (double)acumulate_sum/(double)trials;
        }

        for (int i = 1; i < count.length; i++) {
            System.out.println(i + "\t" + count[i] + "\t" + fraction[i]);
            if (fraction[i] >= 0.5) {
                break;
            }
        }


    }
}

