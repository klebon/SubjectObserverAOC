package userGenerateur;

/**
 * 
 * @author miola, sefacene
 * 
 */
public class DiffusionAtomique implements AlgoDiffusion{
	
	@Override
	public void execute(Generateur g) {
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		g.notifyObservers();
		g.getPhaser().awaitAdvance(g.getPhaser().getPhase());
	}

}
