package jeu;

import java.util.ArrayList;

public class CoupJoue {
    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getRésultat() {
        return Résultat;
    }

    public void setRésultat(String résultat) {
        Résultat = résultat;
    }

    private String Code= "";
    private String Résultat ="";


    ArrayList CompareCode = new ArrayList();

    @Override
    public String toString() {
        return "CoupJoue{" +
                "Code='" + Code + '\'' +
                ", Résultat='" + Résultat + '\'' +
                '}';
    }
 
}
