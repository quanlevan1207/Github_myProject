package com.actvn.java06.doannhom6;




public class MonHoc {

    private String TenMon;
    private int SoTinChi;
    private double Diem;

    public MonHoc(String TenMon, int SoTinChi) {
        this.TenMon = TenMon;
        this.SoTinChi = SoTinChi;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public int getSoTinChi() {
        return SoTinChi;
    }

    public void setSoTinChi(int SoTinChi) {
        this.SoTinChi = SoTinChi;
    }

    public double getDiem() {
        return Diem;
    }

    public void setDiem(double Diem) {
        this.Diem = Diem;
    }
}