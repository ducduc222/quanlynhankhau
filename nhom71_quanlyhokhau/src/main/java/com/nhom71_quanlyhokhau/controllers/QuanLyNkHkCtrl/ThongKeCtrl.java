package com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl;

import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.NhanKhau;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeCtrl {
    public List<NhanKhau> locNhanKhau(String gioiTinh, String loai, int doTuoiTu, int doTuoiDen) throws SQLException, ClassNotFoundException {
        List<NhanKhau> nhanKhauList = new ArrayList<>();
        Connection connection  = MysqlConnection.getMysqlConnection();
        try {
            String sqlGioiTinh = "";
            if (gioiTinh.equals("Tất cả")) sqlGioiTinh = "(nhankhau.gioiTinh = 'Nam' OR nhankhau.gioiTinh = 'Nữ')";
            else sqlGioiTinh = "gioitinh = '"+gioiTinh+"'";

            String sqlDoTuoi = "";
            if (doTuoiDen > 0 && doTuoiTu < doTuoiDen) {
                sqlDoTuoi = "nhankhau.ngaySinh >= DATE_SUB(CURDATE(), INTERVAL "+doTuoiDen+" YEAR)\n" +
                        "  AND nhankhau.ngaySinh <= DATE_SUB(CURDATE(), INTERVAL "+doTuoiTu+" YEAR) ";
            }

            String sqlLoai = "";
            if (loai.equals("Tất cả")) sqlLoai = "";
            if (loai.equals("Tạm trú")) sqlLoai = "tamtru.id > 0";
            if (loai.equals("Tạm vắng")) sqlLoai = "tamvang.id > 0";



            String sql = "SELECT  DISTINCT nhankhau.* FROM nhankhau LEFT JOIN tamvang ON  tamvang.idNhanKhau = nhankhau.id LEFT JOIN tamtru ON tamtru.idNhanKhau = nhankhau.id "
                    +" WHERE "+sqlGioiTinh;
            if (!sqlDoTuoi.equals("")) sql+=" AND "+sqlDoTuoi;
            if (!sqlLoai.equals("")) sql+= " AND "+ sqlLoai;
            System.out.println(sql);

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
