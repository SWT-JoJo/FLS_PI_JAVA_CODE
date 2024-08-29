package E2.Methoden;

import java.awt.*;

public class GeilerNetAufgabe2 {
    public static void main(String[] args) {
        GeilerNetAufgabe2  geilernetAufgabe2 = new GeilerNetAufgabe2();
        geilernetAufgabe2.kaWieIchDieseMethodeNenenSoll();
    }

    public void kaWieIchDieseMethodeNenenSoll(){
        Point p1 = new Point(10, 10);
        Point p1Copy = p1;

        System.out.println("Vor der Verdopplung:");
        System.out.println(p1);
        System.out.println(p1Copy);

        p1Copy.x *= 2;
        p1Copy.y *=2;
        System.out.println("Nach der Verdopplung");
        System.out.println(p1);
        System.out.println(p1Copy);
    }
}
