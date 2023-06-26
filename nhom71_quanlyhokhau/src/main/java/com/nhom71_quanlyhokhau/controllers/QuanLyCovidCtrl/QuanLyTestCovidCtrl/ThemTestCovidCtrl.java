package com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl.QuanLyTestCovidCtrl;

import com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean.TestCovidBean;
import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.NhanKhau;
import com.nhom71_quanlyhokhau.models.TestCovid;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThemTestCovidCtrl {
    public boolean addNewTestCovid(TestCovidBean testCovidBean) throws SQLException, ClassNotFoundException {
        NhanKhau nhanKhau = testCovidBean.getNhanKhau();
        TestCovid testCovid = testCovidBean.getTestCovid();

        Connection connection = MysqlConnection.getMysqlConnection();
        connection.setAutoCommit(false);

        try {
            String sql = "INSERT INTO testcovid(idNhanKhau, soDienThoai, ngayTest, ketQuaTest, noiOHienTai) "
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, testCovid.getIdNhanKhau());
            preparedStatement.setString(2, testCovid.getSoDienThoai());
            preparedStatement.setString(3, testCovid.getNgayTest());
            preparedStatement.setString(4, testCovid.getKetQuaTest());
            preparedStatement.setString(5, testCovid.getNoiOHienTai());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return false;
        }
        connection.commit();
        connection.close();
        return true;
    }
}
