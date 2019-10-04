package jeu;


import org.apache.log4j.Logger;

import java.util.ResourceBundle;

public class Config {
    private Integer essai;
    private Integer combinaison;
    private Boolean developpeur;
    private static Logger logger = Logger.getLogger(Config.class);

    public static Config getRessource() {
        if (ressource == null) {
            ressource = new Config();
        }
        return ressource;
    }


    private static Config ressource;

    private Config() {
        readerproperty();

    }


    public Integer getEssai() {
        return essai;
    }

    public Integer getCombinaison() {
        return combinaison;
    }

    public Boolean getDeveloppeur() {
        return developpeur;
    }

    public void readerproperty() {
        logger.info("Entre dans la methode readerproperty");

        ResourceBundle config = ResourceBundle.getBundle("toto");

        combinaison = Integer.decode(config.getString("Combinaison"));
        essai = Integer.decode(config.getString("Essai"));
        developpeur = Boolean.parseBoolean(config.getString("Developpeur"));

        logger.info("Sortie de la methode readerproperty");
    }
}

