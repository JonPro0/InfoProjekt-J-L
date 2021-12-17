package gui.Wettkampf.sort;

import gui.ArrayPanel;
import gui.SortierAusgabe;
import gui.Wettkampf.WArrayPanel;

import java.util.Arrays;

public class wBogoSort
{
    private SortierAusgabe ausgabe;
    private int[] a;


    public wBogoSort(int[] input){
        a = input;
        this.ausgabe = ausgabe;
    }

    public wBogoSort(int[] input, SortierAusgabe ausgabe) {
        a = input;
        this.ausgabe = ausgabe;

    }

    public void sortieren(WArrayPanel parray, SortierAusgabe ausgabe){
        bogo(a, parray, ausgabe);



    }
    void bogo(int[] arr, WArrayPanel parray2, SortierAusgabe ausgabe)
    {
        int shuffle=1;
        for(;!isSorted(arr);shuffle++)
            shuffle(arr, parray2);



    }
    void shuffle(int[] arr, WArrayPanel parray3)
    {

        int i=arr.length-1;
        while(i>0)
            swap(arr,i--,(int)(Math.random()*i), parray3);
    }
    void swap(int[] arr,int i,int j, WArrayPanel parray4)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        parray4.setArray(a);


    }
    boolean isSorted(int[] arr)
    {

        for(int i=1;i<arr.length;i++)
            if(arr[i]<arr[i-1])
                return false;
        return true;
    }
}