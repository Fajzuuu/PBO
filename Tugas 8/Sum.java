public class Sum {
    public int jumlah(int x, int y) {
        return (x + y);
    }
    public int jumlah(int x, int y, int z) {
        return (x + y + z);
    }
    public double jumlah(double x, double y) {
        return (x + y);
    }

    public static void main(String[] args) {
        Sum S = new Sum();
        System.out.println(S.jumlah(10,20));
        System.out.println(S.jumlah(10,20,30));;
        System.out.println(S.jumlah(10.5,20.5));
    }
}