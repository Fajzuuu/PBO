public class Test {
    public static void main(int x) {
        System.out.println("Main int: " + x);
    }

    public static void main(String text) {
        System.out.println("Main String: " + text);
    }

    public static void main(String[] args) {
        System.out.println("Main utama");

        main(10);
        main("Sepuluh");
    }    
}