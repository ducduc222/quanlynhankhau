package com.nhom71_quanlyhokhau.Bean.QuanLyCovidBean;

import com.nhom71_quanlyhokhau.models.NhanKhau;
import com.nhom71_quanlyhokhau.models.TestCovid;

public class TestCovidBean {
    private NhanKhau nhanKhau;
    private TestCovid testCovid;

    public TestCovidBean() {
    }

    public NhanKhau getNhanKhau() {
        return nhanKhau;
    }

    public void setNhanKhau(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
    }

    public TestCovid getTestCovid() {
        return testCovid;
    }

    public void setTestCovid(TestCovid testCovid) {
        this.testCovid = testCovid;
    }
}
