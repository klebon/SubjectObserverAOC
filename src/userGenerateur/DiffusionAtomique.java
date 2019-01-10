package userGenerateur;

import java.util.concurrent.Phaser;

public class DiffusionAtomique implements AlgoDiffusion{
	
	@Override
	public void execute(Generateur g) {
		g.getPhaser().awaitAdvance(g.getPhaser().getPhase());
	}

}
