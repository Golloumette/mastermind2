package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    /**
     * Afficher le menu de selection
     */
    public void displayAvailableMenu() {

        System.out.println("Quel mode souhaitez vous lancer ?");
        System.out.println("1 - Mode Challenger");
        System.out.println("2 - Mode Défenseur");
        System.out.println("3 - Mode Duel");


    }


    public int runMenu() {
        Scanner sc = new Scanner(System.in);
        this.displayAvailableMenu();
        int nbMenu ;

            try{ nbMenu = sc.nextInt();

            } catch (InputMismatchException e) {

                nbMenu=0;
            }

         //} //while (!responseIsGood);
         return nbMenu;


    }
}





