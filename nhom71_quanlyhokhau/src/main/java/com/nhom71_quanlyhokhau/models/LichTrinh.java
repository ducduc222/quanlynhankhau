package com.nhom71_quanlyhokhau.models;

public class LichTrinh {
    private int id;
    private int idToKhai;
    private String ngay;
    private String noiDung;
    
    public LichTrinh() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdToKhai() {
        return idToKhai;
    }
    public void setIdToKhai(int idToKhai) {
        this.idToKhai = idToKhai;
    }
    public String getNgay() {
        return ngay;
    }
    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
    public String getNoiDung() {
        return noiDung;
    }
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    
}
