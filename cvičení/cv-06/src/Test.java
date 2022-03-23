import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {

	public static int pouzeCelaCisla(Scanner sc) 
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
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze(1);
		int idx = 0;
		float prumer;
		int volba;
		boolean run=true;
		while(run)
		{
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. vypis databazi");
			System.out.println("6 .. vypis databazi do souboru");
			System.out.println("7 .. vloz databazi ze souboru");
			System.out.println("8 .. ukonceni aplikace");
			volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
					try {
						System.out.println("Zadejte pocet studentu");
						mojeDatabaze = new Databaze(sc.nextInt());
					} catch (InputMismatchException e) {
						System.err.println("Zadejte celé číslo");
					}
					break;
				case 2:
					try {
						mojeDatabaze.setStudent();
					} catch(ArrayIndexOutOfBoundsException e) {
						System.err.println("Databáze je plná");
					} catch (InputMismatchException e) {
						System.err.println("Zadejte platnou hodnotu");
					}
					break;
				case 3:
					try {
					System.out.println("Zadejte index a prumer studenta");
					idx=sc.nextInt();
					prumer =sc.nextFloat();
					mojeDatabaze.setPrumer(idx,prumer);

					} catch(InputMismatchException e) {
						System.err.println("Student s indexem " + idx + " neexistuje");
					} catch (NoMeanException e) {
						System.err.println("Zadaný průměr není v intervalu 1 až 5");
					}
					break;
				case 4:
					try {
					System.out.println("Zadejte index studenta");
					idx=sc.nextInt();
					Student info=mojeDatabaze.getStudent(idx);
					System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
					} catch (ArrayIndexOutOfBoundsException e) {
						System.err.println("Student s indexem " + idx + " neexistuje");
					} catch (NoMeanException e) {
						System.err.println("Studentovi nebyl zadán průměr");
					}
					break;
				case 5:
					try {
						mojeDatabaze.writeDat();
					} catch (NoMeanException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 6:
					System.out.println("Zadejte nazev souboru: ");
					String filename = sc.next();
					mojeDatabaze.saveToFile(filename);
					break;
				case 7:
					System.out.println("Zadejte nazev souboru: ");
					String namefile = sc.next();
					mojeDatabaze.readfromFile(namefile);
					break;
				case 8:
					run=false;
					break;
			}
			
		}
	}

}
