package jeu;

import org.apache.log4j.Logger;


public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {


        //Log in console in and log file
        logger.info("Démarrage du programme !!");
        logger.debug("Démarrage du programme !!Mode débug");

        Menu menu = new Menu();
         int nbMenu;
        do {
            nbMenu = menu.runMenu();

        } while (nbMenu < 1 || nbMenu > 3);
        switch (nbMenu) {
            case 1:
                Challenger challenger = new Challenger();
                challenger.play();
                break;
            case 2:
                Defenseur defenseur = new Defenseur();
                defenseur.play();
                break;
            default:
                Duel duel = new Duel();
                duel.play();
                break;

        }
    }
}






