package gui.Wettkampf.sort;

import gui.SortierAusgabe;
import gui.Wettkampf.WArrayPanel;
import util.Util;

import java.util.Arrays;

public class wBubbleSort {
    private SortierAusgabe ausgabe;
    private int[] a;
    int counter = 0;
    public wBubbleSort(int[] input) {
        a = input;
        this.ausgabe = null;
    }

    public wBubbleSort(int[] input, SortierAusgabe ausgabe) {
        a = input;
        this.ausgabe = ausgabe;

    }

    public void sortieren(WArrayPanel parray, SortierAusgabe ausgabe) {
        // Äußere Schleife, separiert unsortierten von sortiertem Bereich


        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    Util.swap(a, j, j + 1);
                    parray.setArray(a);

                }
            }
        }


    }
}