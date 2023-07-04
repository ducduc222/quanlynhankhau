package com.nhom71_quanlyhokhau.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.nhom71_quanlyhokhau.MysqlConnection;
import com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean.CachLyBean;
import com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl.QuanLyCachLyCtrl.CachLyCtrl;
import com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl.QuanLyCachLyCtrl.HoanThanhCachLyCtrl;
import com.nhom71_quanlyhokhau.controllers.QuanLyCovidCtrl.QuanLyCachLyCtrl.ThemCachLyCtrl;
import com.nhom71_quanlyhokhau.controllers.QuanLyNkHkCtrl.QuanLyNhanKhauCtrl.TamTruCtrl;
import com.nhom71_quanlyhokhau.models.TamTru;

public class TestQuery {

	@Test
	public void testGetAllCachLy() throws ClassNotFoundException, SQLException {
		Connection connection = MysqlConnection.getMysqlConnection();
		String sql = "SELECT cachly.*, nhankhau.* FROM cachly LEFT JOIN nhankhau ON cachly.idNhanKhau = nhankhau.id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        int size =0;
        if (resultSet != null) 
        {
        	resultSet.last();    // moves cursor to the last row
          size = resultSet.getRow(); // get row id 
        }
        
        CachLyCtrl cachLyCtrl = new CachLyCtrl();
        List<CachLyBean> resultList = cachLyCtrl.getAllCachLy();
        int resultSize = resultList.size();
		assertEquals(size,resultSize);
	}

	@Test
	public void testHoanThanhCachLy() throws ClassNotFoundException, SQLException{
		HoanThanhCachLyCtrl hoanThanhCachLyCtrl = new HoanThanhCachLyCtrl();
		hoanThanhCachLyCtrl.hoanThanhCachLy(1);
		
		Connection connection = MysqlConnection.getMysqlConnection();
		String sql = "SELECT * FROM cachly WHERE id = 1";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Boolean isExist = resultSet.next();
        
        assertEquals(false, isExist);
	}
	
	@Test
	public void testDangKyTamTru() throws ClassNotFoundException, SQLException{
		int oldSize = 0, newSize = 0;
		Connection connection = MysqlConnection.getMysqlConnection();
        String sql = "SELECT COUNT(*) FROM tamtru";
        PreparedStatement prst = connection.prepareStatement(sql);
        
        ResultSet rs = prst.executeQuery();
        if (rs.next()) oldSize = rs.getInt(1);
		
		TamTru tamTru = new TamTru(12, 21, "123456", "123456", "2023-11-30", "2023-12-15", "abc");
		TamTruCtrl tamTruCtrl = new TamTruCtrl();
		tamTruCtrl.dangKyTamTru(tamTru);
		
		rs = prst.executeQuery();
        if (rs.next()) newSize = rs.getInt(1);
        prst.close();
        
        
        assertEquals(newSize, oldSize+1);       
	}
}
