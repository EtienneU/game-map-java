package map;

import objet.Croix;
import objet.Fleur;
import objet.Talisman;
import personnage.ennemi.*;

public class Map2 extends Map {

    public Map2() {
        super(16, 16);

        //Creation et Positionnement des MONSTRES	 sur Map2
        setTabMonstre(new Monstre[] {
                new Sorciere(),
                new LoupGarou(),
                new Fantome(),
                new Squelette()
        });
        getTabMonstres()[0].setPosition(new int[] {3,9});
        getTabMonstres()[1].setPosition(new int[] {12,2});
        getTabMonstres()[2].setPosition(new int[] {10,12});
        getTabMonstres()[3].setPosition(new int[] {2, 14});

        setLegende("Tu es represente.e par '@' sur la map :)\n\n");

        // on affiche l'Id de chaque PERSO sur la Map2
        int i = 0;
        while (i < getTabMonstres().length) {
            setCharMap(getTabMonstres()[i].getId(),
                    getTabMonstres()[i].getPosition()[0],
                    getTabMonstres()[i].getPosition()[1]);
            setLegende(getLegende() + getTabMonstres()[i].getName() + " est represente.e par '"
                    + getTabMonstres()[i].getId() + "' sur la map ...\n");
            i++;
        }

        setNbrMonster(getTabMonstres().length);

        setBoss(new Dragon());
        getBoss().setPv(40);
        getBoss().setPosition(new int[] {14,14});
        setCharMap(getBoss().getId(), getBoss().getPosition()[0], getBoss().getPosition()[1]);
        setLegende(getLegende() + "\n" + getBoss().getName() + " est represente.e par '"
                + getBoss().getId() + "' sur la map ... Attention ...\n");


        //Creation et Positionnement des Talismans sur Map2
        setTalismans(new Talisman[] {
                new Fleur(),
                new Croix(),
        } );
        getTalismans()[0].setPosition(new int[] {6,4});
        getTalismans()[1].setPosition(new int[] {14,9});

        // on affiche l'Id de chaque OBJET sur la Map2
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
        builtOneWall(new int[]{1,12}, new int[]{8,12}, 'v');
        builtOneWall(new int[]{5,5}, new int[]{12,5}, 'v');
        builtOneWall(new int[]{8,8}, new int[]{14,8}, 'v');

        // Construction des murs horizontaux
        builtOneWall(new int[]{5,3}, new int[]{5,11}, 'h');
        builtOneWall(new int[]{5,5}, new int[]{12,5}, 'h');

    }// END Constructeur Map2
}// END classe Map2
