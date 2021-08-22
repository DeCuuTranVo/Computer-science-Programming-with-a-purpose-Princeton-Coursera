import java.awt.Color;

public class KernelFilter {

    private static int roundColor(double color_value) {
        return (int) Math.round(color_value);
    }

    private static int clampColor(int color_value) {
        if (color_value < 0) {
            color_value = 0;
        } 

        if (color_value > 255) {
            color_value = 255;
        }
        return color_value;
    }

    private static int getRed(Picture picture, int col, int row) {
        int width = picture.width();
        int height = picture.height();

        
        // System.out.println("col before: " + col + ", row before: " + row );
        

        if (col <= -1) {
            col = width + col;
        } else if (col >= width) {
            col = col - width;
        }    
        
        if (row <= -1) {
            row = height + row;
        } else if (row >= height) {
            row = row - height;
        }

        if (width == 1) {
            col = 0;
        }

        if (height == 1) {
            row = 0;
        }

        // System.out.println("col after: " + col + ", row after: " + row);

        Color got_color = picture.get(col, row);
        int red_color = got_color.getRed();
        return red_color;
    } 

    private static int getGreen(Picture picture, int col, int row) {
        int width = picture.width();
        int height = picture.height();
                
        if (col <= -1) {
            col = width + col;
        } else if (col >= width) {
            col = col - width;
        }    
        
        if (row <= -1) {
            row = height + row;
        } else if (row >= height) {
            row = row - height;
        }

        if (width == 1) {
            col = 0;
        }

        if (height == 1) {
            row = 0;
        }

        Color got_color = picture.get(col, row);
        int green_color = got_color.getGreen();
        return green_color;
    } 

    private static int getBlue(Picture picture, int col, int row) {
        int width = picture.width();
        int height = picture.height();
                
        if (col <= -1) {
            col = width + col;
        } else if (col >= width) {
            col = col - width;
        }    
        
        if (row <= -1) {
            row = height + row;
        } else if (row >= height) {
            row = row - height;
        }

        if (width == 1) {
            col = 0;
        }

        if (height == 1) {
            row = 0;
        }

        Color got_color = picture.get(col, row);
        int blue_color = got_color.getBlue();
        return blue_color;
    } 

    private static int[] getRGB(Picture picture, int col, int row) {
        Color got_color = picture.get(col, row);
        int red_color = got_color.getRed();
        int green_color = got_color.getGreen();
        int blue_color = got_color.getBlue();
        int[] rgb_color = {red_color, green_color, blue_color};
        return rgb_color;
    } 

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        // create filter
        int[][] filter = new int[3][3];
        filter[1][1] = 1; 

        int width  = picture.width();
        int height = picture.height();
        // Check filter
        // for (int col = 0; col < 3; col++) {
        //     for (int row = 0; row < 3; row++) {
        //         System.out.print(filter[row][col] + " ");
        //     }
        //     System.out.println();
        // }

        // Create new picture
        Picture filtered_picture = new Picture(width, height); 

        // filtering // 3 color layers
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                // get color
                // Color got_color = picture.get(col, row);
                // int red_color = got_color.getRed();
                // int green_color = got_color.getGreen();
                // int blue_color = got_color.getBlue();

                // int[] rgb_color = getRGB(picture, col, row);
                // int red_color = rgb_color[0];
                // int green_color = rgb_color[1];
                // int blue_color = rgb_color[2];

                
                // if ((width == 1) && (height==1)) { // 1x1
                //     // process color
                //     int red_color = (filter[1][1] * getRed(picture, col, row));

                //     int green_color =(filter[1][1] * getGreen(picture, col, row));
                    
                //     int blue_color =(filter[1][1] * getBlue(picture, col, row));
                // } else if ((width != 1) && (height==1)) {// 8x1
                //                     // process color
                //     int red_color = (
                //         filter[1][0] * getRed(picture, col-1, row) + 
                //         filter[1][1] * getRed(picture, col, row) +
                //         filter[1][2] * getRed(picture, col+1, row));

                //     int green_color =(
                //         filter[1][0] * getGreen(picture, col-1, row) + 
                //         filter[1][1] * getGreen(picture, col, row) +
                //         filter[1][2] * getGreen(picture, col+1, row));
     
                //     int blue_color =(
                //         filter[1][0] * getBlue(picture, col-1, row) + 
                //         filter[1][1] * getBlue(picture, col, row) +
                //         filter[1][2] * getBlue(picture, col+1, row));
                // } else if ((width == 1) && (height!=1)) { // 1x8
                //      // process color
                //     int red_color = (
                //         filter[0][1] * getRed(picture, col, row-1) +
                //         filter[1][1] * getRed(picture, col, row) +
                //         filter[2][1] * getRed(picture, col, row+1));

