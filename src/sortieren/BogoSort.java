package sortieren;

import gui.ArrayPanel;
import gui.SortierAusgabe;

import java.util.Arrays;

public class BogoSort
{
    private SortierAusgabe ausgabe;
    private int[] a;


    public BogoSort(int[] input){
        a = input;
        this.ausgabe = ausgabe;
    }

    public BogoSort(int[] input, SortierAusgabe ausgabe) {
        a = input;
        this.ausgabe = ausgabe;
        ausgabe.println("BogoSort gestartet");
    }

    public void sortieren(ArrayPanel parray, SortierAusgabe ausgabe){
        if(ausgabe != null){
            ausgabe.println("Vorher: " + Arrays.toString(a));
        }
        bogo(a, parray, ausgabe);



    }
    void bogo(int[] arr, ArrayPanel parray2, SortierAusgabe ausgabe)
    {
        int shuffle=1;
        for(;!isSorted(arr);shuffle++)
            shuffle(arr, parray2);
        if(ausgabe != null){
            ausgabe.println("Nachher: " + Arrays.toString(a));
        }

        ausgabe.println("This took "+shuffle+" shuffles.");
    }
    void shuffle(int[] arr, ArrayPanel parray3)
    {

        int i=arr.length-1;
        while(i>0)
            swap(arr,i--,(int)(Math.random()*i), parray3);
    }
    void swap(int[] arr,int i,int j, ArrayPanel parray4)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        parray4.setArray(a);
        try {
            Thread.sleep((long) 0.5);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
    boolean isSorted(int[] arr)
    {

        for(int i=1;i<arr.length;i++)
            if(arr[i]<arr[i-1])
                return false;
        return true;
    }
}