import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	private static final String ARMORFILE = "Aether/armors.json";
	public static HashMap<String, Armor> armorList;

	// Armor characteristics
	public double defMod;
	public Boolean headCover;
	public Boolean legCover;
	public Boolean magicDef;
	public Boolean isMagic;

	public Armor() {}

	/**
	 * Read armors.json into weaponList
	 */
	public static void loadArmors() {

		ObjectMapper mapper = new ObjectMapper();
		Armor[] arr = new Armor[0];
		try {
			arr = mapper.readValue(new File(ARMORFILE), Armor[].class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < arr.length; i++) {
			armorList.put(arr[i].id, arr[i]);
		}
	}

	/**
	 * Load an armor object from armors.txt
	 * @param id the ID of the needed armor
	 * @return the requested Armor object
	 */
	public Armor getArmor(String id) {
		return armorList.get(id);
	}
	
	//return the damage of a strike after protection, checking if the armor covers the spot
	public int afterArmor(int dmg, String place) {
		if ((place.equals("leftLeg") || place.equals("rightLeg")) && !this.legCover)
			return dmg;
		return (int) this.defMod * dmg;
	}

	public String toString() {
		String result = super.toString();

		result += "Defense mod: " + this.defMod + "\n";
		result += "Leg Cover: " + this.legCover + "\n";
		result += "Magic Defense: " + this.magicDef + "\n";
		result += "Is Magic: " + this.isMagic + "\n";

		return result;
	}
}
