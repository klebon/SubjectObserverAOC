package userProxy;

import java.util.concurrent.Callable;

import userGenerateur.DiffusionAtomique;
import userGenerateur.DiffusionCausale;
import userGenerateur.DiffusionSequentielle;
import userGenerateur.Generateur;

/**
 * 
 * @author miola, sefacene
 *
 */
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
		}else if(generateur.getAlgoDiffusion().getClass().equals(DiffusionSequentielle.class)
				|| generateur.getAlgoDiffusion().getClass().equals(DiffusionCausale.class)) {//diffusion sequentielle ou causale
			generateur.getPhaser().arriveAndDeregister();
		}
				
		return this.generateur.getValue();
	}	
}
