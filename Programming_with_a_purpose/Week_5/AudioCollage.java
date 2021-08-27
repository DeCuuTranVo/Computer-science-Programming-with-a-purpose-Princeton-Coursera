public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] a_amplified = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            a_amplified[i] = a[i] * alpha;
        }
        return a_amplified;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] a_reversed = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            a_reversed[i] = a[a.length - 1 - i];
        }
        return a_reversed;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] a_merged = new double[a.length + b.length];

        for (int i = 0; i < a.length + b.length; i++) {
            if (i < a.length) {
                a_merged[i] = a[i];
            } else {
                a_merged[i] = b[i - a.length];
            }
        }

        return a_merged;
    }


    // // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        if (a.length <= b.length) {
            double[] a_long = new double[b.length];
            double[] a_mixed = new double[b.length];

            for (int i = 0; i < a.length; i++) {
                a_long[i] = a[i];
            }

            for (int i = 0; i < b.length; i++) {
                a_mixed[i] = a_long[i] + b[i];
            }

            return a_mixed;
        } else {
            double[] b_long = new double[a.length];
            double[] b_mixed = new double[a.length];

            for (int i = 0; i < b.length; i++) {
                b_long[i] = b[i];
            } 

            for (int i = 0; i < a.length; i++) {
                b_mixed[i] = a[i] + b_long[i];
            }

            return b_mixed;
        }
    }

    // // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] a_changeSpeed = new double[(int) Math.floor(a.length/alpha)];
        
        // System.out.println(a.length/alpha);
        // System.out.println(Math.floor(a.length/alpha));
        // System.out.println(Math.round(a.length/alpha));jav
        // System.out.println(a_changeSpeed.length);

        if (a_changeSpeed.length <= a.length) {
            for(int i = 0; i < a_changeSpeed.length; i++) {
                a_changeSpeed[i] = a[(int) Math.floor(i*alpha)];
                // System.out.print(i + "\t");
                // System.out.print(i*alpha + "\t");
                // System.out.println(Math.floor(i*alpha));
            }
            // StdOut.println("Faster");
        } else {
            for(int i = 0; i < a_changeSpeed.length; i++) {
                a_changeSpeed[i] = a[(int) Math.floor(i*alpha)];
                // System.out.print(i + "\t");
                // System.out.print(i*alpha + "\t");
                // System.out.println(Math.floor(i*alpha));
            }
            // StdOut.println("Slower");
        }
        

        return a_changeSpeed;
    }

    // // Creates an audio collage and plays it on standard audio.
    // // See below for the requirements.
    public static void main(String[] args) {
        double[] samples_a = StdAudio.read("harp.wav");
        double[] samples_b = StdAudio.read("piano.wav");
        double[] samples_c = StdAudio.read("singer.wav");
        double[] samples_d = StdAudio.read("cow.wav");
        double[] samples_e = StdAudio.read("beatbox.wav");
        double[] samples_f = StdAudio.read("scratch.wav");

        double[] sample_amplified = amplify(samples_a, 2.0);
        double[] sample_reversed = reverse(samples_b);
        double[] sample_mixed_ab = mix(sample_amplified, sample_reversed);

        double[] sample_mixed_cd = mix(samples_c, samples_d);
        double[] sample_changed_speed_e = changeSpeed(samples_e, 2.0);
        double[] sample_changed_speed_f = changeSpeed(samples_f, 2.0);
        double[] sample_mixed_ef = mix(sample_changed_speed_e, sample_changed_speed_f);
        
        double[] sample_merged_abcd = merge(sample_mixed_ab, sample_mixed_cd); 
        double[] sample_merged_abcdef = merge(sample_merged_abcd, sample_mixed_ef); 

        double[] sample_rescaled = rescale(sample_merged_abcdef);
        StdAudio.play(sample_rescaled);
        // // StdOut.println(sample_rescaled.length);

        // double[] samples_e =  { -0.125, 0.375, 0.375, 0.5  };//new double[3];
        // // samples_e[0] = 0.2;
        // // samples_e[1] = 0.4;
        // // samples_e[2] = 0.6;
        // double[] sample_changed_speed_e = changeSpeed(samples_e, 0.5625);

        // for (int i = 0; i < sample_changed_speed_e.length; i++) {
        //     System.out.print(sample_changed_speed_e[i] + " ");
        // }
        // System.out.println();

        // StdAudio.play(sample_changed_speed_e);
    }

    public static double[] rescale(double[] a) {
        double[] a_rescaled = new double[a.length];
        double max_a = Double.NEGATIVE_INFINITY;
        double min_a = Double.POSITIVE_INFINITY;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < min_a) {
                min_a = a[i];
            }

            if (a[i] > max_a) {
                max_a = a[i];
            }
        }

        for (int i = 0; i < a.length; i++) {
            a_rescaled[i] = (a[i] - min_a)/(max_a - min_a);
        }

        return a_rescaled;
    }
}