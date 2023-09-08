package com.actvn.java06.doannhom6;



import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class SinhVien {
    private String MaSV;
    private String Name;
    private String gioiTinh;
    private String queQuan;
    private LocalDate ngaySinh;
    private String email;
    private double GPA;
   


    public SinhVien(String MaSV, String Name, String gioiTinh, String queQuan, LocalDate ngaySinh, String email) {
        this.MaSV = MaSV;
        this.Name = Name;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGioitinh() {
        return gioiTinh;
    }

    public void setGioitinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuequan() {
        return queQuan;
    }

    public void setQuequan(String queQuan) {
        this.queQuan = queQuan;
    }

    public LocalDate getNgaysinh() {
        return ngaySinh;
    }

    public void setNgaysinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SinhVien{");
        sb.append("MaSV=").append(MaSV);
        sb.append(", Name=").append(Name);
        sb.append(", Gioitinh=").append(gioiTinh);
        sb.append(", quequan=").append(queQuan);
        sb.append(", Ngaysinh=").append(ngaySinh);
        sb.append(", email=").append(email);
        sb.append(", GPA=").append(GPA);
        sb.append('}');
        return sb.toString();
    }
    
    
}
