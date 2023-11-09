import Characters.Player;
import Locations.*;

import java.util.Scanner;

public class Game {
    final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa hoş geldiniz!");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = input.next();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoş geldiniz!\nBurada yaşananların hepsi gerçek.");
        System.out.println("Lütfen bir karakter seçiniz!");
        player.selectChar();

        Location location = null;
        while(true) {
            System.out.println();
            System.out.println("Bölgeler:\n1- Güvenli Ev --> Burası sizin için güvenli bir ev, düşman yoktur.\n2- Mağaza --> Silah veya Zırh satın alabilirsiniz!\n3- Mağara -->  Ödül <Yemek>, dikkatli ol karşına zombi çıkabilir!\n4- Orman --> Ödül <Odun>, dikkatli ol karşına vampir çıkabilir!\n5- Nehir --> Ödül <Su>, dikkatli ol karşına ayı çıkabilir!\n0- Çıkış yap --> Oyunu sonlandır.");
            System.out.println();
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            switch(selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 0:
                    location = null;
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz.");
                    break;
            }

            if(!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
