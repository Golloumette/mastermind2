package jeu;

public class CoupJoue {
    @Override
    public String toString() {
        return "CoupJoue{" +
                "code='" + code + '\'' +
                ", resultat='" + resultat + '\'' +
                '}';
    }

    private String code= "";
    private String resultat ="";
    private static String codeMin="";
    private static String codeMax="";


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public static String getCodeMin() {
        return codeMin;
    }

    public static void setCodeMin(String codeMin) {
        CoupJoue.codeMin = codeMin;
    }

    public static String getCodeMax() {
        return codeMax;
    }

    public static void setCodeMax(String codeMax) {
        CoupJoue.codeMax = codeMax;
    }




 
}
