package abstrak;

public class Segitiga extends BangunDatar {
    double alas, tinggi;

    public Segitiga(double alas, double tinggi) {
        super(3);
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar segitiga");
    }

    @Override
    public void resize() {
        alas *= 2;
        tinggi *= 2;
    }

    @Override
    public double getLuas() {
        return 0.5 * alas * tinggi;
    }

    @Override
    public double getKeliling() {
        return 3 * alas; // sederhana
    }
}