package game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import map.Map;
import map.Map1;
import map.Map2;
import map.Map3;
import personnage.Perso;
import personnage.ennemi.Monstre;
import personnage.hero.Chevalier;
import personnage.hero.Ogre;
import personnage.hero.Guerriere;
import personnage.hero.Gentil;

public class Game {
    private Gentil player1;

    public Game(String title) {
        System.out.println(title);
        player1 = choosePerso();
        Map carte = createMap(); // Creation de la Map. On l'affiche regulierement pour observer notre progression

        int d; // 'd' pour "deplacement"
        while (player1.getPv() > 0 && carte.getBoss().getVivant()) {
            carte.affiche();
            d = chooseDeplacement();
            carte.DeplacementPerso(player1, d);
        }
    }

    private Gentil choosePerso() {
        System.out.println("\nSelectionne ton perso : ");
        System.out.println("\t1) Chevalier (Alexandre)");
        System.out.println("\t2) Guerriere (Jeanne)\n\t3) Ogre (Schrek)");
        System.out.print("Choix :  ");

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        switch (in) {
            case "1":
                return new Chevalier();
            case "2":
                return new Guerriere();
            case "3":
                return new Ogre();
        }
        System.out.println("\n<<<[ERROR]>>> Choix invalide... Boulet...\n");
        return choosePerso();
    }

    private int chooseDeplacement() {
        System.out.println("Se deplacer dans quelle direction ?\n\n" +
                "        8        \n  " +
                "      ^          \n  " +
                "4  <     >  6   \n  " +
                "      v          \n  " +
                "      2          \n  ");
        System.out.print("Choix :   ");

        Scanner sc = new Scanner(System.in);

        try {
            byte in = sc.nextByte();
            if (in == 2 || in == 4 || in == 6 || in == 8) {
                return in;
            }
            else {
                System.out.println("\n<<<[ERROR]>>> Saisissez 2, 4, 6 ou 8\n");
                return chooseDeplacement();
            }
        } catch (InputMismatchException e ){
            System.out.println("\n<<<[ERROR]>>> Saisissez 2, 4, 6 ou 8\n");
            return chooseDeplacement();
        }

    } // END chooseDeplacement


    private Map createMap() {
        String choix = chooseMap();

        if (choix.equals("1")) {
            Map carte = new Map1();
            carte.placementPerso(player1, player1.getPosition()[0], player1.getPosition()[1]);
            carte.affiche();
            System.out.println(carte.getLegende());
            System.out.println("\n\n  ********   Votre aventure commence !!!  ********   \n\n");
            return carte;
        }

        else if (choix.equals("2")) {
            Map carte = new Map2();
            player1.setPv(player1.getPv() + 15);
            carte.placementPerso(player1, player1.getPosition()[0], player1.getPosition()[1]);
            carte.affiche();
            System.out.println(carte.getLegende());
            System.out.println("\n\n  ********   Votre aventure commence !!!  ********   \n\n");
            return carte;
        }

        else {
            Map carte = new Map3();
            player1.setPv(player1.getPv() + 40);
            carte.placementPerso(player1, player1.getPosition()[0], player1.getPosition()[1]);
            carte.affiche();
            System.out.println(carte.getLegende());
            System.out.println("\n\n  ********   Ton aventure commence !!!  ********   \n\n");
            System.out.println("\n\n  ********   On t'avait dit de ne pas choisir cette carte...  ********   \n\n");
            return carte;
        }
    } // END createMap

    private String chooseMap() {

        System.out.println("Choisis ta Map : \n"
                + "\t1) Pour les noobs (2 monstres et 1 Boss) \n"
                + "\t2) Pour les temeraires (4 monstres et 1 Boss) \n"
                + "\t3) Ne choisis pas cette Map... (surprises) \n");
        System.out.print("Choix : ");

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        if (in.equals("1") || in.equals("2") || in.equals("3")) {
            return in;
        }

        System.out.println("\n<<<[ERROR]>>> Choix invalide... Boulet...\n");
        return chooseMap();
    }


