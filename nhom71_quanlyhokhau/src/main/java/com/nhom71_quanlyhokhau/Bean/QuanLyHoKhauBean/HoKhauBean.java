package com.nhom71_quanlyhokhau.Bean.QuanLyHoKhauBean;

import com.nhom71_quanlyhokhau.models.HoKhau;
import com.nhom71_quanlyhokhau.models.NhanKhau;

import java.util.List;

public class HoKhauBean {
    private HoKhau hoKhau;
    private NhanKhau chuHo;
    private List<ThanhVienCuaHoBean> thanhVienCuaHo;

    public HoKhauBean() {
    }

    public HoKhau getHoKhau() {
        return hoKhau;
    }

    public void setHoKhau(HoKhau hoKhau) {
        this.hoKhau = hoKhau;
    }

    public NhanKhau getChuHo() {
        return chuHo;
    }

    public void setChuHo(NhanKhau chuHo) {
        this.chuHo = chuHo;
    }

    public List<ThanhVienCuaHoBean> getThanhVienCuaHo() {
        return thanhVienCuaHo;
    }

    public void setThanhVienCuaHo(List<ThanhVienCuaHoBean> thanhVienCuaHo) {
        this.thanhVienCuaHo = thanhVienCuaHo;
    }

}
