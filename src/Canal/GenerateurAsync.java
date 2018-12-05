package Canal;

import java.util.concurrent.Future;

import afficheur.ObserverGenerateur;

public interface GenerateurAsync {
	
	public void attach (ObserverGenerateur observateurGenerateur);
	public void detach (ObserverGenerateur observateurGenerateur);
	
	public Future<Integer> getValue();


}
