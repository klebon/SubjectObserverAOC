package userInterface;


import javax.swing.JFrame;

public class SubjectObserverFrame extends JFrame{
	
	private Afficheur afficheur1;
	private Afficheur afficheur2;
	private Afficheur afficheur3;
	private Afficheur afficheur4;
	
	public SubjectObserverFrame() {
		this.afficheur1 = new Afficheur();
		this.afficheur2 = new Afficheur();
		this.afficheur3 = new Afficheur();
		this.afficheur4 = new Afficheur();
		
		this.setSize(500, 500);
				
		this.setVisible(true);
	}

	public Afficheur getAfficheur1() {
		return afficheur1;
	}

	public void setAfficheur1(Afficheur afficheur1) {
		this.afficheur1 = afficheur1;
	}

	public Afficheur getAfficheur2() {
		return afficheur2;
	}

	public void setAfficheur2(Afficheur afficheur2) {
		this.afficheur2 = afficheur2;
	}

	public Afficheur getAfficheur3() {
		return afficheur3;
	}

	public void setAfficheur3(Afficheur afficheur3) {
		this.afficheur3 = afficheur3;
	}

	public Afficheur getAfficheur4() {
		return afficheur4;
	}

	public void setAfficheur4(Afficheur afficheur4) {
		this.afficheur4 = afficheur4;
	}
	
	
}
