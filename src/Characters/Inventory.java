package Characters;

import Weapons.Weapon;
import Weapons.Fist;

public class Inventory {
    private Weapon weapon;

    public Inventory() {
        this.weapon = new Fist();
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
