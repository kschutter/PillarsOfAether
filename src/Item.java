import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author kschutter
 *
 */

public class Item {
	
	//final vars
	private static int ITEMID = 0, NAME = 1, DESC = 2;
	
	private HashMap<String, String> details;

	protected Item(HashMap<String, String> details) {
		this.details = details;
	}

	protected Item(){}

	//load the designated weapon from weapons.txt
	protected static Item loadItem(String itemID, String fileName) {
		Scanner in = new Scanner(System.in);
		Item target = new Item();

		try {
			in = new Scanner(new File(fileName));
		}
		catch (FileNotFoundException e) {
			System.out.println("Did you move " + fileName + "?");
		}

		//find and parse the given item
		HashMap<String, String> map = new HashMap<String, String>();

		//skims through the file until it finds the correct item
//		try {
		while (!in.nextLine().equals("itemID = " + itemID)) {}
//		} catch (NoSuchLineException e) {
//
//		}
		map.put("itemID", itemID);
		String[] line = in.nextLine().split(" = ");
		while (!line.equals("")) {
			map.put(line[0], line[1]);
		}

		target = new Item(map);
		return target;
	}

	public String getName() {
		return details.get("name");
	}
	public void setName(String newName) {
		details.put("name", newName);
	}
	public String getItemID() {
		return details.get("itemID");
	}
	public Boolean getIsMagic() {
		return Boolean.valueOf(details.get("isMagic"));
	}
	public void setIsMagic(Boolean isMagic) {
		details.put("isMagic", String.valueOf(isMagic));
	}
	public String getDesc() {
		return details.get("desc");
	}
	public void setDesc(String newDesc) {
		details.put("desc", newDesc);
	}
}
