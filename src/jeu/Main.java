package jeu;

import org.apache.log4j.Logger;


public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //Log in console in and log file
        logger.info("Demarrage du programme !!");
        logger.debug("Demarrage du programme !!Mode debug");
        boolean choix = true;

        while (choix) {
            Menu menu = new Menu();
            int nbMenu;
            do {
                nbMenu = menu.runMenu();

            } while (nbMenu < 1 || nbMenu > 4);
            switch (nbMenu) {
                case 1:
                    Challenger challenger = new Challenger();
                    challenger.play();
                    break;
                case 2:
                    Defenseur defenseur = new Defenseur();
                    defenseur.play();
                    break;

                case 3:
                    Duel duel = new Duel();
                    duel.play();
                    break;
                default:
                    System.out.println("Au revoir");
                    System.exit(0);

            }


        }
    }
}






