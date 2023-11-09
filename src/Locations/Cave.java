package Locations;

import Characters.Player;
import Monsters.Zombie;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "food", 3);
    }
}
