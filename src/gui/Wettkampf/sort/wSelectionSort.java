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

    }

    public void sortieren(WArrayPanel parray, SortierAusgabe ausgabe) {

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;

            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            Util.swap(a, i, min);
            parray.setArray(a);
        }

    }
}
