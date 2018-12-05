package Canal;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import Generateur.Generateur;
import afficheur.ObserverGenerateur;


public class Canal implements ObserverGenerateurAsync, GenerateurAsync {

	private ObserverGenerateur observerGenerateur; 
	private Generateur generateur;
	private ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(4);
	
	
	@Override
	public Future<Integer> getValue() {
		ScheduledFuture<Integer> f = this.scheduledExecutorService.schedule(new GetValue(this.generateur, this), 
					7000, TimeUnit.MILLISECONDS);
		return f;
	}


	@Override
	public Future<Object> update(Generateur generateurs) {
		this.generateur = generateurs;
		return this.scheduledExecutorService.schedule(new Update(this, this.observerGenerateur), 
				7000, TimeUnit.MILLISECONDS);
	}


	@Override
	public void attach(ObserverGenerateur observateurGenerateur) {
		this.observerGenerateur = observateurGenerateur;
		
	}

	@Override
	public void detach(ObserverGenerateur observateurGenerateur) {
		this.observerGenerateur = null;
		
	}


	
}
