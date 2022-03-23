package com.company;
import java.util.Scanner;



public class BPIS implements Subject{
    Scanner sc;
    int credit;

    public String ReturnName() {
        String name = this.getClass().getSimpleName();
        return name;
    }
    @Override
    public int FinalPoints() {
        return 0;
    }
    public boolean Credit() {
        if (credit == 1) {
            return true;
        }
        else {
            boolean b = false;
            return b;
        }
    }

    public int setCredit() {
        System.out.println("Udělen zápočet?[1=Y/0=N]:");
        sc = new Scanner(System.in);
        credit = sc.nextInt();
        sc.close();
        return credit;
    }
}
