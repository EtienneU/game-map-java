package map;

import game.Game;
import objet.Talisman;
import personnage.ennemi.Boss;
import personnage.ennemi.Monstre;
import personnage.hero.Gentil;

public abstract class Map {

    // taille de la map : nbrLignes x nbrColonnes
    private int nbrLignes;
    private int nbrColonnes;
    private String name;
    private int nbrMonster;
    private char[][] carte;
    private char cell = ' ';
    private Monstre[] tabMonstre;
    private Boss boss;
    private String legende;
    private Talisman[] talismans;


    public Map(int nbrLignes, int nbrColonnes) {
        this.nbrLignes = nbrLignes;
        this.nbrColonnes = nbrColonnes;

        name = " Map (" + nbrLignes + " x " + nbrColonnes + " )";

        carte = new char[this.nbrLignes][this.nbrColonnes];

        int i = 0;
        int j = 0;
        while (i < this.nbrLignes) {
            while (j < this.nbrColonnes) {
                if (i == 0 || i == this.nbrLignes-1) { // Limites horizontales de la map
                    carte[i][j] = '_';
                }
                else if (j == 0 || j == this.nbrColonnes-1) { // Limites verticales de la map
                    carte[i][j] = '|';
                }
                else {
                    carte[i][j] = cell; // le caractere cell constitue un �l�ment modifiable dans les limites de la map
                }
                j++;
            }
            j = 0;
            i++;
        }
    }



    public Talisman[] getTalismans() {
        return talismans;
    }



    public String getName() {
        return name;
    }

    public int getNbrLignes() {
        return nbrLignes;
    }

    public int getNbrColonnes() {
        return nbrColonnes;
    }

    public Monstre[] getTabMonstres() {
        return tabMonstre;
    }

    public Talisman[] getTabTalismans() {
        return talismans;
    }

    public Boss getBoss() {
        return boss;
    }

    public String getLegende() {
        return legende;
    }

    public int getNbrMonster() {
        return nbrMonster;
    }

    public void setCharMap(char c, int x, int y) {
        carte[x][y] = c;
    }

    public void setTabMonstre(Monstre[] tabMonstre) {
        this.tabMonstre = tabMonstre;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public void setLegende(String legende) {
        this.legende = legende;
    }

    public void setTalismans(Talisman[] talismans) {
        this.talismans = talismans;
    }

    public void setNbrMonster(int nbrMonster) {
        this.nbrMonster = nbrMonster;
    }

    public void affiche() {
        int i = 0;
        int j = 0;
        while (i < this.nbrLignes) {
            while (j < this.nbrColonnes) {
                System.out.print(" " + carte[i][j] + " ");
                j++;
            }
            System.out.print("\n");
            j = 0;
            i++;
        }
        System.out.println(" ");
    } // END affiche



    public void placementPerso(Gentil joueur, int x, int y) {
        if (carte[x][y] == cell) { //remplacement du caractere pixel par l'initiale du personnage concern�
            setCharMap(cell, joueur.getPosition()[0], joueur.getPosition()[1]);
            setCharMap(joueur.getId(), x, y);
            joueur.setPosition(new int[] {x,y});
        }
        else if (carte[x][y]=='W' || carte[x][y]=='L' || carte[x][y]=='S' || carte[x][y]=='F') {
            int i = 0;
            while (x!=tabMonstre[i].getPosition()[0] || y!=tabMonstre[i].getPosition()[1]) { //pos != tabMonstre[i].getPosition()) {
                i++;
            }
            System.out.println("\n  ********   Vous venez de rencontrer "+ tabMonstre[i].getName() +" !  ********   \n");
            System.out.println(tabMonstre[i].getAvatar());
            Game.fight(joueur, tabMonstre[i]);
            if (!tabMonstre[i].getVivant()) { // si le MONSTRE est mort, on l'�crase par l'Id du Gentil
                setCharMap(joueur.getId(), x, y); //ecrasement de l'Id du MONSTRE par l'Id du Gentil
                setCharMap(cell, joueur.getPosition()[0], joueur.getPosition()[1]); // effacer l'Id du Gentil par la cellule de base
                joueur.setPosition(new int[] {x,y});  // On actualise la position du Gentil
                nbrMonster--;
            }
        }
        else if (carte[x][y] == 'D') {
            if (nbrMonster > 0) {
                System.out.println("\n<<<[WARNING]>>> Vous ne pouvez pas vous battre contre le Boss "
                        + "tant que tous les monstres sont encore en vie !!!!\n");
            }
            else {
                System.out.println("\n  ********   Vous venez de rencontrer le Boss !  ********   \n");
                System.out.println(boss.getAvatar());
                System.out.println(boss.getMsg());
                Game.fight(joueur, boss);
            }
        }
        else if (carte[x][y] == 'T') {
            int i = 0;
            while (x != talismans[i].getPosition()[0] || y != talismans[i].getPosition()[1]) {
                i++;
            }
            System.out.println(talismans[i].getAvatar());
            System.out.println("Vous avez trouve un TALISMAN : c'est une " + talismans[i].getName());
            joueur.ajouEnergie(talismans[i].getGiveenergie());
            joueur.ajouPv(talismans[i].getGivePv());
            setCharMap(joueur.getId(), x, y); //ecrasement de l'Id du TALISMAN par l'Id du Gentil
            setCharMap(cell, joueur.getPosition()[0], joueur.getPosition()[1]); // effacer l'Id du Gentil par la cellule de base
            joueur.setPosition(new int[] {x,y});  // On actualise la position du Gentil
        }
        else { // emplacement au sein de la map mais deja occup� par un �l�ment du jeu
            System.out.println("<<<[ERROR]>>> Vous vous etes pris un mur ! Reessayez !\n");
            joueur.subitDegat(2);
        }
    }//END placement Perso

    public char getCell() {
        return cell;
    }



    public void setCell(char cell) {
        this.cell = cell;
    }



    public void DeplacementPerso(Gentil joueur, int d) {

        if (d == 2) { // d�placement vers le bas
            placementPerso(joueur, joueur.getPosition()[0]+1,joueur.getPosition()[1]);
        }
        else if (d == 4) { //d�placement vers la gauche
            placementPerso(joueur, joueur.getPosition()[0],joueur.getPosition()[1]-1);
        }
        else if (d == 6){ // d�placement vers la droite
            placementPerso(joueur, joueur.getPosition()[0],joueur.getPosition()[1]+1);
        }
        else if (d == 8){ // d�placement vers le haut
            placementPerso(joueur, joueur.getPosition()[0]-1,joueur.getPosition()[1]);
        }
    }

    //Methode de creation d'un mur vertical ou horizontal
    public void builtOneWall(int[] point_debut, int[] point_fin, char type) {
        if (point_fin[1] - point_debut[1] >= getNbrColonnes() || point_fin[0] - point_debut[0] >= getNbrLignes() ) {
            System.out.println("Points saisis invalides : le mur est trop grand ! ");
        }

        if (type == 'v') { // point_debut[1] == point_fin[1]) { //intention de creer un mur vertical
            while (point_debut[0] <= point_fin[0]) {
                setCharMap('|', point_debut[0], point_debut[1]);
                point_debut[0]++;
            }
        }
        else if (type == 'h') { // point_debut[0] == point_fin[0]) { //intention de creer un mur horizontal
            while (point_debut[1] <= point_fin[1]) {
                setCharMap('_', point_debut[0], point_debut[1]);
                point_debut[1]++;
            }
        }
        else {
            System.out.println(" Coordonnees invalides : le mur ne doit pas etre oblique, mais doit etre vertical ou horizontal. ");
        }
    }
}
