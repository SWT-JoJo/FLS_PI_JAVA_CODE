package Q1.SortierAlgorythmen;

public class QuickSort{
    private int anzahlSchleifendurchlaeufe = 0;
    private int anzahlTauschvorgaenge = 0;


    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] temp = {5,17,8,3,5,1,12,75,6,0};


        for(int i : temp){
            System.out.print(i +", ");
        }
    }

    public int[] quickSort(int[] array, int links, int rechts){

        int i = links;
        int j = rechts;
        int wertMitte = array[(rechts + links) / 2];
        do{
            while (array[i] < wertMitte){
                i++;
            }
            while (array[j] > wertMitte){
                j--;
            }

            if(i <= j){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;

                i++;
                j--;
            }
        } while (i <= j);

        if(links < j){
            quickSort(array, links , j);
        }
        if(i < rechts){
            quickSort(array, i , rechts);
        }

        return array;
    }


    //Getter

    public int getAnzahlSchleifendurchlaeufe() {
        return anzahlSchleifendurchlaeufe;
    }

    public int getAnzahlTauschvorgaenge() {
        return anzahlTauschvorgaenge;
    }
}
