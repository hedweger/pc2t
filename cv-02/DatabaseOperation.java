

import java.util.Scanner;

public class DatabaseOperation {
    public static void main(String [] argv)
    {
        int NumberOfPeople = 3;
        Database[] Dat1 = new Database[NumberOfPeople];
        Scanner sc;

        for (int i = 0; i < NumberOfPeople; i++)
        {
            System.out.println("Input name n." + i + ":");
            sc = new Scanner(System.in);
            String Name = sc.next();
            System.out.println("Input birthday n." + i + ":");
            sc = new Scanner(System.in);
            int Birth = sc.nextInt();
            Dat1[i] = new Database(Name, Birth);
        }

        System.out.println("Input maximum pay:");
        sc = new Scanner(System.in);
        Database.SetMaxPay(sc.nextFloat());

        while (true)
        {
            System.out.println("Input the person's index (0 - inputted number of people):");
            sc = new Scanner(System.in);
            if (!sc.hasNextInt())
            {
                System.out.println("ERROR: You didn't input the right index.");
                continue;
            }
            int Index = sc.nextInt();
            if (Index < 0)
            {
                System.out.println("ERROR: You didn't input the right index.");
                continue;
            }
            if (Index > NumberOfPeople)
            {
                System.out.println("ERROR: You didn't input the right index.");
                continue;
            }
            System.out.println("Input the pay:");
            sc = new Scanner(System.in);
            if (!sc.hasNextFloat())
            {
                System.out.println("ERROR: You didn't input the right pay");
                continue;
            }
            float LocalPay = sc.nextFloat();
            System.out.println("The person's name is: " + Dat1[Index].getName() + " and their birth year is: " + Dat1[Index].getBirth());
            if (Dat1[Index].PayAdd(LocalPay))
            {
                System.out.println("Pay increased " + Dat1[Index].getPay());
            }
            else
            {
                System.out.println("Pay cannot be increased, as their current pay is: " + Dat1[Index].getPay() + " and the maximum pay is: " + Dat1[Index].getMaximumPay());
            }
        }
    }
}
