package com.company;

import java.time.LocalDate;
import java.util.*;

public class HumStudent extends Student {
    public HumStudent(String f_name, String l_name, List<Integer> marks, LocalDate date) {
        super(f_name, l_name, marks, date);
    }
    public String getGroup() {
        return "H";
    }
    public String Ability() {
        var day = date.getDayOfMonth();
        var month = date.getMonth().toString();
        String sign = "";
        if (month == "JANUARY") {
            if (day < 20)
                sign = "Kozoroh";
            else
                sign = "Vodnář";
        }
        else if (month == "FEBRUARY") {
            if (day < 19)
                sign = "Vodnář";
            else
                sign = "Ryby";
        }
        else if(month == "MARCH") {
            if (day < 21)
                sign = "Ryby";
            else
                sign = "Beran";
        }
        else if (month == "APRIL") {
            if (day < 20)
                sign = "Beran";
            else
                sign = "Býk";
        }
        else if (month == "MAY") {
            if (day < 21)
                sign = "Býk";
            else
                sign = "Blíženci";
        }
        else if( month == "JUNE") {
            if (day < 21)
                sign = "Blíženci";
            else
                sign = "Rak";
        }
        else if (month == "JULY") {
            if (day < 23)
                sign = "Rak";
            else
                sign = "Lev";
        }
        else if( month == "AUGUST") {
            if (day < 23)
                sign = "Lev";
            else
                sign = "Panna";
        }
        else if (month == "SEPTEMBER") {
            if (day < 23)
                sign = "Panna";
            else
                sign = "Váhy";
        }
        else if (month == "OCTOBER") {
            if (day < 23)
                sign = "Váhy";
            else
                sign = "Štír";
        }
        else if (month == "NOVEMBER") {
            if (day < 22)
                sign = "Štír";
            else
                sign = "Střelec";
        }
        else if (month == "DECEMBER") {
            if (day < 22)
                sign = "Střelec";
            else
                sign ="Kozoroh";
        }
        return "Znamení: " + sign;
    }
}
