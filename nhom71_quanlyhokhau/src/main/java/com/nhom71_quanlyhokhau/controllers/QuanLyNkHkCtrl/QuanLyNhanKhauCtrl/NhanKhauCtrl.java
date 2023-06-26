package com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl.QuanLyNhanKhauCtrl;

import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.Bean.QuanLyHoKhauBean.NhanKhauBean;
import com.nhom71_quanlyhokhau.models.ChungMinhNhanDan;
import com.nhom71_quanlyhokhau.models.GiaDinh;
import com.nhom71_quanlyhokhau.models.NhanKhau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanKhauCtrl {
    public List<NhanKhau> getDanhSachNhanKhau() throws ClassNotFoundException, SQLException {
        Connection connection = MysqlConnection.getMysqlConnection();
        
        List<NhanKhau> nhanKhauList = new ArrayList<>();

        String sql = "SELECT * FROM nhankhau ORDER BY id DESC";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            NhanKhau nhanKhau = new NhanKhau();

            nhanKhau.setId(resultSet.getInt("id"));
            nhanKhau.setHoTen(resultSet.getString("hoTen"));
            nhanKhau.setNgaySinh(resultSet.getString("ngaySinh"));
            nhanKhau.setGioiTinh(resultSet.getString("gioiTinh"));
            nhanKhau.setNoiSinh(resultSet.getString("noiSinh"));
            nhanKhau.setNguyenQuan(resultSet.getString("nguyenQuan"));
            nhanKhau.setDanToc(resultSet.getString("danToc"));
            nhanKhau.setTonGiao(resultSet.getString("tonGiao"));
            nhanKhau.setQuocTich(resultSet.getString("quocTich"));
            nhanKhau.setNoiThuongTru(resultSet.getString("noiThuongTru"));
            nhanKhau.setDiaChiHienTai(resultSet.getString("diaChiHienTai"));
            nhanKhau.setTrinhDoHocVan(resultSet.getString("trinhDoHocVan"));
            nhanKhau.setNgheNghiep(resultSet.getString("ngheNghiep"));
            nhanKhau.setNoiLamViec(resultSet.getString("noiLamViec"));
            nhanKhau.setIdNguoiTao(resultSet.getInt("idNguoiTao"));
            nhanKhau.setNgayTao(resultSet.getString("ngayTao"));

            nhanKhauList.add(nhanKhau);
        }

        preparedStatement.close();
        connection.close();

        return nhanKhauList;
    }

    public NhanKhauBean getChiTietNhanKhau(int idNhanKhau) throws ClassNotFoundException, SQLException {
        NhanKhauBean nhanKhauBean = new NhanKhauBean();
        Connection connection = MysqlConnection.getMysqlConnection();
        
        String sql = "SELECT nhankhau.*, chungminhnhandan.* FROM nhankhau LEFT JOIN chungminhnhandan ON nhankhau.id = chungminhnhandan.idNhanKhau WHERE nhankhau.id = "+idNhanKhau;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            NhanKhau nhanKhau = new NhanKhau();
            ChungMinhNhanDan chungMinhNhanDan = new ChungMinhNhanDan();
            List<GiaDinh> giaDinhList = new ArrayList<>();

            int nhankhau_id = resultSet.getInt("nhankhau.id");
            nhanKhau.setId(nhankhau_id);
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

            nhanKhauBean.setNhanKhau(nhanKhau);

            chungMinhNhanDan.setId(resultSet.getInt("chungminhnhandan.id"));
            chungMinhNhanDan.setIdNhanKhau(resultSet.getInt("chungminhnhandan.idNhanKhau"));
            chungMinhNhanDan.setSoCMND(resultSet.getString("chungminhnhandan.soCMND"));

            nhanKhauBean.setChungMinhNhanDan(chungMinhNhanDan);

            //lấy list gia đình
            String sql2 = "SELECT * FROM giadinh WHERE giadinh.idNhanKhau = "+nhankhau_id;
            PreparedStatement prst = connection.prepareStatement(sql2);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                GiaDinh giaDinh = new GiaDinh();

                giaDinh.setId(rs.getInt("id"));
                giaDinh.setIdNhanKhau(rs.getInt("idNhanKhau"));
                giaDinh.setHoTen(rs.getString("hoTen"));
                giaDinh.setNgaySinh(rs.getString("ngaySinh"));
                giaDinh.setGioiTinh(rs.getString("gioiTinh"));
                giaDinh.setQuanHeVoiNhanKhau(rs.getString("quanHeVoiNhanKhau"));

                giaDinhList.add(giaDinh);
            }
            nhanKhauBean.setDanhSachThanhVienGiaDinh(giaDinhList);
            prst.close();
        }

        preparedStatement.close();
        connection.close();
        return nhanKhauBean;
    }
}
