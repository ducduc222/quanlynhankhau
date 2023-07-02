package com.nhom71_quanlyhokhau.Util;

import com.toedter.calendar.JCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateForm {
    public static String returnDateString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
