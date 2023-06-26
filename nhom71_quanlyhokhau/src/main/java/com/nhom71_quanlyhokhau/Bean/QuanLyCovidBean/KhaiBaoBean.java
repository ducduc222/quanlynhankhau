package com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean;

import com.nhom71_quanlyhokhau.models.KhaiBao;
import com.nhom71_quanlyhokhau.models.LichTrinh;
import com.nhom71_quanlyhokhau.models.NhanKhau;
import com.nhom71_quanlyhokhau.models.TrieuChung;

import java.util.List;

public class KhaiBaoBean {
    private KhaiBao khaiBao;
    private TrieuChung trieuChung;
    private List<LichTrinh> lichTrinhList;
    private NhanKhau nhanKhau;


    public KhaiBaoBean() {
    }

    public NhanKhau getNhanKhau() {
        return nhanKhau;
    }

    public void setNhanKhau(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
    }

    public KhaiBao getKhaiBao() {
        return khaiBao;
    }

    public void setKhaiBao(KhaiBao khaiBao) {
        this.khaiBao = khaiBao;
    }

    public TrieuChung getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(TrieuChung trieuChung) {
        this.trieuChung = trieuChung;
    }

    public List<LichTrinh> getLichTrinhList() {
        return lichTrinhList;
    }

    public void setLichTrinhList(List<LichTrinh> lichTrinhList) {
        this.lichTrinhList = lichTrinhList;
    }
}
