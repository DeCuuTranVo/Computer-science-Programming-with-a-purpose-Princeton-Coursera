public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        //boolean[][] dark_color = new boolean[n][n];
        StdDraw.setScale(0, n);
        
        //StdDraw.show();
        //StdOut.println(n);
        boolean color_flag = true;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if (color_flag == false) {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                } else {
                    StdDraw.setPenColor(StdDraw.BLUE);
                }

                color_flag = !color_flag;
                StdDraw.filledSquare(i+0.5,j+0.5,0.5);
                //StdDraw.setPenColor(StdDraw.BLACK);
                //StdDraw.text(i+0.5,j+0.5,"("+i+","+j+")");
            }

            if (n%2 == 0) {
                color_flag = !color_flag;
            }
            
        } 
    }
    
}
