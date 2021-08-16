public class RevesPuzzle {
    // public static int count_transfer = 0;
    // public static int count_move = 0;
    // public static int count = 0;

    public static void move(int n, int k, String pole_start, String pole_middle, String pole_end) {
        //count_move++;
        //System.out.println("move " + count_move);

        if (n == 0) {
            // System.out.println("return");
            
            return;
        }

        move(n-1, k, pole_start, pole_end, pole_middle);
        // count++;
        System.out.println("Move disc " + (n+k) + " from " + pole_start + " to " + pole_end);
        //System.out.println("step " + count);
        move(n-1, k, pole_middle, pole_start, pole_end);

        //System.out.println("return");
    }

    public static void transfer(int n, String pole_start, String pole_middle, String pole_end, String pole_other) {
        //count_transfer++;

        int k = (int) (n + 1 - Math.round(Math.sqrt(2 * n + 1)));
        //System.out.println("transfer " + count_transfer);
        if (k == 0) {
            System.out.println("Move disc 1 from " + pole_start + " to " + pole_end);
            // count++;
            return;
        }

        
        transfer(k , pole_start, pole_middle, pole_other, pole_end);
        move(n-k, k, pole_start, pole_middle, pole_end);
        transfer(k, pole_other, pole_middle, pole_end, pole_start);

        //System.out.println("return");
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        transfer(n, "A", "C", "D", "B");
        // System.out.println("total steps: " + count);
    }
}
