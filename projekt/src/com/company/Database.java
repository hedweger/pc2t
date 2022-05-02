package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static java.lang.System.in;

public class Database {
    public Database() {
        data = new HashMap<>();
    }
    /**
    * inserts a student into the database
    * along with the information provided;
    * an empty list of marks is created for each student
     */
    public void SetStudent(String group) {
        int id = data.size();
        if (group.equalsIgnoreCase("T")) {
            System.out.println("Zadejte jmeno, prijmeni a datum narozeni studenta (y-m-d):");
            String birthday = null;
            String f_name = null, l_name = null;
            while (birthday == null) {
                f_name = sc.nextLine();
                l_name = sc.nextLine();
                birthday = sc.nextLine();
            }
            LocalDate date = LocalDate.parse(birthday);
            List<Integer> marks = new ArrayList<>();
            data.put(id, new TechStudent(f_name, l_name, marks, date));
        }
        else if (group.equalsIgnoreCase("H")) {
            System.out.println("Zadejte jmeno, prijmeni a datum narozeni studenta (y-m-d):");
            String f_name = sc.next();
            String l_name = sc.next();
            var birthday = sc.next();
            LocalDate date = LocalDate.parse(birthday);
            List<Integer> marks = new ArrayList<>();
            data.put(id, new HumStudent(f_name, l_name, marks, date));
        }
        else System.out.println("Zadejte platnou skupinu!");
    }
    public void RemoveStudent(int id) {
        data.remove(id);
    }
    public void FindStudent(int id) {
        var entry = data.get(id);
        System.out.println(
                "Jmeno: " + entry.getName() +
                        ", Datum narozeni: " + entry.getBirthday() +
                        ", Prumer: " + entry.getMean()
        );
    }
    public void getSortedStudents() {
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
    public void getStudentsByGroup(String group) {
        if (group.equalsIgnoreCase("T")) {
            for (int i = 0; i < data.size(); i++ ) {
                if ( data.get(i).getClass().getName() == "com.company.TechStudent") {
                    System.out.println(
                            "Jmeno: " + data.get(i).getName() +
                            ", Datum narozeni: " + data.get(i).getBirthday() +
                            ", Prumer: " + data.get(i).getMean()
                    );
                }
                else
                    System.out.println("Ve skupine zadny student neni");
            }
            if (group.equalsIgnoreCase("H")) {
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getClass().getName() == "com.company.HumStudent") {
                        System.out.println("Jmeno: " + data.get(i).getName() +
                                ", Datum narozeni: " + data.get(i).getBirthday() +
                                ", Prumer: " + data.get(i).getMean()
                        );
                    }
                    else
                        System.out.println("Ve skupine zadny student neni");
                }
            }
        }
    }
    public void getTotalMean(String group) {
        var totalmean = 0;
        if (group.equalsIgnoreCase("T")) {
            for (int i = 0; i < data.size(); i++) { totalmean += data.get(i).getMean();}
        } else if (group.equalsIgnoreCase("H")) {
            for (int i = 0; i < data.size(); i++) { totalmean += data.get(i).getMean();}
        }
        System.out.println("Prumer: " + totalmean / data.size());
    }

    public void getNumberOfStudents() {
        var techcount = 0;
        var humcount = 0;
        for (int i = 0; i < data.size(); i++) {
            var group = data.get(i).getClass().getName();
            if (group == "com.company.TechStudent")
                techcount++;
            if (group == "com.company.HumStudent")
                humcount++;
        }
        System.out.println("Technika: " + techcount + " \n" +
                "Humanitni: " + humcount);
    }

    public void doAblity(int id) {
        var group = data.get(id).getClass().getName();
        var word = data.get(id).Ability();
        System.out.println(word);
    }

    public void writeFile() {
        try {
            FileWriter file = new FileWriter("fileOut/databaseTestWrite.txt");
            for (int i = 0; i < data.size(); i++) {
                file.write(i + " ; " +
                        data.get(i).getGroup() + " ; " +
                        data.get(i).getName() + " ; " +
                        data.get(i).getBirthday() + " ; " +
                        data.get(i).getMarks() + "\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile() {
        File file = new File("fileOut/databaseTestRead.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitline = line.split(" ; ");
                int id = Integer.parseInt(splitline[0]);
                String[] splitName = splitline[2].split(" ");
                LocalDate date = LocalDate.parse(splitline[3]);
                String[] splitMarks = splitline[4].split(" ");
                List<Integer> marks = new ArrayList<>();
                for (int i = 0; i < splitMarks.length; i++) {
                    marks.add(Integer.parseInt(splitMarks[i]));
                }
                 if (splitline[1].equalsIgnoreCase("t"))
                    data.put(id, new TechStudent(splitName[0], splitName[1], marks, date));
                if (splitline[1].equalsIgnoreCase("h"))
                    data.put(id, new HumStudent(splitName[0], splitName[1], marks, date));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Student getStudent(int ID) { return data.get(ID); }


    Scanner sc = new Scanner(in);
    private HashMap<Integer, Student> data;
}
