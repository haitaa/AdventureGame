package Characters;

import java.util.Scanner;
import Locations.Location;
import Locations.SafeHouse;
import Locations.ToolStore;

public class Player {
    final Scanner input = new Scanner(System.in);
    private String charName;
    private int damage;
    private int healthy;
    private int money;
    private String name;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Character[] list = {new Samurai(), new Archer(), new Knight()};
        System.out.println("-----------------------------------------");
        System.out.println("| Karakter | ID | Hasar | Sağlık | Para |");
        for (Character character: list) {
            System.out.println("| " + character.getName() + " | " + character.getId() + " | " + character.getDamage() + " | " + character.getHealth() + " | " + character.getMoney() + " | ");
        }
        System.out.println("----------------------------------------");
        System.out.print("Bir karakter seçiniz (1, 2, 3): ");
        int selectChar = input.nextInt();
        switch(selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Geçerli bir değer giriniz.");
                break;
        }
        printInfo();
    }


    public void initPlayer(Character character) {
        this.setDamage(character.getDamage());
        this.setHealthy(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharName(character.getName());
    }

    public void printInfo() {
        System.out.println(
                "Silahınız: " + this.getInventory().getWeapon().getName() +
                ", Zırh: " + this.getInventory().getArmor().getArmor() +
                ", Bloklama: " + this.getInventory().getArmor().getBlock() +
                ", Hasarınız: " + this.getDamage() +
                ", Sağlık: " + this.getHealthy() +
                ", Para: " + this.getMoney());
    }

    public String getCharName() {
        return this.charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getDamage() {
        return this.damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return this.healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
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

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
