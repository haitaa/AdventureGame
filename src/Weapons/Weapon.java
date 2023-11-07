package Weapons;

public abstract class Weapon {
    private int id;
    private int damage;
    private int money;
    private String name;

    public Weapon(int id, int damage, int money, String name) {
        this.id = id;
        this.damage = damage;
        this.money = money;
        this.name = name;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = {new Pistol(), new Sword(), new Rifle()};
        return weaponList;
    }

    public static Weapon getWeaponById(int id) {
        for (Weapon w: Weapon.weapons()) {
            if(w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
