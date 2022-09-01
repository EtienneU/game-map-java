package personnage.ennemi;

import action.Attaque;
import game.Game;

public class LoupGarou extends Monstre {

    public LoupGarou() {
        super("Loulou", Game.getRandomNumberInRange(25,40), 2, 10, Game.getRandomNumberInRange(3,10), new int[] {4,4}, 'L',
                "                            __ \n" +
                        "                          .d$$b \n" +
                        "                        .' TO$;\\ \n" +
                        "                       /  : TP._; \n" +
                        "                      / _.;  :Tb| \n" +
                        "                     /   /   ;j$j \n" +
                        "                 _.-\"       d$$$$ \n" +
                        "               .' ..       d$$$$; \n" +
                        "              /  /P'      d$$$$P. |\\ \n" +
                        "             /   \"      .d$$$P' |\\^\"l \n" +
                        "           .'           `T$P^\"\"\"\"\"  : \n" +
                        "         ._.'      _.'                ;\n" +
                        "      `-.-\".-'-' ._.       _.-\"    .-\" \n" +
                        "    `.-\" _____  ._              .-\" \n" +
                        "   -(.g$$$$$$$b.              .'\n" +
                        "     \"\"^^T$$$P^)            .(:\n" +
                        "       _/  -\"  /.'         /:/;\\\n" +
                        "    ._.'-'`-'  \")/         /;/;\n" +
                        " `-.-\"..--\"\"   \" /         /  ;\n" +
                        ".-\" ..--\"\"        -'          :\\\n" +
                        "..--\"\"--.-\"         (\\      .-(\\\n" +
                        "  ..--\"\"              `-\\(\\/;`\n" +
                        "    _.                      :\n" +
                        "                            ;`-\n" +
                        "                           :\\\n" +
                        "                           ;);\n");
//        setVivant(true);
        setAttaques(new Attaque[]{
                new Attaque("Griffures", 3, 2),
                new Attaque("Crocs aceres", 6, 4)
        });
    }

    LoupGarou(String name, int pv, int lvl, int exp, int force, int [] position, char id, String avatar, boolean vivant) {
        super(name, pv, lvl, exp, force, position, id, avatar);
        setVivant(true);

        setAttaques(new Attaque[]{
                new Attaque("Griffures", 3, 2),
                new Attaque("Crocs aceres", 6, 4)
        });
    }
}
