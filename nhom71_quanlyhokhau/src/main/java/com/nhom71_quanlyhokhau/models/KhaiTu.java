package com.nhom71_quanlyhokhau.models;

public class KhaiTu {
    private int id;
    private int idNhanKhau;
    private int idNguoiKhai;
    private String ngayMat;
    private String lyDo;
    private boolean isChetDoCovid;

    public KhaiTu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public int getIdNguoiKhai() {
        return idNguoiKhai;
    }

    public void setIdNguoiKhai(int idNguoiKhai) {
        this.idNguoiKhai = idNguoiKhai;
    }

    public String getNgayMat() {
        return ngayMat;
    }

    public void setNgayMat(String ngayMat) {
        this.ngayMat = ngayMat;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public boolean isChetDoCovid() {
        return isChetDoCovid;
    }

    public void setChetDoCovid(boolean chetDoCovid) {
        isChetDoCovid = chetDoCovid;
    }
}
