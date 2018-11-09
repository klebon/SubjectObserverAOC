package userInterface;

public class Afficheur extends Thread implements ObserverGenerateur {
	private int value;
	
	public Afficheur() {
		this.value=-1;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
