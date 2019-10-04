package jeu;


public class test {
    public static void main(String[] args) {
        int nombre=0;
        /*String retour = "";
        int c = 7;
        String code ="0000";
        int position = 2;

        for (int i = 0; i < code.length(); i++) {
            if (i == position) {
                retour = retour + c;
            } else {
                retour = retour + code.substring(i, i + 1);
            }
        }
        System.out.println(retour);


        /*int nombre = 1+((int)(Math.random()*(9-1)));
        System.out.println(nombre);
        test test = new test();
        test.generateRandom(1, 7, true, false);
        test.generateRandom(4, 8, true, false);*/

        //System.out.println(5 + (int)(Math.random() * ((5 - 5) ))+"chiffe random");
        int min = 8;
        int max = 9;
        do {
            nombre = min + (int) (Math.random() * ((max - min) + 1));
        } while (nombre == min || nombre == max);// random entre 0 et 9 inclus
        System.out.println(nombre);//0;9
       // System.out.println((int)Math.random() * ( max - min ));//0
        //System.out.println(min + (int)(Math.random() * (max - min)));//0 pas de 9

        /*private int generateRandom ( int min, int max, boolean exclusMin, boolean exclusMax){*/

    }
        public String remplaceCharAtPosition (String code,int position, int c){
            String retour = "9999";
            c = 7;

            for (int i = 0; i < code.length(); i++) {
                if (i == position) {
                    retour = retour + c;
                } else {
                    retour = retour + code.substring(i, i + 1);
                }
            }
            System.out.println(retour);
            return retour;
        }


}
