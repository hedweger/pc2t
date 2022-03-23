package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    var run = true;
        Database database = new Database();
                while (run) 
                {
                    System.out.println("Vyberte pozadovanou cinnost:");
                    System.out.println("1 .. zadani noveho studenta"); // implemented
                    System.out.println("2 .. zadani znamkzy");
                    System.out.println("3 .. propusteni studenta");
                    System.out.println("4 .. search by id");
                    System.out.println("5 .. dovednost studenta");
                    System.out.println("6 .. vypis vsech studentu podle abecedy"); // implemented
                    System.out.println("7 .. vypis prumeru");
                    System.out.println("8.. pocet studentu ve skupinach");
                    System.out.println("9 .. vypis databazi do souboru");
                    System.out.println("10 .. vypis databazi ze souboru");
                    System.out.println("11 .. vloz databazi do SQL");
                    System.out.println("12 .. vloz databazi ze SQL");
                    System.out.println("13 .. ukonceni aplikace");
                    int input = sc.nextInt();
                    switch (input) {
                        case 1:
                            database.SetStudent();
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            database.GetSortedStudents();
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 9:
                            break;
                        case 10:
                            break;
                        case 11:
                            break;
                        case 12:
                            break;
                        case 13:
                            break;
            }
        }
    }
}
