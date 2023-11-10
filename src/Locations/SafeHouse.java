package Locations;

import Characters.Player;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz. Canınız yenilendi!");
        this.getPlayer().setHealthy(this.getPlayer().getDefHealth());
        return true;
    }
}
