package Schleifen;

public class AsciiToChar {
    public static void main(String[] args) {
        for(int i = 65; i < 123;){
            for(int k = 0;k < 6; k++){
                if(i == 91){
                    i = 97;
                }
                System.out.printf("%d = %c", i,i);
                System.out.print(" | ");

                i ++;

                if (i == 123) {
                    break;
                }
            }
            System.out.println();
        }
    }
}
