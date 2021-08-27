public class Clock {
    private int hour;
    private int minute;

    private static boolean validTime(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            return false;
        }
        if (minute < 0 || minute > 59) {
            return false;
        }

        return true;
    }

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        this.hour = h;
        this.minute = m;

        if (!validTime(this.hour, this.minute)) {
            throw new IllegalArgumentException();
        }
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (!s.contains(":")) {
            throw new IllegalArgumentException();
        }

        if (s.length() != 5) {
            throw new IllegalArgumentException();
        }

        String[] parts = s.split(":");

        if (parts.length != 2) {
            throw new IllegalArgumentException();
        }

        this.hour = Integer.parseInt(parts[0]);
        this.minute = Integer.parseInt(parts[1]);

        for (int i = 0; i < parts.length; i++) {
            for (char c : parts[i].toCharArray()) {
                if (!Character.isDigit(c)) {
                    throw new IllegalArgumentException();
                }
            }
        }

        if (!validTime(this.hour, this.minute)) {
            throw new IllegalArgumentException();
        }
    }

    
    // private static String formate(int valor) {
    //     return (valor < 10 ? "0" : "") + valor;
    // }
    
    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }


    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if ((this.hour * 60 + this.minute) < (that.hour*60 + that.minute)) {
            return true;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if ((this.hour == 23)&&(this.minute == 59)) {
            this.hour = 0;
            this.minute = 0;
        } else if ((this.minute == 59)){
            this.hour++;
            this.minute = 0; 
        } else {
            this.minute++;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException();
        }

        int total_time = this.hour * 60 + this.minute + delta;
        int temp_hour = (total_time/60)%24;
        int temp_minute = total_time%60; 

        this.hour = temp_hour;
        this.minute = temp_minute;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock original_clock = new Clock(00, 00);
        String original_string = original_clock.toString();
        // System.out.println(original_string);

        Clock new_clock = new Clock("22:22");
        String new_string = new_clock.toString();
        // System.out.println(new_string);

        boolean earlier_before = original_clock.isEarlierThan(new_clock); 

        // System.out.println("this is earlier than that: " + earlier_before);

        new_clock.tic();
        new_clock.toc(5*60 + 48);

        boolean earlier_after = original_clock.isEarlierThan(new_clock); 
        String new_string_after = new_clock.toString();
        // System.out.println(new_string_after);

        // System.out.println("this is earlier than that: " + earlier_after);



        
    }
}