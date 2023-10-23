package package0;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class KhachHang {

    private final String maSoKhachHang;

    private String hoTen;

    private String gioiTinh;

    private Date ngaySinh;

    private String soCCCD;

    private String queQuan;

    private String matKhau;

    private QuanLyDsTaiKhoan quanLy;

    public KhachHang() {
        this.maSoKhachHang = String.format("%d%02d%d%04d", CauHinh.now.get(Calendar.DATE), CauHinh.now.get(Calendar.MONTH) + 1, CauHinh.now.get(Calendar.YEAR), (int) (Math.random() * 10000 - 1));
        this.matKhau = String.format("%06d", (int) (Math.random() * 1000000 - 1));
    }

    public KhachHang(String maSoKhachHang, String matKhau, String hoTen, String gioiTinh, String ngaySinh, String soCCCD, String queQuan, String stk, double soDu, String ngayTao) throws Exception {
        this.maSoKhachHang = maSoKhachHang;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = CauHinh.F.parse(ngaySinh);
        this.soCCCD = soCCCD;
        this.queQuan = queQuan;
        this.matKhau = matKhau;
        this.quanLy = new QuanLyDsTaiKhoan(soDu, ngayTao, stk);
    }

    public void nhapTTKH() throws ParseException, Exception {
        System.out.println("Nhap thong tin khach hang");
        System.out.print("Nhap ho va ten: ");
        this.hoTen = CauHinh.sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        this.gioiTinh = CauHinh.sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        this.ngaySinh = CauHinh.F.parse(CauHinh.sc.nextLine());
        System.out.print("Nhap so can cuoc cong dan: ");
        this.soCCCD = CauHinh.sc.nextLine();
        System.out.print("Nhap que quan: ");
        this.queQuan = CauHinh.sc.nextLine();
        this.quanLy = new QuanLyDsTaiKhoan();
    }

    public void xuatThongTinDangNhap() {
        System.out.printf("Tai khoan: %s\n Mat khau: %s\n", this.maSoKhachHang, this.matKhau);
    }

    public boolean doiMatKhau() {
        System.out.print("Nhap mat khau cu: ");
        String temp = CauHinh.sc.nextLine();
        if (!temp.equals(this.matKhau)) {
            System.out.println("Sai mat khau");
            return false;
        } else {
            System.out.print("Nhap mat khau moi: ");
            temp = CauHinh.sc.nextLine();
            String regex = "\"d*";
            if (temp.length() == 6 && temp.matches(regex)) {
                this.matKhau = temp;
                return true;
            }
            System.out.println("Dinh dang mat khau la 6 ki tu so");
            return false;
        }
    }

    public double tongTienGui() {
        return this.quanLy.tongTienGui();
    }

    @Override
    public String toString() {
        return String.format("-Ho ten: %s\n-Ma so khach hang: %s\n-Tong tien gui: %,.1f", this.hoTen, this.maSoKhachHang, this.tongTienGui());
    }

    /**
     * @return the maSoKhachHang
     */
    public String getMaSoKhachHang() {
        return maSoKhachHang;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the soCCCD
     */
    public String getSoCCCD() {
        return soCCCD;
    }

    /**
     * @param soCCCD the soCCCD to set
     */
    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the passWord
     */
    public String getPassWord() {
        return matKhau;
    }

    /**
     * @param passWord the passWord to set
     */
    public void setPassWord(String passWord) {
        this.matKhau = passWord;
    }

    /**
     * @return the quanLy
     */
    public QuanLyDsTaiKhoan getQuanLyDsTaiKhoan() {
        return quanLy;
    }

    /**
     * @param quanLy the quanLy to set
     */
    public void setQuanLyDsTaiKhoan(QuanLyDsTaiKhoan quanLy) {
        this.quanLy = quanLy;
    }

}
