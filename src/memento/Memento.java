package memento;

import userGenerateur.Generateur;

/**
 * 
 * @author miola, sefacene
 * 
 * Pattern Memento, rôle Memento
 */
public class Memento {
	
	private Generateur state;

    public Memento(Generateur s) {
        this.state = s;
    }

    public Generateur getState() {
        return state;
    }

}
