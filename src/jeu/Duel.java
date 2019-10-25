package jeu;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Mode duel le joueur et l'ordinateur doivent trouver le code de l'autre
 */

public class Duel {

    private Defenseur defenseur = new Defenseur();
    private Challenger challenger = new Challenger();
    private static Logger logger = Logger.getLogger(Duel.class);

    /**
     * Combinaison des méthodes de challenger et défenseur
     *
     */

    public void play() {
        logger.info("Enree dans la méthode play");
        boolean retour;
        List<CoupJoue> historique = defenseur.getHistorique();
        System.out.println("Bienvenue dans le mode duel");
        defenseur.codeJoueur();// code généré par l'ordinateur
        challenger.generateCode(); // code généré par l'ordinateur
        do {
            defenseur.ordiCode();
            defenseur.compareCode();
            defenseur.remplaceCode();
            System.out.println("A vous de trouver la oombinaison de l'ordinateur");
            retour = challenger.saisieUtilisateur();
            logger.debug(String.format("code= %s historique%s",defenseur.getCode(),historique.get(historique.size()-1).getCode()) );
        }while (!retour && !defenseur.getCode().equals(historique.get(historique.size()-1).getCode()));
        if (defenseur.getCode().equals(historique.get(historique.size()-1).getCode())){
            System.out.println("L'ordinatuer vous a battu");
        }else {
            System.out.println("Vous avez battu l'ordinateur ");
        }
        Rejouer.getRessource().choix();
        logger.info("Sortie de la méthode play");

    }

}

