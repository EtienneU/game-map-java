package personnage.ennemi;

import personnage.Perso;

public class Monstre extends Perso {

    private boolean vivant;

    public Monstre() {
        super("Monstre", 20, 2, 10, 5, new int[] {0,0}, 'M', "");
        this.vivant = true;
    }

    public Monstre(String name, int pv, int lvl, int exp, int force, int [] position, char id, String avatar) {
        super(name, pv, lvl, exp, force, position, id, avatar);
        vivant = true;
        setAvatar(avatar);
    }

    public boolean getVivant(){
        return vivant;
    }

    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }
}
