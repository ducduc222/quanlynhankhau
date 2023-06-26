package com.nhom71_quanlyhokhau.models;

public class ChungMinhNhanDan {
    private int id;
    private int idNhanKhau;
    private String soCMND;

    public ChungMinhNhanDan() {
    }

    public ChungMinhNhanDan(int id, int idNhanKhau, String soCMND) {
        this.id = id;
        this.idNhanKhau = idNhanKhau;
        this.soCMND = soCMND;
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

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }
}
