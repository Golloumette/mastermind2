package jeu;

import org.apache.log4j.Logger;

import java.util.List;

public class Duel {

    private Defenseur defenseur = new Defenseur();
    private Challenger challenger = new Challenger();
   // String code1 = ;
    //private String code = "";
    private static Logger logger = Logger.getLogger(Duel.class);


    public void play() {
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
            logger.info(String.format("Valeur de retour=%s ",retour));
            logger.debug(String.format("code= %s historique%s",defenseur.getCode(),historique.get(historique.size()-1).getCode()) );
        }while (!retour && !defenseur.getCode().equals(historique.get(historique.size()-1).getCode()));


        System.out.println("Vous avez battu l'ordinateur");

    }

}

