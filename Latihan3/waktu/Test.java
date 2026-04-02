package waktu;

public class Test {
    int angka1;
    int angka2;

    Test(int angka1, int angka2) {
        this.angka1 = angka1;
        this.angka2 = angka2;
    }

    int multiply() {
        int c;
        c = angka1 * angka2;
        return c;
    }

    void cetak() {
        System.out.println("Angka 1 : " + angka1);
        System.out.println("Angka 2 : " + angka2);
    }
}
