package com.actvn.java06.doannhom6;

import com.actvn.java06.doannhom6.QuanLyThongTin;
import java.util.List;
import java.util.Scanner;

public class QuanLiDiem {

    public static Scanner sc = new Scanner(System.in);

    public static List<SinhVienATTT> svATTT = QuanLyThongTin.khoa_ATTT.getListSVATTT();

    static void setDiemTungMonKhoaATTT() {

        for (int i = 0; i < svATTT.size(); i++) {
            System.out.println(svATTT.get(i).getMaSV() + " - " + svATTT.get(i).getName() + " : ");
            System.out.println("_Nhap diem mon CAU TRUC DU LIEU VA GIAI THUAT : ");
            svATTT.get(i).ctdl_va_gt.setDiem(sc.nextDouble());

            System.out.println("_Nhap diem mon QUAN TRI AN TOAN HE THONG : ");
            svATTT.get(i).qtat_ht.setDiem(sc.nextDouble());

            System.out.println("_Nhap diem mon GIAO THUC AN TOAN MANG : ");
            svATTT.get(i).gtatm.setDiem(sc.nextDouble());

            System.out.println("_Nhap diem mon NHAP MON MAT MA HOC : ");
            svATTT.get(i).nmmmh.setDiem(sc.nextDouble());

            System.out.println("_Nhap diem mon KI THUAT LAP TRINH : ");
            svATTT.get(i).ktlt.setDiem(sc.nextDouble());

            System.out.println("_Nhap diem mon THUAT TOAN TRONG AN TOAN THONG TIN : ");
            svATTT.get(i).tttattt.setDiem(sc.nextDouble());

            System.out.println("_Nhap diem mon TAN CONG VA PHONG THU HE THONG : ");
            svATTT.get(i).tcvptht.setDiem(sc.nextDouble());

            System.out.println("_Nhap diem mon LAP TRINH HUONG DOI TUONG : ");
            svATTT.get(i).lthdt.setDiem(sc.nextDouble());

            System.out.println("_Nhap diem mon CHUYEN DE CO SO : ");
            svATTT.get(i).cdcs.setDiem(sc.nextDouble());

            System.out.println("_Nhap diem mon KIEN TRUC MAY TINH VA HOP NGU : ");
            svATTT.get(i).ktmtvhn.setDiem(sc.nextDouble());

        }
    }

    static void hienThiDiemKhoaATTT() {
        for (int i = 0; i < svATTT.size(); i++) {
            System.out.printf("%-5d", i + 1);
            System.out.printf("%15s%30s%10s%20f%20f%20f%20f%20f%20f%20f%20f%20f%20f\n", svATTT.get(i).getMaSV(), svATTT.get(i).getName(), svATTT.get(i).getLop(),
                    svATTT.get(i).ctdl_va_gt.getDiem(),
                    svATTT.get(i).qtat_ht.getDiem(),
                    svATTT.get(i).gtatm.getDiem(),
                    svATTT.get(i).nmmmh.getDiem(),
                    svATTT.get(i).ktlt.getDiem(),
                     svATTT.get(i).tttattt.getDiem(),
                     svATTT.get(i).tcvptht.getDiem(),
                     svATTT.get(i).lthdt.getDiem(),
                     svATTT.get(i).cdcs.getDiem(),
                     svATTT.get(i).ktmtvhn.getDiem());
        
    


            
        }

    }

}
