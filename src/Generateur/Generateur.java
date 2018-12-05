package Generateur;

import Canal.ObserverGenerateurAsync;

public interface Generateur {
	
	void attach (ObserverGenerateurAsync observer);
	void detach (ObserverGenerateurAsync observer);
	void run();
	
	Integer getValue(ObserverGenerateurAsync obsGenerateurAsync);
	
}
