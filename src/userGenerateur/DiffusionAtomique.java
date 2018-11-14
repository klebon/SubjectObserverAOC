package userGenerateur;

import java.util.concurrent.Future;

import userProxy.Canal;

public class DiffusionAtomique implements AlgoDiffusion{

	private Canal canal;
	
	@Override
	public Future execute(Generateur g) {
		canal.update(g);
		return canal.update(g);
	}

}
