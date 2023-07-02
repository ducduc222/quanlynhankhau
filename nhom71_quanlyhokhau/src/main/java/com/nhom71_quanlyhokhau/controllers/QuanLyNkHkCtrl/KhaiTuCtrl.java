package com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl;

import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.KhaiTu;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KhaiTuCtrl {
    public boolean khaiTu(KhaiTu khaiTu) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "INSERT INTO khaitu (idNhanKhau, idNguoiKhai, lyDo, ngayMat, isChetDoCovid) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, khaiTu.getIdNhanKhau());
            preparedStatement.setInt(2, khaiTu.getIdNguoiKhai());
            preparedStatement.setString(3, khaiTu.getLyDo());
            preparedStatement.setString(4, khaiTu.getNgayMat());
            preparedStatement.setBoolean(5, khaiTu.isChetDoCovid());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return false;
        }
        connection.close();
        return true;
    }
}
