package com.company;
import java.time.LocalDate;
import java.util.*;

public class Database {
    public Database()
    {
        data = new HashMap<Integer, Student>();
        sc = new Scanner(System.in);
    }

    public void SetStudent(String group) {
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
        if (data.size() == 0) { System.out.println("Databaze je prazdna!"); }
        else
        {
        TreeMap<Integer, Student> sorted = new TreeMap<Integer, Student>();
        sorted.putAll(data);
        for (Map.Entry<Integer, Student> entry :sorted.entrySet())
            {
            System.out.println("ID: " + entry.getKey() +
                    ", Jmeno: " + entry.getValue().getName() +
                    ", Datum narozeni: " + entry.getValue().getBirthday() +
                    ", Prumer: " + entry.getValue().getMean()
                );
            }
        }
    }
    public void FindStudent(int id) {
        var entry = data.get(id);
        System.out.println(
                "Jmeno: " + entry.getName() +
                ", Datum narozeni: " + entry.getBirthday() +
                ", Prumer: " + entry.getMean()
        );
    }
    public void getTotalMean(String input) {
        var totalmean = 0;
        if (input.equalsIgnoreCase("T")) {
            for (int i = 1; i < data.size(); i++) { totalmean += data.get(i).getMean();}
        } else if (input.equalsIgnoreCase("H")) {
            for (int i = 1; i < data.size(); i++) { totalmean += data.get(i).getMean();}
        }
        System.out.println("Prumer: " + totalmean / data.size());
    }

    public Student getStudent(int ID) { return data.get(ID); }
    public void RemoveStudent(int id) { data.remove(id); }

    private Scanner sc;
    private HashMap<Integer, Student> data;
}
