package com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl.QuanLyCachLyCtrl;

import com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean.CachLyBean;
import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.CachLy;
import com.nhom71_quanlyhokhau.models.NhanKhau;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThemCachLyCtrl {
    public boolean addNewCachLy(CachLyBean cachLyBean) throws SQLException, ClassNotFoundException {
        CachLy cachLy = cachLyBean.getCachLy();
        NhanKhau nhanKhau = cachLyBean.getNhanKhau();

        Connection connection = MysqlConnection.getMysqlConnection();
        connection.setAutoCommit(false);

        try {
            //insert cachly
            String sql = "INSERT INTO cachly(idNhanKhau, isCachLyTaiTramYTe, diaDiemCachLy, tuNgay, denNgay, thuocDien, soDienThoai) "
                    + " values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cachLy.getIdNhanKhau());
            preparedStatement.setBoolean(2, cachLy.isCachLyTaiTramYTe());
            preparedStatement.setString(3, cachLy.getDiaDiemCachLy());
            preparedStatement.setString(4, cachLy.getTuNgay());
            preparedStatement.setString(5, cachLy.getDenNgay());
            preparedStatement.setString(6, cachLy.getThuocDien());
            preparedStatement.setString(7, cachLy.getSoDienThoai());
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