                //     int green_color =( 
                //         filter[0][1] * getGreen(picture, col, row-1) +        
                //         filter[1][1] * getGreen(picture, col, row) +
                //         filter[2][1] * getGreen(picture, col, row+1));
     
                //     int blue_color =( 
                //         filter[0][1] * getBlue(picture, col, row-1) +
                //         filter[1][1] * getBlue(picture, col, row) +
                //         filter[2][1] * getBlue(picture, col, row+1));
                // } else { // 8x8
                
                    int red_color = ( filter[0][0] * getRed(picture, col-1, row-1) + 
                            filter[0][1] * getRed(picture, col, row-1) +
                            filter[0][2] * getRed(picture, col+1, row-1) +
                            filter[1][0] * getRed(picture, col-1, row) + 
                            filter[1][1] * getRed(picture, col, row) +
                            filter[1][2] * getRed(picture, col+1, row) +
                            filter[2][0] * getRed(picture, col-1, row+1) + 
                            filter[2][1] * getRed(picture, col, row+1) +
                            filter[2][2] * getRed(picture, col+1, row+1));

                    int green_color =( filter[0][0] * getGreen(picture, col-1, row-1) + 
                            filter[0][1] * getGreen(picture, col, row-1) +
                            filter[0][2] * getGreen(picture, col+1, row-1) +
                            filter[1][0] * getGreen(picture, col-1, row) + 
                            filter[1][1] * getGreen(picture, col, row) +
                            filter[1][2] * getGreen(picture, col+1, row) +
                            filter[2][0] * getGreen(picture, col-1, row+1) + 
                            filter[2][1] * getGreen(picture, col, row+1) +
                            filter[2][2] * getGreen(picture, col+1, row+1));
                 
                    int blue_color =( filter[0][0] * getBlue(picture, col-1, row-1) + 
                            filter[0][1] * getBlue(picture, col, row-1) +
                            filter[0][2] * getBlue(picture, col+1, row-1) +
                            filter[1][0] * getBlue(picture, col-1, row) + 
                            filter[1][1] * getBlue(picture, col, row) +
                            filter[1][2] * getBlue(picture, col+1, row) +
                            filter[2][0] * getBlue(picture, col-1, row+1) + 
                            filter[2][1] * getBlue(picture, col, row+1) +
                            filter[2][2] * getBlue(picture, col+1, row+1));
                // }
            
                // process color

                red_color = roundColor((double) red_color);
                green_color = roundColor((double) green_color);
                blue_color = roundColor((double) blue_color);

                red_color = clampColor((int)red_color);
                green_color = clampColor((int)green_color);
                blue_color = clampColor((int)blue_color);

                

                // set color
                Color set_color = new Color((int)red_color, (int)green_color, (int)blue_color);
                filtered_picture.set(col, row, set_color);


