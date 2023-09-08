package com.actvn.java06.doannhom6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Khoa_CNTT {

    private List<SinhVienCNTT> listSVCNTT = new ArrayList<>();
    private List<MonHoc> listMonCT = new ArrayList<>();

    public Khoa_CNTT() {
    }

    public List<SinhVienCNTT> getListSVCNTT() {
        return listSVCNTT;
    }

    public void setListSVCNTT(List<SinhVienCNTT> listSVCNTT) {
        this.listSVCNTT = listSVCNTT;
    }

    public List<MonHoc> getListMonCT() {
        return listMonCT;
    }

    public void setListMonCT(List<MonHoc> listMonCT) {
        this.listMonCT = listMonCT;
    }

    
}
