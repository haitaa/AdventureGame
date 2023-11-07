package Locations;

import Armors.Armor;
import Characters.Player;
import Weapons.Weapon;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------- Mağazaya Hoşgeldiniz ------");
        boolean showMenu = true;
        while(showMenu) {
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
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz!");
                    showMenu = false;
                    break;
            }

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
        System.out.println("------ Zırhlar ------");
        System.out.println();
        for(Armor armor: Armor.armors()) {
            System.out.println(armor.getArmor() + " <Para: " + armor.getMoney() + ", ID: " + armor.getId() + ", Engelleme: " + armor.getBlock());
        }
    }

    public void buyArmor() {
        System.out.print("Bir zırh seçiniz: ");
        int selectArmor = input.nextInt();
        while(selectArmor < 1 || selectArmor > Armor.armors().length) {
            System.out.print("Geçersiz bir değer girdiniz. Tekrar deneyin: ");
            selectArmor = input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorById(selectArmor);
        if(selectedArmor != null) {
            if(selectedArmor.getMoney() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır.");
            } else {
                System.out.println(selectedArmor.getArmor() + " zırhını satın aldınız.");
                int newMoney = this.getPlayer().getMoney() - selectedArmor.getMoney();
                System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getArmor());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Yeni zırhınız: " + this.getPlayer().getInventory().getArmor().getArmor());
                this.getPlayer().printInfo();
            }
        }
    }
}
