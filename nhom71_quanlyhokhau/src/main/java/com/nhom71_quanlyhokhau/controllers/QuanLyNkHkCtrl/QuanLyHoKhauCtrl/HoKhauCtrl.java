package com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl.QuanLyHoKhauCtrl;

import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.Bean.QuanLyHoKhauBean.HoKhauBean;
import com.nhom71_quanlyhokhau.Bean.QuanLyHoKhauBean.ThanhVienCuaHoBean;
import com.nhom71_quanlyhokhau.models.HoKhau;
import com.nhom71_quanlyhokhau.models.HoKhauNhanKhau;
import com.nhom71_quanlyhokhau.models.NhanKhau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoKhauCtrl {
    public HoKhauCtrl() {
    }

    public List<HoKhauBean> getDanhSachHoKhau() throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();

        List<HoKhauBean> hoKhauBeanList = new ArrayList<>();

        String sql = "SELECT hokhau.*, nhankhau.* FROM hokhau LEFT JOIN nhankhau ON hokhau.idChuHo = nhankhau.id ORDER BY hokhau.id DESC";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            HoKhauBean hoKhauBean = new HoKhauBean();
            HoKhau hoKhau = new HoKhau();
            NhanKhau chuHo = new NhanKhau();
            List<ThanhVienCuaHoBean> thanhVienCuaHoBeanList = new ArrayList();

            hoKhau.setId(resultSet.getInt("hokhau.id"));
            hoKhau.setIdChuHo(resultSet.getInt("hokhau.idChuHo"));
            hoKhau.setMaHoKhau(resultSet.getString("hokhau.maHoKhau"));
            hoKhau.setMaKhuVuc(resultSet.getString("hokhau.maKhuVuc"));
            hoKhau.setDiaChi(resultSet.getString("hokhau.diaChi"));
            hoKhau.setIdNguoiTao(resultSet.getInt("hokhau.idNguoiTao"));
            hoKhau.setNgayTao(resultSet.getString("hokhau.ngayTao"));
            
            hoKhauBean.setHoKhau(hoKhau);

            chuHo.setHoTen(resultSet.getString("nhankhau.hoTen"));
            chuHo.setNgaySinh(resultSet.getString("nhankhau.ngaySinh"));
            chuHo.setGioiTinh(resultSet.getString("nhankhau.gioiTinh"));
            chuHo.setId(resultSet.getInt("nhankhau.id"));

            hoKhauBean.setChuHo(chuHo);

            String sql1 = "SELECT nhankhau.*,hokhau_nhankhau.*  FROM hokhau_nhankhau LEFT JOIN nhankhau ON hokhau_nhankhau.idNhanKhau = nhankhau.id WHERE hokhau_nhankhau.idHoKhau = "+hoKhau.getId();
            PreparedStatement prst = connection.prepareStatement(sql1);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                ThanhVienCuaHoBean thanhVienCuaHoBean = new ThanhVienCuaHoBean();

                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setId(rs.getInt("nhankhau.id"));
                nhanKhau.setHoTen(rs.getString("nhankhau.hoTen"));
                nhanKhau.setNgaySinh(rs.getString("nhankhau.ngaySinh"));
                nhanKhau.setGioiTinh(rs.getString("nhankhau.gioiTinh"));
                nhanKhau.setNoiSinh(rs.getString("nhankhau.noiSinh"));
                nhanKhau.setNguyenQuan(rs.getString("nhankhau.nguyenQuan"));
                nhanKhau.setDanToc(rs.getString("nhankhau.danToc"));
                nhanKhau.setTonGiao(rs.getString("nhankhau.tonGiao"));
                nhanKhau.setQuocTich(rs.getString("nhankhau.quocTich"));
                nhanKhau.setNoiThuongTru(rs.getString("nhankhau.noiThuongTru"));
                nhanKhau.setDiaChiHienTai(rs.getString("nhankhau.diaChiHienTai"));
                nhanKhau.setTrinhDoHocVan(rs.getString("nhankhau.trinhDoHocVan"));
                nhanKhau.setNgheNghiep(rs.getString("nhankhau.ngheNghiep"));
                nhanKhau.setNoiLamViec(rs.getString("nhankhau.noiLamViec"));
                nhanKhau.setIdNguoiTao(rs.getInt("nhankhau.idNguoiTao"));
                nhanKhau.setNgayTao(rs.getString("nhankhau.ngayTao"));

                thanhVienCuaHoBean.setNhanKhau(nhanKhau);

                HoKhauNhanKhau hoKhauNhanKhau = new HoKhauNhanKhau();
                hoKhauNhanKhau.setId(rs.getInt("hokhau_nhankhau.id"));
                hoKhauNhanKhau.setIdNhanKhau(rs.getInt("hokhau_nhankhau.idNhanKhau"));
                hoKhauNhanKhau.setIdHoKhau(rs.getInt("hokhau_nhankhau.idHoKhau"));
                hoKhauNhanKhau.setQuanHeVoiChuHo(rs.getString("hokhau_nhankhau.quanHeVoiChuHo"));

                thanhVienCuaHoBean.setHoKhauNhanKhau(hoKhauNhanKhau);

                thanhVienCuaHoBeanList.add(thanhVienCuaHoBean);
            }
            prst.close();
            hoKhauBean.setThanhVienCuaHo(thanhVienCuaHoBeanList);

            hoKhauBeanList.add(hoKhauBean);
        }

        preparedStatement.close();
        connection.close();
        return hoKhauBeanList;
    }


    public HoKhauBean getChiTietHoKhau(int idHoKhau) throws ClassNotFoundException, SQLException {
        HoKhauBean hoKhauBean = new HoKhauBean();

        Connection connection = MysqlConnection.getMysqlConnection();
        String sql = "SELECT hokhau.*, nhankhau.* FROM hokhau LEFT JOIN nhankhau ON hokhau.idChuHo = nhankhau.id WHERE hokhau.id = "+idHoKhau;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            HoKhau hoKhau = new HoKhau();
            NhanKhau chuHo = new NhanKhau();
            List<ThanhVienCuaHoBean> thanhVienCuaHoBeanList = new ArrayList();

            int idHo = resultSet.getInt("hokhau.id");
            hoKhau.setId(idHo);
            hoKhau.setIdChuHo(resultSet.getInt("hokhau.idChuHo"));
            hoKhau.setMaHoKhau(resultSet.getString("hokhau.maHoKhau"));
            hoKhau.setMaKhuVuc(resultSet.getString("hokhau.maKhuVuc"));
            hoKhau.setDiaChi(resultSet.getString("hokhau.diaChi"));
            hoKhau.setIdNguoiTao(resultSet.getInt("hokhau.idNguoiTao"));
            hoKhau.setNgayTao(resultSet.getString("hokhau.ngayTao"));    

            hoKhauBean.setHoKhau(hoKhau);

            chuHo.setId(resultSet.getInt("nhankhau.id"));
            chuHo.setHoTen(resultSet.getString("nhankhau.hoTen"));
            chuHo.setNgaySinh(resultSet.getString("nhankhau.ngaySinh"));
            chuHo.setGioiTinh(resultSet.getString("nhankhau.gioiTinh"));
            chuHo.setNoiSinh(resultSet.getString("nhankhau.noiSinh"));
            chuHo.setNguyenQuan(resultSet.getString("nhankhau.nguyenQuan"));
            chuHo.setDanToc(resultSet.getString("nhankhau.danToc"));
            chuHo.setTonGiao(resultSet.getString("nhankhau.tonGiao"));
            chuHo.setQuocTich(resultSet.getString("nhankhau.quocTich"));
            chuHo.setNoiThuongTru(resultSet.getString("nhankhau.noiThuongTru"));
            chuHo.setDiaChiHienTai(resultSet.getString("nhankhau.diaChiHienTai"));
            chuHo.setTrinhDoHocVan(resultSet.getString("nhankhau.trinhDoHocVan"));
            chuHo.setNgheNghiep(resultSet.getString("nhankhau.ngheNghiep"));
            chuHo.setNoiLamViec(resultSet.getString("nhankhau.noiLamViec"));
            chuHo.setIdNguoiTao(resultSet.getInt("nhankhau.idNguoiTao"));
            chuHo.setNgayTao(resultSet.getString("nhankhau.ngayTao"));

            hoKhauBean.setChuHo(chuHo);

            //get Thành viên của hộ
            String sql1 = "SELECT nhankhau.*,hokhau_nhankhau.*  FROM hokhau_nhankhau LEFT JOIN nhankhau ON hokhau_nhankhau.idNhanKhau = nhankhau.id WHERE hokhau_nhankhau.idHoKhau = "+idHo;
            PreparedStatement prst = connection.prepareStatement(sql1);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                ThanhVienCuaHoBean thanhVienCuaHoBean = new ThanhVienCuaHoBean();

                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setId(rs.getInt("nhankhau.id"));
                nhanKhau.setHoTen(rs.getString("nhankhau.hoTen"));
                nhanKhau.setNgaySinh(rs.getString("nhankhau.ngaySinh"));
                nhanKhau.setGioiTinh(rs.getString("nhankhau.gioiTinh"));
                nhanKhau.setNoiSinh(rs.getString("nhankhau.noiSinh"));
                nhanKhau.setNguyenQuan(rs.getString("nhankhau.nguyenQuan"));
                nhanKhau.setDanToc(rs.getString("nhankhau.danToc"));
                nhanKhau.setTonGiao(rs.getString("nhankhau.tonGiao"));
                nhanKhau.setQuocTich(rs.getString("nhankhau.quocTich"));
                nhanKhau.setNoiThuongTru(rs.getString("nhankhau.noiThuongTru"));
                nhanKhau.setDiaChiHienTai(rs.getString("nhankhau.diaChiHienTai"));
                nhanKhau.setTrinhDoHocVan(rs.getString("nhankhau.trinhDoHocVan"));
                nhanKhau.setNgheNghiep(rs.getString("nhankhau.ngheNghiep"));
                nhanKhau.setNoiLamViec(rs.getString("nhankhau.noiLamViec"));
                nhanKhau.setIdNguoiTao(rs.getInt("nhankhau.idNguoiTao"));
                nhanKhau.setNgayTao(rs.getString("nhankhau.ngayTao"));

                thanhVienCuaHoBean.setNhanKhau(nhanKhau);

                HoKhauNhanKhau hoKhauNhanKhau = new HoKhauNhanKhau();
                hoKhauNhanKhau.setId(rs.getInt("hokhau_nhankhau.id"));
                hoKhauNhanKhau.setIdNhanKhau(rs.getInt("hokhau_nhankhau.idNhanKhau"));
                hoKhauNhanKhau.setIdHoKhau(rs.getInt("hokhau_nhankhau.idHoKhau"));
                hoKhauNhanKhau.setQuanHeVoiChuHo(rs.getString("hokhau_nhankhau.quanHeVoiChuHo"));

                thanhVienCuaHoBean.setHoKhauNhanKhau(hoKhauNhanKhau);

                thanhVienCuaHoBeanList.add(thanhVienCuaHoBean);
            }
            prst.close();
            hoKhauBean.setThanhVienCuaHo(thanhVienCuaHoBeanList);
        }

        preparedStatement.close();
        connection.close();

        return hoKhauBean;
    }
}
