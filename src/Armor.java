import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author kschutter
 *
 */
public class Armor extends Item {
	
	private static final int ITEMID = 0, NAME = 1, DEFMOD = 2, HEADCOVER = 3,
			LEGCOVER = 4, BLUDG = 5, SLASH = 6, PIERCE = 7, MAGICDEF = 8, 
			ISMAGIC = 9, DESC = 10;
	
	private double defMod;
	private Boolean headCover, legCover, bludg, slash, pierce, magicDef, isMagic;
	
	private Armor(String itemID, String name, double defMod, Boolean headCover,
			Boolean legCover, Boolean bludg, Boolean slash, Boolean pierce, 
			Boolean magicDef, Boolean isMagic, String desc) {
		this.itemID = itemID;
		this.name = name;
		this.defMod = defMod;
		this.headCover = headCover;
		this.legCover = legCover;
		this.bludg = bludg;
		this.slash = slash;
		this.pierce = pierce;
		this.magicDef = magicDef;
		this.isMagic = isMagic;
		this.desc = desc;
	}
	
	public Armor loadArmor(String itemID) {
		this.itemID = itemID;
		Scanner in = new Scanner(System.in);
		try {
			in.close();
			in = new Scanner(new File("armors.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("Did you move armors.txt?");
		}
		
		//find and parse the given armor
		String[] str;
		do {
			str = in.next().split("|");
		} while (!str[0].equals(itemID));
		
		return new Armor(str[ITEMID], str[NAME], Double.parseDouble(str[DEFMOD]),
				Boolean.parseBoolean(str[HEADCOVER]), Boolean.parseBoolean(str[LEGCOVER]),
				Boolean.parseBoolean(str[BLUDG]), Boolean.parseBoolean(str[SLASH]),
				Boolean.parseBoolean(str[PIERCE]), Boolean.parseBoolean(str[MAGICDEF]),
				Boolean.parseBoolean(str[ISMAGIC]), str[DESC]);
	}
	
	//return the damage of a strike after protection, checking if the armor covers the spot
	public int afterArmor(int dmg, String place) {
		if ((place.equals("leftLeg") | place.equals("rightLeg")) && !this.legCover)
			return dmg;
		return (int) this.defMod * dmg;
	}

	public String getitemID() {
		return itemID;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getDefMod() {
		return defMod;
	}
	public void setDefMod(double defMod) {
		this.defMod = defMod;
	}

	public Boolean getHeadCover() {
		return headCover;
	}
	public Boolean getLegCover() {
		return legCover;
	}
	public Boolean getBludg() {
		return bludg;
	}
	public Boolean getSlash() {
		return slash;
	}
	public Boolean getPierce() {
		return pierce;
	}

	public Boolean getMagicDef() {
		return magicDef;
	}
	public void setMagicDef(Boolean magicDef) {
		this.magicDef = magicDef;
	}

	public Boolean getIsMagic() {
		return isMagic;
	}
	public void setIsMagic(Boolean isMagic) {
		this.isMagic = isMagic;
	}
}
