package abstrak;

public class Kotak extends BangunDatar implements Resizeable {
    double panjang, lebar;

    public Kotak(double panjang, double lebar) {
        super(4);
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar kotak");
    }

    @Override
    public void resize() {
        // dari abstract (tidak dipakai)
    }

    // dari interface
    @Override
    public void resize(double x) {
        panjang *= x;
        lebar *= x;
    }

    @Override
    public double getLuas() {
        return panjang * lebar;
    }

    @Override
    public double getKeliling() {
        return 2 * (panjang + lebar);
    }
}