package jeu;

public class CoupJoue {
    private String Code= "";
    private String Resultat ="";

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getResultat() {
        return Resultat;
    }

    public void setResultat(String resultat) {
        Resultat = resultat;
    }

    @Override
    public String toString() {
        return "CoupJoue{" +
                "Code='" + Code + '\'' +
                ", Resultat='" + Resultat + '\'' +
                '}';
    }
 
}
