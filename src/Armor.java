import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author kschutter
 *
 */
public class Armor extends Item {
	
	private static final String ARMORFILE = "Aether/armors.txt";

	private HashMap<String, String> details;

	/**
	 * @param details a hashmap of all characteristics of this item
	 */
	private Armor(HashMap<String, String> details) {
		super(details);
	}

	/**
	 * Defaults to Padded Armor
	 */
	private Armor() {
		this.details.put("itemID", "padded");
		this.details.put("name", "Padded Armor");
		this.details.put("defMod", ".9");
		this.details.put("legCover", "true");
		this.details.put("magicDef", "false");
		this.details.put("isMagic", "false");
		this.details.put("desc", "Consisting of quilted layers of cloth and batting, " +
				"this rugged suit offers little more protection than street clothes.");
	}

	/**
	 * Load an armor object from armors.txt
	 * @param itemID the ID of the needed armor
	 * @return
	 */
	public Armor loadArmor(String itemID) {
		return (Armor) loadItem(itemID, ARMORFILE);
	}
	
	//return the damage of a strike after protection, checking if the armor covers the spot
	public int afterArmor(int dmg, String place) {
		if ((place.equals("leftLeg") || place.equals("rightLeg")) && !getLegCover())
			return dmg;
		return (int) (Double.parseDouble(details.get("defMod")) * dmg);
	}

	//getters and setters
	public double getDefMod() {
		return Double.valueOf(details.get("defMod"));
	}
	public void setDefMod(double newDefMod) {
		details.put("defMod", String.valueOf(newDefMod));
	}
	public Boolean getLegCover() {
		return Boolean.valueOf(details.get("legCover"));
	}
	public Boolean getMagicDef() {
		return Boolean.valueOf(details.get("magicDef"));
	}
	public void setMagicDef(Double newMagicDef) {
		details.put("magicDef", String.valueOf(newMagicDef));
	}
}
