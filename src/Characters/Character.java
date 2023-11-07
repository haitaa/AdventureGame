public class Character {
    private int damage;
    private int health;
    private int money;

    public Character(int damage, int health, int money) {
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
