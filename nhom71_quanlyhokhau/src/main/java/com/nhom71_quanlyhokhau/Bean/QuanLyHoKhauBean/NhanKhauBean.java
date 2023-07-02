package com.nhom71_quanlyhokhau.Bean.QuanLyHoKhauBean;

import com.nhom71_quanlyhokhau.models.ChungMinhNhanDan;
import com.nhom71_quanlyhokhau.models.GiaDinh;
import com.nhom71_quanlyhokhau.models.NhanKhau;

import java.util.List;

public class NhanKhauBean {
    private NhanKhau nhanKhau;
    private ChungMinhNhanDan chungMinhNhanDan;
    private List<GiaDinh> danhSachThanhVienGiaDinh;

    public NhanKhauBean() {
    }

    public NhanKhauBean(NhanKhau nhanKhau, ChungMinhNhanDan chungMinhNhanDan, List<GiaDinh> danhSachThanhVienGiaDinh) {
        this.nhanKhau = nhanKhau;
        this.chungMinhNhanDan = chungMinhNhanDan;
        this.danhSachThanhVienGiaDinh = danhSachThanhVienGiaDinh;
    }

    public NhanKhau getNhanKhau() {
        return nhanKhau;
    }

    public void setNhanKhau(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
    }

    public ChungMinhNhanDan getChungMinhNhanDan() {
        return chungMinhNhanDan;
    }

    public void setChungMinhNhanDan(ChungMinhNhanDan chungMinhNhanDan) {
        this.chungMinhNhanDan = chungMinhNhanDan;
    }

    public List<GiaDinh> getDanhSachThanhVienGiaDinh() {
        return danhSachThanhVienGiaDinh;
    }

    public void setDanhSachThanhVienGiaDinh(List<GiaDinh> danhSachThanhVienGiaDinh) {
        this.danhSachThanhVienGiaDinh = danhSachThanhVienGiaDinh;
    }
}
