package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static int wholeNumbers(Scanner sc)
    {
        int cislo = 0;
        try
        {
            cislo = sc.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Nastala vyjimka typu "+e.toString());
            System.out.println("zadejte prosim cele cislo ");
            sc.nextLine();
            cislo = wholeNumbers(sc);
        }
        return cislo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    var run = true;
        Database database = new Database();

                while (run) {
                    System.out.println("Vyberte pozadovanou cinnost:");
                    System.out.println("1 .. zadani noveho studenta"); // implemented
                    System.out.println("2 .. zadani znamky"); // implemented
                    System.out.println("3 .. propusteni studenta"); // implemented
                    System.out.println("4 .. dovednost studenta"); // implemented
                    System.out.println("5 .. vypis studentu"); // implemented
                    System.out.println("6 .. pocet studentu ve skupinach"); // implemented
                    System.out.println("7 .. prumer dle skupin"); // implemented
                    System.out.println("8 .. prace s soubory"); // implemented
                    System.out.println("9 .. SQL"); // implemented
                    int input = wholeNumbers(sc);
                        switch (input) {
                            case 1:
                                System.out.println("Zadejte skupinu (T/H):");
                                var group = sc.next();
                                database.SetStudent(group);
                                break;
                            case 2:
                                System.out.println("Zadejte ID studenta a znamku: ");
                                var student = database.getStudent(sc.nextInt());
                                student.AddMark(sc.nextInt());
                                break;
                            case 3:
                                System.out.println("Zadejete ID studenta ktereho chcete propustit: ");
                                database.RemoveStudent(sc.nextInt());
                                break;
                            case 4:
                                System.out.println("Zadejete ID studenta");
                                database.doAblity(sc.nextInt());
                                break;
                            case 5:
                                System.out.println("Vyberte jak chcete studenta najit \n" +
                                        "1 .. dle ID\n" +
                                        "2 .. vsichni dle abecedy\n" +
                                        "3 .. studenti dle abecedy dle skupin");
                                int choice = sc.nextInt();
                                switch (choice) {
                                    case 1:
                                        System.out.println("Zadejte ID studenta ktereho chcete najit: ");
                                        database.FindStudent(sc.nextInt());
                                        break;
                                    case 2:
                                        database.getSortedStudents();
                                        break;
                                    case 3:
                                        System.out.println("Zadejte skupinu: ");
                                        group = sc.next();
                                        database.getStudentsByGroup(group);
                                        break;
                                }
                                break;
                            case 6:
                                database.getNumberOfStudents();
                                break;
                            case 7:
                                group = sc.next();
                                database.getTotalMean(group);
                                break;
                            case 8:
                                System.out.println("1 .. do souboru\n" +
                                        "2 .. ze souboru");
                                choice = sc.nextInt();
                                switch (choice) {
                                    case 1:
                                        database.writeFile();
                                        break;
                                    case 2:
                                        database.readFile();
                                        break;
                                }
                                break;
                            case 9:
                                System.out.println("1 .. do SQL\n" +
                                        "2 .. ze SQL");
                                choice = sc.nextInt();
                                switch (choice) {
                                    case 1:
                                        database.addToSQL();
                                        break;
                                    case 2:
                                        database.getFromSQL();
                                        break;
                                }
                                break;
                            default:
                                System.out.println("Zadejte platny input!");
                                break;
                        }


            }

        }
}
