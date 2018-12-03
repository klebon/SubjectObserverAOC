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
	
	@Override
	public Future update(Generateur g) {
		
		Update u = new Update();
		u.setA(afficheur);
		
		Future f = (Future) scheduledES.schedule(u, 700, TimeUnit.MILLISECONDS);
		try{
			u.setG(new Generateur(generateur));
			f = (Future) u.call();
			System.out.println("canal -> update : "+f.get().toString());
		}catch(Exception e) {
			
		}
		return f;
	}
	
	@Override
	public Future getValue() {
		GetValue gv = new GetValue();
		gv.setG(generateur);
		System.out.println("appel getvalue");

		Future f2 = (Future) scheduledES.schedule(gv, 700, TimeUnit.MILLISECONDS);
		try{
			f2 = scheduledES.submit(gv);
			System.out.println("canal -> getvalue : "+Integer.parseInt(f2.get().toString()));
		}catch(Exception e) {
			System.out.println(e);
		}
		return f2;
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
