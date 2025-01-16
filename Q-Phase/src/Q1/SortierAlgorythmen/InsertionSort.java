package Q1.SortierAlgorythmen;

public class InsertionSort {
    private int anzahlSchleifendurchlaeufe = 0;

    public int[] insertionsort(int[] array) {

        for(int i = 1; i < array.length; i ++){
            int key = array[i];
            int k = i;
            for(;k > 0 && array[k-1] > key; k--) {
                    array[k] = array[k-1];
            }

            if(array[k] != key){ array[k] = key;}

            anzahlSchleifendurchlaeufe++;
        }

        return  array;
    }


    //Getter

    public int getAnzahlSchleifendurchlaeufe() {
        return anzahlSchleifendurchlaeufe;
    }
}
