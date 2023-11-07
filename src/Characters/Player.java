package Characters;

import java.util.Scanner;

public class Player {
    final Scanner input = new Scanner(System.in);
    private String charName;
    private int damage;
    private int healthy;
    private int money;
    private String name;

    public Player(String name) {
        this.name = name;
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
        System.out.println("Karakter: " + this.getCharName() + ", Hasar: " + this.getDamage() + ", Sağlık: " + this.getHealthy() + ", Para: " + this.getMoney());
    }

    public void initPlayer(Character character) {
        this.setDamage(character.getDamage());
        this.setHealthy(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharName(character.getName());
    }

    public String getCharName() {
        return this.charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getDamage() {
        return this.damage;
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
}
