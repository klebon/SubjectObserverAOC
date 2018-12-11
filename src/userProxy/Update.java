package userProxy;

import java.util.concurrent.Callable;

import userGenerateur.Generateur;
import userInterface.Afficheur;

public class Update implements Callable {

	private Canal c;

	public Object call() throws Exception {
		c.notifyObservers();
		return null;
	}

	public Canal getC() {
		return c;
	}

	public void setC(Canal c) {
		this.c = c;
	}
	
	
}
