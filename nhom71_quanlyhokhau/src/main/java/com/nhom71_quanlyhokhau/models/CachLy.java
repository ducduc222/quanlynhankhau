package com.nhom71_quanlyhokhau.models;

public class CachLy {
    private int id;
    private int idNhanKhau;
    private boolean isCachLyTaiTramYTe;
    private String diaDiemCachLy;
    private String tuNgay;
    private String denNgay;
    private String thuocDien;
    private String soDienThoai;
    
    public CachLy() {
    }
    
    public CachLy(int id, int idNhanKhau, boolean isCachLyTaiTramYTe, String diaDiemCachLy, String tuNgay,
            String denNgay, String thuocDien) {
        this.id = id;
        this.idNhanKhau = idNhanKhau;
        this.isCachLyTaiTramYTe = isCachLyTaiTramYTe;
        this.diaDiemCachLy = diaDiemCachLy;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.thuocDien = thuocDien;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
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
    public boolean isCachLyTaiTramYTe() {
        return isCachLyTaiTramYTe;
    }
    public void setCachLyTaiTramYTe(boolean isCachLyTaiTramYTe) {
        this.isCachLyTaiTramYTe = isCachLyTaiTramYTe;
    }
    public String getDiaDiemCachLy() {
        return diaDiemCachLy;
    }
    public void setDiaDiemCachLy(String diaDiemCachLy) {
        this.diaDiemCachLy = diaDiemCachLy;
    }
    public String getTuNgay() {
        return tuNgay;
    }
    public void setTuNgay(String tuNgay) {
        this.tuNgay = tuNgay;
    }
    public String getDenNgay() {
        return denNgay;
    }
    public void setDenNgay(String denNgay) {
        this.denNgay = denNgay;
    }
    public String getThuocDien() {
        return thuocDien;
    }
    public void setThuocDien(String thuocDien) {
        this.thuocDien = thuocDien;
    }

    
}
