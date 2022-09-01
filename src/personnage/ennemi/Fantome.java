package personnage.ennemi;


import action.Attaque;
import game.Game;

public class Fantome extends Monstre {

    public Fantome() {
        super("Casper", Game.getRandomNumberInRange(8,20), 2, 10, Game.getRandomNumberInRange(0,5), new int[] {6,4}, 'F', " " +
                "    .-.  \n" +
                "   .'   `. \n" +
                "   :g g   :\n" +
                "   : o    `.\n" +
                "   :         ``.\n" +
                "  :             `.\n" +
                " :  :         .   `.\n" +
                " :   :          ` . `.\n" +
                "  `.. :            `. ``;\n" +
                "    `:;             `:'\n" +
                "        :              `.\n" +
                "         `.              `.     .\n" +
                "            `'`'`'`---..,___`;.-'   \n");
//        setVivant(true);
        setAttaques(new Attaque[]{
                new Attaque("Tourmente", 3, 2),
                new Attaque("Chatouilles", 6, 4)
        });
    }
}



