package com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl.QuanLyTestCovidCtrl;

import com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean.TestCovidBean;
import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.NhanKhau;
import com.nhom71_quanlyhokhau.models.TestCovid;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestCovidCtrl {
    public List<TestCovidBean> getAllTestCovid() throws SQLException, ClassNotFoundException {
        List<TestCovidBean> testCovidBeanList = new ArrayList<>();

        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT testcovid.*, nhankhau.* FROM testcovid LEFT JOIN nhankhau ON testcovid.idNhanKhau = nhankhau.id";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TestCovidBean testCovidBean = new TestCovidBean();
                NhanKhau nhanKhau = new NhanKhau();
                TestCovid testCovid = new TestCovid();

                testCovid.setId(resultSet.getInt("testcovid.id"));
                testCovid.setIdNhanKhau(resultSet.getInt("testcovid.idNhanKhau"));
                testCovid.setSoDienThoai(resultSet.getString("testcovid.soDienThoai"));
                testCovid.setNgayTest(resultSet.getString("testcovid.ngayTest"));
                testCovid.setKetQuaTest(resultSet.getString("testcovid.ketQuaTest"));
                testCovid.setNoiOHienTai(resultSet.getString("testcovid.noiOHienTai"));
                testCovidBean.setTestCovid(testCovid);

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
                testCovidBean.setNhanKhau(nhanKhau);

                testCovidBeanList.add(testCovidBean);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return null;
        }

        return testCovidBeanList;
    }
}
