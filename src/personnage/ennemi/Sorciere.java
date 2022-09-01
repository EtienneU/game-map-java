package personnage.ennemi;

import action.Attaque;
import game.Game;

public class Sorciere extends Monstre {

    public Sorciere() {
        super("Tabatha", Game.getRandomNumberInRange(20,30), 2, 10, Game.getRandomNumberInRange(2,10), new int[] {3,3}, 'W', " " +


                "                                           ++=  -:-  ::" +

                "                                       :+- =-   -:-  ::\n" +

                "                                    -*  +#:            \n" +

                "                                   =    -*             \n" +

                "                                 -*     *              \n" +

                "                                +-     -+              \n" +

                "                              -@=++: # :-              \n" +

                "                             *WW=@W#*W@#               \n" +

                "                          +*: +#+@W*#WWW-              \n" +

                "               +@*::::++:       -+==+  -*+             \n" +

                "                 -*-     :++:#=***+:-      :**+-       \n" +

                "                   -*    *+:*-#=*+=+ = *+-----::*=@#+  \n" +

                "                     :#:*=-**+*-#=#@+-= =-    :=*      \n" +

                "                      -* =            =- #=*:          \n" +

                "                      *  :*   ++     +*   #            \n" +

                "                     +-    -@+     *#     #            \n" +

                "                     ===    = *-:# -+   :#W            \n" +

                "                      -+    = ++*  :+   +=             \n" +

                "                      :+    #  -   =-  -=+:            \n" +

                " #*                   *=+= ++     --+: # -#-           \n" +

                "=+ :=:              +#*+*-=-*       #:#+-*:+=          \n" +

                "@:  ++*@W#*=+     :#-   +- :@:    -#++=-#==##          \n" +

                "*+--:*#W@  :##+::+ *-=-  =       :**::::::-    ++      \n" +

                "         +*=*   -++++=W: *=      *-=           =       \n" +

                "                   -+=--#*       +:=          -+       \n" +

                "                        :*       =-*           #       \n" +

                "                       :=**-     = *           =-      \n" +

                "                      -@+-       ++*-          ++      \n" +

                "                    :* -*-+#=:    -+=@#*@W#===*-       \n" +

                "-                    +==*#=#+  -++==-+#-  ++           \n" +

                "(c) 2020 topster.de#################################### \n");
        setVivant(true);
        setAttaques(new Attaque[]{
                new Attaque("Nez crochu", 3, 2),
                new Attaque("Sort cuisant", 6, 4)
        });



    }

    Sorciere(String name, int pv, int lvl, int exp, int force, int [] position, char id, String avatar) {
        super(name, pv, lvl, exp, force, position, id, avatar);
        setVivant(true);

        setAttaques(new Attaque[]{
                new Attaque("Coup de nez crochu", 3, 2),
                new Attaque("Sortilege de brulure", 6, 4)
        });
    }
}
