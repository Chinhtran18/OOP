package package0;

import java.text.ParseException;
import java.util.Calendar;

public class TaiKhoanCoKyHan extends TaiKhoan {

    private Calendar ngayDaoHan;

    private KyHan kyHan;

    public TaiKhoanCoKyHan(Double tienGui, KyHan kyHan) throws Exception {
        super(tienGui);
        this.ngayDaoHan = kyHan.tinhNgayDaoHan();
        this.kyHan = kyHan;
    }

    public TaiKhoanCoKyHan(String stk, double sd, String ngayM, String kyHan) throws ParseException, Exception {
        super(sd, ngayM, stk);
        this.kyHan = KyHan.valueOf(kyHan);
        this.ngayDaoHan = this.kyHan.tinhNgayDaoHan(CauHinh.F.parse(ngayM));
    }

    @Override
    public double getLaiSuat() {
        return kyHan.getLaiSuat();
    }

    @Override
    public boolean isDaoHan() {
        return CauHinh.now.compareTo(ngayDaoHan) >= 0;
    }

    public boolean rutTien(TaiKhoan tkc, double tienRut) {
        if (isDaoHan()) {
            super.rutTien(tienRut);
            return true;
        } else {
            System.out.print("Xac nhan rut tien truoc ngay dao han (Y/N): ");
            String c = CauHinh.sc.nextLine();
            if (c.equals("Y") && tienRut <= this.getSoDu()) {
                tkc.setSoDu(tkc.getSoDu() + this.getSoDu() * tkc.getLaiSuat() + tienRut);
                this.setSoDu(this.getSoDu()-tienRut);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isHopLe(double tienGui) {
        return tienGui >= 100000;
    }

    @Override
    public double tinhTienLai() {
        return kyHan.tinhTienLai(this.getSoDu());
    }

    @Override
    public String toString() {
        return String.format("STK:%s - So du: %,.1f", getSoTaiKhoan(), getSoDu());
    }

    /**
     * @return the ngayDaoHan
     */
    public Calendar getNgayDaoHan() {
        return ngayDaoHan;
    }

    /**
     * @param ngayDaoHan the ngayDaoHan to set
     */
    public void setNgayDaoHan(Calendar ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }

    /**
     * @return the kyHan
     */
    public KyHan getKyHan() {
        return kyHan;
    }

    /**
     * @param kyHan the kyHan to set
     */
    public void setKyHan(KyHan kyHan) {
        this.kyHan = kyHan;
    }

}
