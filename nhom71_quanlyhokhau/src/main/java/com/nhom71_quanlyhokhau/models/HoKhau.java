package com.nhom71_quanlyhokhau.models;

public class HoKhau {
    private int id;
    private int idChuHo;
    private String maHoKhau;
    private String maKhuVuc;
    private String diaChi;
    private int idNguoiTao;
    private String ngayTao;
    public HoKhau() {
    }
    public HoKhau(int id, int idChuHo, String maHoKhau, String maKhuVuc, String diaChi, int idNguoiTao,
            String ngayTao) {
        this.id = id;
        this.idChuHo = idChuHo;
        this.maHoKhau = maHoKhau;
        this.maKhuVuc = maKhuVuc;
        this.diaChi = diaChi;
        this.idNguoiTao = idNguoiTao;
        this.ngayTao = ngayTao;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdChuHo() {
        return idChuHo;
    }
    public void setIdChuHo(int idChuHo) {
        this.idChuHo = idChuHo;
    }
    public String getMaHoKhau() {
        return maHoKhau;
    }
    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }
    public String getMaKhuVuc() {
        return maKhuVuc;
    }
    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public int getIdNguoiTao() {
        return idNguoiTao;
    }
    public void setIdNguoiTao(int idNguoiTao) {
        this.idNguoiTao = idNguoiTao;
    }
    public String getNgayTao() {
        return ngayTao;
    }
    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    
}
