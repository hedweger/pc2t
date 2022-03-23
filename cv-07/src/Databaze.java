import java.io.*;
import java.util.*;

public class Databaze {
	public Databaze()
	{
		prvkyDatabaze = new HashMap<String, Student>();
		sc=new Scanner(System.in);
	}
	
	public void setStudent()
	{

		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok=sc.nextInt();
		prvkyDatabaze.put(jmeno, new Student(jmeno,rok));
	}
	
	public Student getStudent(String name)
	{
		var student = prvkyDatabaze.get(name);
		return student;

	}
	
	public void setPrumer(String name, float prumer) throws NoMeanException {
		try {
		prvkyDatabaze.get(name).setStudijniPrumer(prumer);
		} catch(NullPointerException e){
			System.err.println("Student: " + name + " neexistuje");
		}
	}
	public void removeStudent(String name) {
		try{ prvkyDatabaze.remove(name);}
		catch (NullPointerException e) {			System.err.println("Student: " + name + " neexistuje");}
	}
	public void writeDat() {
		var list = prvkyDatabaze.keySet();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			Student info=prvkyDatabaze.get(iterator.next());
			try {
				System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
			} catch (NoMeanException e) {
				e.printStackTrace();
			}
		}
	}

	private Scanner sc;
	private HashMap<String, Student> prvkyDatabaze;
}