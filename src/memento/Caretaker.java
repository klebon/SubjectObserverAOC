package memento;

import java.util.ArrayList;

/**
 * 
 * @author miola, sefacene
 * 
 * Pattern Memento : rôle Caretaker
 */
public class Caretaker {
    private ArrayList<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public Memento getMemento() {
        return mementos.get(mementos.size()-1);
    }
}
