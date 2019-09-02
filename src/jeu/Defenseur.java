package jeu;

import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Defenseur {
    private Config config = new Config();
    private List<CoupJoue> historique  = new ArrayList <CoupJoue>();
    private String code = "";
    private String  resultat = "";

    private static Logger logger = Logger.getLogger(Defenseur.class);

    public void play() {

        System.out.println("Bienvenue dans le mode défenseur");
        codeJoueur();
        do {
            ordiCode();
            compareCode();
            for (CoupJoue coupJoue : historique){
                System.out.println(" Affichage de l'historique code = " + coupJoue.getCode()+" résultat = "+coupJoue.getResultat());
            }

        } while (!code.equals(historique.get(historique.size()-1).getCode()) && historique.size()<config.getEssai());

    }
        /*Voici les spécifications pour l’autre mode “défenseur” :

Le joueur (cette fois dans le rôle de défenseur) définit une combinaison de X chiffres aléatoirement.
L'intelligence artificielle de l’ordinateur doit faire une proposition d’une combinaison de X chiffres (c’est le rôle attaquant).
Le joueur indique pour chaque chiffre de la combinaison proposée si le chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c’est le bon (=).
L’intelligence artificielle fait une autre proposition en se basant sur la réponse fournit par le joueur.
Il y a un nombre limité d’essais.*/

    /*
    Le joueur choisi son code secret
     */
    public String codeJoueur() {
        Scanner sc = new Scanner(System.in);

        boolean b;
        do {
            System.out.println("Merci de saisir votre code secret à " + config.getCombinaison() + " chiffres");
            code = sc.nextLine();

            b = Pattern.matches("^[0-9]+[0-9]$", code);
        } while (!b);

        return code;

    }
    /*
    L'ordi fait une proposition
     */
    public String ordiCode() {
        CoupJoue coupJoue = new CoupJoue();

        int code = 0;
        int i = 0;
        String code1 = "";
        Random c = new Random();
        do {
            code = c.nextInt(9);
            i++;
            code1 = code1 + String.valueOf(code);
        } while (i < config.getCombinaison());
        if (config.getDeveloppeur())
            System.out.println( " L'odinateur propose la combinaison suivante :"+code1);
        coupJoue.setCode(code1);
        historique.add(coupJoue);
        return code1 ;
    }
    /*
    Le joueur indique à l'odinateur le résultat de sa proposition
     */
    public void compareCode() {
        logger.info("Entre dans la methode compareCode");
        char inferieur = '-' ;
        char superieur = '+';
        char egal = '=';

        Scanner sc = new Scanner(System.in);
        boolean b ;

        do {
            System.out.println("Merci d'indiquer pour chaque chiffre si le nombre à trouver est plus grand (+) plus petit (-) ou correct (=)");
            resultat = sc.nextLine();

            b = Pattern.matches("^[+\\-=]+$", resultat);
        } while (!b );//|| resultat.length() != code1.length());
        historique.get(historique.size()-1).setResultat(resultat);
        for(int i = 0; i<config.getCombinaison();i++){
        char symboleResultat = resultat.charAt(i);
        char propo = ordiCode().charAt(i);
        if (symboleResultat == inferieur)
        Random chiffre = new Random(historique.get(historique.size()-1));}
        logger.info("Sortie de la methode compareCode resultat="+resultat);
    }

}
