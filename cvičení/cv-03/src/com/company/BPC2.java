package com.company;
import java.util.Scanner;

public class BPC2 implements Subject{
    private int exams, finalexam, project;
    private int numberOfExams = 3;
    Scanner sc;

    public String ReturnName() {
        String name = this.getClass().getSimpleName();
        return name;
    }

    public int FinalPoints() {
        int finalpoints = exams + finalexam + project;
        return finalpoints;
    }
    public boolean Credit() {
        if (MinCredit <= exams + finalexam + project) {
            return true;
        }
        else {
            boolean b = false;
            return b;
        }
    }
    public int setExams() {
        for (int i = 0; i < numberOfExams; i++) {
            System.out.println("Vložte bodové hodnocení pro cvičení " + (i + 1) + ": ");
            sc = new Scanner(System.in);
            exams += sc.nextInt();
        }
        return exams;
    }
    public int setFinalExam() {
        System.out.println("Vložte bodové hodnocení zkoušky");
        sc = new Scanner(System.in);
        finalexam = sc.nextInt();
        return finalexam;
    }
    public int setProject() {
        System.out.println("Vložte bodové hodnocení projektu");
        sc = new Scanner(System.in);
        project = sc.nextInt();
        return project;
    }

}
