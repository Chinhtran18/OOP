package package0;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public enum KyHan {
    MOT_TUAN(Calendar.DAY_OF_YEAR, 7, 2.0 / 100) {
        @Override
        public double tinhTienLai(double soDu) {
            return soDu * (2.0/100)/Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        }
    },
    MOT_THANG(Calendar.MONTH, 1, 5.5 / 100) {
        @Override
        public double tinhTienLai(double soDu) {
            return soDu *(5.5 / 100)/12;
        }
    },
    SAU_THANG(Calendar.MONTH, 6, 7.5 / 100) {
        @Override
        public double tinhTienLai(double soDu) {
            return soDu * (7.5 / 100)/2;
        }
    },
    MOT_NAM(Calendar.YEAR, 1, 7.9 / 100) {
        @Override
        public double tinhTienLai(double soDu) {
            return soDu * (7.9 / 100);
        }
    };
    private final int loaiTG;

    private final int khoangTG;

    private final double laiSuat;

    private KyHan(int ktg, int loai, double ls) {
        this.khoangTG = ktg;
        this.loaiTG = loai;
        this.laiSuat = ls;
    }

    public Calendar tinhNgayDaoHan(Date ngayM) {
        Calendar c = new GregorianCalendar();
        c.setTime(ngayM);
        c.add(khoangTG, loaiTG);
        return c;
    }

    public Calendar tinhNgayDaoHan() {
        Calendar c = (Calendar) CauHinh.now.clone();
        c.add(khoangTG, loaiTG);
        return c;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public abstract double tinhTienLai(double soDu);

}
