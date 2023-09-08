package com.actvn.java06.doannhom6;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class QuanLyThongTin {

    private static final String CSV_GHI_SINH_VIEN_ATTT_FILE_PATH = "C:\\Java core\\Java06\\Sinh_vien_ATTT.csv";
    private static final String CSV_GHI_SINH_VIEN_CNTT_FILE_PATH = "C:\\Java core\\Java06\\Sinh_vien_CNTT.csv";
    private static final String CSV_GHI_SINH_VIEN_DTVT_FILE_PATH = "C:\\Java core\\Java06\\Sinh_vien_DTVT.csv";

    public static Scanner sc = new Scanner(System.in);

    public static Khoa_ATTT khoa_ATTT = new Khoa_ATTT();
    public static Khoa_CNTT khoa_CNTT = new Khoa_CNTT();
    public static Khoa_DTVT khoa_DTVT = new Khoa_DTVT();

    public static List<SinhVienATTT> listSVATTT = new ArrayList<>();
    public static List<SinhVienCNTT> listSVCNTT = new ArrayList<>();
    public static List<SinhVienDTVT> listSVDTVT = new ArrayList<>();

//==================================== CAC MENU CHUC NANG ========================================================
    static void menuSuaThongTin() {
        System.out.println("\n\t====================MENU==========================\n");
        System.out.println("\t1. Sua thong tin ten lop.");
        System.out.println("\t2. Sua thong tin ho ten.");
        System.out.println("\t3. Sua thong tin gioi tinh.");
        System.out.println("\t4. Sua thong tin que quan.");
        System.out.println("\t5. Sua thong tin ngay thang nam sinh.");
        System.out.println("\t6. Sua thong tin email.");
        System.out.println("\t\t _Lua chon của bạn : ");
    }

    static void menuLocDanhSach() {
        System.out.println("\n\t====================MENU==========================\n");
        System.out.println("\t1. loc thong tin theo lop.");
        System.out.println("\t2. loc thong tin cua 1 sinh vien bat ki.");
        System.out.println("\t\t _Lua chon của bạn : ");
    }

//================================= CAC HAM BO TRO =========================================================
    public static <E> void hienThiChoHamShow(E e, int dem) {
        System.out.printf("%-5d", dem);
        System.out.print("" + e.toString());
    }

    public static <E> void show(List<E> list) {
        int dem = 1;
        System.out.printf("%-5s%15s%25s%10s%10s%15s%15s%50s%30s\n\n", "STT", "MA SV", "HO VA TEN", "KHOA", "LOP", "GIOI TINH", "NGAY SINH", "QUE QUAN", "EMAIL");
        for (E e : list) {
            hienThiChoHamShow(e, dem);
            dem++;
        }
    }

    public static int timKiemSVATTT(String str) {

        for (int i = 0; i < khoa_ATTT.getListSVATTT().size(); i++) {
            if (khoa_ATTT.getListSVATTT().get(i).getMaSV().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static int timKiemSVCNTT(String str) {

        for (int i = 0; i < khoa_CNTT.getListSVCNTT().size(); i++) {
            if (khoa_CNTT.getListSVCNTT().get(i).getMaSV().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static int timKiemSVDTVT(String str) {

        for (int i = 0; i < khoa_DTVT.getListSVDTVT().size(); i++) {
            if (khoa_DTVT.getListSVDTVT().get(i).getMaSV().equals(str)) {
                return i;
            }
        }
        return -1;
    }

//===================================================================================================================
// ================================================ THEM MOI =========================================================
    public static void themMoiSinhVien() throws FileNotFoundException, CsvDataTypeMismatchException {

        System.out.println("+ Nhap ten khoa (ATTT/CNTT/DTVT): ");
        String tenNganh = sc.nextLine();
        System.out.println("+ Nhap ma sinh vien: ");
        String maSV = sc.nextLine();
        System.out.println("+ Nhap ten lop : ");
        String lop = sc.nextLine();
        System.out.println("+ Nhap ho va ten sinh vien : ");
        String hoTen = sc.nextLine();
        System.out.println("+ Nhap ngay thang nam sinh (dd-MM-yyyy) : ");
        String strDay = sc.nextLine();
        LocalDate ntNamSinh = LocalDate.parse(strDay, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("+ Nhap gioi tinh (Nam/Nu) : ");
        String gioiTinh = sc.nextLine();
        System.out.println("+ Nhap dia chi (xa,huyen,tinh / phuong,thi tran, thanh pho) : ");
        String queQuan = sc.nextLine();
        System.out.println("+ Nhap email lien he : ");
        String email = sc.nextLine();

        if ("ATTT".equals(tenNganh)) {
            SinhVienATTT svATTT = new SinhVienATTT(tenNganh, lop, maSV, hoTen, gioiTinh, queQuan, ntNamSinh, email);
            listSVATTT.add(svATTT);
            khoa_ATTT.setListSVATTT(listSVATTT);
            /*   try {
                luuSinhVienATTT();
            } catch (CsvRequiredFieldEmptyException ex) {
                Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
            } */
        } else if ("CNTT".equals(tenNganh)) {
            SinhVienCNTT svCNTT = new SinhVienCNTT(tenNganh, lop, maSV, hoTen, gioiTinh, queQuan, ntNamSinh, email);
            listSVCNTT.add(svCNTT);
            khoa_CNTT.setListSVCNTT(listSVCNTT);
            /*  try {
                luuSinhVienCNTT();
            } catch (CsvRequiredFieldEmptyException ex) {
                Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
            } */
        } else {
            SinhVienDTVT svDTVT = new SinhVienDTVT(tenNganh, lop, maSV, hoTen, gioiTinh, queQuan, ntNamSinh, email);
            listSVDTVT.add(svDTVT);
            khoa_DTVT.setListSVDTVT(listSVDTVT);
            /*   try {
                luuSinhVienDTVT();
            } catch (CsvRequiredFieldEmptyException ex) {
                Logger.getLogger(QuanLy.class.getName()).log(Level.SEVERE, null, ex);
            } */
        }
    }

//============================================ HIEN THI =============================================================== 
    public static void hienThiThongTin() {
        System.out.println("\n\t===================MENU==============================\n");
        System.out.println("\t1. Hien thi thong tin sinh viên khoa ATTT");
        System.out.println("\t2. Hien thi thong tin sinh viên khoa CNTT");
        System.out.println("\t3. Hien thi thong tin sinh viên khoa DTVT");
        System.out.println("\t4. Hien thi thong tin tat ca sinh viên");
        System.out.println("\t\t _Lua chon của bạn : ");
        int chon = sc.nextInt();
        sc.nextLine();
        switch (chon) {
            case 1:
                show(khoa_ATTT.getListSVATTT());
                break;
            case 2:
                show(khoa_CNTT.getListSVCNTT());
                break;
            case 3:
                show(khoa_DTVT.getListSVDTVT());
                break;
            case 4:
                System.out.println("_ATTT : ");
                show(khoa_ATTT.getListSVATTT());
                System.out.println("_CNTT : ");
                show(khoa_CNTT.getListSVCNTT());
                System.out.println("_DTVT : ");
                show(khoa_DTVT.getListSVDTVT());
                break;

        }

    }
// =========================================== SUA THONG TIN ========================================================

    public static void suaThongTin() {
        System.out.println("_Nhap MSV can sua thong tin : ");
        String ma = sc.nextLine();
        String item = ma.substring(0, 2);
        int index;
        if ("AT".equals(item)) {   //----------------------- ATTT --------------------------
            index = timKiemSVATTT(ma);
            if (index < 0) {
                System.out.println("KHONG TIM THAY SINH VIEN !!!");
            } else {

                menuSuaThongTin();
                int chon = sc.nextInt();
                sc.nextLine();

                switch (chon) {

                    case 1:
                        System.out.println("\nNhap ten lop moi : ");
                        String l = sc.nextLine();
                        khoa_ATTT.getListSVATTT().get(index).setLop(l);
                        break;
                    case 2:
                        System.out.println("\nNhap ho ten moi : ");
                        String ht = sc.nextLine();
                        khoa_ATTT.getListSVATTT().get(index).setName(ht);
                        break;
                    case 3:
                        System.out.println("\nNhap gioi tinh moi : ");
                        String gt = sc.nextLine();
                        khoa_ATTT.getListSVATTT().get(index).setGioitinh(gt);
                        break;
                    case 4:
                        System.out.println("\nNhap que quan moi : ");
                        String qq = sc.nextLine();
                        khoa_ATTT.getListSVATTT().get(index).setQuequan(qq);
                        break;
                    case 5:
                        System.out.println("\nNhap ngay thang nam sinh moi (dd-MM-yyyy) : ");
                        String ntn = sc.nextLine();
                        LocalDate dateMoi = LocalDate.parse(ntn, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        khoa_ATTT.getListSVATTT().get(index).setNgaysinh(dateMoi);
                        break;
                    case 6:
                        System.out.println("\nNhap ten email moi : ");
                        String em = sc.nextLine();
                        khoa_ATTT.getListSVATTT().get(index).setEmail(em);
                        break;
                    default:
                        break;

                }
            }
        } else if ("CT".equals(item)) {   // ------------------------ CNTT ------------------------------
            index = timKiemSVCNTT(ma);
            if (index < 0) {
                System.out.println("KHONG TIM THAY SINH VIEN !!!");
            } else {

                menuSuaThongTin();
                int chon = sc.nextInt();
                sc.nextLine();

                switch (chon) {

                    case 1:
                        System.out.println("\nNhap ten lop moi : ");
                        String l = sc.nextLine();
                        khoa_CNTT.getListSVCNTT().get(index).setLop(l);
                        break;
                    case 2:
                        System.out.println("\nNhap ho ten moi : ");
                        String ht = sc.nextLine();
                        khoa_CNTT.getListSVCNTT().get(index).setName(ht);
                        break;
                    case 3:
                        System.out.println("\nNhap gioi tinh moi : ");
                        String gt = sc.nextLine();
                        khoa_CNTT.getListSVCNTT().get(index).setGioitinh(gt);
                        break;
                    case 4:
                        System.out.println("\nNhap que quan moi : ");
                        String qq = sc.nextLine();
                        khoa_CNTT.getListSVCNTT().get(index).setQuequan(qq);
                        break;
                    case 5:
                        System.out.println("\nNhap ngay thang nam sinh moi (dd-MM-yyyy) : ");
                        String ntn = sc.nextLine();
                        LocalDate dateMoi = LocalDate.parse(ntn, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        khoa_CNTT.getListSVCNTT().get(index).setNgaysinh(dateMoi);
                        break;
                    case 6:
                        System.out.println("\nNhap ten email moi : ");
                        String em = sc.nextLine();
                        khoa_CNTT.getListSVCNTT().get(index).setEmail(em);
                        break;
                    default:
                        break;

                }
            }
        } else {             //   -------------------------- DTVT---------------------
            index = timKiemSVDTVT(ma);
            if (index < 0) {
                System.out.println("KHONG TIM THAY SINH VIEN !!!");
            } else {

                menuSuaThongTin();
                int chon = sc.nextInt();
                sc.nextLine();

                switch (chon) {

                    case 1:
                        System.out.println("\nNhap ten lop moi : ");
                        String l = sc.nextLine();
                        khoa_DTVT.getListSVDTVT().get(index).setLop(l);
                        break;
                    case 2:
                        System.out.println("\nNhap ho ten moi : ");
                        String ht = sc.nextLine();
                        khoa_DTVT.getListSVDTVT().get(index).setName(ht);
                        break;
                    case 3:
                        System.out.println("\nNhap gioi tinh moi : ");
                        String gt = sc.nextLine();
                        khoa_DTVT.getListSVDTVT().get(index).setGioitinh(gt);
                        break;
                    case 4:
                        System.out.println("\nNhap que quan moi : ");
                        String qq = sc.nextLine();
                        khoa_DTVT.getListSVDTVT().get(index).setQuequan(qq);
                        break;
                    case 5:
                        System.out.println("\nNhap ngay thang nam sinh moi (dd-MM-yyyy) : ");
                        String ntn = sc.nextLine();
                        LocalDate dateMoi = LocalDate.parse(ntn, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        khoa_DTVT.getListSVDTVT().get(index).setNgaysinh(dateMoi);
                        break;
                    case 6:
                        System.out.println("\nNhap ten email moi : ");
                        String em = sc.nextLine();
                        khoa_DTVT.getListSVDTVT().get(index).setEmail(em);
                        break;
                    default:
                        break;
                }
            }
        }

    }

// ====================================== XOA BO ===============================================================
    static void xoaSinhVien() {
        System.out.println("_Nhap MSV can xoa bo : ");
        String ma = sc.nextLine();
        String item = ma.substring(0, 2);
        int index;
        if ("AT".equals(item)) {
            index = timKiemSVATTT(ma);
            if (index < 0) {
                System.out.println("KHONG TIM THAY SINH VIEN CAN XOA !!!");
            } else {
                khoa_ATTT.getListSVATTT().remove(index);
            }
        } else if ("CT".equals(item)) {
            index = timKiemSVCNTT(ma);
            if (index < 0) {
                System.out.println("KHONG TIM THAY SINH VIEN CAN XOA !!!");
            } else {
                khoa_CNTT.getListSVCNTT().remove(index);
            }
        } else {
            index = timKiemSVDTVT(ma);
            if (index < 0) {
                System.out.println("KHONG TIM THAY SINH VIEN CAN XOA !!!");
            } else {
                khoa_DTVT.getListSVDTVT().remove(index);
            }
        }

    }

    //========================================= TIM KIEM ==============================================================
    static void timKiemLocDanhSach() {
        menuLocDanhSach();
        int chon = sc.nextInt();
        sc.nextLine();
        switch (chon) {
            case 1:
                System.out.println("_Nhap ten lop can loc (AT.../CT.../DT...) : ");
                String tl = sc.nextLine();
                if ("AT".equals(tl.substring(0, 2))) {
                    int dem = 1;
                    System.out.printf("%-5s%15s%25s%10s%10s%15s%15s%50s%30s\n\n", "STT", "MA SV", "HO VA TEN", "KHOA", "LOP", "GIOI TINH", "NGAY SINH", "QUE QUAN", "EMAIL");
                    for (SinhVienATTT at : khoa_ATTT.getListSVATTT()) {
                        if (at.getLop().equals(tl)) {
                            hienThiChoHamShow(at, dem);
                            dem++;
                        }
                    }
                } else if ("CT".equals(tl.substring(0, 2))) {
                    int dem = 1;
                    System.out.printf("%-5s%15s%25s%10s%10s%15s%15s%50s%30s\n\n", "STT", "MA SV", "HO VA TEN", "KHOA", "LOP", "GIOI TINH", "NGAY SINH", "QUE QUAN", "EMAIL");
                    for (SinhVienCNTT ct : khoa_CNTT.getListSVCNTT()) {
                        if (ct.getLop().equals(tl)) {
                            hienThiChoHamShow(ct, dem);
                            dem++;
                        }
                    }
                } else {
                    int dem = 1;
                    System.out.printf("%-5s%15s%25s%10s%10s%15s%15s%50s%30s\n\n", "STT", "MA SV", "HO VA TEN", "KHOA", "LOP", "GIOI TINH", "NGAY SINH", "QUE QUAN", "EMAIL");
                    for (SinhVienDTVT dt : khoa_DTVT.getListSVDTVT()) {
                        if (dt.getLop().equals(tl)) {
                            hienThiChoHamShow(dt, dem);
                            dem++;
                        }
                    }
                }
                break;
            case 2:
                System.out.println("_Nhap MaSV can tim : ");
                String t2 = sc.nextLine();
                if (t2.charAt(0) == 'A') {
                    int index = timKiemSVATTT(t2);
                    if (index < 0) {
                        System.out.println("KHONG TIM THAY SINH VIEN CAN TIM !!!");
                    } else {
                        System.out.printf("%-5s%15s%25s%10s%10s%15s%15s%50s%30s\n\n", "STT", "MA SV", "HO VA TEN", "KHOA", "LOP", "GIOI TINH", "NGAY SINH", "QUE QUAN", "EMAIL");
                        hienThiChoHamShow(khoa_ATTT.getListSVATTT().get(index), 1);
                    }
                } else if (t2.charAt(0) == 'C') {
                    int index = timKiemSVCNTT(t2);
                    if (index < 0) {
                        System.out.println("KHONG TIM THAY SINH VIEN CAN TIM !!!");
                    } else {
                        System.out.printf("%-5s%15s%25s%10s%10s%15s%15s%50s%30s\n\n", "STT", "MA SV", "HO VA TEN", "KHOA", "LOP", "GIOI TINH", "NGAY SINH", "QUE QUAN", "EMAIL");
                        hienThiChoHamShow(khoa_CNTT.getListSVCNTT().get(index), 1);
                    }
                } else {
                    int index = timKiemSVDTVT(t2);
                    if (index < 0) {
                        System.out.println("KHONG TIM THAY SINH VIEN CAN TIM !!!");
                    } else {
                        System.out.printf("%-5s%15s%25s%10s%10s%15s%15s%50s%30s\n\n", "STT", "MA SV", "HO VA TEN", "KHOA", "LOP", "GIOI TINH", "NGAY SINH", "QUE QUAN", "EMAIL");
                        hienThiChoHamShow(khoa_DTVT.getListSVDTVT().get(index), 1);
                    }
                }
                break;
            default:
                break;
        }

    }

// ===================================== LUU XUAT FILE ==========================================================
    //---------------------------ATTT-------------------------------------
    static void luuSinhVienATTT() throws FileNotFoundException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new File(CSV_GHI_SINH_VIEN_ATTT_FILE_PATH));

            StatefulBeanToCsv<SinhVienATTT> beanToCsv = new StatefulBeanToCsvBuilder<SinhVienATTT>(pw)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<SinhVienATTT> testList = new ArrayList<>();
            for (SinhVienATTT svat : khoa_ATTT.getListSVATTT()) {

                testList.add(svat);
            }

            beanToCsv.write(testList);

        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    //--------------------------- CNTT -----------------------------------------
    static void luuSinhVienCNTT() throws FileNotFoundException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new File(CSV_GHI_SINH_VIEN_CNTT_FILE_PATH));

            StatefulBeanToCsv<SinhVienCNTT> beanToCsv = new StatefulBeanToCsvBuilder<SinhVienCNTT>(pw)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<SinhVienCNTT> testList = new ArrayList<>();
            for (SinhVienCNTT svct : khoa_CNTT.getListSVCNTT()) {

                testList.add(svct);
            }

            beanToCsv.write(testList);

        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    //--------------------------------------- DTVT ----------------------------------------------------------   
    static void luuSinhVienDTVT() throws FileNotFoundException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new File(CSV_GHI_SINH_VIEN_DTVT_FILE_PATH));

            StatefulBeanToCsv<SinhVienDTVT> beanToCsv = new StatefulBeanToCsvBuilder<SinhVienDTVT>(pw)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<SinhVienDTVT> testList = new ArrayList<>();
            for (SinhVienDTVT svdt : khoa_DTVT.getListSVDTVT()) {

                testList.add(svdt);
            }

            beanToCsv.write(testList);

        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    static void xuatFileSinhVien() throws FileNotFoundException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        System.out.println("\n\t===================MENU==============================\n");
        System.out.println("\t1. xuat file CSV sinh viên khoa ATTT");
        System.out.println("\t2. xuat file  CSV sinh viên khoa CNTT");
        System.out.println("\t3. xuat file CSV sinh viên khoa DTVT");
        System.out.println("\t\t _Lua chon của bạn : ");
        
        int chon = sc.nextInt();
        switch (chon) {
            case 1:
                luuSinhVienATTT();
                break;
            case 2:
                luuSinhVienCNTT();
                break;
            case 3:
               luuSinhVienDTVT();
               break;
                      
        }
    }

}
