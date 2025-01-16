package Q1.SortierAlgorythmen;

public class SelectionSort {
    private static int anzSchleifendurchlauefe = 0;
    private static int anzTauschdurchgaenge = 0;

    public static int[] selectionSort(int[] feld){
        for(int i = 0; i < feld.length-1; i ++){
            int temp = i;
            for(int k = i+1; k < feld.length; k++){
                if(feld[k] < feld[temp]){
                    temp = k;
                }
            }

            if(temp != i) {
                int temp2 = feld[i];
                feld[i] = feld[temp];
                feld[temp] = temp2;
                anzTauschdurchgaenge++;
            }
            anzSchleifendurchlauefe++;
        }

        return feld;
    }



    //Getter
    public static int getAnzSchleifendurchlauefe() {
        return anzSchleifendurchlauefe;
    }

    public static int getAnzTauschdurchgaenge() {
        return anzTauschdurchgaenge;
    }
}
