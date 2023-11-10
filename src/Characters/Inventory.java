package Characters;

import Armors.Leaf;
import Weapons.Weapon;
import Weapons.Fist;
import Armors.Armor;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private int food;
    private int firewood;
    private int water;

    public Inventory() {
        this.weapon = new Fist();
        this.armor = new Leaf();
        this.food = 0;
        this.firewood = 0;
        this.water = 0;
    }

    public int completeCave() {
        System.out.println("Mağara görevi başarıyla tamamlanmıştır!");
        return this.food;
    }

    public int completeForest() {
        System.out.println("Orman görevi başarıyla tamamlanmıştır!");
        return this.firewood;
    }

    public int completeRiver() {
        System.out.println("Nehir görevi başarıyla tamamlanmıştır!");
        return this.water;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getFood() {
        return this.food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFirewood() {
        return this.firewood;
    }

    public void setFirewood(int firewood) {
        this.firewood = firewood;
    }

    public int getWater() {
        return this.water;
    }

    public void setWater(int water) {
        this.water = water;
    }

}
