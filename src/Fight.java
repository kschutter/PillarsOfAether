

/**
 * 
 * @author kschutter
 *
 */
public class Fight extends Encounter{

	private static final long serialVersionUID = 1L;
	
	private static final int ENCOUNTERID = 0, DESCRIPTION = 2;
	
	public Fight(String encounterID){
		super(encounterID);
		name.setText("You are fighting " + name.getText());
		desc.append("\n" + details[DESCRIPTION]);
	}

}
