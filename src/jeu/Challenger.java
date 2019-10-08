package jeu;


import org.apache.log4j.Logger;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Challenger {
    private static Logger logger = Logger.getLogger(Challenger.class);


    String code1 = "";
    public int nbCoup = 0;



    public String generateCode() {
        logger.info("Entrée dans la methode generateCode");
        int code = 0;
        int i = 0;
        Random c = new Random();
        do {
            code = c.nextInt(9);
            i++;
            code1 = code1 + String.valueOf(code);
        } while (i < Config.getRessource().getCombinaison());
        if (Config.getRessource().getDeveloppeur())
            System.out.println(code1);
        logger.info("Sortie de la methode generateCode");
        return code1;
    }


    public void play() {
        logger.info("Entrée dans la methode play");
        System.out.println("Bienvenue dans le mode challenger");
        generateCode();

        boolean retour;

        do {
            retour = saisieUtilisateur();
            nbCoup++;
        } while (!retour && nbCoup <Config.getRessource().getEssai().intValue());

        if (nbCoup < 2)
            System.out.println("Vous avez gagné en  " + nbCoup + " coup");
        else if (retour && nbCoup <= Config.getRessource().getEssai().intValue())
            System.out.println("Vous avez réussi en " + nbCoup + " coups");
        else
            System.out.println("Vous avez perdu la solution était " + code1 + " " + nbCoup);
        logger.info("Sortie de la methode play");

    }

    public boolean saisieUtilisateur() {
        logger.info("Entre dans la methode saisieUtilisateur");
        Scanner sc = new Scanner(System.in);
        String propo1 = "";
        boolean b;
        do {
            System.out.println("Merci de saisir un code à " + Config.getRessource().getCombinaison() + " chiffres");
            propo1 = sc.nextLine();

            b = Pattern.matches("^[0-9]+$", propo1);
        } while (!b || propo1.length() != code1.length());
        boolean retour = true;
        for (int i = 0; i < Config.getRessource().getCombinaison(); i++) {
            char code3 = code1.charAt(i);
            char propo2 = propo1.charAt(i);
            if (code3 == propo2)
                System.out.print("=");

            else if (code3 < propo2) {
                System.out.print("-");
                retour = false;
            } else {
                System.out.print("+");
                retour = false;
            }
        }
        System.out.println("");
        logger.info("Sortie de la methode saisieUtilisateur");
        return retour;

    }
}


