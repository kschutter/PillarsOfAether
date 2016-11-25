import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author kschutter
 *
 */
public class Weapon extends Item {
	
	private Boolean isRanged;
	private double dmgMod;
	private String dmgStat;
	private String dmgType;
	private Boolean isMagic;
	
	//test weapon will default to fist
	private Weapon(String itemID, String name, Boolean isRanged, double dmgMod, 
			String dmgStat, String dmgType, Boolean isMagic) {
		this.name = name;
		this.isRanged = isRanged;
		this.dmgMod = dmgMod;
		this.dmgStat = dmgStat;
		this.dmgType = dmgType;
		this.isMagic = isMagic;
	}
	
	//load the designated weapon from weapons.txt
	public Weapon loadWeapon(String weapID) {
		itemID = weapID;
		Scanner in = new Scanner(System.in);
		try {
			in.close();
			in = new Scanner(new File("weapons.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("Did you move weapons.txt?");
		}
		
		//find and parse the given weapon
		String[] str;
		do {
			str = in.next().split("|");
		} while (!str[0].equals(weapID));
		
		return new Weapon(str[0], str[1], Boolean.parseBoolean(str[2]),
				Double.parseDouble(str[3]), str[4], str[5], 
				Boolean.parseBoolean(str[6]));
	}
	
	//
	
	public String getName() {
		return name;
	}
	public Boolean getIsRanged() {
		return isRanged;
	}
	public String getDmgStat() {
		return dmgStat;
	}
	public double getDmgMod() {
		return dmgMod;
	}
	public String getDmgType() {
		return dmgType;
	}
	
	public Boolean getIsMagic() {
		return isMagic;
	}
	public void setIsMagic(Boolean isMagic) {
		this.isMagic = isMagic;
	}
}
