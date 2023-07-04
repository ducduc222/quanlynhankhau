/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nhom71_quanlyhokhau;

import com.nhom71_quanlyhokhau.UI.HomeView;
import com.nhom71_quanlyhokhau.UI.LoginView;

import java.sql.SQLException;

/**
 *
 * @author nguyenduc
 */
public class Nhom71_quanlyhokhau {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }
}
