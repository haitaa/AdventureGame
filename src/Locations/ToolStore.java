package Locations;

import Characters.Player;
import Weapons.Weapon;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------- Mağazaya Hoşgeldiniz ------");
        System.out.println("1- Silahlar");
        System.out.println("2- Zırhlar");
        System.out.println("3- Çıkış Yap");
        System.out.print("Bir işlem seçiniz: ");
        int selectCase = input.nextInt();
        while(selectCase < 1 || selectCase > 4) {
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectCase = input.nextInt();
        }
        switch(selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Bir daha bekleriz!");
                return true;
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("----- Silahlar -----");
        System.out.println();
        for (Weapon w: Weapon.weapons()) {
            System.out.println(w.getName() + " <Para: " + w.getMoney() + ", ID: " + w.getId() + ", Hasar: " + w.getDamage() + ">");
        }
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz: ");
        int selectWeapon = input.nextInt();
        while(selectWeapon < 1 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectWeapon = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponById(selectWeapon);
        if(selectedWeapon != null) {
            if(selectedWeapon.getMoney() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır.");
            } else {
                // Satın almanın gerçekleştiği alan
                System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                int newMoney = this.getPlayer().getMoney() - selectedWeapon.getMoney();
                this.getPlayer().setMoney(newMoney);
                System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().printInfo();
            }
        }
    }

    public void printArmor() {
        System.out.println("Zırhlar");
    }
}
