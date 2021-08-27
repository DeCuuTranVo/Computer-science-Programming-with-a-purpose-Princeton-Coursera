package Programming_with_a_purpose.Week_2;

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        Integer n = Integer.parseInt(args[0]);
        Integer r = Integer.parseInt(args[1]);
        
        double sum = 0;
        double product = 1;
        for (int i = 1; i <= n; i++) {
            product = 1/(double) Math.pow(i, r);
            sum += product;
        }
        System.out.println(sum);
    }
}