    public static void fight(Gentil player1, Monstre player2) {
        setDuelEnnemie(player1, player2);
        System.out.println("\n" + player1.getName().toUpperCase() + " [ " +player1.getPv()+ " PV, " + player1.getEnergie() + " E ]"
                + " SE BAT CONTRE " + player2.getName().toUpperCase() + " [ " +player2.getPv()+ " PV ]\n");
        boolean tour = true;
        while (player1.getPv() > 0 && player2.getPv() >0 && player1.getEnergie() > 0)
        {
            if (tour) {
                int uenergie = player1.choixAttaque();
                player1.perdEnergie(uenergie);
            }
            else if (!tour) {
                int attNb = getRandomNumberInRange(0,1);
                player2.attaque(player2.getAttaque()[attNb]);
            }
            tour = !tour;
            System.out.println("\n\t------------------\n");
        }
        if (player2.getPv()<1) {
            System.out.println(player2.getName() + " est mort.e !\n");
            player2.setVivant(false);
            if (player2.getId() == 'D') {
                System.out.println("  " +




                        "                                                                                                                                                 \r\n" +
                        "                                                                             \r\n" +
                        "WWWWWWWW                           WWWWWWWWIIIIIIIIIINNNNNNNN        NNNNNNNN\r\n" +
                        "W::::::W                           W::::::WI::::::::IN:::::::N       N::::::N\r\n" +
                        "W::::::W                           W::::::WI::::::::IN::::::::N      N::::::N\r\n" +
                        "W::::::W                           W::::::WII::::::IIN:::::::::N     N::::::N\r\n" +
                        " W:::::W           WWWWW           W:::::W   I::::I  N::::::::::N    N::::::N\r\n" +
                        "  W:::::W         W:::::W         W:::::W    I::::I  N:::::::::::N   N::::::N\r\n" +
                        "   W:::::W       W:::::::W       W:::::W     I::::I  N:::::::N::::N  N::::::N\r\n" +
                        "    W:::::W     W:::::::::W     W:::::W      I::::I  N::::::N N::::N N::::::N\r\n" +
                        "     W:::::W   W:::::W:::::W   W:::::W       I::::I  N::::::N  N::::N:::::::N\r\n" +
                        "      W:::::W W:::::W W:::::W W:::::W        I::::I  N::::::N   N:::::::::::N\r\n" +
                        "       W:::::W:::::W   W:::::W:::::W         I::::I  N::::::N    N::::::::::N\r\n" +
                        "        W:::::::::W     W:::::::::W          I::::I  N::::::N     N:::::::::N\r\n" +
                        "         W:::::::W       W:::::::W         II::::::IIN::::::N      N::::::::N\r\n" +
                        "          W:::::W         W:::::W          I::::::::IN::::::N       N:::::::N\r\n" +
                        "           W:::W           W:::W           I::::::::IN::::::N        N::::::N\r\n" +
                        "            WWW             WWW            IIIIIIIIIINNNNNNNN         NNNNNNN"



                );
            }

        }
        else {
            System.out.println(" _____   ___  ___  ___ _____   _____  _   _ ___________ \n" +
                    "|  __ \\ / _ \\ |  \\/  ||  ___| |  _  || | | |  ___| ___ \\\n" +
                    "| |  \\// /_\\ \\| .  . || |__   | | | || | | | |__ | |_/ /\n" +
                    "| | __ |  _  || |\\/| ||  __|  | | | || | | |  __||    / \n" +
                    "| |_\\ \\| | | || |  | || |___  \\ \\_/ /\\ \\_/ / |___| |\\ \\ \n" +
                    " \\____/\\_| |_/\\_|  |_/\\____/   \\___/  \\___/\\____/\\_| \\_|\n" +
                    "                                                        \n\n\n\n"
                    + "####### ######  #     #       #     #####     #    ### #     #    ### ### \r\n" +
                    "   #    #     #  #   #       # #   #     #   # #    #  ##    #    ### ### \r\n" +
                    "   #    #     #   # #       #   #  #        #   #   #  # #   #    ### ### \r\n" +
                    "   #    ######     #       #     # #  #### #     #  #  #  #  #     #   #  \r\n" +
                    "   #    #   #      #       ####### #     # #######  #  #   # #            \r\n" +
                    "   #    #    #     #       #     # #     # #     #  #  #    ##    ### ### \r\n" +
                    "   #    #     #    #       #     #  #####  #     # ### #     #    ### ###");
        }
    } // END fight


    private static void setDuelEnnemie(Perso perso1, Perso perso2) {
        perso1.setEnnemie(perso2);
        perso2.setEnnemie(perso1);
    }


    public static int getRandomNumberInRange(int min, int max) {

        if (min < max) {
            Random r = new Random();
            return r.nextInt((max - min) + 1) + min;
        }
        else {
            return getRandomNumberInRange(min,max);
        }
    }
}
