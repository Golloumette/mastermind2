package jeu;
//import org.apache.log4j.Logger;
//import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    //static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //DOMConfigurator.configure("Log4j.xml");

        //Log in console in and log file
        //logger.info("Démarrage du programme !!");
        // logger.debug("Démarrage du programme !!Mode débug");

        Menu menu = new Menu();
        int nbMenu = menu.runMenu();
        do {
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
                    duel.Duel();
                    break;
                default:
                    System.out.println("Merci de choisir l'un des trois modes proposés");
                    // Scanner sc = new Scanner(System.in);
                    // sc.next();
                    nbMenu = menu.runMenu();
                    break;
            }
        } while (nbMenu < 1 || nbMenu > 3);
    }

}




