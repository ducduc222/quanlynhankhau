package com.nhom71_quanlyhokhau.models;

public class TamTru {
    private int id;
    private int idNhanKhau;
    private String maGiayTamTru;
    private String soDienThoai;
    private String tuNgay;
    private String denNgay;
    private String lyDo;
    public TamTru() {
    }
    public TamTru(int id, int idNhanKhau, String maGiayTamTru, String soDienThoai, String tuNgay, String denNgay,
            String lyDo) {
        this.id = id;
        this.idNhanKhau = idNhanKhau;
        this.maGiayTamTru = maGiayTamTru;
        this.soDienThoai = soDienThoai;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lyDo = lyDo;
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
    public String getMaGiayTamTru() {
        return maGiayTamTru;
    }
    public void setMaGiayTamTru(String maGiayTamTru) {
        this.maGiayTamTru = maGiayTamTru;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
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
    public String getLyDo() {
        return lyDo;
    }
    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    
}
