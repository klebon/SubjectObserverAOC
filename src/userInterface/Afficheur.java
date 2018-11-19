package userInterface;

import java.util.concurrent.Future;

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

	public Future update() {
		return canal.getValue();
	}
	
	
}
