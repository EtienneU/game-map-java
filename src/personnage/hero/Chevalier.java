package personnage.hero;

import action.Attaque;

public class Chevalier extends Gentil {

    public Chevalier() {
        super("Alexandre", 35, 1, 0, 5, new int[] {1,1}, '@', (
                        "      /\\\r\n" +
                                "      ||\r\n" +
                                "      ||\r\n" +
                                "      ||\r\n" +
                                "      ||           {}\r\n" +
                                "      ||          .--.\r\n" +
                                "      ||         /.--.\\\r\n" +
                                "      ||         |====|\r\n" +
                                "      ||         |`::`|\r\n" +
                                "     _||_    .-;`\\..../`;_.-^-._\r\n" +
                                "      /\\\\   /  |...::..|`   :   `|\r\n" +
                                "      |:'\\ |   /'''::''|   .:.   |\r\n" +
                                "       \\ /\\;-,/\\   ::  |..:::::..|\r\n" +
                                "        \\ <` >  >._::_.| ':::::' |\r\n" +
                                "         `\"\"`  /   ^^  |   ':'   |\r\n" +
                                "               |       \\    :    /\r\n" +
                                "               |        \\   :   / \r\n" +
                                "               |___/\\___|`-.:.-`\r\n" +
                                "                \\_ || _/    `\r\n" +
                                "                <_ >< _>\r\n" +
                                "                |  ||  |\r\n" +
                                "                |  ||  |\r\n" +
                                "               _\\.:||:./_\r\n" +
                                "         jgs  /____/\\____\\"),
                "epee", 100);
        setAttaques(new Attaque[]{
                new Attaque("Choc frontal", 3, 2),
                new Attaque("Coup d'epee", 6, 4)});
        System.out.println(getAvatar());
        System.out.println("\n" + getName() + " part a l'aventure !!\n");
    }
}
