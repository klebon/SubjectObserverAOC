package userGenerateur;

import java.util.concurrent.Future;
import java.util.concurrent.Phaser;

import userProxy.Canal;

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
