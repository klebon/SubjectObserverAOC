package userGenerateur;

import java.util.Observable;
import java.util.concurrent.Phaser;

/**
 * 
 * @author miola, sefacene
 *
 */
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

	/**
	 * initiatise le générateur, incrémente sa valeur et la diffuse 
	 * tant que l'utilisateur n'a pas appuyé sur le boutton stop 
	 */
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
