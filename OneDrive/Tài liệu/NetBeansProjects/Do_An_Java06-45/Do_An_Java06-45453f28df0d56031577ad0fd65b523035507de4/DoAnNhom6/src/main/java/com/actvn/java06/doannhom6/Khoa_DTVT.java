package com.actvn.java06.doannhom6;

import java.util.ArrayList;
import java.util.List;


public class Khoa_DTVT {

    private List<SinhVienDTVT> listSVDTVT = new ArrayList<>();
    private List<MonHoc> listMonDT = new ArrayList<>();

    public Khoa_DTVT() {
    }

    public List<SinhVienDTVT> getListSVDTVT() {
        return listSVDTVT;
    }

    public void setListSVDTVT(List<SinhVienDTVT> listSVDTVT) {
        this.listSVDTVT = listSVDTVT;
    }

    public List<MonHoc> getListMonDT() {
        return listMonDT;
    }

    public void setListMonDT(List<MonHoc> listMonDT) {
        this.listMonDT = listMonDT;
    }
    
    

}
