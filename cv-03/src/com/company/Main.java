package com.company;

public class Main {

    public static void main(String[] args) {
        BPC1 bpc1 = new BPC1();
        BPC2 bpc2 = new BPC2();
        BPIS bpis = new BPIS();

        bpc1.setExams();
        bpc1.setFinalExam();
        bpc2.setExams();
        bpc2.setProject();
        bpc2.setFinalExam();
        bpis.setCredit();

        System.out.println(bpc1.ReturnName() + " " + bpc1.FinalPoints() + " " + bpc1.Credit());
        System.out.println(bpc2.ReturnName() + " " + bpc2.FinalPoints() + " " + bpc2.Credit());
        System.out.println(bpis.ReturnName() + " " + bpis.FinalPoints() + " " + bpis.Credit());

    }
}
