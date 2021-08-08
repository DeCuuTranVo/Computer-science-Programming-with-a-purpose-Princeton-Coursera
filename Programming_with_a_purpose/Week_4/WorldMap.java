public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        //StdDraw.polygon()

        // to speed up performance, defer displaying points
        StdDraw.enableDoubleBuffering();

        // plot points, one at a time
        while (!StdIn.isEmpty()) {
            String next_line = StdIn.readLine();
            if (next_line.isEmpty()) {
                String name = StdIn.readString();
                int num_vertex = StdIn.readInt();
                double[] x_array = new double[num_vertex];
                double[] y_array = new double[num_vertex]; 
                for (int i = 0; i < num_vertex; i++) {
                    double x = StdIn.readDouble();
                    double y = StdIn.readDouble();
                    //StdDraw.point(x, y);
                    x_array[i] = x; 
                    y_array[i] = y;
                }
                StdDraw.polygon(x_array, y_array);   
            }
            // double x = StdIn.readDouble();
            // double y = StdIn.readDouble();
            // StdDraw.point(x, y);
        }

        // display all of the points now
        StdDraw.show();


        // StdOut.println(width);
        // StdOut.println(height);
    }
}
