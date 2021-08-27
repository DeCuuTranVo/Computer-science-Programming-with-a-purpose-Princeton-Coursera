package Programming_with_a_purpose.Week_2;

public class RandomWalkers {
    public static void main(String[] args) {
        
        Integer r = Integer.parseInt(args[0]);
        Integer trials = Integer.parseInt(args[1]);

        Integer total_steps = 0;

        for (int i = 0; i < trials; i++) {
            Integer x = 0;
            Integer y = 0;
            Integer distance = 0;
            Integer step = 0;
            while (distance < r) {
                double movement = Math.random();

                if (movement < 0.25) {
                    x += 1;
                } else if (movement < 0.5) {
                    x -= 1;
                } else if (movement < 0.75) {
                    y += 1;
                } else {
                    y -= 1;
                }

                // System.out.println("(" + x + ", " + y + ")");
                distance = Math.abs(x) + Math.abs(y);
                step++;
            }
            // System.out.println("steps = " + step);
            total_steps += step;
        }

        float average_steps = (float)total_steps/(float)trials;
        System.out.println("average number of steps = " + average_steps);
    }
}
