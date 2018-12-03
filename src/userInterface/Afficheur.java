package userInterface;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import userGenerateur.Generateur;
import userProxy.Canal;

public class Afficheur extends Thread implements ObserverGenerateur {
	private int value;
	private Canal canal;
	
	public Afficheur() {
		this.value=-1;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public void update(Generateur g) throws InterruptedException, ExecutionException {
		value = (int) canal.getValue().get();
	}
	
	public void run() {
		while(true) {
			try {
				this.update();
				System.out.println("afficheur : "+value);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
