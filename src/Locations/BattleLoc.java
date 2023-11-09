package Locations;

import Characters.Player;
import Monsters.Obstacle;

import java.sql.SQLOutput;
import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız: " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor.");
        System.out.print("<S>avaş veya <K>aç: ");
        String selectBattleCase = input.next();
        selectBattleCase = selectBattleCase.toUpperCase();
        if(selectBattleCase.equals("S")) {
            if(combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz.");
                return true;
            }
        }
        if(this.getPlayer().getHealthy() < 0) {
            System.out.println("Öldünüz.");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for(int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<V>ur veya <K>aç: ");
                String selectCombat = input.next().toUpperCase();
                if(selectCombat.equals("V")) {
                    System.out.println("Siz vurdunuz!");
                    int playerDamage =this.obstacle.getHealth() - this.getPlayer().getTotalDamage();
                    this.getObstacle().setHealth(playerDamage);
                    afterHit();
                    if(this.getObstacle().getHealth() > 0) {
                        System.out.println("Canavar vurdu!");
                        int monsterDamage = this.getPlayer().getHealthy() - this.getObstacle().getDamage();
                        if(monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealthy(monsterDamage);
                        afterHit();
                    }
                }
            }

            if(this.getObstacle().getHealth() < this.getPlayer().getHealthy()) {
                System.out.println("Düşmanı Yendiniz!");
                System.out.println(this.getObstacle().getMoney() + " para kazandınız!");
                int newBalance = this.getObstacle().getMoney() + this.getPlayer().getMoney();
                this.getPlayer().setMoney(newBalance);
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
            }
        }
        return false;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("-----------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealthy());
        System.out.println("Silah: " + this.getPlayer().getWeapon().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getArmor());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: " + this.getPlayer().getMoney());
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("-------------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getMoney());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return this.obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return this.award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return this.maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
