import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * 
 * @author kschutter
 *
 */

public class Item {

	protected Item(){}

	public String id;
	public String name;
	public String description;

	public static void loadItems() {
		Weapon.loadWeapons();
		Armor.loadArmors();
	}

	public String toString() {
		String result = "";

		result += "Item ID: " + this.id + "\n";
		result += "Item Name: " + this.name + "\n";
		result += "Item Description: " + this.description + "\n";

		return result;
	}

}
