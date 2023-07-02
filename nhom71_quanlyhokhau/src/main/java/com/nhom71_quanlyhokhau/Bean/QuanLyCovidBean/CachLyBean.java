package com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean;

import com.nhom71_quanlyhokhau.models.CachLy;
import com.nhom71_quanlyhokhau.models.NhanKhau;

public class CachLyBean {
    private NhanKhau nhanKhau;
    private CachLy cachLy;

    public CachLyBean() {
    }

    public NhanKhau getNhanKhau() {
        return nhanKhau;
    }

    public void setNhanKhau(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
    }

    public CachLy getCachLy() {
        return cachLy;
    }

    public void setCachLy(CachLy cachLy) {
        this.cachLy = cachLy;
    }
}