                // System.out.println(red_color + " " + green_color + " " + blue_color);
                // break;
            }
            // break;
        }
        // rounding

        // clamping

        //return
        
        // int width  = picture.width();
        // int height = picture.height();

        // // convert to grayscale
        // for (int col = 0; col < width; col++) {
        //     for (int row = 0; row < height; row++) {
        //         Color color = picture.get(col, row);
        //         Color gray = Luminance.toGray(color);
        //         picture.set(col, row, gray);
        //     }
        // }

        return filtered_picture;
        // return picture;
    }

    // // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        // create filter
        double[][] filter = new double[3][3];

        filter[0][0] = (1.0/16.0) * 1;
        filter[0][1] = (1.0/16.0) * 2;
        filter[0][2] = (1.0/16.0) * 1;
        filter[1][0] = (1.0/16.0) * 2;
        filter[1][1] = (1.0/16.0) * 4;
        filter[1][2] = (1.0/16.0) * 2;
        filter[2][0] = (1.0/16.0) * 1;
        filter[2][1] = (1.0/16.0) * 2;
        filter[2][2] = (1.0/16.0) * 1;

        // // Check filter
        // for (int col = 0; col < 3; col++) {
        //     for (int row = 0; row < 3; row++) {
        //         System.out.print(filter[row][col] + " ");
        //     }
        //     System.out.println();
        // }

        int width  = picture.width();
        int height = picture.height();

        // Create new picture
        Picture filtered_picture = new Picture(width, height); 

        // filtering // 3 color layers
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {

                int red_color_ori = getRed(picture, col, row); 
                int green_color_ori = getGreen(picture, col, row);
                int blue_color_ori = getBlue(picture, col, row);
                // System.out.println(red_color_ori + " " + green_color_ori + " " + blue_color_ori);

                // process color
                double red_color = ( filter[0][0] * getRed(picture, col-1, row-1) + 
                            filter[0][1] * getRed(picture, col, row-1) +
                            filter[0][2] * getRed(picture, col+1, row-1) +
                            filter[1][0] * getRed(picture, col-1, row) + 
                            filter[1][1] * getRed(picture, col, row) +
                            filter[1][2] * getRed(picture, col+1, row) +
                            filter[2][0] * getRed(picture, col-1, row+1) + 
                            filter[2][1] * getRed(picture, col, row+1) +
                            filter[2][2] * getRed(picture, col+1, row+1));

                double green_color = ( filter[0][0] * getGreen(picture, col-1, row-1) + 
                            filter[0][1] * getGreen(picture, col, row-1) +
                            filter[0][2] * getGreen(picture, col+1, row-1) +
                            filter[1][0] * getGreen(picture, col-1, row) + 
                            filter[1][1] * getGreen(picture, col, row) +
                            filter[1][2] * getGreen(picture, col+1, row) +
                            filter[2][0] * getGreen(picture, col-1, row+1) + 
                            filter[2][1] * getGreen(picture, col, row+1) +
                            filter[2][2] * getGreen(picture, col+1, row+1));
                 
                double blue_color = ( filter[0][0] * getBlue(picture, col-1, row-1) + 
                            filter[0][1] * getBlue(picture, col, row-1) +
                            filter[0][2] * getBlue(picture, col+1, row-1) +
                            filter[1][0] * getBlue(picture, col-1, row) + 
                            filter[1][1] * getBlue(picture, col, row) +
                            filter[1][2] * getBlue(picture, col+1, row) +
                            filter[2][0] * getBlue(picture, col-1, row+1) + 
                            filter[2][1] * getBlue(picture, col, row+1) +
                            filter[2][2] * getBlue(picture, col+1, row+1));

                // System.out.println(red_color + " " + green_color + " " + blue_color);

                red_color = roundColor((double) red_color);
                green_color = roundColor((double) green_color);
                blue_color = roundColor((double) blue_color);

                // System.out.println(red_color + " " + green_color + " " + blue_color);

                red_color = clampColor((int)red_color);
                green_color = clampColor((int)green_color);
                blue_color = clampColor((int)blue_color);

                // set color
                Color set_color = new Color((int)red_color, (int)green_color, (int)blue_color);
                filtered_picture.set(col, row, set_color);

                // System.out.println(red_color + " " + green_color + " " + blue_color);
                // break;
            }
            // break;
        }

        return filtered_picture;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
         // create filter
         int[][] filter = new int[3][3];

         filter[0][0] = 0;
         filter[0][1] = -1;
         filter[0][2] = 0;
         filter[1][0] = -1;
         filter[1][1] = 5;
         filter[1][2] = -1;
         filter[2][0] = 0;
         filter[2][1] = -1;
         filter[2][2] = 0;
 
         int width  = picture.width();
         int height = picture.height();
 
         // Create new picture
         Picture filtered_picture = new Picture(width, height); 
 
         // filtering // 3 color layers
         for (int col = 0; col < width; col++) {
             for (int row = 0; row < height; row++) {
                 // process color
                 double red_color = (1.0) * ( filter[0][0] * getRed(picture, col-1, row-1) + 
                             filter[0][1] * getRed(picture, col, row-1) +
                             filter[0][2] * getRed(picture, col+1, row-1) +
                             filter[1][0] * getRed(picture, col-1, row) + 
                             filter[1][1] * getRed(picture, col, row) +
                             filter[1][2] * getRed(picture, col+1, row) +
                             filter[2][0] * getRed(picture, col-1, row+1) + 
                             filter[2][1] * getRed(picture, col, row+1) +
                             filter[2][2] * getRed(picture, col+1, row+1));
 
                 double green_color =(1.0) *( filter[0][0] * getGreen(picture, col-1, row-1) + 
                             filter[0][1] * getGreen(picture, col, row-1) +
                             filter[0][2] * getGreen(picture, col+1, row-1) +
                             filter[1][0] * getGreen(picture, col-1, row) + 
                             filter[1][1] * getGreen(picture, col, row) +
                             filter[1][2] * getGreen(picture, col+1, row) +
                             filter[2][0] * getGreen(picture, col-1, row+1) + 
                             filter[2][1] * getGreen(picture, col, row+1) +
                             filter[2][2] * getGreen(picture, col+1, row+1));
                  
                 double blue_color =(1.0) *( filter[0][0] * getBlue(picture, col-1, row-1) + 
                             filter[0][1] * getBlue(picture, col, row-1) +
                             filter[0][2] * getBlue(picture, col+1, row-1) +
                             filter[1][0] * getBlue(picture, col-1, row) + 
                             filter[1][1] * getBlue(picture, col, row) +
                             filter[1][2] * getBlue(picture, col+1, row) +
                             filter[2][0] * getBlue(picture, col-1, row+1) + 
                             filter[2][1] * getBlue(picture, col, row+1) +
                             filter[2][2] * getBlue(picture, col+1, row+1));
 
                 // System.out.println(red_color + " " + green_color + " " + blue_color);
 
                 red_color = roundColor((double) red_color);
                 green_color = roundColor((double) green_color);
                 blue_color = roundColor((double) blue_color);
 
                 // System.out.println(red_color + " " + green_color + " " + blue_color);
 
                 red_color = clampColor((int)red_color);
                 green_color = clampColor((int)green_color);
                 blue_color = clampColor((int)blue_color);
 
                 // set color
                 Color set_color = new Color((int)red_color, (int)green_color, (int)blue_color);
                 filtered_picture.set(col, row, set_color);
 
                 // System.out.println(red_color + " " + green_color + " " + blue_color);
                 // break;
             }
             // break;
         }
 
         return filtered_picture;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        // create filter
        int[][] filter = new int[3][3];

        filter[0][0] = -1;
        filter[0][1] = -1;
        filter[0][2] = -1;
        filter[1][0] = -1;
        filter[1][1] = 8;
        filter[1][2] = -1;
        filter[2][0] = -1;
        filter[2][1] = -1;
        filter[2][2] = -1;

        int width  = picture.width();
        int height = picture.height();

        // Create new picture
        Picture filtered_picture = new Picture(width, height); 

        // filtering // 3 color layers
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                // process color
                double red_color = (1.0) * ( filter[0][0] * getRed(picture, col-1, row-1) + 
                            filter[0][1] * getRed(picture, col, row-1) +
                            filter[0][2] * getRed(picture, col+1, row-1) +
                            filter[1][0] * getRed(picture, col-1, row) + 
                            filter[1][1] * getRed(picture, col, row) +
                            filter[1][2] * getRed(picture, col+1, row) +
                            filter[2][0] * getRed(picture, col-1, row+1) + 
                            filter[2][1] * getRed(picture, col, row+1) +
                            filter[2][2] * getRed(picture, col+1, row+1));

                double green_color =(1.0) *( filter[0][0] * getGreen(picture, col-1, row-1) + 
                            filter[0][1] * getGreen(picture, col, row-1) +
                            filter[0][2] * getGreen(picture, col+1, row-1) +
                            filter[1][0] * getGreen(picture, col-1, row) + 
                            filter[1][1] * getGreen(picture, col, row) +
                            filter[1][2] * getGreen(picture, col+1, row) +
                            filter[2][0] * getGreen(picture, col-1, row+1) + 
                            filter[2][1] * getGreen(picture, col, row+1) +
                            filter[2][2] * getGreen(picture, col+1, row+1));
                 
                double blue_color =(1.0) *( filter[0][0] * getBlue(picture, col-1, row-1) + 
                            filter[0][1] * getBlue(picture, col, row-1) +
                            filter[0][2] * getBlue(picture, col+1, row-1) +
                            filter[1][0] * getBlue(picture, col-1, row) + 
                            filter[1][1] * getBlue(picture, col, row) +
                            filter[1][2] * getBlue(picture, col+1, row) +
                            filter[2][0] * getBlue(picture, col-1, row+1) + 
                            filter[2][1] * getBlue(picture, col, row+1) +
                            filter[2][2] * getBlue(picture, col+1, row+1));

                // System.out.println(red_color + " " + green_color + " " + blue_color);

                red_color = roundColor((double) red_color);
                green_color = roundColor((double) green_color);
                blue_color = roundColor((double) blue_color);

                // System.out.println(red_color + " " + green_color + " " + blue_color);

                red_color = clampColor((int)red_color);
                green_color = clampColor((int)green_color);
                blue_color = clampColor((int)blue_color);

                // set color
                Color set_color = new Color((int)red_color, (int)green_color, (int)blue_color);
                filtered_picture.set(col, row, set_color);

                // System.out.println(red_color + " " + green_color + " " + blue_color);
                // break;
            }
            // break;
        }

        return filtered_picture;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        // create filter
        int[][] filter = new int[3][3];

        filter[0][0] = -2;
        filter[0][1] = -1;
        filter[0][2] = 0;
        filter[1][0] = -1;
        filter[1][1] = 1;
        filter[1][2] = 1;
        filter[2][0] = 0;
        filter[2][1] = 1;
        filter[2][2] = 2;

        int width  = picture.width();
        int height = picture.height();

        // Create new picture
        Picture filtered_picture = new Picture(width, height); 

        // filtering // 3 color layers
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                // process color
                double red_color = (1.0) * ( filter[0][0] * getRed(picture, col-1, row-1) + 
                            filter[0][1] * getRed(picture, col, row-1) +
                            filter[0][2] * getRed(picture, col+1, row-1) +
                            filter[1][0] * getRed(picture, col-1, row) + 
                            filter[1][1] * getRed(picture, col, row) +
                            filter[1][2] * getRed(picture, col+1, row) +
                            filter[2][0] * getRed(picture, col-1, row+1) + 
                            filter[2][1] * getRed(picture, col, row+1) +
                            filter[2][2] * getRed(picture, col+1, row+1));

                double green_color =(1.0) *( filter[0][0] * getGreen(picture, col-1, row-1) + 
                            filter[0][1] * getGreen(picture, col, row-1) +
                            filter[0][2] * getGreen(picture, col+1, row-1) +
                            filter[1][0] * getGreen(picture, col-1, row) + 
                            filter[1][1] * getGreen(picture, col, row) +
                            filter[1][2] * getGreen(picture, col+1, row) +
                            filter[2][0] * getGreen(picture, col-1, row+1) + 
                            filter[2][1] * getGreen(picture, col, row+1) +
                            filter[2][2] * getGreen(picture, col+1, row+1));
                 
                double blue_color =(1.0) *( filter[0][0] * getBlue(picture, col-1, row-1) + 
                            filter[0][1] * getBlue(picture, col, row-1) +
                            filter[0][2] * getBlue(picture, col+1, row-1) +
                            filter[1][0] * getBlue(picture, col-1, row) + 
                            filter[1][1] * getBlue(picture, col, row) +
                            filter[1][2] * getBlue(picture, col+1, row) +
                            filter[2][0] * getBlue(picture, col-1, row+1) + 
                            filter[2][1] * getBlue(picture, col, row+1) +
                            filter[2][2] * getBlue(picture, col+1, row+1));

                // System.out.println(red_color + " " + green_color + " " + blue_color);

                red_color = roundColor((double) red_color);
                green_color = roundColor((double) green_color);
                blue_color = roundColor((double) blue_color);

                // System.out.println(red_color + " " + green_color + " " + blue_color);

                red_color = clampColor((int)red_color);
                green_color = clampColor((int)green_color);
                blue_color = clampColor((int)blue_color);

                // set color
                Color set_color = new Color((int)red_color, (int)green_color, (int)blue_color);
                filtered_picture.set(col, row, set_color);

                // System.out.println(red_color + " " + green_color + " " + blue_color);
                // break;
            }
            // break;
        }

        return filtered_picture;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
         // create filter
         int[][] filter = new int[9][9];

         filter[0][0] = 1;
         filter[1][1] = 1;
         filter[2][2] = 1;
         filter[3][3] = 1;
         filter[4][4] = 1;
         filter[5][5] = 1;
         filter[6][6] = 1;
         filter[7][7] = 1;
         filter[8][8] = 1;
 
         int width  = picture.width();
         int height = picture.height();
 
         // Create new picture
         Picture filtered_picture = new Picture(width, height); 
 
         // filtering // 3 color layers
         for (int col = 0; col < width; col++) {
             for (int row = 0; row < height; row++) {
                 // process color
                 double red_color = (1.0/9) * ( filter[0][0] * getRed(picture, col-4, row-4) + 
                            filter[1][1] * getRed(picture, col-3, row-3) +
                            filter[2][2] * getRed(picture, col-2, row-2) +
                            filter[3][3] * getRed(picture, col-1, row-1) + 
                            filter[4][4] * getRed(picture, col, row) +
                            filter[5][5] * getRed(picture, col+1, row+1) +
                            filter[6][6] * getRed(picture, col+2, row+2) + 
                            filter[7][7] * getRed(picture, col+3, row+3) +
                            filter[8][8] * getRed(picture, col+4, row+4));

                double green_color =(1.0/9) *( filter[0][0] * getGreen(picture, col-4, row-4) + 
                            filter[1][1] * getGreen(picture, col-3, row-3) +
                            filter[2][2] * getGreen(picture, col-2, row-2) +
                            filter[3][3] * getGreen(picture, col-1, row-1) + 
                            filter[4][4] * getGreen(picture, col, row) +
                            filter[5][5] * getGreen(picture, col+1, row+1) +
                            filter[6][6] * getGreen(picture, col+2, row+2) + 
                            filter[7][7] * getGreen(picture, col+3, row+3) +
                            filter[8][8] * getGreen(picture, col+4, row+4));
                 
                double blue_color =(1.0/9) *( filter[0][0] * getBlue(picture, col-4, row-4) + 
                            filter[1][1] * getBlue(picture, col-3, row-3) +
                            filter[2][2] * getBlue(picture, col-2, row-2) +
                            filter[3][3] * getBlue(picture, col-1, row-1) + 
                            filter[4][4] * getBlue(picture, col, row) +
                            filter[5][5] * getBlue(picture, col+1, row+1) +
                            filter[6][6] * getBlue(picture, col+2, row+2) + 
                            filter[7][7] * getBlue(picture, col+3, row+3) +
                            filter[8][8] * getBlue(picture, col+4, row+4));
 
                 // System.out.println(red_color + " " + green_color + " " + blue_color);
 
                 red_color = roundColor((double) red_color);
                 green_color = roundColor((double) green_color);
                 blue_color = roundColor((double) blue_color);
 
                 // System.out.println(red_color + " " + green_color + " " + blue_color);
 
                 red_color = clampColor((int)red_color);
                 green_color = clampColor((int)green_color);
                 blue_color = clampColor((int)blue_color);
 
                 // set color
                 Color set_color = new Color((int)red_color, (int)green_color, (int)blue_color);
                 filtered_picture.set(col, row, set_color);
 
                 // System.out.println(red_color + " " + green_color + " " + blue_color);
                //  break;
             }
            //  break;
         }
 
         return filtered_picture;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture original_picture = new Picture(args[0]);
        original_picture.show();

        Picture identity_picture = identity(original_picture);
        identity_picture.show();

        Picture gaussian_picture = gaussian(original_picture);
        gaussian_picture.show();

        Picture sharpen_picture = sharpen(original_picture);
        sharpen_picture.show();

        Picture laplacian_picture = laplacian(original_picture);
        laplacian_picture.show();

        Picture emboss_picture = emboss(original_picture);
        emboss_picture.show();

        Picture motion_picture = motionBlur(original_picture);
        motion_picture.show();

    //     // test original
    //     int red_pixel_original = getRed(original_picture, 0, 0);
    //     int green_pixel_original = getGreen(original_picture, 0, 0);
    //     int blue_pixel_original = getBlue(original_picture,0,0);

    //     System.out.println("original: ("+ red_pixel_original + "," + green_pixel_original + "," + blue_pixel_original + ")");

    //     // // test original
    //     // int red_pixel_identity = getRed(identity_picture, 0, 0);
    //     // int green_pixel_identity = getGreen(identity_picture, 0, 0);
    //     // int blue_pixel_identity = getBlue(identity_picture,0,0);

    //     // System.out.println("identity: ("+ red_pixel_identity + "," + green_pixel_identity + "," + blue_pixel_identity + ")");
        

    //     // // test gaussian
    //     // int red_pixel_gaussian = getRed(gaussian_picture, 0, 0);
    //     // int green_pixel_gaussian = getGreen(gaussian_picture, 0, 0);
    //     // int blue_pixel_gaussian = getBlue(gaussian_picture,0,0);

    //     // System.out.println("gaussian: ("+ red_pixel_gaussian + "," + green_pixel_gaussian + "," + blue_pixel_gaussian + ")");
    
    //     // test motion blur
    //     int red_pixel_motion = getRed(motion_picture, 0, 0);
    //     int green_pixel_motion = getGreen(motion_picture, 0, 0);
    //     int blue_pixel_motion = getBlue(motion_picture, 0,0);
    //     System.out.println("motion: ("+ red_pixel_motion + "," + green_pixel_motion + "," + blue_pixel_motion + ")");
    }

}
