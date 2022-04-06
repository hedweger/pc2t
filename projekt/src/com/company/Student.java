package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Student {
    public String getName() {
        return String.format(f_name + " " + l_name);
    }
    public String getBirthday() {
        return date.toString();
    }
    public void AddMark(int mark) { Marks.add(mark); }
    public double getMean() {
        var sumofmarks = 0;
        for (int i = 0; i < Marks.size(); i++)
            sumofmarks += Marks.get(i);
        return sumofmarks / Marks.size();
    }

    List<Integer> Marks = new ArrayList<Integer>();
    String f_name, l_name;
    LocalDate date;
}
