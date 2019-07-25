package jeu;



import java.util.Random;
import java.util.Scanner;

public class Challenger {
    private Config config = new Config();
    String code1 = "";
    //private String proposition;


    public String generateCode() {
        int code = 0;
        int i = 0;
        Random c = new Random();
        do {
            code = c.nextInt(9);
            i++;
            code1 = code1 + String.valueOf(code);
        } while (i < config.getCombinaison());
        if (config.getDeveloppeur())
            System.out.println(code1);
        return code1;
    }


    public void play() {
        System.out.println("Bienvenue dans le mode challenger");
        generateCode();
        int nbCoup = 0;
        boolean retour;

        do {
            retour = saisieUtilisateur();
            nbCoup++;
        } while (!retour && nbCoup < config.getEssai());

        if (nbCoup < 2)
            System.out.println("Vous avez gagné en  " + nbCoup + " coup");
        else if (nbCoup != config.getEssai())
            System.out.println("Vous avez réussi en " + nbCoup + " coups");
        else
            System.out.println("Vous avez perdu la solution était " + code1);

    }

    public boolean saisieUtilisateur() {
        Scanner sc = new Scanner(System.in);
        Integer propositionChiffre = 0;
        boolean chiffre = false;
        sc.nextLine();
        System.out.println("Merci de saisir un code à " + config.getCombinaison() + " chiffres");
        do {

             String proposition = sc.nextLine();
             try {
                 propositionChiffre = Integer.parseInt(proposition);
                 chiffre = true;
             } catch ( NumberFormatException  e ){
                System.out.println("Cette valeur n'est pas un nombre,merci de saisir un code à " + config.getCombinaison() + " chiffres");
             } /*catch (StringIndexOutOfBoundsException e){
                 System.out.println("Cette valeur n'est pas un nombre,merci de saisir un code à " + config.getCombinaison() + " chiffres");
             }*/

            //proposition = String.valueOf(chiffre);

            //  if (proposition.length() < code1.length());
            //System.out.println("Vous devez saisir un code à " + config.getCombinaison() + " chiffres");
            // verouiller par des chiffres
        } while (chiffre!= true);
                //proposition.length() != code1.length());
        String propo2 = String.valueOf(propositionChiffre);
        boolean retour = true;
        for (int i = 0; i < config.getCombinaison(); i++) {
            char code3 = code1.charAt(i);
            char propo1 = propo2.charAt(i);
            if (code3 == propo1)
                System.out.print("=");

            else if (code3 < propo1) {
                System.out.print("+");
                retour = false;
            } else {
                System.out.print("-");
                retour = false;
            }
        }
        System.out.println("");
        return retour;
    }
}


