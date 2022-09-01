package personnage.hero;

import personnage.Perso;

public class Gentil extends Perso {
    private String arme;
    private int energie;

    public Gentil() {
        super("Hero", 20, 2, 10, 5, new int[] {0, 0}, '@', " ");
        arme = "GitLab";
    }

    public Gentil(String name, int pv, int lvl, int exp, int force,
            int [] position, char id, String avatar, String arme, int energie) {
        super(name, pv, lvl, exp, force, position, id, avatar);
        this.arme = arme;
        this.energie = energie;
    }

    public String getArme() {
        return arme;
    }

    public int getEnergie() {
        return energie;
    }

    public void setArme(String arme) {
        this.arme = arme;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public void ajouEnergie( int giveenergie) {
        energie = energie + giveenergie;
        System.out.println(getName() + " a gagne " + giveenergie + " points d'energie. Son energie monte a " + energie + " pts ! ");
    }

    public void perdEnergie(int uenergie) {
        energie = energie - uenergie;
        System.out.println(getName() + " a perdu " + uenergie + " pts d'energie, il lui en reste " + (Math.max(energie, 0)) + ".");
    }
}

