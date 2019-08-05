package jeu;

import org.apache.log4j.Logger;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Defenseur {
    private Config config = new Config();
    private String code = "";

    private static Logger logger = Logger.getLogger(Defenseur.class);

    public void play() {

        System.out.println("Bienvenue dans le mode défenseur");
        saisieUtilisateur();
        System.out.println(code);
        /*Voici les spécifications pour l’autre mode “défenseur” :

Le joueur (cette fois dans le rôle de défenseur) définit une combinaison de X chiffres aléatoirement.
L'intelligence artificielle de l’ordinateur doit faire une proposition d’une combinaison de X chiffres (c’est le rôle attaquant).
Le joueur indique pour chaque chiffre de la combinaison proposée si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c’est le bon (=).
L’intelligence artificielle fait une autre proposition en se basant sur la réponse fournit par le joueur.
Il y a un nombre limité d’essais.*/
    }

    public String saisieUtilisateur() {
        Scanner sc = new Scanner(System.in);

        boolean b;
        do {
            System.out.println("Merci de saisir votre code secret à " + config.getCombinaison() + " chiffres");
            code = sc.nextLine();

            b = Pattern.matches("^[0-9]+[0-9]$", code);
        } while (!b);

        return code;

    }
}
