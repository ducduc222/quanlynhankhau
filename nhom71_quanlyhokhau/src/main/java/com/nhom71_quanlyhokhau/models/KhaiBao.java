package com.nhom71_quanlyhokhau.models;

public class KhaiBao {
    private int id;
    private int idNhanKhau;
    private String soDienThoai;
    private String noiOHienTai;
    private String ngayKhaiBao;

    
    public KhaiBao() {
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
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getNoiOHienTai() {
        return noiOHienTai;
    }
    public void setNoiOHienTai(String noiOHienTai) {
        this.noiOHienTai = noiOHienTai;
    }
    public String getNgayKhaiBao() {
        return ngayKhaiBao;
    }
    public void setNgayKhaiBao(String ngayKhaiBao) {
        this.ngayKhaiBao = ngayKhaiBao;
    }

    
}
