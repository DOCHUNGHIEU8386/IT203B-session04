import java.util.*;

public class Cau1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quan ly san pham");

        System.out.print("Nhap so luong san pham: ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                System.out.println("Loi:So san pham phai lon hon > 0");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi:Vui long nhap so nguyen hop le");
            return;
        }

        List<Double> giaSanPham = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Nhap gia san pham thu " + (i + 1) + ": ");
                    double gia = Double.parseDouble(sc.nextLine());
                    giaSanPham.add(gia);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Loi:Vui long nhap so thuc hop le");
                }
            }
        }

        double tong = 0;
        for (double gia : giaSanPham) {
            tong += gia;
        }

        double trungBinh = tong / n;

        int countTrenTrieu = 0;
        for (double gia : giaSanPham) {
            if (gia > 1000000) {
                countTrenTrieu++;
            }
        }

        int countDuoiTramNgan = 0;
        for (double gia : giaSanPham) {
            if (gia < 100000) {
                countDuoiTramNgan++;
            }
        }

        Set<Double> setGia = new HashSet<>();
        for (double gia : giaSanPham) {
            setGia.add(gia);
        }

        int soMucGiaKhacNhau = setGia.size();

        System.out.println("\nKET QUA");
        System.out.printf("Tong gia tri hang hoa: %,.0f VND\n", tong);
        System.out.printf("Gia trung binh: %,.0f VND\n", trungBinh);
        System.out.println("So san pham co gia > 1.000.000: " + countTrenTrieu);
        System.out.println("So san pham co gia < 100.000: " + countDuoiTramNgan);

        System.out.println("Danh sach gia sau khi loai bo trung:");
        for (double gia : setGia) {
            System.out.printf("%.0f\n", gia);
        }

        System.out.println("So muc gia khac nhau: " + soMucGiaKhacNhau);

        sc.close();
    }
}
