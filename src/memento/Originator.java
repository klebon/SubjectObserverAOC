package memento;

import userGenerateur.Generateur;

/**
 * 
 * @author miola, sefacene
 * 
 * Pattern Memento, rôle Originator
 */
public class Originator {
    private Generateur state;

    public void setState(Generateur s) {
        this.state = s;
    }

    public Memento save() {
        return new Memento(state);
    }
    
    public void restore(Memento m) {
        state = m.getState();
    }
}
