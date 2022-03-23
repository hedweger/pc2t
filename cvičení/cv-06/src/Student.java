
public class Student {
	public Student(String jmeno, int rocnik)
	{
		this.jmeno=jmeno;
		this.rocnik=rocnik;
	}
	
	public String getJmeno()
	{
		return jmeno;
	}
	
	public int getRocnik()
	{
		return rocnik;
	}
	
	public float getStudijniPrumer() throws NoMeanException{
		if (studijniPrumer == 0) {throw new NoMeanException();}
		else {return studijniPrumer;}
	}

	public void setStudijniPrumer(float studijniPrumer) throws NoMeanException {
		if (studijniPrumer >= 1 && studijniPrumer <= 5) {this.studijniPrumer = studijniPrumer;}
		else {throw new NoMeanException("Neplatný interval");}

	}

	private String jmeno;
	private int rocnik;
	private float studijniPrumer;
}