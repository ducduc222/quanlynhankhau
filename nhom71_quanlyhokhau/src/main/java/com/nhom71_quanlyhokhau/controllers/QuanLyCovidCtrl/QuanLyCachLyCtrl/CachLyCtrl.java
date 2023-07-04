package com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl.QuanLyCachLyCtrl;

import com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean.CachLyBean;
import com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean.TestCovidBean;
import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.CachLy;
import com.nhom71_quanlyhokhau.models.NhanKhau;
import com.nhom71_quanlyhokhau.models.TestCovid;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CachLyCtrl {
    public List<CachLyBean> getAllCachLy() throws SQLException, ClassNotFoundException {

        List<CachLyBean> cachLyBeanList = new ArrayList<>();

        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT cachly.*, nhankhau.* FROM cachly LEFT JOIN nhankhau ON cachly.idNhanKhau = nhankhau.id";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                CachLyBean cachLyBean = new CachLyBean();
                NhanKhau nhanKhau = new NhanKhau();
                CachLy cachLy = new CachLy();

                cachLy.setId(resultSet.getInt("cachly.id"));
                cachLy.setIdNhanKhau(resultSet.getInt("cachly.idNhanKhau"));
                cachLy.setCachLyTaiTramYTe(resultSet.getBoolean("cachly.isCachLyTaiTramYTe"));
                cachLy.setDiaDiemCachLy(resultSet.getString("cachly.diaDiemCachLy"));
                cachLy.setTuNgay(resultSet.getString("cachly.tuNgay"));
                cachLy.setDenNgay(resultSet.getString("cachly.denNgay"));
                cachLy.setThuocDien(resultSet.getString("cachly.thuocDien"));
                cachLy.setSoDienThoai(resultSet.getString("cachly.soDienThoai"));
                cachLyBean.setCachLy(cachLy);

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
                cachLyBean.setNhanKhau(nhanKhau);

                cachLyBeanList.add(cachLyBean);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return null;
        }

        return cachLyBeanList;
    }
}
