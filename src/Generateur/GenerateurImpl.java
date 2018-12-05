package Generateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Canal.ObserverGenerateurAsync;
import diffusion.AlgoDiffusion;


public class GenerateurImpl extends Observable implements Generateur {

	private AlgoDiffusion algoDif;
	private int value = 0;
	private List <ObserverGenerateurAsync> observers = new ArrayList<ObserverGenerateurAsync>();

	
	
	@Override
	public void attach(ObserverGenerateurAsync observer) {
			observers.add(observer);
		
	}
	
	@Override
	public void detach(ObserverGenerateurAsync observer) {
		if (observers.contains(observer)){
			observers.remove(observer);
		}
		
	}
	
	@Override
	public void run() {
			value ++;
			setChanged();
			notifyObservers(value);
			this.algoDif.execute();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
	}
	
	@Override
	public Integer getValue(ObserverGenerateurAsync obsGenerateurAsync) {
		return this.value;
	}

	public AlgoDiffusion getAlgoDif() {
		return algoDif;
	}
	
	public void setAlgoDif(AlgoDiffusion algoDif) {
		this.algoDif = algoDif;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public List<ObserverGenerateurAsync> getObservers() {
		return observers;
	}
	
	public void setObservers(List<ObserverGenerateurAsync> observers) {
		this.observers = observers;
	}

	
}
