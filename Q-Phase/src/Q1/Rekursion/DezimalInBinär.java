package Q1.Rekursion;

public class DezimalInBinär {

    public static void main(String[] args) {
        System.out.println(umrechnung(15));
    }

    public static String umrechnung(int decimalNumber){
        String temp = String.valueOf(decimalNumber%2);

        if(decimalNumber == 0){
            return temp;
        }
        return temp += umrechnung(decimalNumber/2);
    }
}

