package main;

import java.util.concurrent.ScheduledExecutorService;

import userGenerateur.AlgoDiffusion;
import userGenerateur.DiffusionAtomique;
import userGenerateur.Generateur;
import userProxy.Canal;

public class Main {

	public static void main(String[] args) {
		//SubjectObserverFrame sof = new SubjectObserverFrame();
		Generateur g = new Generateur();
		g.setValue(20);
		AlgoDiffusion algDiff = new DiffusionAtomique();
		g.setAlgoDiffusion(algDiff);
		Canal c = new Canal();
		algDiff.setCanal(c);
		ScheduledExecutorService ses;//instancier ????
		try {
			g.start();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
