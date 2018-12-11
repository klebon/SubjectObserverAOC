package userGenerateur;

import java.util.concurrent.Future;

import userProxy.Canal;

public class DiffusionAtomique implements AlgoDiffusion{

	@Override
	public void execute(Generateur g) {
		g.notifyObservers();
	}

}
