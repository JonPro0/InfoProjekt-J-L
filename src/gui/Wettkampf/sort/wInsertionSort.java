package gui.Wettkampf.sort;

import gui.ArrayPanel;
import gui.SortierAusgabe;
import gui.Wettkampf.WArrayPanel;
import util.Util;

import java.util.Arrays;

public class wInsertionSort {
    private SortierAusgabe ausgabe;
    private int[] a;

    public wInsertionSort(int[] input){
        a = input;
        this.ausgabe = null;
    }

    public wInsertionSort(int[] input, SortierAusgabe ausgabe) {
        a = input;


    }

    public void sortieren(WArrayPanel parray, SortierAusgabe ausgabe) {
        // 7       / 2 3 1 0 8 5
        // 2 7     / 3 1 0 8 5
        // 2 3 7   / 1 0 8 5
        // 2 3 1 7 / 0 8 5
        // 2 1 3 7 / 0 8 5
        // 1 2 3 7 / 0 8 5
        //     j
        // 1 2 3 10    /  7
        // 1 2 3 7     / 10



        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                Util.swap(a, j, j - 1);
                j -= 1;
                parray.setArray(a);
            }
        }


        // for (int i = 1; i < a.length; i++) {
        //     for (int j = i; j > 0; j--) {
        //         if (a[j] < a[j-1]) {
        //             Util.swap(a, j, j-1);
        //         }
        //     }
        // }
    }
}
