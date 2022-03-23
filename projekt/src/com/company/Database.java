package com.company;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Database {
    public Database() {
        data = new HashMap<Integer, Student>();
        sc = new Scanner(System.in);
    }

    public void SetStudent() {
        System.out.println("Zadejte skupinu (T/H):");
        var group = sc.next();
        int id = data.size() + 1;
        if (group.equalsIgnoreCase("T")) {
            System.out.println("Zadejte jmeno, prijmeni a datum narozeni studenta (y-m-d):");
            String f_name = sc.next();
            String l_name = sc.next();
            var birthday = sc.next();
            LocalDate date = LocalDate.parse(birthday);
            data.put(id, new TechStudent(f_name, l_name, date));
        }
        else if (group.equalsIgnoreCase("H")) {
            System.out.println("Zadejte jmeno, prijmeni a datum narozeni studenta (y-m-d):");
            String f_name = sc.next();
            String l_name = sc.next();
            var birthday = sc.next();
            LocalDate date = LocalDate.parse(birthday);
            data.put(id, new HumStudent(f_name, l_name, date));
        }
        else System.out.println("Zadejte platnou skupinu!");
    }

    public void GetSortedStudents() {
        TreeMap<Integer, Student> sorted = new TreeMap<Integer, Student>();
        sorted.putAll(data);
        for (Map.Entry<Integer, Student> entry :sorted.entrySet()) {
            System.out.println("ID: " + entry.getKey() +
                    ", Jmeno: " + entry.getValue().getName() +
                    ", Datum narozeni: " + entry.getValue().getBirthday());
        }
    }

    private Scanner sc;
    private HashMap<Integer, Student> data;
}
