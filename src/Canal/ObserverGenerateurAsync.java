package Canal;

import java.util.concurrent.Future;

import Generateur.Generateur;


public interface ObserverGenerateurAsync {
	
	public Future <Object> update (Generateur generateur);


}
