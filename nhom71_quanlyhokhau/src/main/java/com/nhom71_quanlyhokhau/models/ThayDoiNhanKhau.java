package com.nhom71_quanlyhokhau.models;

public class ThayDoiNhanKhau {
    private int  id;
    private String noiDungThayDoi;
    
    public ThayDoiNhanKhau() {
    }

    
    public ThayDoiNhanKhau(int id, String noiDungThayDoi) {
        this.id = id;
        this.noiDungThayDoi = noiDungThayDoi;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNoiDungThayDoi() {
        return noiDungThayDoi;
    }
    public void setNoiDungThayDoi(String noiDungThayDoi) {
        this.noiDungThayDoi = noiDungThayDoi;
    }
}
