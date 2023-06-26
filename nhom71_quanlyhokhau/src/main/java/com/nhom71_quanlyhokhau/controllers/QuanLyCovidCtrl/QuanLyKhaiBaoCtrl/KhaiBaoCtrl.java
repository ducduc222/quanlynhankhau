package com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl.QuanLyKhaiBaoCtrl;

import com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean.KhaiBaoBean;
import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.models.KhaiBao;
import com.nhom71_quanlyhokhau.models.LichTrinh;
import com.nhom71_quanlyhokhau.models.NhanKhau;
import com.nhom71_quanlyhokhau.models.TrieuChung;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhaiBaoCtrl {
    public List<KhaiBaoBean> getAllKhaiBao() throws SQLException, ClassNotFoundException {
        List<KhaiBaoBean> khaiBaoBeanList = new ArrayList<>();

        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT thongtinkhaibao.*, trieuchung.*, nhankhau.* FROM thongtinkhaibao LEFT JOIN trieuchung ON trieuchung.idToKhai = thongtinkhaibao.id LEFT JOIN nhankhau ON thongtinkhaibao.idNhanKhau = nhankhau.id ORDER BY thongtinkhaibao.id DESC";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                KhaiBaoBean khaiBaoBean = new KhaiBaoBean();
                KhaiBao khaiBao = new KhaiBao();
                NhanKhau nhanKhau = new NhanKhau();
                TrieuChung trieuChung = new TrieuChung();
                List<LichTrinh> lichTrinhs = new ArrayList<>();

                //khaibao
                khaiBao.setId(resultSet.getInt("thongtinkhaibao.id"));
                khaiBao.setIdNhanKhau(resultSet.getInt("thongtinkhaibao.idNhanKhau"));
                khaiBao.setSoDienThoai(resultSet.getString("thongtinkhaibao.soDienThoai"));
                khaiBao.setNoiOHienTai(resultSet.getString("thongtinkhaibao.noiOHienTai"));
                khaiBao.setNgayKhaiBao(resultSet.getString("thongtinkhaibao.ngayKhaiBao"));
                khaiBaoBean.setKhaiBao(khaiBao);

                //nhankhau
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
                khaiBaoBean.setNhanKhau(nhanKhau);

                //trieuchung
                trieuChung.setId(resultSet.getInt("trieuchung.id"));
                trieuChung.setIdToKhai(resultSet.getInt("trieuchung.idToKhai"));
                trieuChung.setBieuHien(resultSet.getString("trieuchung.bieuHien"));
                khaiBaoBean.setTrieuChung(trieuChung);

                //lichtrinh
                int idToKhai = resultSet.getInt("thongtinkhaibao.id");
                String sql2 = "SELECT * FROM lichtrinh WHERE idToKhai = "+idToKhai;
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);

                ResultSet rs = preparedStatement1.executeQuery();
                while (rs.next()) {
                    LichTrinh lichTrinh = new LichTrinh();

                    lichTrinh.setId(rs.getInt("id"));
                    lichTrinh.setIdToKhai(rs.getInt("idToKhai"));
                    lichTrinh.setNgay(rs.getString("ngay"));
                    lichTrinh.setNoiDung(rs.getString("noiDung"));

                    lichTrinhs.add(lichTrinh);
                }

                khaiBaoBean.setLichTrinhList(lichTrinhs);
                khaiBaoBeanList.add(khaiBaoBean);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            return null;
        }

        return khaiBaoBeanList;
    }


    public KhaiBaoBean getChiTietThongTinKhaiBao(int idToKhai) throws SQLException, ClassNotFoundException {
        KhaiBaoBean khaiBaoBean = new KhaiBaoBean();
        Connection connection = MysqlConnection.getMysqlConnection();
        try {
            String sql = "SELECT thongtinkhaibao.*, trieuchung.*, nhankhau.* FROM thongtinkhaibao LEFT JOIN trieuchung ON trieuchung.idToKhai = thongtinkhaibao.id LEFT JOIN nhankhau ON thongtinkhaibao.idNhanKhau = nhankhau.id"
                    + " WHERE thongtinkhaibao.id = "+idToKhai;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                KhaiBao khaiBao = new KhaiBao();
                NhanKhau nhanKhau = new NhanKhau();
                TrieuChung trieuChung = new TrieuChung();
                List<LichTrinh> lichTrinhs = new ArrayList<>();

                //khaibao
                khaiBao.setId(resultSet.getInt("thongtinkhaibao.id"));
                khaiBao.setIdNhanKhau(resultSet.getInt("thongtinkhaibao.idNhanKhau"));
                khaiBao.setSoDienThoai(resultSet.getString("thongtinkhaibao.soDienThoai"));
                khaiBao.setNoiOHienTai(resultSet.getString("thongtinkhaibao.noiOHienTai"));
                khaiBao.setNgayKhaiBao(resultSet.getString("thongtinkhaibao.ngayKhaiBao"));
                khaiBaoBean.setKhaiBao(khaiBao);

                //nhankhau
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
                khaiBaoBean.setNhanKhau(nhanKhau);

                //trieuchung
                trieuChung.setId(resultSet.getInt("trieuchung.id"));
                trieuChung.setIdToKhai(resultSet.getInt("trieuchung.idToKhai"));
                trieuChung.setBieuHien(resultSet.getString("trieuchung.bieuHien"));
                khaiBaoBean.setTrieuChung(trieuChung);

                //lichtrinh
                String sql2 = "SELECT * FROM lichtrinh WHERE idToKhai = "+idToKhai;
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                ResultSet rs = preparedStatement1.executeQuery();
                while (rs.next()) {
                    LichTrinh lichTrinh = new LichTrinh();

                    lichTrinh.setId(rs.getInt("id"));
                    lichTrinh.setIdToKhai(rs.getInt("idToKhai"));
                    lichTrinh.setNgay(rs.getString("ngay"));
                    lichTrinh.setNoiDung(rs.getString("noiDung"));

                    lichTrinhs.add(lichTrinh);
                }

                khaiBaoBean.setLichTrinhList(lichTrinhs);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
            System.out.println(e.getMessage());
            return null;
        }

        return khaiBaoBean;
    }
}
