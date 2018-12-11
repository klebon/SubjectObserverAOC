package main;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import userInterface.Afficheur;

public class AfficheurLabel extends JLabel implements Observer {
	
	private Afficheur aff;

	public AfficheurLabel(Afficheur a) {
		this.aff=a;
		this.setText(" "+a.getValue()+" ");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.setText(" "+aff.getValue()+" ");
	}

	public Afficheur getAff() {
		return aff;
	}

	public void setAff(Afficheur aff) {
		this.aff = aff;
	}

}
