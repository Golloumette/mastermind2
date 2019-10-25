package jeu;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * permet de rejouer après la fin de la partie
 */
public class Rejouer {

    /**
     * permet de recuperer le choix du joueur
     * @return return le choix du joueur
     */
    public boolean choix() {
        Scanner sc = new Scanner(System.in);
        String resultat ;
        boolean yes = false;
        System.out.println("Voulez vous rejouer");
        System.out.println("O - OUI   ou N - NON");
        boolean b;
        do {

            resultat = sc.nextLine();


            b = Pattern.matches("^[ON]+$", resultat);
        } while (!b);
        char choix = resultat.charAt(0);
        if (choix == 'O') {
            yes = true;

        } else {
            System.out.println("Au revoir");
            System.exit(0);
        }
        return yes;
    }

    /**
     * initialise la classe pour le premiere fois
     * @return
     */
    public static Rejouer getRessource() {
        if (ressource == null) {
            ressource = new Rejouer();
        }
        return ressource;
    }


    private static Rejouer ressource;
}

