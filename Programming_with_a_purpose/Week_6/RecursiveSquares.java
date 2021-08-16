public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length/2);
        
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length/2);
        return;
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        
        // compute x- and y-coordinates of the 4 half-size H-trees
        double x0 = x - length/2;
        double x1 = x + length/2;
        double y0 = y - length/2;
        double y1 = y + length/2;

        // recursively draw 4 half-size H-trees of order n-1
        
        draw(n-1, x0, y1, length/2);    // upper left  H-tree
        draw(n-1, x1, y1, length/2);    // upper right H-tree
        drawSquare(x, y, length);
        draw(n-1, x0, y0, length/2);    // lower left  H-tree
        draw(n-1, x1, y0, length/2);    // lower right H-tree
        
        return;
    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double x = 0.5, y = 0.5;   // center of H-tree
        double size = 0.5;         // side length of H-tree
        draw(n, x, y, size);
    }
}