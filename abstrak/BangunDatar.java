package abstrak;

public abstract class BangunDatar {
    
    int x, y;
    int jumlahSisi;

    public BangunDatar(int sisi) {
        this.jumlahSisi = sisi;
    }

    public void pindahkan(int a, int b) {
        x = a;
        y = b;
    }

    public int getJumlahSisi() {
        return jumlahSisi;
    }

    public abstract void draw();
    public abstract void resize();

    public abstract double getLuas();
    public abstract double getKeliling();
}