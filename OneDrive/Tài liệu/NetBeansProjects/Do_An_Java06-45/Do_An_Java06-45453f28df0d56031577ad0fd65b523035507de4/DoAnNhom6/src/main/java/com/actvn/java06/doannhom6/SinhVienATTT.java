package com.actvn.java06.doannhom6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SinhVienATTT extends SinhVien {

    private String TenNganh;
    private String Lop;
    
   // private ArrayList <MonHoc>  monATTT= new ArrayList<>(10);
     MonHoc ctdl_va_gt = new MonHoc("CAU TRUC DU LIEU VA GIAI THUAT", 3);
     MonHoc qtat_ht = new MonHoc("QUAN TRI AN TOAN HE THONG", 3);
     MonHoc nmmmh = new MonHoc("NHAP MON MAT MA HOC", 3);
     MonHoc gtatm = new MonHoc("GIAO THUC AN TOAN MANG", 3);
     MonHoc ktlt = new MonHoc("KI THUAT LAP TRINH", 3);
     MonHoc tttattt = new MonHoc("THUAT TOAN TRONG AN TOAN THONG TIN", 3);
     MonHoc tcvptht = new MonHoc("TAN CONG VA PHONG THU HE THONG", 3);
     MonHoc lthdt = new MonHoc("LAP TRINH HUONG DOI TUONG", 3);
     MonHoc cdcs = new MonHoc("CHUYEN DE CO SO", 3);
     MonHoc ktmtvhn = new MonHoc("KIEN TRUC MAY TINH VA HOP NGU", 3);


    public SinhVienATTT(String TenNganh, String Lop, String MaSV, String Name, String gioiTinh, String queQuan, LocalDate ngaySinh, String email) {
        super(MaSV, Name, gioiTinh, queQuan, ngaySinh, email);
        this.TenNganh = TenNganh;
        this.Lop = Lop;
    }

    public String getTenNganh() {
        return TenNganh;
    }

    public void setTenNganh(String TenNganh) {
        this.TenNganh = TenNganh;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }
    
    

    @Override
    public String toString() {
        return String.format("%15s%25s%10s%10s%15s%15s%50s%30s\n", getMaSV(), getName(), getTenNganh(), getLop(), getGioitinh(), getNgaysinh(), getQuequan(), getEmail());
    }


}
