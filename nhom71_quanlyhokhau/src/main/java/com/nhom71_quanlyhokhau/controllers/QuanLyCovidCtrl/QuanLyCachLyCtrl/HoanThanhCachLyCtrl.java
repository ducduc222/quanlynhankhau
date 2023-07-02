package com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl.QuanLyCachLyCtrl;

import com.nhom71_quanlyhokhau.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HoanThanhCachLyCtrl {
    public boolean hoanThanhCachLy(int idCachLy) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "DELETE FROM cachly WHERE id = "+idCachLy;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return false;
        }
        connection.close();
        return true;
    }
}
