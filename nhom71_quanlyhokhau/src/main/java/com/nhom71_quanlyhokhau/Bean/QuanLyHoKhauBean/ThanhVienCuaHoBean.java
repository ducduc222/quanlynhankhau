package com.nhom71_quanlyhokhau.Bean.QuanLyHoKhauBean;

import com.nhom71_quanlyhokhau.models.HoKhauNhanKhau;
import com.nhom71_quanlyhokhau.models.NhanKhau;

public class ThanhVienCuaHoBean {
    private NhanKhau nhanKhau;
    private HoKhauNhanKhau hoKhauNhanKhau;

    public ThanhVienCuaHoBean() {
    }

    public ThanhVienCuaHoBean(NhanKhau nhanKhau, HoKhauNhanKhau hoKhauNhanKhau) {
        this.nhanKhau = nhanKhau;
        this.hoKhauNhanKhau = hoKhauNhanKhau;
    }

    public NhanKhau getNhanKhau() {
        return nhanKhau;
    }

    public void setNhanKhau(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
    }

    public HoKhauNhanKhau getHoKhauNhanKhau() {
        return hoKhauNhanKhau;
    }

    public void setHoKhauNhanKhau(HoKhauNhanKhau hoKhauNhanKhau) {
        this.hoKhauNhanKhau = hoKhauNhanKhau;
    }
}
