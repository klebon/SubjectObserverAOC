package userGenerateur;

import java.util.Observable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Generateur extends Observable {
	
	private boolean run;
	private int value;
	private AlgoDiffusion algoDiffusion;
	
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
		while(this.isRun()) {
			try {
				Thread.sleep(1500);
			}catch(Exception e) {
				e.printStackTrace();
			}
			value++;
			this.setChanged();
			notifyObservers(this.value);
			algoDiffusion.execute(this);
		}
	}

	public AlgoDiffusion getAlgoDiffusion() {
		return algoDiffusion;
	}

	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion) {
		this.algoDiffusion = algoDiffusion;
	}
}
