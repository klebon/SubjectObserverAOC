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
		SubjectObserverFrame sof = new SubjectObserverFrame();
		/*Generateur g = new Generateur();
		AlgoDiffusion algDiff = new DiffusionAtomique();
		Canal c = new Canal();
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
		Afficheur a = new Afficheur();
		
		g.setAlgoDiffusion(algDiff);
		
		c.setScheduledESI(ses);
		c.setAfficheur(a);
		c.setGenerateur(g);
		
		a.setCanal(c);
		
		g.addObserver(c);
		c.addObserver(a);
		
		try {
			g.run();
		}catch(Exception e) {
			System.out.println(e);
		}*/
	}

}