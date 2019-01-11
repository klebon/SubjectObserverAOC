package userProxy;

import java.util.Observable;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import userGenerateur.Generateur;
import userInterface.Afficheur;

public class Canal extends Observable implements ObserverGenerateurAsync {

	private Generateur generateur;
	private Generateur generateurTMP=null;
	private Afficheur afficheur;
	private ScheduledExecutorService scheduledES;
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg != null && arg.getClass().equals(Generateur.class)) {
			this.setGenerateurTMP(new Generateur((Generateur) arg));
			this.getGenerateurTMP().setAlgoDiffusion(generateur.getAlgoDiffusion());
			this.getGenerateurTMP().setPhaser(generateur.getPhaser());
		}
		
		Update u = new Update();
		u.setC(this);
		this.setChanged();
		scheduledES.schedule(u, 1000, TimeUnit.MILLISECONDS);
	}
	
	public Future getValue() {
		GetValue gv;
		if(generateurTMP!=null) {//cas sequentiel
			gv = new GetValue(generateurTMP);
		} else {//cas atomique
			gv = new GetValue(generateur);
		}
		this.setGenerateurTMP(null);
		
		return scheduledES.schedule(gv, new Random().nextInt(2000), TimeUnit.MILLISECONDS);
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

	public Generateur getGenerateurTMP() {
		return generateurTMP;
	}

	public void setGenerateurTMP(Generateur generateurTMP) {
		this.generateurTMP = generateurTMP;
	}
}
