package personnage;

import action.Attaque;
import game.Game;

import java.util.Scanner;

public abstract class Perso {
    private String name;
    private int pv;
    private int lvl;
    private int exp;
    private int force;
    private int [] position;// = new int [][];
    private Attaque[] attaques;
    private Perso ennemie;
    private char id;
    private String avatar;

    public Perso(String name, int pv, int lvl, int exp, int force,
                 int [] position, char id, String avatar) {
        this.name = name;
        this.pv = pv;
        this.exp = exp;
        this.force = force;
        this.position = position;
        this.id = id;
        this.avatar = avatar;
//		System.out.println(avatar);
    }

    public String getName() {
        return name;
    }

    public int getPv() {
        return pv;
    }

    public int getLvl() {
        return lvl;
    }

    public int getForce() {
        return force;
    }

    public int[] getPosition() {
        return position;
    }

    public Attaque[] getAttaque() {
        return attaques;
    }

    public char getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPv(int pv){
        this.pv = pv;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setAttaques(Attaque[] attaques) {
        this.attaques = attaques;
    }

    public void setEnnemie(Perso ennemie) {
        this.ennemie = ennemie;
    }

    public void setId(char id) {
        this.id = id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public void subitDegat(int degat) {
        pv = pv - degat;
        System.out.println(name + " a perdu " + degat + " PV, il lui en reste " + ((pv > 0) ? pv : 0) + ".");
    }

    public void ajouPv( int givePv) {
        pv = pv + givePv;
        System.out.println(name + " a gagne " + givePv + " points de PV, et atteint les " + pv + " PV.");
    }


    public int choixAttaque() {
        System.out.print(name +" [ " + pv + " PV ]  Selectionne ton attaque : \n");

        int i = 0;
        while (i < attaques.length) {

            System.out.println("\t"+(i+1) + ") " +  attaques[i].getName()+ " [ " + attaques[i].getDegat() + " pts de degats"
                    + " + " + force + " pts de force."
                    + " Mobilise " + attaques[i].getUenergie() + " pts d'Energie.]") ;

            i = i + 1;
        }

        System.out.print("Choix :");
        Scanner sc = new Scanner(System.in);

        try {
            int in = sc.nextInt();
            attaque(attaques[in - 1]);
            return attaques[in-1].getUenergie();

        } catch (Exception e) {
            System.out.println("\n<<<[ERROR]>>> Recommence .... Tu es vraiment mauvais .... Cette attaque n'existe pas !!\n");
            return choixAttaque();
        }
    }


    public void attaque(Attaque attaque) {
        int rnd = Game.getRandomNumberInRange(0,10);
        int eff = 0;
        System.out.println(name + " attaque [" + attaque.getName() + "] " +  ennemie.getName());
        if (rnd == 0 || rnd == 1) {
            eff = -2;
            System.out.println("Dommage " + name + " cette attaque n'est pas tres efficace, l'personnage.ennemi perd 2PV de moins que prevu.");
        }
        else if (rnd == 9 || rnd == 10) {
            eff = 4;
            System.out.println("Wow, quelle chance pour " + name + " ! Son attaque etait grave efficace ! L'personnage.ennemi perd 4 PV supplementaires !");
        }
        else {
            int rndEgoDegat = Game.getRandomNumberInRange(0, 10);
            if (rndEgoDegat<3) {
                System.out.println("Quelle maladresse ! " + name + " s'auto-inflige 3 degats !");
                subitDegat(3);
            }
        }
        ennemie.subitDegat(attaque.getDegat()+force+ eff);
    }
}
