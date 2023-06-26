package com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl.QuanLyHoKhauCtrl;

import com.nhom71_quanlyhokhau.Bean.QuanLyHoKhauBean.HoKhauBean;
import com.nhom71_quanlyhokhau.Bean.QuanLyHoKhauBean.ThanhVienCuaHoBean;
import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.Session;
import com.nhom71_quanlyhokhau.Util.DateForm;
import com.nhom71_quanlyhokhau.models.HoKhau;
import com.nhom71_quanlyhokhau.models.NhanKhau;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class TachHoKhauCtrl {
    public boolean tachHoKhau(HoKhauBean hoKhauBean, boolean isHoMoi) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        connection.setAutoCommit(false);

        try {
            if (isHoMoi) {
                HoKhau hoKhau = hoKhauBean.getHoKhau();
                NhanKhau chuHo = hoKhauBean.getChuHo();
                List<ThanhVienCuaHoBean> thanhVienCuaHo = hoKhauBean.getThanhVienCuaHo();

                // xóa chủ hộ mới khỏi danh sách thành viên hộ:
                String sqltt = "DELETE FROM hokhau_nhankhau WHERE idNhanKhau = " + chuHo.getId();
                PreparedStatement prstt = connection.prepareStatement(sqltt);
                prstt.execute();
                prstt.close();

                // thêm hộ khẩu:
                String query = "INSERT INTO hokhau (idChuHo,maHoKhau, maKhuVuc, diaChi, idNguoiTao, ngayTao)"
                        + " values (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setInt(1, hoKhau.getIdChuHo());
                preparedStatement.setString(2, hoKhau.getMaHoKhau());
                preparedStatement.setString(3, hoKhau.getMaKhuVuc());
                preparedStatement.setString(4, hoKhau.getDiaChi());
                preparedStatement.setInt(5, Session.getIdAdmin());
                JCalendar jCalendar = new JCalendar();
                preparedStatement.setString(6, DateForm.returnDateString(jCalendar.getDate()));

                preparedStatement.execute();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int IdHoKhau = resultSet.getInt(1);
                    // insert thành viên cua hộ
                    thanhVienCuaHo.forEach(thanhvien -> {
                        // xóa thành viên cũ:
                        try {
                            String sqlDL = "DELETE FROM hokhau_nhankhau WHERE idNhanKhau = " + thanhvien.getNhanKhau().getId();
                            PreparedStatement preparedStatement1 = connection.prepareStatement(sqlDL);
                            preparedStatement1.execute();
                            preparedStatement1.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
                        }
                        String sql2 = "INSERT INTO hokhau_nhankhau(idNhanKhau, idHoKhau, quanHeVoiChuHo)"
                                + " values (?, ?, ?)";
                        try {
                            PreparedStatement prst2 = connection.prepareStatement(sql2);
                            prst2.setInt(1, thanhvien.getNhanKhau().getId());
                            prst2.setInt(2, IdHoKhau);
                            prst2.setString(3, thanhvien.getHoKhauNhanKhau().getQuanHeVoiChuHo());

                            prst2.execute();
                            prst2.close();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
                preparedStatement.close();
            } else {
                for (int i = 0; i<hoKhauBean.getThanhVienCuaHo().size(); i++) {
                    // xóa thành viên cũ:
                    String sqlDL = "DELETE FROM hokhau_nhankhau WHERE idNhanKhau = "+hoKhauBean.getThanhVienCuaHo().get(i).getNhanKhau().getId();
                    PreparedStatement prDl = connection.prepareStatement(sqlDL);
                    prDl.execute();
                    prDl.close();

                    String sqlInsert = "INSERT INTO hokhau_nhankhau(idNhanKhau, idHoKhau, quanHeVoiChuHo)"
                            + " values (?, ?, ?)";

                    PreparedStatement prstInsert = connection.prepareStatement(sqlInsert);

                    int IdHoKhau = hoKhauBean.getHoKhau().getId();
                    prstInsert.setInt(1, hoKhauBean.getThanhVienCuaHo().get(i).getNhanKhau().getId());
                    prstInsert.setInt(2, IdHoKhau);
                    prstInsert.setString(3, hoKhauBean.getThanhVienCuaHo().get(i).getHoKhauNhanKhau().getQuanHeVoiChuHo());

                    prstInsert.execute();
                    prstInsert.close();



                }

            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
        }

        connection.close();
        return true;
    }
}
