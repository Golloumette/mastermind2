package jeu;

import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Defenseur {

    public List<CoupJoue> getHistorique() {
        return historique;
    }

    private List<CoupJoue> historique = new ArrayList<CoupJoue>();
    private String code = "";


    private static char inferieur = '-';
    private static char superieur = '+';
    private static char egal = '=';

    private static Logger logger = Logger.getLogger(Defenseur.class);

    public void play() {

        System.out.println("Bienvenue dans le mode défenseur");
        codeJoueur();
        do {
            ordiCode();
            compareCode();
            remplaceCode();
        }
        while (!code.equals(historique.get(historique.size() - 1).getCode()) && historique.size() < Config.getRessource().getEssai());
        if (historique.size()< Config.getRessource().getEssai()) {
            System.out.println("L'ordinateur a trouvé la combinaison en " + historique.size() + " coups");
        }else {
            System.out.println("Vous avez gagné, l'ordinateur n'a pas trouvé la combinaison.");
        }
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
            System.out.println("Merci de saisir votre code secret à " + Config.getRessource().getCombinaison() + " chiffres");
            code = sc.nextLine();

            b = Pattern.matches("^[0-9]+[0-9]$", code);
        } while (!b);

        return code;
    }

    /*
    L'ordi fait une proposition
     */
    public String ordiCode() {
        logger.info("Entré dans la méthode ordiCode");
        CoupJoue coupJoue = new CoupJoue();
        String code1 = "";
        int code = 0;
        if (historique.size() == 0) {
            int i = 0;

            Random c = new Random();
            do {
                code = c.nextInt(9);
                i++;
                code1 = code1 + String.valueOf(code);
            } while (i < Config.getRessource().getCombinaison());
            System.out.println(" L'odinateur propose la combinaison suivante :" + code1);
            coupJoue.setCode(code1);
            historique.add(coupJoue);
            return code1;
        } else {
            CoupJoue dernierCoupJoue = historique.get(historique.size() - 1);
            String code2 = "";
            for (int j = 0; j < Config.getRessource().getCombinaison(); j++) {
                char propoMax = CoupJoue.getCodeMax().charAt(j);// decouper le codemax par charactère
                int ipropoMax = Character.getNumericValue(propoMax);// transformer le  codemax en integer
                char propoMin = CoupJoue.getCodeMin().charAt(j);// decouper le codemin par charactere
                int ipropoMin = Character.getNumericValue(propoMin);// transformer le codemin en integer
                char symboleResultat = dernierCoupJoue.getResultat().charAt(j);// affichage du caractère +/-/=
                logger.debug("ipropomax=" + ipropoMax +" "+ "ipropomin=" + ipropoMin +" "+ "symbole" + symboleResultat);
                if (symboleResultat == inferieur) {
                    do {
                        code = generateRandom(ipropoMin, ipropoMax);
                    } while (code == ipropoMax);
                    code2 = code2 + String.valueOf(code);
                } else if (symboleResultat == superieur) {
                    do {
                        code = generateRandom(ipropoMin, ipropoMax);

                    } while (code == ipropoMin);
                    code2 = code2 + String.valueOf(code);
                } else {
                    code = generateRandom(ipropoMin, ipropoMax);
                    code2 = code2 + String.valueOf(code);

                }
                }
                System.out.println(" L'odinateur propose la combinaison suivante :" + code2);
                coupJoue.setCode(code2);
                historique.add(coupJoue);
                logger.info("Sortie de la méthode ordiCode");
                return code2;
            }

        }

    /*
    Le joueur indique à l'odinateur le résultat de sa proposition
     */
        public void compareCode () {
            logger.info("Entre dans la methode compareCode");
            String resultat = "";

            Scanner sc = new Scanner(System.in);
            boolean b;

            do {
                System.out.println("Merci d'indiquer pour chaque chiffre si le nombre à trouver est plus grand (+) plus petit (-) ou correct (=)");
                resultat = sc.nextLine();

                b = Pattern.matches("^[+\\-=]+$", resultat);
            } while (!b);//|| resultat.length() != code1.length());
            historique.get(historique.size() - 1).setResultat(resultat);
            logger.info("Sortie de la methode compareCode resultat=" + resultat);
        }

        private int generateRandom ( int min, int max){
            logger.info("Entrée dans la méthode generateRandom");
            if (min == max) {
               int nombre = (min + (int) (Math.random() * (max - min)));// conserve le chiffre correct
                return nombre;
            } else {
                    int nombre = min + (int) (Math.random() * ((max - min) + 1));
                 // random entre 0 et 9 inclus
            logger.info("Nombre="+nombre+" Sortie dans la méthode generateRandom");
                return nombre;

        }}


        private String remplaceCharAtPosition (String code,int position, char c){

            String retour = "";

            for (int i = 0; i < code.length(); i++) {
                if (i == position) {
                    retour = retour + c;
                } else {
                    retour = retour + code.substring(i, i + 1);
                }
            }
            return retour;
        }

        public void remplaceCode () {

            logger.info("Entrée dans la méthode replaceCode");
            CoupJoue dernierCoupJoue = historique.get(historique.size() - 1);
            logger.info("tableau " + dernierCoupJoue +""+ "codemin=" + CoupJoue.getCodeMin()+"" + "code max=" + CoupJoue.getCodeMax());
            for (int j = 0; j < Config.getRessource().getCombinaison(); j++) {
                char symboleResultat = dernierCoupJoue.getResultat().charAt(j);
                char codeChiffre = dernierCoupJoue.getCode().charAt(j);//decoupage du code ordi par caractère
                logger.info("codeChifre" + codeChiffre);
                if (symboleResultat == inferieur) {
                    CoupJoue.setCodeMax(remplaceCharAtPosition(CoupJoue.getCodeMax(), j, codeChiffre));
                    logger.info("affichage de code" + dernierCoupJoue.getCode());
                } else if (symboleResultat == superieur) {
                    CoupJoue.setCodeMin(remplaceCharAtPosition(CoupJoue.getCodeMin(), j, codeChiffre));
                } else {
                    CoupJoue.setCodeMax(remplaceCharAtPosition(CoupJoue.getCodeMax(), j, codeChiffre));
                    CoupJoue.setCodeMin(remplaceCharAtPosition(CoupJoue.getCodeMin(), j, codeChiffre));

                }


            }
            logger.info("tableau " + dernierCoupJoue +""+ "code max=" + CoupJoue.getCodeMax()+"" + "codemin=" + CoupJoue.getCodeMin() +""+ "sortie de la méthode remplaceCode");
        }

    }
