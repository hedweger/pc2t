abstract class Ctverec {
	public Ctverec() {}
	private float hrana;
	// vypocet obsahu ctverce
	float vypoctiObsah(){
		return (hrana*hrana);
	}
	// zjisteni delky hrany ctverce
	float getHrana(){					
		return hrana;
	}
	// nastaveni delky hrany ctverce
	void setHrana(float delka){			
		hrana=delka;
	}
	// konstruktor se zadanim delky hrany ctverce
	public Ctverec(float hrana){
		this.hrana=hrana;
	}
}
