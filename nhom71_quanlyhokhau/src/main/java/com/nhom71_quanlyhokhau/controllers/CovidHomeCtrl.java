package com.nhom71_quanlyhokhau.controllers;

import com.nhom71_quanlyhokhau.MysqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CovidHomeCtrl {
    public int getSoDaKhaiBao() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT COUNT(DISTINCT idNhanKhau) FROM thongtinkhaibao";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return -1;
        }
        return -1;
    }

    public int getTongNhanKhau() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT COUNT(*) FROM nhankhau";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return -1;
        }
        return -1;
    }

    public int getSoCachLyTaiNha() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT COUNT(*) FROM cachly WHERE isCachLyTaiTramYTe = FALSE";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return -1;
        }
        return -1;
    }

    public int getSoCachLyTaiTramYTe() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT COUNT(*) FROM cachly WHERE isCachLyTaiTramYTe = TRUE";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return -1;
        }
        return -1;
    }

    public int getSoF0() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT COUNT(*) FROM cachly WHERE thuocDien = 'F0'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return -1;
        }
        return -1;
    }

    public int getSoF1() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT COUNT(*) FROM cachly WHERE thuocDien = 'F1'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return -1;
        }
        return -1;
    }

    public int getSoFn() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT COUNT(*) FROM cachly WHERE thuocDien = 'Fn'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return -1;
        }
        return -1;
    }


}
