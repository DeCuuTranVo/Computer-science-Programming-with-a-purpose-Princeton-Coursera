public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359) throw new IllegalArgumentException();
        if (s < 0 || s > 100) throw new IllegalArgumentException();
        if (b < 0 || b > 100) throw new IllegalArgumentException();

        this.hue = h;
        this.saturation = s;
        this.brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + this.hue + ", " + this.saturation + ", " + this.brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (this.saturation == 0 || this.brightness == 0) {
            return true;
        }
        return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException();
        }


        return (int)Math.round(Math.min(Math.pow(this.hue - that.hue, 2), Math.pow(360 - Math.abs(this.hue - that.hue), 2)) + Math.pow(this.saturation - that.saturation, 2) + Math.pow(this.brightness - that.brightness,2));
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // read data from input arguments 
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        // System.out.println("h: " + h + ", s: " + s + ", b: " + b);

        ColorHSB preference_color = new ColorHSB(h,s, b);
        // System.out.println(preference_color.toString());

        int min_distance = Integer.MAX_VALUE;
        String min_name = "";
        ColorHSB min_color = null; //new ColorHSB(h , s, b);
        // loop through it
        while (StdIn.hasNextLine()) {
            String sample_name = StdIn.readString();
            // read file
            int sample_h = StdIn.readInt();
            int sample_s = StdIn.readInt();
            int sample_b = StdIn.readInt();

            // show color string
            ColorHSB sample_color = new ColorHSB(sample_h, sample_s, sample_b);
            // System.out.println(sample_name + " " +  sample_color.toString());

            // Check gray scale
            // System.out.println("is gray scale: " + sample_color.isGrayscale());

            // calculate distance 
            int sample_distance = preference_color.distanceSquaredTo(sample_color);
            
            // save best distance
            // System.out.println("sample_distance: " + sample_distance + ", min_distance: " + min_distance);
            
            if (sample_distance  <min_distance) {
                min_distance = sample_distance;
                min_name = sample_name;
                min_color = new ColorHSB(sample_h, sample_s, sample_b);
            }
        }         
        // print nearest color 
        System.out.println(min_name + " " +  min_color.toString());
        
    }

}