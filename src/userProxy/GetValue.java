package userProxy;

import java.util.concurrent.Callable;

import userGenerateur.DiffusionAtomique;
import userGenerateur.Generateur;


public class GetValue implements Callable<Integer>{

	private Generateur generateur;
	
	public GetValue(Generateur generateur) {
		super();
		this.generateur = generateur;
	}
	
	@Override
	public Integer call() throws Exception {
		//diffusion atomique
		if(generateur.getAlgoDiffusion().getClass().equals(DiffusionAtomique.class)) {
			generateur.getPhaser().arrive();
		}
				
		return this.generateur.getValue();
	}	
}
