package com.company;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HumStudent implements Student {
    public HumStudent(String f_name, String l_name, LocalDate date) {
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
    String f_name, l_name;
    LocalDate date;
}
