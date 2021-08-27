public class HelloGoodbye {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        String firstName = args[0];
        String secondName = args[1];

        System.out.println("Hello " + firstName + " and " + secondName +".");
        System.out.println("Goodbye " + secondName + " and " + firstName +".");
    }
}
