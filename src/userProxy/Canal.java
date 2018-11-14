package userProxy;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import userGenerateur.Generateur;
import userInterface.Afficheur;

public class Canal implements ObserverGenerateurAsync, GenerateurAsync {

	private Generateur generateur;
	private Afficheur afficheur;
	private ScheduledExecutorService scheduledES; 
	
	
	public Future getValue() {
		return null;
	}
	
	@Override
	public Future update(Generateur g) {
		Callable mi = new Update();
		Future f = (Future) scheduledES.schedule(mi, 700, TimeUnit.MILLISECONDS);
		return f;			
	}
	
	public Generateur getGenerateur() {
		return generateur;
	}

	public void setGenerateur(Generateur generateur) {
		this.generateur = generateur;
	}

	public Afficheur getAfficheur() {
		return afficheur;
	}

	public ScheduledExecutorService getScheduledESI() {
		return scheduledES;
	}

	public void setScheduledESI(ScheduledExecutorService scheduledES) {
		this.scheduledES = scheduledES;
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}
	
	

	
}
