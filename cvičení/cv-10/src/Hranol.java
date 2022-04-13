
public class Hranol extends Ctverec{

	// konstruktor se zadanim delky hrany, vysky a materialu
	Hranol(float podstava,float vyska, boolean drevena){
		super(podstava);
		hrana=vyska;
		zeDreva=drevena;
		pocetHranolu++;
	}
	
	// vypocet objemu hranolu
	float vypoctiObjem() {
		return this.hrana*vypoctiObsah();
	}
	
	// nastaveni materialu
	void setDreveny(boolean dreveny){
		zeDreva=dreveny;
	}
	
	// zjisteni materialu
	boolean jeDreveny(){
		return zeDreva;
	}
	
	// zjisteni celkoveho poctu existujicich kostek
	static int getPocetHranolu(){
		return pocetHranolu;
	}
	
	// zjisteni vysky hranolu
	float getHrana(){					
		return hrana;
	}
	// nastaveni vysky hranolu
	void setHrana(float delka){			
		hrana=delka;
	}

	private float hrana;
	boolean zeDreva;
	static int pocetHranolu=0;
	
	
}
