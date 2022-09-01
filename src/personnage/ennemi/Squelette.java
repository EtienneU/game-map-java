package personnage.ennemi;


import action.Attaque;
import game.Game;

public class Squelette extends Monstre {

    public Squelette () {
        super("Oscar", Game.getRandomNumberInRange(15,25), 2, 10, Game.getRandomNumberInRange(2, 10), new int[] {8,8}, 'S',
                "                            __ \n" +
                        " @@@@@                                        @@@@@\r\n" +
                        "@@@@@@@                                      @@@@@@@\r\n" +
                        "@@@@@@@           @@@@@@@@@@@@@@@            @@@@@@@\r\n" +
                        " @@@@@@@@       @@@@@@@@@@@@@@@@@@@        @@@@@@@@\r\n" +
                        "     @@@@@     @@@@@@@@@@@@@@@@@@@@@     @@@@@\r\n" +
                        "       @@@@@  @@@@@@@@@@@@@@@@@@@@@@@  @@@@@\r\n" +
                        "         @@  @@@@@@@@@@@@@@@@@@@@@@@@@  @@\r\n" +
                        "            @@@@@@@    @@@@@@    @@@@@@\r\n" +
                        "            @@@@@@      @@@@      @@@@@\r\n" +
                        "            @@@@@@      @@@@      @@@@@\r\n" +
                        "             @@@@@@    @@@@@@    @@@@@\r\n" +
                        "              @@@@@@@@@@@  @@@@@@@@@@\r\n" +
                        "               @@@@@@@@@@  @@@@@@@@@\r\n" +
                        "           @@   @@@@@@@@@@@@@@@@@   @@\r\n" +
                        "           @@@@  @@@@ @ @ @ @ @@@@  @@@@\r\n" +
                        "          @@@@@   @@@ @ @ @ @ @@@   @@@@@\r\n" +
                        "        @@@@@      @@@@@@@@@@@@@      @@@@@\r\n" +
                        "      @@@@          @@@@@@@@@@@          @@@@\r\n" +
                        "   @@@@@              @@@@@@@              @@@@@\r\n" +
                        "  @@@@@@@                                 @@@@@@@\r\n" +
                        "   @@@@@                                   @@@@@\n");
//        setVivant(true);
        setAttaques(new Attaque[]{
                new Attaque("Coup de femur", 3, 2),
                new Attaque("Vomi acide", 6, 4)
        });
    }
}
