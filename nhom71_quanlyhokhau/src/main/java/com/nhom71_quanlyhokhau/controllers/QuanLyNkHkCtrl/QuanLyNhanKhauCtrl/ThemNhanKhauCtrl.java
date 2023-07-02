package com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl.QuanLyNhanKhauCtrl;

import com.nhom71_quanlyhokhau.Bean.QuanLyHoKhauBean.NhanKhauBean;
import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.Session;
import com.nhom71_quanlyhokhau.Util.DateForm;
import com.nhom71_quanlyhokhau.models.ChungMinhNhanDan;
import com.nhom71_quanlyhokhau.models.GiaDinh;
import com.nhom71_quanlyhokhau.models.NhanKhau;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class ThemNhanKhauCtrl {
    public boolean addNewNhanKhau(NhanKhauBean nhanKhauBean, boolean isMoiSinh) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.setAutoCommit(false);

        try {


            NhanKhau nhanKhau = nhanKhauBean.getNhanKhau();
            ChungMinhNhanDan chungMinhNhanDan = nhanKhauBean.getChungMinhNhanDan();
            List<GiaDinh> giaDinhList = nhanKhauBean.getDanhSachThanhVienGiaDinh();

            // thêm nhân khẩu:
            String query = "INSERT INTO nhankhau (hoTen, ngaySinh, gioiTinh, noiSinh, nguyenQuan, danToc, tonGiao, quocTich, noiThuongTru, diaChiHienTai, trinhDoHocVan, ngheNghiep, noiLamViec, idNguoiTao, ngayTao)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, nhanKhau.getHoTen());
            preparedStatement.setString(2, nhanKhau.getNgaySinh());
            preparedStatement.setString(3, nhanKhau.getGioiTinh());
            preparedStatement.setString(4, nhanKhau.getNoiSinh());
            preparedStatement.setString(5, nhanKhau.getNguyenQuan());
            preparedStatement.setString(6, nhanKhau.getDanToc());
            preparedStatement.setString(7, nhanKhau.getTonGiao());
            preparedStatement.setString(8, nhanKhau.getQuocTich());
            preparedStatement.setString(9, nhanKhau.getNoiThuongTru());
            preparedStatement.setString(10, nhanKhau.getDiaChiHienTai());
            preparedStatement.setString(11, nhanKhau.getTrinhDoHocVan());
            preparedStatement.setString(12, nhanKhau.getNgheNghiep());
            preparedStatement.setString(13, nhanKhau.getNoiLamViec());
            preparedStatement.setInt(14, Session.getIdAdmin());
            JCalendar jCalendar = new JCalendar();
            preparedStatement.setString(15, DateForm.returnDateString(jCalendar.getDate()));

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int IdNhanKhau = resultSet.getInt(1);

                // insert cccd / nếu không phải mới sinh
                if (!isMoiSinh) {
                    String sql = "INSERT INTO chungminhnhandan(idNhanKhau, soCMND)"
                            + " values (?, ?)";
                    PreparedStatement prst = connection.prepareStatement(sql);
                    prst.setInt(1, IdNhanKhau);
                    prst.setString(2, chungMinhNhanDan.getSoCMND());
                    prst.execute();
                }

                // insert gia đình
                giaDinhList.forEach(giaDinh -> {
                    String sql2 = "INSERT INTO giadinh(idNhanKhau, hoTen, ngaySinh, gioiTinh, quanHeVoiNhanKhau)"
                            + " values (?, ?, ?, ?, ?)";
                    try {
                        PreparedStatement prst2 = connection.prepareStatement(sql2);
                        prst2.setInt(1, IdNhanKhau);
                        prst2.setString(2, giaDinh.getHoTen());
                        prst2.setString(3, giaDinh.getNgaySinh());
                        prst2.setString(4, giaDinh.getGioiTinh());
                        prst2.setString(5, giaDinh.getQuanHeVoiNhanKhau());

                        prst2.execute();
                        prst2.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Lỗi xảy ra: " + e.getMessage());
        }
        connection.close();
        return true;
    }
}
