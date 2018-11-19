package userGenerateur;

import java.util.concurrent.Future;

import userProxy.Canal;

public interface AlgoDiffusion {
	
	public Future execute(Generateur g);
	
	public void setCanal(Canal c);
}
