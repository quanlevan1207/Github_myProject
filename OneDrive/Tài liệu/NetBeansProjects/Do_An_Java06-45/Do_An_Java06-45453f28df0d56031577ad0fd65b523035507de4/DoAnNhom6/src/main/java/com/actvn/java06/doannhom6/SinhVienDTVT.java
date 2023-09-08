package com.actvn.java06.doannhom6;

import java.time.LocalDate;


public class SinhVienDTVT extends SinhVien{
    private String TenNganh;
    private String Lop;

    public SinhVienDTVT(String TenNganh, String Lop, String MaSV, String Name, String gioiTinh, String queQuan, LocalDate ngaySinh, String email) {
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
        return String.format("%15s%25s%10s%10s%15s%15s%50s%30s\n",getMaSV(),getName(), getTenNganh(),getLop(),getGioitinh(), getNgaysinh(),getQuequan(), getEmail()  );
    }

  
        
    }
    

