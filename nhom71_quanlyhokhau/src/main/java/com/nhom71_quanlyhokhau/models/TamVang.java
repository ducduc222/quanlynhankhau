package com.nhom71_quanlyhokhau.models;

public class TamVang {
    private int id;
    private int idNhanKhau;
    private String maGiayTamVang;
    private String soDienThoai;
    private String diaChiTamTru;
    private String tuNgay;
    private String denNgay;
    private String lyDo;
    public TamVang() {
    }
    
    public TamVang(int id, int idNhanKhau, String maGiayTamVang, String soDienThoai, String diaChiTamTru, String tuNgay,
            String denNgay, String lyDo) {
        this.id = id;
        this.idNhanKhau = idNhanKhau;
        this.maGiayTamVang = maGiayTamVang;
        this.soDienThoai = soDienThoai;
        this.diaChiTamTru = diaChiTamTru;
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
    public String getMaGiayTamVang() {
        return maGiayTamVang;
    }
    
    public void setMaGiayTamVang(String maGiayTamVang) {
        this.maGiayTamVang = maGiayTamVang;
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

    public String getDiaChiTamTru() {
        return diaChiTamTru;
    }

    public void setDiaChiTamTru(String diaChiTamTru) {
        this.diaChiTamTru = diaChiTamTru;
    }

    
}
