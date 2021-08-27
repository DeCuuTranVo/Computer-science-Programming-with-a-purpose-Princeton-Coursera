package Programming_with_a_purpose.Week_3;


public class ThueMorse {
    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]);
        
        int step = (int) (Math.log(n)/Math.log(2)) + 1;

        // Create morse sequence (1D array)
        boolean[] morse_sequence = new boolean[1];
        for (int i = 0; i < step; i++) {
            boolean[] morse_step = new boolean[2* morse_sequence.length];
            for (int j = 0; j < morse_sequence.length; j++) {
                morse_step[j] = morse_sequence[j];
                morse_step[j+morse_sequence.length] = !morse_sequence[j];
            }
            morse_sequence = morse_step;

            // for (int k = 0; k < a.length; k++) {
            //     System.out.print(a[k] + " ");
            // }

            // System.out.println();
        }

        boolean[] morse_array = new boolean[n];
        for (int i = 0; i < morse_array.length; i++) {
            morse_array[i] = morse_sequence[i];
        }

        // Create morse table (2D array)
        boolean[][] morse_table = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (morse_sequence[i] == morse_array[j]) {
                    morse_table[i][j] = true;
                } else {
                    morse_table[i][j] = false;
                }
            }
        }

        // Convert from boolean to string (2D array)
        String[][] morse_weave = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (morse_table[i][j] == true) {
                    morse_weave[i][j] = "+";
                } else {
                    morse_weave[i][j] = "-";
                }
            }
        }

        // Print result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(morse_weave[i][j] + "  ");
            }
            System.out.println();
        }


    }
}
