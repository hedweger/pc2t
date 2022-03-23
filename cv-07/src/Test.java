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
		Databaze mojeDatabaze=new Databaze();
		String name;
		float prumer;
		int volba;
		boolean run=true;
		while(run)
		{
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vlozeni noveho studenta");
			System.out.println("2 .. nastaveni prumeru studenta");
			System.out.println("3 .. vypis informace o studentovi");
			System.out.println("4 .. odstran studenta");
			System.out.println("5 .. vypis databazi");
			System.out.println("6 .. konec");
			volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
					try {
						mojeDatabaze.setStudent();
					} catch(ArrayIndexOutOfBoundsException e) {
						System.err.println("Databáze je plná");
					} catch (InputMismatchException e) {
						System.err.println("Zadejte platnou hodnotu");
					}
					break;
				case 2:
					try {
					System.out.println("Zadejte jmeno a prumer studenta");
					name=sc.next();
					prumer =sc.nextFloat();
					mojeDatabaze.setPrumer(name,prumer);

					} catch(InputMismatchException e) {
						System.err.println("Student neexistuje");
					} catch (NoMeanException e) {
						System.err.println("Zadaný průměr není v intervalu 1 až 5");
					}
					break;
				case 3:
					try {
					System.out.println("Zadejte jmeno studenta");
					name=sc.next();
					Student info=mojeDatabaze.getStudent(name);
					System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
					} catch (ArrayIndexOutOfBoundsException e) {
						System.err.println("Student neexistuje");
					} catch (NoMeanException e) {
						System.err.println("Studentovi nebyl zadán průměr");
					} catch (NullPointerException e) {System.err.println("Student neexistuje");}
					break;
				case 4:
					try {
						System.out.println("Zadejte jmeno studenta");
						name = sc.next();
						Student info = mojeDatabaze.getStudent(name);
						mojeDatabaze.removeStudent(name);
						System.out.println("Student odstranen");
					} catch (NullPointerException e) {
						System.err.println("Student neexistuje");
					} catch (ArrayIndexOutOfBoundsException e) {
						System.err.println("Student neexistuje");
					}
					break;
				case 5:
					mojeDatabaze.writeDat();
					break;
				case 6:
					run = false;
					break;
			}
			
		}
	}

}
