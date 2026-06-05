package abstrak;

public class Sepeda extends Kendaraan {
    private boolean isAuto;

    // Constructor
    public Sepeda(String merk, String model, int jumlahRoda, boolean isAuto) {
        setMerk(merk);
        setModel(model);
        setJumlahRoda(jumlahRoda);
        this.isAuto = isAuto;
    }

    // Method jenis()
    public void jenis() {
        if (isAuto) {
            System.out.println("Sepeda otomatis");
        } else {
            System.out.println("Sepeda kayuh");
        }
    }

    @Override
    public void nyalakan() {
        System.out.println("Sepeda siap digunakan");
    }
}