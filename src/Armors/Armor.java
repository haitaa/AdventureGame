package Armors;

public abstract class Armor {
    private String armor;
    private int id;
    private int block;
    private int money;

    public Armor(String armor, int id, int block, int money) {
        this.armor = armor;
        this.id = id;
        this.block = block;
        this.money = money;
    }

    public static Armor[] armors() {
        Armor[] armors = {new LightArmor(), new MidArmor(), new HeavyArmor()};
        return armors;
    }

    public static Armor getArmorById(int id) {
        for (Armor armor: Armor.armors()) {
            if(armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }

    public String getArmor() {
        return this.armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return this.block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
