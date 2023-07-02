package com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl.QuanLyNhanKhauCtrl;

import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.NhanKhau;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckCccdCtrl {
    public static int returnNhanKhau(String cccd) throws SQLException, ClassNotFoundException {
        if (cccd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hãy nhập cccd");
            return 0;
        }

        String sql = "SELECT * FROM chungminhnhandan WHERE soCMND = '"+cccd+"'";
        Connection connection = MysqlConnection.getMysqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int id = 0;
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getInt("idNhanKhau"));
                id = resultSet.getInt("idNhanKhau");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy cccd");
                id = 0;
            }
        } catch (Exception e) {

        }
        preparedStatement.close();
        connection.close();
        return id;
    }
}