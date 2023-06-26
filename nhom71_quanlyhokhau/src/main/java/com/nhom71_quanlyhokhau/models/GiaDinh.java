package com.nhom71_quanlyhokhau.models;

public class GiaDinh {
    private int id;
    private int idNhanKhau;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String quanHeVoiNhanKhau;

    public GiaDinh() {
    }

    public GiaDinh(int id, int idNhanKhau, String hoTen, String ngaySinh, String gioiTinh, String quanHeVoiNhanKhau) {
        this.id = id;
        this.idNhanKhau = idNhanKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.quanHeVoiNhanKhau = quanHeVoiNhanKhau;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuanHeVoiNhanKhau() {
        return quanHeVoiNhanKhau;
    }

    public void setQuanHeVoiNhanKhau(String quanHeVoiNhanKhau) {
        this.quanHeVoiNhanKhau = quanHeVoiNhanKhau;
    }
}
