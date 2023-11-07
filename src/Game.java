import Characters.Player;

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
    }
}
