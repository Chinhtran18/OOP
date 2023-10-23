/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package package0;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author chinh
 */
public final class GiaoDien {

    public GiaoDien() {
    }

    public int choose() {
        return Integer.parseInt(CauHinh.sc.nextLine());
    }

    public void giaoDienChinh(QuanLyDsKhachHang q) {
        int choice;
        do {
            System.out.print("1. Dang nhap\n2. Tao tai khoan\n3. Dang nhap voi admin\n4. Thoat\nNhap lua chon cua ban: ");
            choice = choose();
            System.out.println("--------------------------------------------");
            switch (choice) {
                case 1 -> {
                    System.out.println("Nhap thong tin dang nhap: ");
                    System.out.print("Tai khoan: ");
                    String user = CauHinh.sc.nextLine();
                    System.out.print("Mat khau: ");
                    String pass = CauHinh.sc.nextLine();
                    try {
                        KhachHang c = q.dangNhap(user, pass);
                        if (c == null) {
                            System.out.println("Sai tai khoan hoac mat khau");
                            System.out.println("--------------------------------------------");
                        } else {
                            giaoDienTaiKhoanChinh(c);
                        }
                    } catch (NoSuchElementException ex) {
                        System.out.println("Sai tai khoan hoac mat khau");
                        System.out.println("--------------------------------------------");
                    }
                    break;
                }
                case 2 -> {
                    try {
                        KhachHang c = new KhachHang();
                        c.nhapTTKH();
                        System.out.println("Tao tai khoan thanh cong!");
                        c.xuatThongTinDangNhap();
                        q.themKhachHang(c);
                    } catch (Exception ex) {
                        ex.getMessage();
                    }
                    break;
                }
                case 3 -> {
                    giaoDienAdmin(q);
                    break;
                }
                default -> {
                    System.out.println("Da thoat khoi chuong trinh");
                    break;
                }
            }
        } while (choice >= 1 && choice <= 3);
    }

    public void giaoDienTaiKhoanChinh(KhachHang c) {
        int choice;
        do {
            System.out.printf("%s - %s\tSo tai khoan chinh: %s\n", c.getHoTen(), c.getMaSoKhachHang(), c.getQuanLyDsTaiKhoan().getTaiKhoan().getSoTaiKhoan());
            System.out.printf("So du tai khoan chinh: %,.1f\n", c.getQuanLyDsTaiKhoan().getTaiKhoan().getSoDu());
            System.out.print("1. Xem cac tai khoan ky han\n2. Nop tien\n3. Rut tien\n4. Doi mat khau\n5. Mo tai khoan ky han\n6. Thoat\nNhap lua chon cua ban: ");
            choice = choose();
            switch (choice) {
                case 1 -> {
                    giaoDienCacTaiKhoanKyHan(c);
                    break;
                }
                case 2 -> {
                    giaoDienNopTien(c.getQuanLyDsTaiKhoan().getTaiKhoan());
                    break;
                }
                case 3 -> {
                    giaoDienRutTien(c.getQuanLyDsTaiKhoan().getTaiKhoan());
                    break;
                }
                case 4 -> {
                    c.doiMatKhau();
                }
                case 5 -> {
                    System.out.printf("%s - %s\tSo tai khoan chinh: %s\n", c.getHoTen(), c.getMaSoKhachHang(), c.getQuanLyDsTaiKhoan().getTaiKhoan().getSoTaiKhoan());
                    System.out.print("Nhap so tien gui: ");
                    double m = Double.parseDouble(CauHinh.sc.nextLine());
                    System.out.println("Chon ky han: ");
                    KyHan k = QuanLyDsTaiKhoan.chonKyHan();
                    try {
                        c.getQuanLyDsTaiKhoan().moTaiKhoanKyHan(m, k);
                        System.out.println("Tao tai khoan ky han thanh cong!");
                        System.out.println("--------------------------------------------");

                    } catch (Exception ex) {
                        System.out.println("Khong du dieu kien tao tai khoan ky han");
                        System.out.println("--------------------------------------------");

                    }
                    break;
                }
                default -> {
                    break;
                }
            }
        } while (choice >= 1 && choice <= 5);
    }

