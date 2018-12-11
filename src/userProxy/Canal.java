package userProxy;

import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import userGenerateur.Generateur;
import userInterface.Afficheur;

public class Canal extends Observable implements ObserverGenerateurAsync, GenerateurAsync {

	private Generateur generateur;
	private Afficheur afficheur;
	private ScheduledExecutorService scheduledES; 
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("canal notified");
		Update u = new Update();
		u.setC(this);
		this.setChanged();
		scheduledES.schedule(u, 700, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public Future getValue() {
		GetValue gv = new GetValue();
		gv.setG(generateur);

		return scheduledES.schedule(gv, 700, TimeUnit.MILLISECONDS);
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
