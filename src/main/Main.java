package main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import userGenerateur.AlgoDiffusion;
import userGenerateur.DiffusionAtomique;
import userGenerateur.Generateur;
import userInterface.Afficheur;
import userProxy.Canal;

public class Main {

	public static void main(String[] args) {
		//SubjectObserverFrame sof = new SubjectObserverFrame();
		Generateur g = new Generateur();
		g.setValue(20);
		AlgoDiffusion algDiff = new DiffusionAtomique();
		g.setAlgoDiffusion(algDiff);
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
		Canal c = new Canal();
		c.setScheduledESI(ses);
		algDiff.setCanal(c);
		Afficheur a = new Afficheur();
		c.setAfficheur(a);
		a.setCanal(c);
		c.setGenerateur(g);
		try {
			g.start();
			a.start();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
