package package0;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class TaiKhoan {

    private final String soTaiKhoan;
    private double soDu;

    private Date ngayMo;

    public TaiKhoan(Double tienGui) throws Exception {
        this.soTaiKhoan = String.format("6261%d%05d", CauHinh.now.get(Calendar.YEAR), (int) (Math.random() * 100000 - 1));
        if (isHopLe(tienGui)) {
            this.soDu = tienGui;
            this.ngayMo = CauHinh.now.getTime();
        } else {
            throw new Exception("Khong du dieu kien de tao tai khoan");
        }
    }

    public TaiKhoan(double tienGui, String ngayMo, String stk) throws ParseException, Exception {
        this.soTaiKhoan = stk;
        if (isHopLe(tienGui)) {
            this.soDu = tienGui;
            this.ngayMo = CauHinh.F.parse(ngayMo);
        } else {
            throw new Exception("Khong du dieu kien tao tai khoan");
        }
    }

    public double getLaiSuat() {
        return 0.2 / 100;
    }

    public boolean isDaoHan() {
        return true;
    }

    public boolean nopTien(double t) {
        if (isDaoHan()) {
            this.soDu += t;
            return true;
        }
        return false;
    }

    public boolean rutTien(double t) {
        if (isDaoHan() && t <= this.soDu) {
            this.soDu -= t;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("So tai khoan: %s\nSo du tai khoan: %,.1f\n", this.soTaiKhoan, this.soDu);
    }

    public double tinhTienLai() {
        return getLaiSuat() * (1 + (0.2 / 100));
    }

    public boolean isHopLe(double tienGui) {
        return tienGui >= 50000;
    }

    /**
     * @return the maTK
     */
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    /**
     * @return the soDu
     */
    public double getSoDu() {
        return soDu;
    }

    /**
     * @param soDu the soDu to set
     */
    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    /**
     * @return the ngayMo
     */
    public Date getNgayMo() {
        return ngayMo;
    }

    /**
     * @param ngayMo the ngayMo to set
     */
    public void setNgayMo(Date ngayMo) {
        this.ngayMo = ngayMo;
    }
}
