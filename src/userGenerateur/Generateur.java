package userGenerateur;

import java.util.concurrent.Future;


public class Generateur extends Thread{
	
	private int value;
	private AlgoDiffusion algoDiffusion;
	
	public Generateur() {
		this.value=0;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void run() {
		Future f = algoDiffusion.execute(this);
	}

	public AlgoDiffusion getAlgoDiffusion() {
		return algoDiffusion;
	}

	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion) {
		this.algoDiffusion = algoDiffusion;
	}
	

}
