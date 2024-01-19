package Schleifen;

public class MenschÄrgerDichNicht {
    public static void main(String[] args) {
        int gewürfelt = 0;
        int würfel = 0;

        do{
            würfel = (int) (Math.random() * 6 +1);
            System.out.println("Sie haben eine " + würfel);
            gewürfelt ++;
        } while (würfel == 6);

        System.out.println("Es wurde " + gewürfelt + "x gewürfelt");
    }
}
