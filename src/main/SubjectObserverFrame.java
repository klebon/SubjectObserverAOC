package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.*;
import javax.swing.border.Border;

import userGenerateur.AlgoDiffusion;
import userGenerateur.DiffusionAtomique;
import userGenerateur.DiffusionCausale;
import userGenerateur.DiffusionSequentielle;
import userGenerateur.Generateur;
import userInterface.Afficheur;
import userProxy.Canal;

public class SubjectObserverFrame extends JFrame {

	public SubjectObserverFrame() {
		Generateur g = new Generateur();
		AlgoDiffusion algDiffAtomique = new DiffusionAtomique();
		AlgoDiffusion algDiffSequentielle = new DiffusionSequentielle();
		AlgoDiffusion algDiffCausale = new DiffusionCausale();
		
		String[] tabAlgDiff = {"Atomique", "Sequentielle", "Causale"};
		
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
		Canal c1 = new Canal();
		Afficheur a1 = new Afficheur();
		Canal c2 = new Canal();
		Afficheur a2 = new Afficheur();
		Canal c3 = new Canal();
		Afficheur a3 = new Afficheur();
		Canal c4 = new Canal();
		Afficheur a4 = new Afficheur();
		
		c1.setScheduledESI(ses);
		c2.setScheduledESI(ses);
		c3.setScheduledESI(ses);
		c4.setScheduledESI(ses);
		
		c1.setAfficheur(a1);
		a1.setCanal(c1);
		c2.setAfficheur(a2);
		a2.setCanal(c2);
		c3.setAfficheur(a3);
		a3.setCanal(c3);
		c4.setAfficheur(a4);
		a4.setCanal(c4);
		
		c1.setGenerateur(g);
		c2.setGenerateur(g);
		c3.setGenerateur(g);
		c4.setGenerateur(g);
		
		g.addObserver(c1);
		g.addObserver(c2);
		g.addObserver(c3);
		g.addObserver(c4);
		
		c1.addObserver(a1);
		c2.addObserver(a2);
		c3.addObserver(a3);
		c4.addObserver(a4);
		
		/*Partie interfaces*/
		this.setSize(600, 65);
		this.setResizable(false);
		this.setTitle("Observer parrallèle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pan = new JPanel();
		BorderLayout bl = new BorderLayout();
		
		JComboBox<String> jcb = new JComboBox<String>(tabAlgDiff);
		jcb.setSelectedIndex(0);
		g.setAlgoDiffusion(algDiffAtomique);
		
		jcb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch((String) jcb.getSelectedItem()){
				case "Atomique":
					g.setAlgoDiffusion(algDiffAtomique);
					break;
				case "Sequentielle" :
					g.setAlgoDiffusion(algDiffSequentielle);
					break;
				case "Causale" :
					g.setAlgoDiffusion(algDiffCausale);
					break;		
				}
			}
		});
		
		pan.add(jcb, bl.PAGE_START);
		
		AfficheurLabel afficheur1Label = new AfficheurLabel(a1);
		a1.addObserver(afficheur1Label);
		AfficheurLabel afficheur2Label = new AfficheurLabel(a2);
		a2.addObserver(afficheur2Label);
		AfficheurLabel afficheur3Label = new AfficheurLabel(a3);
		a3.addObserver(afficheur3Label);
		AfficheurLabel afficheur4Label = new AfficheurLabel(a4);
		a4.addObserver(afficheur4Label);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		
		afficheur1Label.setBorder(border);
		afficheur2Label.setBorder(border);
		afficheur3Label.setBorder(border);
		afficheur4Label.setBorder(border);
		
		pan.add(afficheur1Label, bl.CENTER);
		pan.add(afficheur2Label, bl.CENTER);
		pan.add(afficheur3Label, bl.CENTER);
		pan.add(afficheur4Label, bl.CENTER);
		
		JButton start = new JButton("START");
		JButton stop = new JButton("STOP");
		JButton reset = new JButton("RESET");
		stop.setEnabled(false);
		reset.setEnabled(false);
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						start.setEnabled(false);
						reset.setEnabled(false);
						stop.setEnabled(true);
						g.setRun(true);
						g.run();
					}
				}.start();
			}
		});
		
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.setRun(false);
				start.setEnabled(true);
				reset.setEnabled(true);
				stop.setEnabled(false);
			}
		});
				
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.setValue(0);
				a1.setValue(0);
				a2.setValue(0);
				a3.setValue(0);
				a4.setValue(0);
				start.setEnabled(true);
				reset.setEnabled(false);
				stop.setEnabled(false);
			}
		});
		
		pan.add(start, bl.PAGE_END);
		pan.add(stop, bl.PAGE_END);
		pan.add(reset, bl.PAGE_END);
		
		this.add(pan);
	}
}
