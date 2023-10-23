package package0;

import java.util.ArrayList;
import java.util.List;

public class QuanLyDsTaiKhoan {

    private TaiKhoan taiKhoanChinh;

    private List<TaiKhoan> danhSach;

    public QuanLyDsTaiKhoan() throws Exception {
        System.out.print("Nhap so tien gui: ");
        double tienGui = Double.parseDouble(CauHinh.sc.nextLine());
        this.taiKhoanChinh = new TaiKhoan(tienGui);
        this.danhSach = new ArrayList<>();
    }

    public QuanLyDsTaiKhoan(double tienGui, String date, String stk) throws Exception {
        this.taiKhoanChinh = new TaiKhoan(tienGui, date, stk);
        this.danhSach = new ArrayList<>();
    }

    public void moTaiKhoanKyHan(double tienGui, KyHan kyHan) throws Exception {
        if (taiKhoanChinh.getSoDu() >= 50000 && tienGui >= 100000) {
            TaiKhoan t = new TaiKhoanCoKyHan(tienGui, kyHan);
            this.danhSach.add(t);
        } else {
            throw new Exception("Khong du dieu kien de mo tai khoan ky han");
        }
    }

    public double tinhTienLai(String soTaiKhoan) {
        if (taiKhoanChinh.getSoTaiKhoan().equals(soTaiKhoan)) {
            return taiKhoanChinh.tinhTienLai();
        }
        return danhSach.stream().filter(x -> x.getSoTaiKhoan().equals(soTaiKhoan)).findFirst().get().tinhTienLai();
    }

    public double tongTienGui() {
        return taiKhoanChinh.getSoDu() + danhSach.stream().mapToDouble(x -> x.getSoDu()).sum();
    }

    public static KyHan chonKyHan() {
        System.out.print("1. Mot tuan\n2. Mot thang\n3. Sau thang\n4. Mot nam\nLua chon cua ban: ");
        switch (Integer.parseInt(CauHinh.sc.nextLine())) {
            case 1 -> {
                return KyHan.MOT_TUAN;
            }
            case 2 -> {
                return KyHan.MOT_THANG;
            }
            case 3 -> {
                return KyHan.SAU_THANG;
            }
            default -> {
                return KyHan.MOT_NAM;
            }
        }
    }

    /**
     * @return the taiKhoan
     */
    public TaiKhoan getTaiKhoan() {
        return taiKhoanChinh;
    }

    /**
     * @param taiKhoan the taiKhoan to set
     */
    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoanChinh = taiKhoan;
    }

    /**
     * @return the danhSach
     */
    public List<TaiKhoan> getDanhSach() {
        return danhSach;
    }

    /**
     * @param ds the danhSach to set
     */
    public void setDanhSach(List<TaiKhoan> ds) {
        this.danhSach = ds;
    }

}
