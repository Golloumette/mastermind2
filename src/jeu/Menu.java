package jeu;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static org.apache.log4j.Logger logger = Logger.getLogger(Menu.class);

    /**
     * Afficher le menu de selection
     */
    public void displayAvailableMenu() {

        System.out.println("Quel mode souhaitez vous lancer ?");
        System.out.println("1 - Mode Challenger");
        System.out.println("2 - Mode Défenseur");
        System.out.println("3 - Mode Duel");
        System.out.println("4 - Quitter le jeu");


    }


    public int runMenu() {
        logger.info(" Entrée dans runMenu");

        Scanner sc = new Scanner(System.in);
        this.displayAvailableMenu();
        int nbMenu;

        try {
            nbMenu = sc.nextInt();

        } catch (InputMismatchException e) {
            logger.error("", e);
            nbMenu = 0;
        }

        return nbMenu;


    }
}





