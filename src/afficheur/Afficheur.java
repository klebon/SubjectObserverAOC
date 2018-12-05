package afficheur;

import java.util.Observable;
import java.util.concurrent.ExecutionException;

import Canal.GenerateurAsync;

public class Afficheur extends Observable implements ObserverGenerateur {

	private int value;
	
	
	@Override
	public void update(GenerateurAsync genAsync) {
		
		try {
			value = genAsync.getValue().get();
			setChanged();
			notifyObservers(value);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
