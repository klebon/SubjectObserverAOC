package userProxy;

import java.util.concurrent.Callable;

import userGenerateur.Generateur;

public class GetValue implements Callable{

	private Generateur g;
	
	public Generateur getG() {
		return g;
	}

	public void setG(Generateur g) {
		this.g = g;
	}

	@Override
	public Object call() throws Exception {
		return g.getValue();
	}

	
	
}
