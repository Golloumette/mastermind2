package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Joueur {
    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    private String Pseudo;
    private int Score;
    Scanner sc = new Scanner(System.in);

    public String getPseudo() {
        return Pseudo;
    }

    public int getScore() {
        return Score;
    }
}



