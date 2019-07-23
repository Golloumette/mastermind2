package jeu;

public abstract class ModeDeJeu {
    private int ChiffreCombinaison;
    private int nombre_essai;

    public ModeDeJeu(int ChiffreCombinaison, int nombre_essai){
        this.ChiffreCombinaison = ChiffreCombinaison;
        this.nombre_essai = nombre_essai;

        }
    /*public abstract void genererCode(int){*/



    public abstract void afficherLaReponse();}




