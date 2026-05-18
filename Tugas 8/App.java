import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BangunDatar bd;
		Scanner inputan = new Scanner(System.in);
		SegiEmpat persegiPanjang = new SegiEmpat();
		bd = persegiPanjang;
		System.out.print("Masukkan Panjang: ");
		bd.panjang = inputan.nextDouble();
		
		System.out.print("Masukkan Lebar: ");
		bd.lebar = inputan.nextDouble();
		
		double luas = bd.luas();
		bd.cetakLuas("Persegi panjang",luas);
		
		Segitiga sikusiku = new Segitiga();
		bd = sikusiku;
		
		System.out.print("Masukkan Panjang: ");
		bd.panjang = inputan.nextDouble();
		
		System.out.print("Masukkan Tinggi: ");
		bd.tinggi = inputan.nextDouble();
		
		double luas1 = bd.luas(bd.panjang, bd.tinggi);
		bd.cetakLuas("Segitiga siku-siku", luas1);
		
		SegiEmpat persegi = new SegiEmpat();
		
		System.out.println("Masukkan Sisi: ");
		int sisi = inputan.nextInt();
		
		int luas2 = persegi.luas(sisi);
		
		persegi.cetakLuas("Persegi", luas2);

		JajarGenjang jg = new JajarGenjang();
		bd = jg;

		System.out.print("Masukkan Alas Jajar Genjang: ");
		bd.panjang = inputan.nextDouble();

		System.out.print("Masukkan Tinggi Jajar Genjang: ");
		bd.tinggi = inputan.nextDouble();

		double luas3 = bd.luas(bd.panjang, bd.tinggi);
		bd.cetakLuas("Jajar Genjang", luas3);
	}
}