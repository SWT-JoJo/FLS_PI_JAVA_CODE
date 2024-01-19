package Schleifen;

public class Würfel {

    public static void main(String[] args) {

        int würfel1 = (int) (Math.random() * 6 + 1);
        int würfel2 = (int) (Math.random() * 6 + 1);
        System.out.println("Würfel 1: " + würfel1);
        System.out.println("Würfel 1: " + würfel2);

        if(würfel2 == würfel1){
            System.out.println("GEWINNN");
        }
        else{
            System.out.println("LOOSER");
        }
    }
}
