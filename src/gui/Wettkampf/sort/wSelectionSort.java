package gui.Wettkampf.sort;

import gui.ArrayPanel;
import gui.SortierAusgabe;
import gui.Wettkampf.WArrayPanel;
import util.Util;

import java.util.Arrays;

public class wSelectionSort {
    private int[] a;
    private SortierAusgabe ausgabe;

    public wSelectionSort(int[] input){
        a = input;
        this.ausgabe = null;
    }

    public wSelectionSort(int[] input, SortierAusgabe ausgabe) {
        a = input;
        this.ausgabe = ausgabe;
        ausgabe.println("SelectionSort gestartet");
    }

    public void sortieren(WArrayPanel parray, SortierAusgabe ausgabe) {
        if (ausgabe != null){
            ausgabe.println("Vorher: " + Arrays.toString(a));
        }
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;

            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            Util.swap(a, i, min);
            if(a.length < 40){
                try{
                    Util.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if(a.length < 80){
                try{
                    Util.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try{
                    Util.sleep(1);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            parray.setArray(a);
        }
        if (ausgabe != null){
            ausgabe.println("Nachher: " + Arrays.toString(a));
        }
    }
}
