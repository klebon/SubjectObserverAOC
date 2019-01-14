package userGenerateur;

import java.util.concurrent.Phaser;

/**
 * 
 * @author miola, sefacene
 *
 */
public class DiffusionSequentielle implements AlgoDiffusion{

	@Override
	public void execute(Generateur g) {
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(g.getPhaser().isTerminated()) {
			g.setPhaser(new Phaser(4));
			Generateur gCopie = new Generateur(g);
			g.notifyObservers(gCopie);
		}		
	}
}
