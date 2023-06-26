package com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl.QuanLyHoKhauCtrl;

import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.NhanKhau;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckNhanKhauThuocHoKhau {
    public static boolean isDaCoHoKhau(NhanKhau nhanKhau) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        String sql = "SELECT * FROM hokhau_nhankhau WHERE idNhanKhau = "+nhanKhau.getId();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Nhân khẩu đã có hộ khẩu");
            return true;
        }
        preparedStatement.close();

        String sql2 = "SELECT * FROM hokhau WHERE idChuHo = "+ nhanKhau.getId();
        PreparedStatement prst = connection.prepareStatement(sql2);
        ResultSet rs2 = prst.executeQuery();
        if (rs2.next()) {
            JOptionPane.showMessageDialog(null, "Nhân khẩu đã có hộ khẩu");
            return true;
        }
        prst.close();

        connection.close();

        return false;
    }

}
