package Q1.ArrayListen;

import java.util.ArrayList;

public class Demo {

    public static void main(String[] args) {
        String[] namen = new String[2];
        namen[0] = "Linus";
        namen[1] = "Rosa";
        // namen[2] = "Samuel"; -> Index out of Bounds


        ArrayList<String> namensListe = new ArrayList<>();
        namensListe.add("Linus");
        namensListe.add("Rosa");
        namensListe.add("Lucas");
        namensListe.add("Samuel");

        for (String name : namensListe){
            System.out.println(name);
        }

        if (namensListe.contains("Rosa")){
            System.out.println("Rosa steht an stelle: " + namensListe.indexOf("Rosa"));
        }

        namensListe.remove("Linus");

        System.out.println();


        if (namensListe.contains("Rosa")){
            System.out.println("Rosa steht an stelle: " + namensListe.indexOf("Rosa"));
        }

        namensListe.clear();

        System.out.println(namensListe);

    }
}
