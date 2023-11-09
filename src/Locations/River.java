package Locations;

import Characters.Player;
import Monsters.Bear;

public class River extends BattleLoc{
    public River(Player player) {
        super(player, "Nehir", new Bear(), "water", 3);
    }
}
