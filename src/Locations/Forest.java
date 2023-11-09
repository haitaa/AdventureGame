package Locations;

import Characters.Player;
import Monsters.Obstacle;
import Monsters.Vampire;
import Monsters.Zombie;

public class Forest extends BattleLoc{
    public Forest(Player player) {
            super(player, "Orman", new Vampire(), "firewood", 3);
    }
}
