package personnage.hero;

import action.Attaque;

public class Ogre extends Gentil {

    public Ogre() {
        super("Shrek", 30, 1, 0, 6, new int [] {1, 1}, '@', (
                        "                   ,-'     `._ \r\n" +
                                "                 ,'           `.        ,-. \r\n" +
                                "               ,'               \\       ),.\\ \r\n" +
                                "     ,.       /                  \\     /(  \\; \r\n" +
                                "    /'\\\\     ,o.        ,ooooo.   \\  ,'  `-') \r\n" +
                                "    )) )`. d8P\"Y8.    ,8P\"\"\"\"\"Y8.  `'  .--\"' \r\n" +
                                "   (`-'   `Y'  `Y8    dP       `'     / \r\n" +
                                "    `----.(   __ `    ,' ,---.       ( \r\n" +
                                "           ),--.`.   (  ;,---.        ) \r\n" +
                                "          / \\O_,' )   \\  \\O_,'        | \r\n" +
                                "         ;  `-- ,'       `---'        | \r\n" +
                                "         |    -'         `.           | \r\n" +
                                "        _;    ,            )          : \r\n" +
                                "     _.'|     `.:._   ,.::\" `..       | \r\n" +
                                "  --'   |   .'     \"\"\"         `      |`. \r\n" +
                                "        |  :;      :   :     _.       |`.`.-'--. \r\n" +
                                "        |  ' .     :   :__.,'|/       |  \\ \r\n" +
                                "        `     \\--.__.-'|_|_|-/        /   ) \r\n" +
                                "         \\     \\_   `--^\"__,'        ,    | \r\n" +
                                "   -hrr- ;  `    `--^---'          ,'     | \r\n" +
                                "          \\  `                    /      / \r\n" +
                                "           \\   `    _ _          / \r\n" +
                                "            \\           `       / \r\n" +
                                "             \\           '    ,' \r\n" +
                                "              `.       ,   _,' \r\n" +
                                "                `-.___.---' "),
                "Morve", 100);
        setAttaques(new Attaque[]{
                new Attaque("Pet mortel", 3, 2),
                new Attaque("jet de morve corrosive", 6, 4)});
        System.out.println(getAvatar());
        System.out.println("\n" + getName() + " part a l'aventure !!\n");
    }
}