    public void giaoDienCacTaiKhoanKyHan(KhachHang c) {
        int amount = c.getQuanLyDsTaiKhoan().getDanhSach().size();
        int choice;
        do {
            System.out.printf("%s - %s\tSo tai khoan chinh: %s\n", c.getHoTen(), c.getMaSoKhachHang(), c.getQuanLyDsTaiKhoan().getTaiKhoan().getSoTaiKhoan());
            for (int i = 0; i < amount; ++i) {
                System.out.printf("%d. %s\n", i + 1, c.getQuanLyDsTaiKhoan().getDanhSach().get(i));
            }
            System.out.printf("%d. Xem tien lai\n%d. Thoat\nNhap lua chon cua ban: ", amount + 1, amount + 2);
            choice = choose();
            System.out.println("--------------------------------------------");

            if (choice > 0 && choice <= amount) {
                giaoDienTaiKhoanKyHan(c.getQuanLyDsTaiKhoan().getTaiKhoan(), c.getQuanLyDsTaiKhoan().getDanhSach().get(choice - 1));
                break;
            } else if (choice == amount + 1) {
                System.out.print("Nhap so tai khoan: ");
                System.out.printf("Tien lai: %,.1f\n", c.getQuanLyDsTaiKhoan().tinhTienLai(CauHinh.sc.nextLine()));
                System.out.println("--------------------------------------------");
            }
        } while (true);
    }

    public void giaoDienTaiKhoanKyHan(TaiKhoan chinh, TaiKhoan kyHan) {
        TaiKhoanCoKyHan c = (TaiKhoanCoKyHan) kyHan;
        int choice;
        do {
            System.out.printf("So du tai khoan: %,.1f - Ky han: %s - Lai suat: %.2f - Ngay dao han: %s\n", c.getSoDu(), c.getKyHan(), c.getLaiSuat() * 100, CauHinh.F.format(c.getNgayDaoHan().getTime()));
            System.out.print("1. Nop tien\n2. Rut tien\n3. Thoat\nNhap lua chon cua ban: ");
            choice = choose();
            switch (choice) {
                case 1 -> {
                    giaoDienNopTien(c);
                    System.out.println("--------------------------------------------");

                    break;
                }
                case 2 -> {
                    giaoDienRutTien(chinh, c);
                    System.out.println("--------------------------------------------");

                    break;
                }
                default -> {
                    break;
                }
            }
        } while (choice >= 1 && choice <= 2);
    }

    public void giaoDienNopTien(TaiKhoan c) {
        System.out.print("Nhap so tien nop: ");
        double m = Double.parseDouble(CauHinh.sc.nextLine());
        if (c.nopTien(m)) {
            System.out.println("Nop tien thanh cong");
        } else {
            System.out.println("Khong du dieu kien de thuc hien yeu cau");
        }
        System.out.println("--------------------------------------------");

    }

    public void giaoDienRutTien(TaiKhoan c) {
        System.out.print("Nhap so tien rut: ");
        double m = Double.parseDouble(CauHinh.sc.nextLine());
        if (c.rutTien(m)) {
            System.out.println("Rut tien thanh cong");
        } else {
            System.out.println("Khong du dieu kien de thuc hien yeu cau");
        }
        System.out.println("--------------------------------------------");

    }

    public void giaoDienRutTien(TaiKhoan chinh, TaiKhoan kyHan) {
        TaiKhoanCoKyHan c = (TaiKhoanCoKyHan) kyHan;
        System.out.print("Nhap so tien rut: ");
        double m = Double.parseDouble(CauHinh.sc.nextLine());
        if (c.rutTien(chinh, m)) {
            System.out.println("Rut tien thanh cong");
        } else {
            System.out.println("Khong du dieu kien de thuc hien yeu cau");
        }
        System.out.println("--------------------------------------------");

    }

    public void giaoDienAdmin(QuanLyDsKhachHang q) {
        int choice;
        q.hienThi();
        do {
            System.out.print("1. Tra cuu khach hang theo ten\n2. Tra cuu khach hang theo ma so khach hang\n3. Sap xep khach hang theo tong tien gui\n4. Thoat\nNhap lua chon cua ban: ");
            choice = choose();
            System.out.println("--------------------------------------------");

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhap ten khach hang: ");
                    String name = CauHinh.sc.nextLine();
                    List<KhachHang> temp = q.traCuuKHs(name);
                    if (temp == null) {
                        System.out.printf("Khong tim thay khach hang co ten %s", name);
                    } else {
                        temp.forEach(x -> System.out.println(x));
                    }
                    System.out.println("--------------------------------------------");

                    break;
                }
                case 2 -> {
                    System.out.print("Nhap ma so khach hang: ");
                    String maSo = CauHinh.sc.nextLine();
                    KhachHang temp = q.traCuuKH(maSo);
                    if (temp == null) {
                        System.out.printf("Khong tim thay khach hang co ma so %s", maSo);
                    } else {
                        System.out.println(temp);
                    }
                    System.out.println("--------------------------------------------");

                    break;
                }
                case 3 -> {
                    q.sapXep();
                    q.hienThi();
                    System.out.println("--------------------------------------------");

                    break;
                }
                default -> {
                    break;
                }
            }
        } while (choice >= 1 && choice <= 3);
    }
}
