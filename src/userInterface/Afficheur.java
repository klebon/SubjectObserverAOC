package userInterface;

import java.util.Observable;
import userProxy.Canal;

/**
 * 
 * @author miola, sefacene
 *
 */
public class Afficheur extends Observable implements ObserverGenerateur {
	private int value;
	private Canal canal;
	
	public Afficheur() {
		this.value=0;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		this.setChanged();
		this.notifyObservers();
	}
	
	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	/**
	 * notifie l'AfficheursLabel qu'il peut actualiser sa valeur
	 */
	@Override
	public void update(Observable o, Object arg) {
		try {
			value = (int) canal.getValue().get();
			this.setChanged();
			this.notifyObservers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
