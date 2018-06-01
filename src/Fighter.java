import java.util.ArrayList;

/**
 * 
 * @author kschutter
 * description: class of one who fights, either the PC or a mob
 *
 */
class Fighter {
	
	//final vars
	private static final int[] LVLEXP = {300,900,2700,6500,14000,23000,
										34000,48000,64000,85000,100000,
										120000,140000,165000,195000,
										225000,265000,305000,355000};
	
	//Stat variables
	private int str;
	private int inte;
	private int dex;
	private int chari;
	private int con;
	
	private int lvl;
	private int exp;
	
	//health variables
	private int maxHP;
	private int currentHP;
	private int headHP;
	private int torsoHP;
	private int rightArmHP;
	private int leftArmHP;
	private int rightLegHP;
	private int leftLegHP;
	
	//equipment
	private Weapon primary;
	private Weapon offhand;
	
	//inventory
	private ArrayList<Item> inventory;
	
	//test fighter lvl 0 with avg stats
	public Fighter() {
		str = 10;
		inte = 10;
		dex = 10;
		chari = 10;
		con = 10;
		maxHP = 20;
		lvl = 0;
		
		setPrimary(Weapon.getWeapon("fists"));
	}
	
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getInte() {
		return inte;
	}
	public void setInte(int inte) {
		this.inte = inte;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getChari() {
		return chari;
	}
	public void setChari(int chari) {
		this.chari = chari;
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	public int getTorsoHP() {
		return torsoHP;
	}
	public void setTorsoHP(int torsoHP) {
		this.torsoHP = torsoHP;
	}
	public int getRightArmHP() {
		return rightArmHP;
	}
	public void setRightArmHP(int rightArmHP) {
		this.rightArmHP = rightArmHP;
	}
	public int getLeftArmHP() {
		return leftArmHP;
	}
	public void setLeftArmHP(int leftArmHP) {
		this.leftArmHP = leftArmHP;
	}
	public int getRightLegHP() {
		return rightLegHP;
	}
	public void setRightLegHP(int rightLegHP) {
		this.rightLegHP = rightLegHP;
	}
	public int getLeftLegHP() {
		return leftLegHP;
	}
	public void setLeftLegHP(int leftLegHP) {
		this.leftLegHP = leftLegHP;
	}

	public int getLvl() {
		return lvl;
	}

	public int getExp() {
		return exp;
	}
	
	//add exp, then commence leveling process if enough exp is reached
	public void addExp(int exp) {
		this.exp += exp;
		if (this.exp > LVLEXP[this.lvl+1])
			levelUp();
	}
	
	//Level up
	public void levelUp() {
	}
	
	public Weapon getPrimary() {
		return primary;
	}
	public void setPrimary(Weapon primary) {
		this.primary = primary;
	}

	public Weapon getOffhand() {
		return offhand;
	}
	public void setOffhand(Weapon offhand) {
		this.offhand = offhand;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public void addToInventory(Item newItem) {
		this.inventory.add(newItem);
	}

}
