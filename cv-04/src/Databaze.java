import java.util.InputMismatchException;
import java.util.Scanner;

public class Databaze {
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}
	
	public void setStudent()
	{

		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok=sc.nextInt();
		prvkyDatabaze[posledniStudent++]=new Student(jmeno,rok);
	}
	
	public Student getStudent(int idx)
	{
		return prvkyDatabaze[idx];

	}
	
	public void setPrumer(int idx, float prumer) throws NoMeanException {
		try {
		prvkyDatabaze[idx].setStudijniPrumer(prumer);
		} catch(NullPointerException e){
			System.err.println("Student s indexem " + idx + " neexistuje");
		} catch(ArrayIndexOutOfBoundsException e){
			System.err.println("Student s indexem " + idx + " neexistuje");
		}
	}
	
	private Scanner sc;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
}