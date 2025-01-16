public class PinGenerator {
    public static void main(String[] args) {
        int laenge = 4;
        String temp = "";
        int i = 0;
        while (i < laenge){ //for - loop
            temp += ((int) (Math.random() * 9 + 1) );
            i = i+1;
        }

        System.out.println(temp); //pint()

    }


}
