package abstrak;

public class MainResize {
    public static void main(String[] args) {
        Kotak k = new Kotak(4, 5);

        System.out.println("Sebelum resize:");
        System.out.println("Luas: " + k.getLuas());
        System.out.println("Keliling: " + k.getKeliling());

        k.resize(2);

        System.out.println("\nSetelah resize:");
        System.out.println("Luas: " + k.getLuas());
        System.out.println("Keliling: " + k.getKeliling());
    }
}