package Monsters;

public class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int money;
    private int defHealth;

    public Obstacle(String name, int id, int damage, int health, int money) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.defHealth = health;
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId()  {
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

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if(health < 0) {
            this.health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDefHealth() {
        return this.defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

}
