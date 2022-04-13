import java.util.Scanner;

public class Pole {
	Pole() {};

	// Konstruktor s velikosti pole
	Pole(int velikost)
	{
		mojeHranoly=new Hranol[velikost];
		sc=new Scanner(System.in);
	}
	
	// vlozeni hranolu do pole na prvni volnou pozici
	void zadejHranol(){
		boolean drevena = false;
		float delka = 0;
		float vyska = 0;
		System.out.println("Zadejte delku podstavy hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		delka=sc.nextFloat();
		System.out.println("Zadejte vysku hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		vyska=sc.nextFloat();
		System.out.println("Je drevena?");
		while(!sc.hasNextBoolean())
		{
			sc.next();
		}
		drevena=sc.nextBoolean();
		if (Hranol.getPocetHranolu()==mojeHranoly.length)
		{
			System.out.println("Pole uz je zaplneno");
			return;
		}
		mojeHranoly[Hranol.getPocetHranolu()] = new Hranol(delka, vyska, drevena);
	}
	
	// vypis objemu vsech hranolu
	void vypoctiObjem()
	{
		for (int i=0;i<mojeHranoly.length;i++)
			System.out.println("Objem " + i + " hranolu je " + mojeHranoly[i].vypoctiObjem());
	}
	
	// vypis obsahu podstavy vsech hranolu
	void vypoctiObsahPodstavy()
	{
		for (int i=0;i<mojeHranoly.length;i++)
			System.out.println("Obsah "+i+" hranolu je " + mojeHranoly[i].vypoctiObsah());
	}
	
	// nalezeni indexu nejmensiho hranolu
	int najdiNejmensiObjem()
	{
		float min=50000000;
		int id=0;
		for (int i = 0;i<mojeHranoly.length;i++)
		{
			min=mojeHranoly[i].vypoctiObjem();
			if (mojeHranoly[i].vypoctiObjem()<min){
				min=mojeHranoly[i].vypoctiObjem();
				id = i;
			}
		}
		return id;
	}
	
	// zjisteni celkoveho poctu drevenych kostek
	int zjistiPocetDrevenych(){
		int pocetDrevenych=0;
		for (int i=0;i<mojeHranoly.length;i++)
		{
			if (mojeHranoly[i].jeDreveny() == true)
				pocetDrevenych++;
		}
		return pocetDrevenych;
	}

	private Scanner sc;
	private Hranol[] mojeHranoly;
}
