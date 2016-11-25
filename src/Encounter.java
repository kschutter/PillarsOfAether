
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 * @author kschutter
 *
 */
public class Encounter extends JFrame {
	
	//Final variables
	private static final long serialVersionUID = 1L;
	private static final int TEXT_WIDTH = 35;
	private static final int TEXT_HEIGHT = 18;
	protected static final Font BUTTONFONT = new Font("Button Font", Font.PLAIN, 36);
	
	//instance variables
	protected JPanel panel;
	protected JPanel buttonPanel;
	protected JButton[] choices = new JButton[8];
	protected static JLabel name;
	protected static JTextArea desc;
	protected static String[] details;
	protected static Encounter formattedPanel;
	
	/**
	 * 
	 * @param encounterID designates the scene
	 * @throws FileNotFoundException
	 */
	public Encounter(String encounterID) {
		Scanner in = new Scanner(System.in);
		try {
			in.close();
			in = new Scanner(new File("encounters.txt"));
		} 
		catch (FileNotFoundException e) {
			System.out.print("Have you removed the encounters.txt file?");
		}
		
		//split on "|", finding the line with the given ID
		do {
			details = in.nextLine().split("\\|");
		} while (!details[0].equals(encounterID));
		
		name = new JLabel(details[1]);
		name.setFont(new Font(name.getName(), Font.PLAIN, 48));
		
		createPanel();
		in.close();
	}
	
	/**
	 * 
	 * @param encounterID designates the scene
	 * @return the panel to add to the main frame
	 * @throws FileNotFoundException
	 */
	public static void startEncounter(String encounterID, Game run){
		switch (encounterID.substring(0,5)) {
			case "fight": formattedPanel = new Fight(encounterID);
				break;
			case "title": formattedPanel = new TitleScreen();
				break;
			default: throw new IllegalArgumentException(encounterID + " is not legal");
		}
		run.clearPanel();
		run.current = formattedPanel.panel;
		run.add(run.current);
		run.pack();
	}
	
	//create panel to return
	public void createPanel() {
		panel = new JPanel();
		panel.setVisible(true);
		panel.add(name, BorderLayout.NORTH);
		
		desc = new JTextArea(TEXT_HEIGHT,TEXT_WIDTH);
		desc.setPreferredSize(desc.getSize());
		desc.setEditable(false);
		desc.setFont(new Font(name.getName(), Font.PLAIN, 36));
		desc.setLineWrap(true);
		desc.setWrapStyleWord(true);
		panel.add(desc, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		buttonPanel.setVisible(true);
		buttonPanel.setLayout(new GridLayout(2, 8));
		panel.add(buttonPanel, BorderLayout.SOUTH);
	}
}
