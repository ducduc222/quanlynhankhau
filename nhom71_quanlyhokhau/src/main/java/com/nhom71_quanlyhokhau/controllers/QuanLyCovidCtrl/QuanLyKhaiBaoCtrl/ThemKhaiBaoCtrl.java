package com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl.QuanLyKhaiBaoCtrl;

import com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean.KhaiBaoBean;
import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.Util.DateForm;
import com.nhom71_quanlyhokhau.models.KhaiBao;
import com.nhom71_quanlyhokhau.models.LichTrinh;
import com.nhom71_quanlyhokhau.models.NhanKhau;
import com.nhom71_quanlyhokhau.models.TrieuChung;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class ThemKhaiBaoCtrl {
    public boolean addNewKhaiBao(KhaiBaoBean khaiBaoBean) throws SQLException, ClassNotFoundException {
        KhaiBao khaiBao = khaiBaoBean.getKhaiBao();
        TrieuChung trieuChung = khaiBaoBean.getTrieuChung();
        List<LichTrinh> lichTrinhList = khaiBaoBean.getLichTrinhList();
        NhanKhau nhanKhau = khaiBaoBean.getNhanKhau();

        Connection connection = MysqlConnection.getMysqlConnection();
        connection.setAutoCommit(false);
        try {
            //insert thongtinkhaibao
            String sql = "INSERT INTO thongtinkhaibao(idNhanKhau, soDienThoai, noiOHienTai, ngayKhaiBao) "
                    + " values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1,khaiBao.getIdNhanKhau());
            preparedStatement.setString(2, khaiBao.getSoDienThoai());
            preparedStatement.setString(3, khaiBao.getNoiOHienTai());
            JCalendar jCalendar = new JCalendar();
            preparedStatement.setString(4, DateForm.returnDateString(jCalendar.getDate()));

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int idToKhai = resultSet.getInt(1);

                //insert trieuchung
                String sqlTrieuChung = "INSERT INTO trieuchung(idToKhai, bieuHien) "
                        + " values (?,?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(sqlTrieuChung);
                preparedStatement1.setInt(1, idToKhai);
                preparedStatement1.setString(2, trieuChung.getBieuHien());
                preparedStatement1.execute();
                preparedStatement1.close();

                //insert lichtrinh
                for (int i = 0; i<lichTrinhList.size(); i++) {
                    String sqlLichTrinh = "INSERT INTO lichtrinh(idToKhai, ngay, noidung) "
                            + " values (?, ?, ?)";

                    PreparedStatement preparedStatement2 = connection.prepareStatement(sqlLichTrinh);
                    preparedStatement2.setInt(1, idToKhai);
                    preparedStatement2.setString(2, lichTrinhList.get(i).getNgay());
                    preparedStatement2.setString(3, lichTrinhList.get(i).getNoiDung());
                    preparedStatement2.execute();
                    preparedStatement2.close();
                }

            }
            preparedStatement.close();

        } catch (SQLException e) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return false;
        }

        connection.commit();
        connection.close();
        return true;
    }
}
