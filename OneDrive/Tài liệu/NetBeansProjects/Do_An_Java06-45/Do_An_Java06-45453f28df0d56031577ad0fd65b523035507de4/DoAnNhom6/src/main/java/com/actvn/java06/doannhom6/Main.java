package com.actvn.java06.doannhom6;

import  com.actvn.java06.doannhom6.QuanLyThongTin;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    static void Menu_1() {
        System.out.println("====================== MENU =======================");
        System.out.println("I. THEM MOI 1 SINH VIEN.");
        System.out.println("II. HIEN THI DANH SACH SINH VIEN. ");
        System.out.println("III. SUA THONG TIN 1 SINH VIEN.");
        System.out.println("IV.XOA MOT SINH VIEN.");
        System.out.println("V. XUAT FILE SINH VIEN.");
        System.out.println("VI. LOC THONG TIN SINH VIEN.");
        System.out.println(" _Moi ban chon chuc nang : ");
    }

    public static void main(String[] args) throws FileNotFoundException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        do {
            Menu_1();
            luachon = sc.nextInt();
            switch (luachon) {
                case 1:
                    sc .nextLine();
                    QuanLyThongTin.themMoiSinhVien();
                    System.out.println("");
                    break;
                case 2:
                    QuanLyThongTin.hienThiThongTin();
                    System.out.println("");
                    break;
                case 3:
                    QuanLyThongTin.suaThongTin();
                    System.out.println("");
                    break;
                case 4:
                    QuanLyThongTin.xoaSinhVien();
                    System.out.println("");
                    break;
                    case 5:
                    QuanLyThongTin.xuatFileSinhVien();
                    break;
                case 6:
                    QuanLyThongTin.timKiemLocDanhSach();
                    System.out.println("");
                    break;
                case 7:
                    QuanLiDiem.setDiemTungMonKhoaATTT();
                    System.out.println("");
                    QuanLiDiem.hienThiDiemKhoaATTT();
            }

        } while (luachon != 8);

    }
}
