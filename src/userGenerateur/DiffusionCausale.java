package userGenerateur;

import java.util.concurrent.Future;
import java.util.concurrent.Phaser;
import memento.*;

import userProxy.Canal;

public class DiffusionCausale implements AlgoDiffusion{
	
	private Caretaker caretaker;
	private Originator originator;
	
	public DiffusionCausale() {
		this.setCaretaker(new Caretaker());
		this.setOriginator(new Originator());
	}

	@Override
	public void execute(Generateur g) {
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		originator.setState(g);
		caretaker.addMemento(originator.save());
		g.notifyObservers(caretaker.getMemento());
	}

	public Caretaker getCaretaker() {
		return caretaker;
	}

	public void setCaretaker(Caretaker caretaker) {
		this.caretaker = caretaker;
	}

	public Originator getOriginator() {
		return originator;
	}

	public void setOriginator(Originator originator) {
		this.originator = originator;
	}
}

