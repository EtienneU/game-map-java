package map;

import objet.Croix;
import objet.Fleur;
import objet.Talisman;
import personnage.ennemi.*;

public class Map3 extends Map {
    private boolean sorciere;
    private boolean loupGarou;
    private boolean squelette;
    private boolean fantome;

    public Map3() {
        super(22, 27);
        sorciere = false; loupGarou = false; squelette = false; fantome = false;

        // Creation et positionnement des monstres
        setTabMonstre(new Monstre[] {
                new Sorciere(),
                new Sorciere(),
                new LoupGarou(),
                new LoupGarou(),
                new Squelette(),
                new Squelette(),
                new Fantome(),
                new Fantome() } );
        getTabMonstres()[0].setPosition(new int[] {2, 3}); getTabMonstres()[1].setPosition(new int[] {20, 4});
        getTabMonstres()[2].setPosition(new int[] {1, 20}); getTabMonstres()[3].setPosition(new int[] {10, 8});
        getTabMonstres()[4].setPosition(new int[] {14, 1}); getTabMonstres()[5].setPosition(new int[] {11, 24});
        getTabMonstres()[6].setPosition(new int[] {8, 13}); getTabMonstres()[7].setPosition(new int[] {15, 14});

        setLegende("Tu es represente par '@' sur la map :)\n\n");
        int i = 0;
        while (i < getTabMonstres().length) {
            setCharMap(getTabMonstres()[i].getId(),
                    getTabMonstres()[i].getPosition()[0],
                    getTabMonstres()[i].getPosition()[1]);
            if (getTabMonstres()[i].getId() == 'W' && !sorciere) {
                setLegende(getLegende() + getTabMonstres()[i].getName() + " est represente par '"
                        + getTabMonstres()[i].getId() + "' sur la map ...\n");
                sorciere = !sorciere;
            }
            else if ((getTabMonstres()[i].getId() == 'L' && !loupGarou)) {
                setLegende(getLegende() + getTabMonstres()[i].getName() + " est represente par '"
                        + getTabMonstres()[i].getId() + "' sur la map ...\n");
                loupGarou = !loupGarou;
            }
            else if ((getTabMonstres()[i].getId() == 'S' && !squelette)) {
                setLegende(getLegende() + getTabMonstres()[i].getName() + " est represente par '"
                        + getTabMonstres()[i].getId() + "' sur la map ...\n");
                squelette = !squelette;
            }
            else if ((getTabMonstres()[i].getId() == 'F' && !fantome)) {
                setLegende(getLegende() + getTabMonstres()[i].getName() + " est represente par '"
                        + getTabMonstres()[i].getId() + "' sur la map ...\n");
                fantome = !fantome;
            }
            i++;
        }

        setNbrMonster(getTabMonstres().length);

        // Creation du Boss
        setBoss(new Dragon());
        getBoss().setPosition(new int[] {20, 25});
        setCharMap(getBoss().getId(), getBoss().getPosition()[0], getBoss().getPosition()[1]);
        setLegende(getLegende() + "\n" + getBoss().getName() + " est respresente par '"
                + getBoss().getId() + "' sur la map ... Attention ...\n");

        //Creation et positionnement des Talismans
        setTalismans(new Talisman[] {
                new Fleur(), new Fleur(), new Fleur(), new Fleur(), new Fleur(), new Fleur(), new Fleur(),
                new Croix(), new Croix(), new Croix(), new Croix(), new Croix(), new Croix(), new Croix()
        } );

        getTalismans()[0].setPosition(new int[] {2, 8}); // Fleur *7
        getTalismans()[1].setPosition(new int[] {2, 23}); getTalismans()[2].setPosition(new int[] {7, 15});
        getTalismans()[3].setPosition(new int[] {12, 22}); getTalismans()[4].setPosition(new int[] {16, 2});
        getTalismans()[5].setPosition(new int[] {19, 10}); getTalismans()[6].setPosition(new int[] {19, 22});
        getTalismans()[7].setPosition(new int[] {1, 14}); // Croix *7
        getTalismans()[8].setPosition(new int[] {5, 25}); getTalismans()[9].setPosition(new int[] {8, 3});
        getTalismans()[10].setPosition(new int[] {15, 9}); getTalismans()[11].setPosition(new int[] {16, 22});
        getTalismans()[12].setPosition(new int[] {20, 6}); getTalismans()[13].setPosition(new int[] {20, 17});

        i = 0;
        while (i < getTalismans().length) {
            setCharMap(getTalismans()[i].getId(),
                    getTalismans()[i].getPosition()[0],
                    getTalismans()[i].getPosition()[1]);
            i++;
        }
        setLegende(getLegende() + "\n" + getTalismans().length + " Talismans se trouvent ici. Ils te seront d'une aide precieuse. On represente un talisman par un '"
                + getTalismans()[0].getId() + "' sur la map ...\n"); // on part du principe que tous les talismans ont le m�me Id,c'est-�-dire 'T'

        // Construction des murs verticaux
        builtOneWall(new int[]{1,2}, new int[]{3,2}, 'v'); builtOneWall(new int[]{12,2}, new int[]{13,2}, 'v');
        builtOneWall(new int[]{6,3}, new int[]{6,3}, 'v'); builtOneWall(new int[]{16,3}, new int[]{17,3}, 'v');
        builtOneWall(new int[]{1,4}, new int[]{1,4}, 'v'); builtOneWall(new int[]{10,4}, new int[]{11,4}, 'v');
        builtOneWall(new int[]{7,5}, new int[]{8,5}, 'v'); builtOneWall(new int[]{14,5}, new int[]{15,5}, 'v'); builtOneWall(new int[]{20,5}, new int[]{20,5}, 'v');
        builtOneWall(new int[]{3,7}, new int[]{9,7}, 'v'); builtOneWall(new int[]{12,7}, new int[]{12,7}, 'v'); builtOneWall(new int[]{17,7}, new int[]{17,7}, 'v');
        builtOneWall(new int[]{15,8}, new int[]{15,8}, 'v');
        builtOneWall(new int[]{1,9}, new int[]{4,9}, 'v'); builtOneWall(new int[]{10,9}, new int[]{10,9}, 'v'); builtOneWall(new int[]{19,9}, new int[]{20,9}, 'v');
        builtOneWall(new int[]{7,10}, new int[]{9,10}, 'v'); builtOneWall(new int[]{16,10}, new int[]{17,10}, 'v');
        builtOneWall(new int[]{2,11}, new int[]{2,11}, 'v'); builtOneWall(new int[]{12,11}, new int[]{12,11}, 'v'); builtOneWall(new int[]{19,11}, new int[]{19,11}, 'v');
        builtOneWall(new int[]{6,12}, new int[]{7,12}, 'v'); builtOneWall(new int[]{9,12}, new int[]{11,12}, 'v');
        builtOneWall(new int[]{1,13}, new int[]{1,13}, 'v'); builtOneWall(new int[]{13,13}, new int[]{13,13}, 'v'); builtOneWall(new int[]{17,13}, new int[]{17,13}, 'v');
        builtOneWall(new int[]{4,14}, new int[]{11,14}, 'v'); builtOneWall(new int[]{18,14}, new int[]{19,14}, 'v');
        builtOneWall(new int[]{1,15}, new int[]{1,15}, 'v'); builtOneWall(new int[]{12,15}, new int[]{12,15}, 'v'); builtOneWall(new int[]{15,15}, new int[]{15,15}, 'v');
        builtOneWall(new int[]{2,16}, new int[]{4,16}, 'v'); builtOneWall(new int[]{7,16}, new int[]{9,16}, 'v'); builtOneWall(new int[]{18,16}, new int[]{20,16}, 'v');
        builtOneWall(new int[]{10,17}, new int[]{10,17}, 'v'); builtOneWall(new int[]{13,17}, new int[]{14,17}, 'v'); builtOneWall(new int[]{16,17}, new int[]{17,17}, 'v');
        builtOneWall(new int[]{5,18}, new int[]{7,18}, 'v'); builtOneWall(new int[]{20,18}, new int[]{20,18}, 'v');
        builtOneWall(new int[]{8,19}, new int[]{8,19}, 'v'); builtOneWall(new int[]{11,19}, new int[]{19,19}, 'v');
        builtOneWall(new int[]{4,20}, new int[]{5,20}, 'v');
        builtOneWall(new int[]{6,21}, new int[]{13,21}, 'v'); builtOneWall(new int[]{16,21}, new int[]{19,21}, 'v');
        builtOneWall(new int[]{3,22}, new int[]{3,22}, 'v');
        builtOneWall(new int[]{4,23}, new int[]{4,23}, 'v'); builtOneWall(new int[]{10,23}, new int[]{16,23}, 'v'); builtOneWall(new int[]{19,23}, new int[]{20,23}, 'v');
        builtOneWall(new int[]{1,24}, new int[]{3,24}, 'v');

        // Construction des murs horizontaux
        builtOneWall(new int[]{1,5}, new int[]{1,8}, 'h'); builtOneWall(new int[]{1,16}, new int[]{1,16}, 'h');
        builtOneWall(new int[]{2,18}, new int[]{2,22}, 'h');
        builtOneWall(new int[]{3,3}, new int[]{3,5}, 'h'); builtOneWall(new int[]{3,11}, new int[]{3,14}, 'h'); builtOneWall(new int[]{3,23}, new int[]{3,23}, 'h');
        builtOneWall(new int[]{4,17}, new int[]{4,18}, 'h');
        builtOneWall(new int[]{5,1}, new int[]{5,1}, 'h'); builtOneWall(new int[]{5,3}, new int[]{5,4}, 'h'); builtOneWall(new int[]{5,6}, new int[]{5,6}, 'h');
        builtOneWall(new int[]{5,9}, new int[]{5,12}, 'h'); builtOneWall(new int[]{5,21}, new int[]{5,21}, 'h');
        builtOneWall(new int[]{6,15}, new int[]{6,16}, 'h'); builtOneWall(new int[]{6,23}, new int[]{6,25}, 'h');
        builtOneWall(new int[]{7,1}, new int[]{7,3}, 'h'); builtOneWall(new int[]{7,8}, new int[]{7,8}, 'h'); builtOneWall(new int[]{7,18}, new int[]{7,19}, 'h');
        builtOneWall(new int[]{8,22}, new int[]{8,24}, 'h');
        builtOneWall(new int[]{9,2}, new int[]{9,6}, 'h'); builtOneWall(new int[]{9,9}, new int[]{9,9}, 'h'); builtOneWall(new int[]{9,17}, new int[]{9,17}, 'h');
        builtOneWall(new int[]{10,18}, new int[]{10,19}, 'h');
        builtOneWall(new int[]{11,1}, new int[]{11,2}, 'h'); builtOneWall(new int[]{11,5}, new int[]{11,7}, 'h'); builtOneWall(new int[]{11,11}, new int[]{11,11}, 'h');
        builtOneWall(new int[]{11,15}, new int[]{11,15}, 'h'); builtOneWall(new int[]{11,22}, new int[]{11,22}, 'h'); builtOneWall(new int[]{11,25}, new int[]{11,25}, 'h');
        builtOneWall(new int[]{12,8}, new int[]{12,10}, 'h'); builtOneWall(new int[]{12,16}, new int[]{12,17}, 'h');
        builtOneWall(new int[]{13,4}, new int[]{13,5}, 'h'); builtOneWall(new int[]{13,24}, new int[]{13,24}, 'h');
        builtOneWall(new int[]{14,6}, new int[]{14,6}, 'h'); builtOneWall(new int[]{14,8}, new int[]{14,15}, 'h');
        builtOneWall(new int[]{15,2}, new int[]{15,4}, 'h'); builtOneWall(new int[]{15,21}, new int[]{15,22}, 'h'); builtOneWall(new int[]{15,25}, new int[]{15,25}, 'h');
        builtOneWall(new int[]{16,7}, new int[]{16,8}, 'h'); builtOneWall(new int[]{16,12}, new int[]{16,13}, 'h');
        builtOneWall(new int[]{17,1}, new int[]{17,2}, 'h'); builtOneWall(new int[]{17,5}, new int[]{17,6}, 'h'); builtOneWall(new int[]{17,14}, new int[]{17,14}, 'h');
        builtOneWall(new int[]{17,16}, new int[]{17,16}, 'h'); builtOneWall(new int[]{17,25}, new int[]{17,25}, 'h');
        builtOneWall(new int[]{18,9}, new int[]{18,11}, 'h'); builtOneWall(new int[]{18,22}, new int[]{18,23}, 'h');
        builtOneWall(new int[]{19,2}, new int[]{19,7}, 'h'); builtOneWall(new int[]{19,12}, new int[]{19,13}, 'h');
        builtOneWall(new int[]{19,18}, new int[]{19,18}, 'h'); builtOneWall(new int[]{19,24}, new int[]{19,24}, 'h');
    }
}
