package Monsters;

public class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;

    public Obstacle(String name, int id, int damage, int health) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
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
        this.health = health;
    }
}
