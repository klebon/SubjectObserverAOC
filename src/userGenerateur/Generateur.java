package userGenerateur;

import userProxy.Canal;

public class Generateur extends Thread{
	
	private int value;
	private Canal canal;
	
	public Generateur() {
		this.value=0;
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
	
	public void run() {
		
	}
	

}
