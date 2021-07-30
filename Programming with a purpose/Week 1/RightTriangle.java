public class RightTriangle {
    public static void main(String[] args) {
        Integer firstEdge = Integer.parseInt(args[0]);
        Integer secondEdge = Integer.parseInt(args[1]);
        Integer thirdEdge = Integer.parseInt(args[2]);

        System.out.println(((firstEdge > 0) && (secondEdge > 0) && (thirdEdge > 0)) && (((firstEdge*firstEdge + secondEdge*secondEdge == thirdEdge*thirdEdge) || (firstEdge*firstEdge == secondEdge*secondEdge + thirdEdge*thirdEdge) || (firstEdge*firstEdge + thirdEdge*thirdEdge == secondEdge*secondEdge))) );
         
    }
    
}
