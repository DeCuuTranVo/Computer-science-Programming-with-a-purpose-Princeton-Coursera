import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        // Play soundtrackA
        // StdAudio.loop("piano.wav");

        // read argument
        In in = new In(args[0]); // read file from file name
        String title = in.readLine(); 
        String xAxis = in.readLine(); 
        String source = in.readLine();

        // System.out.println(title);
        // System.out.println(x_axis_label);
        // System.out.println(source);

        // Setup StdDraw 
        // StdDraw.setScale(-2, +2);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        // Create the bar chart
        BarChart chart = new BarChart(title, xAxis, source);
        


        int num_bar_display = Integer.parseInt(args[1]); 

        // System.out.println("txt_file: " + txt_file +", num_bar_display" + num_bar_display);
        while(in.hasNextLine()) {
            // read number of line in that group
            in.readLine();
            int num_entries = Integer.parseInt(in.readLine());
            // System.out.println(num_entries);

            // Create bars arrays (data structure)
            Bar[] bars = new Bar[num_entries];
            // Read num_entries entries
            for (int i = 0; i < num_entries; i++) {
                // read an entry in that group
                String entry = in.readLine();
                String[] entry_split = entry.split(",");
                // System.out.println(entry);
                           
                // // read details of an entry in that group
                String year = entry_split[0].trim();
                String name = entry_split[1].trim();
                String country = entry_split[2].trim();
                int value = Integer.parseInt(entry_split[3]);
                String category = entry_split[4].trim();

                chart.setCaption(year);

                bars[i] = new Bar(name, value, category);

                
    
                // System.out.println("year: " + year + ", name: " + name + ", country: " + country + ", value: " + value + ", category: " + category);   
            }

            // Sort the bars
            Arrays.sort(bars);

            // add the bars to the bar chart
            for (int i = bars.length - 1; i >= (bars.length - num_bar_display); i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            // Animation
            
            // Clear the offscreen canvas.
            StdDraw.clear();
            // Draw objects on the offscreen canvas.
            chart.draw();

            // Copy the offscreen canvas to the onscreen canvas.
            StdDraw.show();

            // Wait for a short while.
            StdDraw.pause(20);

            // Delete all bars from the chart
            chart.reset();
            // break;
        }
        // 
        in.close();
    }
}
