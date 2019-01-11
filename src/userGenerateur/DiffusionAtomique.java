package userGenerateur;

import java.util.concurrent.Phaser;

public class DiffusionAtomique implements AlgoDiffusion{
	
	@Override
	public void execute(Generateur g) {
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		g.notifyObservers();
		g.getPhaser().awaitAdvance(g.getPhaser().getPhase());
	}

}
