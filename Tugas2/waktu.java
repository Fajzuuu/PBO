public class waktu {
    int detik;
    int menit;
    int jam;

    public waktu(int jam, int menit, int detik) {
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
    }

    public static void main(String[] args) {
        // membuat objek dari class Waktu
        waktu mulai = new waktu(8, 12, 15);
        waktu selesai = new waktu(12, 34, 55);
        waktu selisih;

        // memanggil method perbedaan
        selisih = perbedaan(mulai, selesai);

        System.out.printf("Selisih Waktu: %d:%d:%d - ", mulai.jam, mulai.menit, mulai.detik);
        System.out.printf("%d:%d:%d ", selesai.jam, selesai.menit, selesai.detik);
        System.out.printf("= %d:%d:%d\n", selisih.jam, selisih.menit, selisih.detik);
    }

    public static waktu perbedaan(waktu mulai, waktu selesai) {
        waktu selisih = new waktu(0, 0, 0);

        // jika detik mulai lebih besar
        // konversi menit selesai ke dalam detik
        // dan tambahkan detik ke detik selesai
        if (mulai.detik > selesai.detik) {
            --selesai.menit;
            selesai.detik += 60;
        }

        selisih.detik = selesai.detik - mulai.detik;

        // jika menit mulai lebih besar
        // konversi jam selesai ke dalam menit
        // kemudian tambahkan ke dalam menit selesai
        if (mulai.menit > selesai.menit) {
            --selesai.jam;
            selesai.menit += 60;
        }

        selisih.menit = selesai.menit - mulai.menit;
        selisih.jam = selesai.jam - mulai.jam;

        return (selisih);
    }
}
