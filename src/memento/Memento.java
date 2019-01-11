package memento;

import userGenerateur.Generateur;

public class Memento {
	
	private Generateur state;

    public Memento(Generateur s) {
        this.state = s;
    }

    public Generateur getState() {
        return state;
    }

}
