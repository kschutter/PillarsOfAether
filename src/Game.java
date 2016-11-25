import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author kschutter
 *
 */
public class Game extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private static final boolean alwaysTop = true;
	private static final Dimension GAME_SIZE = 	new Dimension(1200, 1200);
	
	public JPanel current = new JPanel();

	public Game() {
		Encounter.startEncounter("titleScreen", this);
		add(current);
		setVisible(true);
		setAlwaysOnTop(alwaysTop);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(GAME_SIZE);
		setSize(GAME_SIZE);
	}
	
	public void clearPanel() {
		this.remove(current);
	}
}
