package userProxy;


import java.util.concurrent.Future;

import userGenerateur.Generateur;

public interface ObserverGenerateurAsync {
	
	public Future update(Generateur g);

}
