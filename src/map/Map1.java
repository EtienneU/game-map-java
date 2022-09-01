package map;

import personnage.ennemi.Dragon;
import personnage.ennemi.LoupGarou;
import personnage.ennemi.Monstre;
import personnage.ennemi.Sorciere;

public class Map1 extends Map {

    public Map1() {
        super(8, 8);
        setTabMonstre(new Monstre[] {
                new Sorciere(),
                new LoupGarou()} );
        getTabMonstres()[0].setPosition(new int[] {3,3});
        getTabMonstres()[1].setPosition(new int[] {4,4});
        setLegende("Tu es represente par '@' sur la map :)\n\n");
        int i = 0;
        while (i < getTabMonstres().length) {
            setCharMap(getTabMonstres()[i].getId(),
                    getTabMonstres()[i].getPosition()[0],
                    getTabMonstres()[i].getPosition()[1]);
            getTabMonstres()[i].setPv(15);
            setLegende(getLegende() + getTabMonstres()[i].getName() + " est represente par '"
                    + getTabMonstres()[i].getId() + "' sur la map ...\n");
            i++;
        }

        setNbrMonster(getTabMonstres().length);

        setBoss(new Dragon());
        getBoss().setPv(20);
        getBoss().setPosition(new int[] {6,6});
        setCharMap(getBoss().getId(), getBoss().getPosition()[0], getBoss().getPosition()[1]);
        setLegende(getLegende() + "\n" + getBoss().getName() + " est represente par '"
                + getBoss().getId() + "' sur la map ... Attention ...\n");
    }
}
