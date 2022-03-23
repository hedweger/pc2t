import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

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

	public void writeDat() throws NoMeanException {
		for (int i = 0; i < prvkyDatabaze.length; i++) {
			if (prvkyDatabaze[i] == null) {
				System.out.print(" ");
			}
			else {
				System.out.println(i + "Jmeno: " + prvkyDatabaze[i].getJmeno() + ", rocnik: " + prvkyDatabaze[i].getRocnik() + ", prumer: " + prvkyDatabaze[i].getStudijniPrumer());
			}
		}
	}

	public boolean saveToFile(String filename) {
		try {
			FileWriter fw = new FileWriter(filename);
			BufferedWriter out = new BufferedWriter(fw);
			for (int i = 0; i < prvkyDatabaze.length; i++) {
				if (prvkyDatabaze[i] == null) {
					out.write(" ");
				}
				else {
					out.write(i + " Jmeno: " + prvkyDatabaze[i].getJmeno() + " rocnik: " + prvkyDatabaze[i].getRocnik() + " prumer: " + prvkyDatabaze[i].getStudijniPrumer());
					out.newLine();
				}
			}
			out.close();
			fw.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false; } catch (NoMeanException e) {
			System.err.println(e.getMessage());
		}
		return true;
	}

	public static Vector<Student> readfromFile(String filename) {
		FileReader fr = null;
		BufferedReader bfr = null;
		Vector<Student> out = new Vector<Student>();

		try {
			fr = new FileReader(filename);
			bfr = new BufferedReader(fr);

			while(true) {
				String line = bfr.readLine();
				if (line == null || line == "") {break;}
				String splitter = " ";
				String[] split = line.split(splitter);
				if (split.length == 6) {
					out.add(new Student(split[2], Integer.parseInt(split[4])));

				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return out;
	}


	private Scanner sc;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
}