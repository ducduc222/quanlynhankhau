package com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl.QuanLyNhanKhauCtrl;

import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.TamTru;
import com.nhom71_quanlyhokhau.models.TamVang;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TamTruCtrl {
    public boolean dangKyTamTru(TamTru tamTru) throws SQLException, ClassNotFoundException {
        if (    tamTru.getIdNhanKhau() == 0
                ||  tamTru.getMaGiayTamTru().isEmpty()
                ||  tamTru.getSoDienThoai().isEmpty()
                ||  tamTru.getTuNgay().isEmpty()
                ||  tamTru.getDenNgay().isEmpty()
                ||  tamTru.getLyDo().isEmpty()
        ) {
            JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
            return false;
        }
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "INSERT INTO tamtru (idNhanKhau, maGiayTamTru, soDienThoai, tuNgay, denNgay, lyDo) "
                    + " value (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tamTru.getIdNhanKhau());
            preparedStatement.setString(2, tamTru.getMaGiayTamTru());
            preparedStatement.setString(3, tamTru.getSoDienThoai());
            preparedStatement.setString(4, tamTru.getTuNgay());
            preparedStatement.setString(5, tamTru.getDenNgay());
            preparedStatement.setString(6, tamTru.getLyDo());
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
