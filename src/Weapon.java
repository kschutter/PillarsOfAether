import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author kschutter
 *
 */
public class Weapon extends Item {

	private static String WEAPONFILE = "Aether/weapons.txt";

	private HashMap<String, String> details;

	/**
	 * @param details a hashmap of all characteristics of this item
	 */
	private Weapon(HashMap<String, String> details) {
		super(details);
	}
	
	// load the designated weapon from weapons.txt
	public static Weapon loadWeapon(String weapID) {
		return (Weapon) loadItem(weapID, WEAPONFILE);
	}
	
	// getters and setters
	public Boolean getIsRanged() {
		return Boolean.valueOf(details.get("isRanged"));
	}
	public String getDmgStat() {
		return details.get("dmgStat");
	}
	public double getDmgMod() {
		return Double.parseDouble(details.get("dmgMod"));
	}
	public void setDmgMod(String newDmgMod) {
		details.put("dmgMod", newDmgMod);
	}
	public String getDmgType() {
		return details.get("dmgType");
	}
}
