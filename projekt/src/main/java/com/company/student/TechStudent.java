package com.company.student;

import java.time.LocalDate;
import java.util.*;

public class TechStudent extends Student {
    public TechStudent(String f_name, String l_name, List<Integer> marks, LocalDate date) {
        super(f_name, l_name, marks, date);
    }
    public String getGroup() {
        return "T";
    }
    public String Ability() {
        var year = date.getYear();
        if (year % 4 == 0)
            return "Rok je přestupný";
        return "Rok není přestupný";
    }
}
