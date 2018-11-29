package userProxy;

import java.util.concurrent.Callable;
import userInterface.Afficheur;

public class Update implements Callable {

	private Afficheur a;
	
	public Afficheur getA() {
		return a;
	}

	public void setA(Afficheur a) {
		this.a = a;
	}

	@Override
	public Object call() throws Exception {
		return a.update();
	}	
}
