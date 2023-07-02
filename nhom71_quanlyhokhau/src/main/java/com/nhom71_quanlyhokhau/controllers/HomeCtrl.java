package com.nhom71_quanlyhokhau.controllers;

import com.nhom71_quanlyhokhau.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeCtrl {
    private int soNhanKhau;
    private int soHoKhau;
    private int soTamTru;
    private int soTamVang;

    public HomeCtrl() throws SQLException, ClassNotFoundException {
        this.getNum();
    }

    public void getNum() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String sql1 = "SELECT COUNT(*) FROM hokhau";
        PreparedStatement prst1 = connection.prepareStatement(sql1);
        ResultSet rs1 = prst1.executeQuery();
        if (rs1.next()) soHoKhau = rs1.getInt(1);
        prst1.close();

        String sql2 = "SELECT COUNT(*) FROM nhankhau";
        PreparedStatement prst2 = connection.prepareStatement(sql2);
        ResultSet rs2 = prst2.executeQuery();
        if (rs2.next()) soNhanKhau = rs2.getInt(1);
        prst2.close();

        String sql3 = "SELECT COUNT(*) FROM tamtru";
        PreparedStatement prst3 = connection.prepareStatement(sql3);
        ResultSet rs3 = prst3.executeQuery();
        if (rs3.next()) soTamTru = rs3.getInt(1);
        prst3.close();

        String sql4 = "SELECT COUNT(*) FROM tamvang";
        PreparedStatement prst4 = connection.prepareStatement(sql4);
        ResultSet rs4 = prst4.executeQuery();
        if (rs4.next()) soTamVang = rs4.getInt(1);
        prst4.close();

    }

    public int getSoNhanKhau() {
        return soNhanKhau;
    }

    public void setSoNhanKhau(int soNhanKhau) {
        this.soNhanKhau = soNhanKhau;
    }

    public int getSoHoKhau() {
        return soHoKhau;
    }

    public void setSoHoKhau(int soHoKhau) {
        this.soHoKhau = soHoKhau;
    }

    public int getSoTamTru() {
        return soTamTru;
    }

    public void setSoTamTru(int soTamTru) {
        this.soTamTru = soTamTru;
    }

    public int getSoTamVang() {
        return soTamVang;
    }

    public void setSoTamVang(int soTamVang) {
        this.soTamVang = soTamVang;
    }
}
