package com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl.QuanLyNhanKhauCtrl;

import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.TamVang;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TamVangCtrl {
    public boolean dangKyTamVang(TamVang tamVang) throws SQLException, ClassNotFoundException {
        if (    tamVang.getIdNhanKhau() == 0
            ||  tamVang.getMaGiayTamVang().isEmpty()
            ||  tamVang.getSoDienThoai().isEmpty()
            ||  tamVang.getDiaChiTamTru().isEmpty()
            ||  tamVang.getTuNgay().isEmpty()
            ||  tamVang.getDenNgay().isEmpty()
            ||  tamVang.getLyDo().isEmpty()
        ) {
            JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
            return false;
        }
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "INSERT INTO tamvang (idNhanKhau, maGiayTamVang, soDienThoai, diaChiTamTru, tuNgay, denNgay, lyDo) "
                    + " value (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tamVang.getIdNhanKhau());
            preparedStatement.setString(2, tamVang.getMaGiayTamVang());
            preparedStatement.setString(3, tamVang.getSoDienThoai());
            preparedStatement.setString(4, tamVang.getDiaChiTamTru());
            preparedStatement.setString(5, tamVang.getTuNgay());
            preparedStatement.setString(6, tamVang.getDenNgay());
            preparedStatement.setString(7, tamVang.getLyDo());
            preparedStatement.execute();
            preparedStatement.close();

            JOptionPane.showMessageDialog(null, "Lưu thành công");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
        }
        connection.close();
        return true;
    }
}
