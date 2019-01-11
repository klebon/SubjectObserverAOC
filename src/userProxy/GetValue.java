package userProxy;

import java.util.concurrent.Callable;

import userGenerateur.DiffusionAtomique;
import userGenerateur.DiffusionSequentielle;
import userGenerateur.Generateur;


public class GetValue implements Callable<Integer>{

	private Generateur generateur;
	
	public GetValue(Generateur generateur) {
		super();
		this.generateur = generateur;
	}
	
	@Override
	public Integer call() throws Exception {
		if(generateur.getAlgoDiffusion().getClass().equals(DiffusionAtomique.class)) {//diffusion atomique
			generateur.getPhaser().arrive();
		}else if(generateur.getAlgoDiffusion().getClass().equals(DiffusionSequentielle.class)) {//diffusion sequentielle
			generateur.getPhaser().arriveAndDeregister();
		}
				
		return this.generateur.getValue();
	}	
}
