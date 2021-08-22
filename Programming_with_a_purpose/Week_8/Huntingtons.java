public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        boolean is_consecutive = false;
        int max_repeats = 0;
        int repeats = 0;
        for (int i =0; i < dna.length()-2; i++) {
            // if (i%3 == 0) {
                String sub_dna = dna.substring(i, i+3);
                

                if (sub_dna.equals("CAG")) {
                    repeats++;
                    is_consecutive = true;
                    i += 2;
                } else {
                    repeats = 0;
                    is_consecutive = false;
                }

                // System.out.println(sub_dna + ": " + is_consecutive);
                if ((is_consecutive) &&(repeats > max_repeats)) {
                    max_repeats = repeats;
                }


            }
        // }
    
        // System.out.println(max_repeats);
        return max_repeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String cleaned_s = s.replace("\r", "").replace("\n", "").replace("\t","").replace(" ","");//.replace("\n", "\t").replace("\t",""); //;
        return cleaned_s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if ((maxRepeats <= 9)||(maxRepeats >=181)) {
            return "not human";
        } else if ((maxRepeats>=10) && (maxRepeats<=35)) {
            return "normal";
        } else if ((maxRepeats>=36) && (maxRepeats<=39)){
            return "high risk";
        } else {
            return "Huntington's";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // read file in
        In in = new In(args[0]);
        String s = in.readAll();
        in.close();
    
        
        // remove white space
        String dna = removeWhitespace(s); 
        // System.out.println(dna);

        // calculate max repeates
        int max_repeats = maxRepeats(dna);
        // System.out.println(max_repeats);

        // for (int i = 0; i < cleaned_s.length(); i++) {
        //     if (i%3 == 0) {
        //         System.out.println(cleaned_s.substring(i, i+3));
        //     }
        // }

        
        // diagnosis
        String diagnosis = diagnose(max_repeats);

        // Output
        System.out.println("max repeats = " + max_repeats);
        System.out.println(diagnosis);

    }

}