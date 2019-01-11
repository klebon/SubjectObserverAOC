package userGenerateur;

import java.util.Observable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Phaser;

public class Generateur extends Observable {
	
	private boolean run;
	private int value;
	private AlgoDiffusion algoDiffusion;
	private Phaser ph;
	
	public Generateur() {
		this.run=false;
		this.value=0;
	}
	
	public Generateur(Generateur g) {
		this.value=g.getValue();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}

	public void run() {
		this.setPhaser(new Phaser(4));
		
		//initialisation diffusion sequentielle et causale
		if(this.getAlgoDiffusion().getClass().equals(DiffusionSequentielle.class)
				|| this.getAlgoDiffusion().getClass().equals(DiffusionCausale.class)) {
			this.getPhaser().forceTermination();
		}
		
		while(this.isRun()) {
			value++;
			this.setChanged();
			algoDiffusion.execute(this);
		}
	}

	public AlgoDiffusion getAlgoDiffusion() {
		return algoDiffusion;
	}

	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion) {
		this.algoDiffusion = algoDiffusion;
	}

	public Phaser getPhaser() {
		return ph;
	}

	public void setPhaser(Phaser ph) {
		this.ph = ph;
	}
}
