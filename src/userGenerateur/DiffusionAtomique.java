package userGenerateur;

import java.util.concurrent.Future;

import userProxy.Canal;

public class DiffusionAtomique implements AlgoDiffusion{

	private Canal canal;
	
	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	@Override
	public Future execute(Generateur g) {
		return canal.update(g);
	}

}
