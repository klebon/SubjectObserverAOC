package Canal;

import java.util.concurrent.Callable;

import Generateur.Generateur;

public class GetValue implements Callable<Integer>{

	private Generateur generateur;
	private ObserverGenerateurAsync observerGenerateurAsync;
	
	public GetValue(Generateur generateur, ObserverGenerateurAsync obsGeneAsync) {
		super();
		this.generateur = generateur;
		this.observerGenerateurAsync=obsGeneAsync;
	}


	@Override
	public Integer call() throws Exception {
		return this.generateur.getValue(this.observerGenerateurAsync);
	}
	
	
}
