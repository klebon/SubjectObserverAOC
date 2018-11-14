package userGenerateur;

import userProxy.Canal;

public class Generateur extends Thread{
	
	private int value;
	private Canal canal;
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
	
	public void execute() {
		algoDiffusion.execute(this);
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	
	public void run() {
		
	}

	public AlgoDiffusion getAlgoDiffusion() {
		return algoDiffusion;
	}

	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion) {
		this.algoDiffusion = algoDiffusion;
	}
	

}
