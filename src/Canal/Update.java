package Canal;

import java.util.concurrent.Callable;

import afficheur.ObserverGenerateur;

public class Update implements Callable<Object> {
	
	private GenerateurAsync generateurAsync;
	private ObserverGenerateur observerGenerateur;
	
	

	public Update(GenerateurAsync generateurAsync, ObserverGenerateur observerGenerateur) {
		super();
		this.generateurAsync = generateurAsync;
		this.observerGenerateur = observerGenerateur;
	}



	@Override
	public Object call() throws Exception {
		this.observerGenerateur.update(this.generateurAsync);
		return null;
	}



}
