package package0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyDsKhachHang {

    private List<KhachHang> danhSach;

    public QuanLyDsKhachHang() {
        this.danhSach = new ArrayList<>();
    }

    public List<KhachHang> traCuuKHs(String hoTen) {
        return this.danhSach.stream().filter(x -> x.getHoTen().contains(hoTen)).toList();
    }

    public KhachHang traCuuKH(String ms) {
        return this.danhSach.stream().filter(x -> x.getMaSoKhachHang().equals(ms)).findFirst().get();
    }

    public void sapXep() {
        this.danhSach.sort(Comparator.comparing(KhachHang::tongTienGui).reversed());
    }

    public void hienThi() {
        this.danhSach.forEach(x -> {
            System.out.println("Thong tin khach hang: ");
            System.out.println(x.toString());
        });
    }

    public void themKhachHang(KhachHang c) {
        this.danhSach.add(c);
    }

    public KhachHang dangNhap(String userName, String passWord) {
        KhachHang c = this.traCuuKH(userName);
        if (c == null) {
            return c;
        } else if (c.getPassWord().equals(passWord)) {
            return c;
        }
        return null;
    }

    public void layDuLieu(String duongDan) throws FileNotFoundException, Exception {
        File f = new File(duongDan);
        try (Scanner sc = new Scanner(f)) {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 1; i <= n; i++) {
                String[] info = sc.nextLine().split("-");
                KhachHang temp = new KhachHang(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], Double.parseDouble(info[8]), info[9]);
                int m = Integer.parseInt(sc.nextLine());
                if (m != 0) {
                    for (int j = 1; j <= m; j++) {
                        info = sc.nextLine().split("-");
                        temp.getQuanLyDsTaiKhoan().getDanhSach().add(new TaiKhoanCoKyHan(info[0], Double.parseDouble(info[1]), info[2], info[3]));
                    }
                }
                themKhachHang(temp);
            }
        }
    }

    /**
     * @return the danhSach
     */
    /**
     * @return the danhSach
     */
    public List<KhachHang> getDanhSach() {
        return danhSach;
    }

    /**
     * @param danhSach the danhSach to set
     */
    public void setDanhSach(List<KhachHang> danhSach) {
        this.danhSach = danhSach;
    }

}
