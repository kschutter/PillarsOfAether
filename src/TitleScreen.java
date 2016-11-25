import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * @author kschutter
 *
 */
public class TitleScreen extends Encounter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//option buttons
	
	public TitleScreen() {
		super("titleScreen");
		createButtons();
		desc.append("Welcome!");
	}
	
	//create option buttons
	private void createButtons() {
		choices[0] = new JButton("New Game");
		choices[1] = new JButton("Load Game");
		choices[2] = new JButton("Test Fight");
		
		for (int i = 0; i < 3; i++) {
			choices[i].setFont(new Font(name.getName(), Font.PLAIN, 24));
			choices[i].setEnabled(true);
			choices[i].addActionListener(new ButtonListener());
			choices[i].setFont(BUTTONFONT);
			buttonPanel.add(choices[i]);
		}
	}
	
	//button listeners
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getText()) {
				case ("New Game"): System.out.println("Not implemented");
				break;
				case ("Load Game"): System.out.println("Not implemented");
				break;
				case ("Test Fight"): Encounter.startEncounter("fight_test_kobold", StartGame.run);
			}
			
		}
		
	}
}
