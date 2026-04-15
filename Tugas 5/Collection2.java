import java.util.ArrayList;

public class Collection2 {
    public static void main(String judul[]) {
        ArrayList<String> buku = new ArrayList<>();
        System.out.println("Daftar Buku secara urut :");
        buku.add("Dilan 1990"); buku.add("Dilan 1991");
        buku.add("Laskar Pelangi"); buku.add("Mahaguru");
        buku.add("Mengejar Matahari"); buku.add("Milea");
        buku.add("Perahu kertas");

        for (int i = 0; i < buku.size(); i++) {
            System.out.println(buku.get(i));
        }
        System.out.println(" ");
        System.out.println("Buku mahaguru ada");
        System.out.println(" ");
        System.out.println("Daftar Buku setelah Mahaguru dipinjam :");
        buku.remove("Mahaguru");
        for (int i = 0; i < buku.size(); i++) {
            System.out.println(buku.get(i));
        }
    }
}
