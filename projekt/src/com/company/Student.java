package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Student {
    public Student() {}
    public Student(String f_name, String l_name, List<Integer> Marks, LocalDate date) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.Marks = Marks;
        this.date = date;
    }
    public String Ability() { return "";}
    public String getGroup() {return "";}
    // getters for info
    public String getName() {
        return String.format(f_name + " " + l_name);
    }
    public String getBirthday() {
        return date.toString();
    }
    // methods for working with marks
    public void AddMark(int mark) { Marks.add(mark); }
    public double getMean() {
        var sumofmarks = 0;
        for (int i = 0; i < Marks.size(); i++)
            sumofmarks += Marks.get(i);
        return sumofmarks / Marks.size();
    }
    public String getMarks() {
        var marks = "";
        for (int i = 0; i<Marks.size(); i++)
            marks += Marks.get(i) + " ";
        return marks;
    }

    protected List<Integer> Marks = new ArrayList<Integer>();
    protected String f_name, l_name;
    protected LocalDate date;
}
