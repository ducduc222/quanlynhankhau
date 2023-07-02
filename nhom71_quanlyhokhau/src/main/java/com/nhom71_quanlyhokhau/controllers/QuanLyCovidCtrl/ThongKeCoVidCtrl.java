package com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl;

import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.NhanKhau;

import javax.swing.*;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeCoVidCtrl {
    public List<NhanKhau> getListNhanKhauCovid() throws SQLException, ClassNotFoundException {
        List<NhanKhau> nhanKhauList = new ArrayList<>();
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT DISTINCT nhankhau.* FROM nhankhau LEFT JOIN thongtinkhaibao ON thongtinkhaibao.idNhanKhau = nhankhau.id"
                    +" LEFT JOIN testcovid ON testcovid.idNhanKhau = nhankhau.id"
                    +" LEFT JOIN cachly ON cachly.idNhanKhau = nhankhau.id"
                    +" LEFT JOIN khaitu ON khaitu.idNhanKhau = nhankhau.id AND khaitu.isChetDoCovid = 1"
                    +" WHERE ( thongtinkhaibao.id > 0 OR  testcovid.id > 0 OR cachly.id > 0 OR khaitu.id > 0)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setId(resultSet.getInt("nhankhau.id"));
                nhanKhau.setHoTen(resultSet.getString("nhankhau.hoTen"));
                nhanKhau.setNgaySinh(resultSet.getString("nhankhau.ngaySinh"));
                nhanKhau.setGioiTinh(resultSet.getString("nhankhau.gioiTinh"));
                nhanKhau.setNoiSinh(resultSet.getString("nhankhau.noiSinh"));
                nhanKhau.setNguyenQuan(resultSet.getString("nhankhau.nguyenQuan"));
                nhanKhau.setDanToc(resultSet.getString("nhankhau.danToc"));
                nhanKhau.setTonGiao(resultSet.getString("nhankhau.tonGiao"));
                nhanKhau.setQuocTich(resultSet.getString("nhankhau.quocTich"));
                nhanKhau.setNoiThuongTru(resultSet.getString("nhankhau.noiThuongTru"));
                nhanKhau.setDiaChiHienTai(resultSet.getString("nhankhau.diaChiHienTai"));
                nhanKhau.setTrinhDoHocVan(resultSet.getString("nhankhau.trinhDoHocVan"));
                nhanKhau.setNgheNghiep(resultSet.getString("nhankhau.ngheNghiep"));
                nhanKhau.setNoiLamViec(resultSet.getString("nhankhau.noiLamViec"));
                nhanKhau.setIdNguoiTao(resultSet.getInt("nhankhau.idNguoiTao"));
                nhanKhau.setNgayTao(resultSet.getString("nhankhau.ngayTao"));

                nhanKhauList.add(nhanKhau);
            }
            preparedStatement.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return null;
        }
        connection.close();
        return nhanKhauList;
    }
    public List<NhanKhau> locCovid(String gioiTinh, String tuNgay, String denNgay, boolean F0, boolean F1, boolean Fn, boolean testcovid, boolean cachlytainha, boolean cachlytaitram, boolean chet) throws SQLException, ClassNotFoundException {
        List<NhanKhau> nhanKhauList = new ArrayList<>();
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT DISTINCT nhankhau.* FROM nhankhau LEFT JOIN thongtinkhaibao ON thongtinkhaibao.idNhanKhau = nhankhau.id"
                    +" LEFT JOIN testcovid ON testcovid.idNhanKhau = nhankhau.id"
                    +" LEFT JOIN cachly ON cachly.idNhanKhau = nhankhau.id"
                    +" LEFT JOIN khaitu ON khaitu.idNhanKhau = nhankhau.id AND khaitu.isChetDoCovid = 1"
                    +" WHERE ( thongtinkhaibao.id > 0 OR  testcovid.id > 0 OR cachly.id > 0 OR khaitu.id > 0) ";

            if (gioiTinh.equals("Tất cả")) sql += " AND (nhankhau.gioiTinh = 'Nam' OR nhankhau.gioiTinh = 'Nữ')";
            else sql += " AND nhankhau.gioitinh = '"+gioiTinh+"'";

            sql+= " AND  ( (thongtinkhaibao.ngayKhaiBao BETWEEN '"+tuNgay+"' AND '"+denNgay+"') "
                    +" OR (testcovid.ngayTest BETWEEN '"+tuNgay+"' AND '"+denNgay+"') "
                    +" OR (cachly.tuNgay BETWEEN '"+tuNgay+"' AND '"+denNgay+"') "
                    +" OR (cachly.denNgay BETWEEN '"+tuNgay+"' AND '"+denNgay+"') "
                    +" OR (khaitu.ngayMat BETWEEN '"+tuNgay+"' AND '"+denNgay+"') "
                    +" )";
            if (F0) sql+= " AND cachly.thuocDien = 'F0'";
            if (F1) sql+= " AND cachly.thuocDien = 'F1'";
            if (Fn) sql+= " AND cachly.thuocDien = 'Fn'";
            if (cachlytainha) sql+= " AND cachly.isCachLyTaiTramYTe = 0";
            if (cachlytaitram) sql+= " AND cachly.isCachLyTaiTramYTe = 1";
            if (testcovid) sql+= " AND testcovid.id > 0";
            if (chet) sql+= " AND khaitu.id > 0";



            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setId(resultSet.getInt("nhankhau.id"));
                nhanKhau.setHoTen(resultSet.getString("nhankhau.hoTen"));
                nhanKhau.setNgaySinh(resultSet.getString("nhankhau.ngaySinh"));
                nhanKhau.setGioiTinh(resultSet.getString("nhankhau.gioiTinh"));
                nhanKhau.setNoiSinh(resultSet.getString("nhankhau.noiSinh"));
                nhanKhau.setNguyenQuan(resultSet.getString("nhankhau.nguyenQuan"));
                nhanKhau.setDanToc(resultSet.getString("nhankhau.danToc"));
                nhanKhau.setTonGiao(resultSet.getString("nhankhau.tonGiao"));
                nhanKhau.setQuocTich(resultSet.getString("nhankhau.quocTich"));
                nhanKhau.setNoiThuongTru(resultSet.getString("nhankhau.noiThuongTru"));
                nhanKhau.setDiaChiHienTai(resultSet.getString("nhankhau.diaChiHienTai"));
                nhanKhau.setTrinhDoHocVan(resultSet.getString("nhankhau.trinhDoHocVan"));
                nhanKhau.setNgheNghiep(resultSet.getString("nhankhau.ngheNghiep"));
                nhanKhau.setNoiLamViec(resultSet.getString("nhankhau.noiLamViec"));
                nhanKhau.setIdNguoiTao(resultSet.getInt("nhankhau.idNguoiTao"));
                nhanKhau.setNgayTao(resultSet.getString("nhankhau.ngayTao"));

                nhanKhauList.add(nhanKhau);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return null;
        }
        return nhanKhauList;
    }
}
