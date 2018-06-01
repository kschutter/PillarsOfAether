import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author kschutter
 *
 */
public class Fight extends Encounter{

	private static final long serialVersionUID = 1L;
	
	public Fight(String encounterID){
		super(encounterID);
		createButtons();
		name.setText("You are fighting " + name.getText());
		desc.append("\n" + details.get("desc"));
	}
	
	public void createButtons() {
		choices[0] = new JButton(Game.self.getPrimary().name);
		choices[1] = new JButton("Load Game");
		choices[2] = new JButton("Test Fight");
		choices[3] = new JButton("Test Fight");
		choices[4] = new JButton("Test Fight");
		choices[5] = new JButton("Test Fight");
		
		for (int i = 0; i < 5; i++) {
			choices[i].setFont(new Font(name.getName(), Font.PLAIN, 24));
			choices[i].setEnabled(true);
			//choices[i].addActionListener(new ButtonListener());
			choices[i].setFont(BUTTONFONT);
			buttonPanel.add(choices[i]);
		}
	}

}
