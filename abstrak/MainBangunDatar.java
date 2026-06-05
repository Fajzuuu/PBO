package abstrak;

public class MainBangunDatar {
    public static void main(String[] args) {
        Kotak k = new Kotak(4, 5);
        Segitiga s = new Segitiga(6, 8);

        System.out.println("Kotak:");
        System.out.println("Luas: " + k.getLuas());
        System.out.println("Keliling: " + k.getKeliling());

        System.out.println("\nSegitiga:");
        System.out.println("Luas: " + s.getLuas());
        System.out.println("Keliling: " + s.getKeliling());
    }
}