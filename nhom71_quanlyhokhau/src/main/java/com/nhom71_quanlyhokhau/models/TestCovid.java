package com.nhom71_quanlyhokhau.models;

public class TestCovid {
    private int id;
    private int idNhanKhau;
    private String soDienThoai;
    private String ngayTest;
    private String ketQuaTest;
    private String noiOHienTai;
    public TestCovid() {
    }

    public String getNoiOHienTai() {
        return noiOHienTai;
    }

    public void setNoiOHienTai(String noiOHienTai) {
        this.noiOHienTai = noiOHienTai;
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
    public String getNgayTest() {
        return ngayTest;
    }
    public void setNgayTest(String ngayTest) {
        this.ngayTest = ngayTest;
    }
    public String getKetQuaTest() {
        return ketQuaTest;
    }
    public void setKetQuaTest(String ketQuaTest) {
        this.ketQuaTest = ketQuaTest;
    }

    
}
