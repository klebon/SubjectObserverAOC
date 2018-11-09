package userProxy;

import future.Future;
import userGenerateur.Generateur;
import userGenerateur.ObserverGenrateurAsync;
import userInterface.Afficheur;

public class Canal implements ObserverGenrateurAsync {

	private Generateur generateur;
	private Afficheur afficheur1;
	private Afficheur afficheur2;
	private Afficheur afficheur3;
	private Afficheur afficheur4;
	
	public int getValue() {
		return this.getGenerateur().getValue();
	}
	
	public Future update() {
		return null;
	}

	public Generateur getGenerateur() {
		return generateur;
	}

	public void setGenerateur(Generateur generateur) {
		this.generateur = generateur;
	}

	public Afficheur getAfficheur1() {
		return afficheur1;
	}

	public void setAfficheur1(Afficheur afficheur1) {
		this.afficheur1 = afficheur1;
	}

	public Afficheur getAfficheur2() {
		return afficheur2;
	}

	public void setAfficheur2(Afficheur afficheur2) {
		this.afficheur2 = afficheur2;
	}

	public Afficheur getAfficheur3() {
		return afficheur3;
	}

	public void setAfficheur3(Afficheur afficheur3) {
		this.afficheur3 = afficheur3;
	}

	public Afficheur getAfficheur4() {
		return afficheur4;
	}

	public void setAfficheur4(Afficheur afficheur4) {
		this.afficheur4 = afficheur4;
	}


}
