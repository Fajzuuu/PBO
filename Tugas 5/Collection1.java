import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Collection1 {
    public static void main(String[] judul) {
        Set<String> buku = new TreeSet<String>();
        buku.add("Dilan 1990"); buku.add("Dilan 1991");
        buku.add("Laskar Pelangi"); buku.add("Mahaguru");
        buku.add("Mengejar Matahari"); buku.add("Perahu kertas");
        buku.add("Milea"); 

        System.out.println("Daftar Buku :");
        for (Iterator<String> iterator = buku.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
    }
}