public class GreatCircle {
    public static void main(String[] args) {
        Double x1 = Double.parseDouble(args[0]);
        Double y1 = Double.parseDouble(args[1]);
        Double x2 = Double.parseDouble(args[2]);
        Double y2 = Double.parseDouble(args[3]);

        x1 = Math.toRadians(x1);
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);

        Double r = 6371.0;

        Double fisrtHalf = Math.pow(Math.sin((x2 - x1)/2), 2);
        Double secondHalf = Math.pow(Math.sin((y2 - y1)/2), 2);

        Double distance = 2*r*Math.asin(Math.sqrt((fisrtHalf + Math.cos(x1)*Math.cos(x2)*secondHalf)));

        System.out.println(distance + " kilometers");
    }
    
}
