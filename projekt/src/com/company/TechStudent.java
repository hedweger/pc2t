package com.company;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TechStudent implements Student{
    public TechStudent(String f_name, String l_name, LocalDate date) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.date = date;
    }
    public String getName() {
        return String.format(f_name + " " + l_name);
    }
    public String getBirthday() {
        return date.toString();
    }
    public boolean IsLeap(Date date) {
        // date.getYear je deprecated
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        var year = calendar.get(Calendar.YEAR);
        if (year % 4 == 0)  return true;
        else return false;
    }

    String f_name, l_name;
    LocalDate date;
}
