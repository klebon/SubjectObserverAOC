package userProxy;

import java.util.concurrent.Callable;

import userGenerateur.Generateur;


public class GetValue implements Callable<Integer>{

	private Generateur generateur;
	
	public GetValue(Generateur generateur) {
		super();
		this.generateur = generateur;
	}
	
	@Override
	public Integer call() throws Exception {
		return this.generateur.getValue();
	}	
}
