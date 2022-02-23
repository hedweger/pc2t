package com.company;
import java.util.Scanner;

public class BPC1 implements Subject{
    Scanner sc;
    private int exams = 0;
    public int finalexam;
    private int numberOfExams = 3;

    public String ReturnName() {
        String name = this.getClass().getSimpleName();
        return name;
    }
    @Override
    public int FinalPoints() {
        return exams + finalexam;
    }
    public boolean Credit() {
        if (MinCredit <= exams + finalexam) {
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
}
