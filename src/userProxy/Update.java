package userProxy;

import java.util.concurrent.Callable;

import userGenerateur.Generateur;
import userInterface.Afficheur;

public class Update implements Callable {

	private Afficheur a;
	private Generateur g;
	
	public Afficheur getA() {
		return a;
	}

	public void setA(Afficheur a) {
		this.a = a;
	}

	public Object call() throws Exception {
		return a.update(g);
	}

	public Generateur getG() {
		return g;
	}

	public void setG(Generateur g) {
		this.g = g;
	}
	
	


}
