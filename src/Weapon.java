import java.io.File;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author kschutter
 *
 */
public class Weapon extends Item {

	private static final String WEAPONFILE = "Aether/weapons.json";
	public static HashMap<String, Weapon> weaponList = new HashMap<>();

	// Weapon characteristics
	public Boolean isTwoHanded;
	public Boolean isRanged;
	public double dmgMod;
	public String dmgStat;
	public String dmgType;
	public Boolean isMagic;

	public Weapon() {}

    /**
     * Read weapons.json into weaponList
     */
	public static void loadWeapons() {

		ObjectMapper mapper = new ObjectMapper();
		Weapon[] arr = new Weapon[0];
		try {
			arr = mapper.readValue(new File(WEAPONFILE), Weapon[].class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < arr.length; i++) {
			weaponList.put(arr[i].id, arr[i]);
		}
	}

    /**
     * Return the designated weapon from weapon list
     * @param id the ID of the requested item
     */
	public static Weapon getWeapon(String id) {
		return weaponList.get(id);
	}

	/**
	 * Overrides toString()
	 * @return A string representation of the object
	 */
	public String toString() {
		String result = super.toString();

		result += "Is two handed: " + this.isTwoHanded + "\n";
		result += "Is ranged: " + this.isRanged + "\n";
		result += "Damage Modifier: " + this.dmgMod + "\n";
		result += "Damage Stat: " + this.dmgStat + "\n";
		result += "Damage Type: " + this.dmgType + "\n";
		result += "Is magic: " + this.isMagic + "\n";

		return result;
	}
}
