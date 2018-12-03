package userGenerateur;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Generateur extends Thread{
	
	private int value;
	private AlgoDiffusion algoDiffusion;
	
	public Generateur() {
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
	
	public void run() {
		Future f = algoDiffusion.execute(this);
		try {
			System.out.println("generateur : "+f.get().toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public AlgoDiffusion getAlgoDiffusion() {
		return algoDiffusion;
	}

	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion) {
		this.algoDiffusion = algoDiffusion;
	}
}
