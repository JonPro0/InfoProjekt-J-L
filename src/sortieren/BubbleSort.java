package sortieren;

import gui.ArrayPanel;
import gui.SortierAusgabe;
import util.Util;

import java.util.Arrays;

public class BubbleSort {
    private SortierAusgabe ausgabe;
    private int[] a;
    int counter = 0;
    public BubbleSort(int[] input) {
        a = input;
        this.ausgabe = null;
    }

    public BubbleSort(int[] input, SortierAusgabe ausgabe) {
        a = input;
        this.ausgabe = ausgabe;
        ausgabe.println("BubbleSort gestartet");
    }

    public void sortieren(ArrayPanel parray, SortierAusgabe ausgabe) {
        // Äußere Schleife, separiert unsortierten von sortiertem Bereich
        if (ausgabe != null) {
            ausgabe.println("Vorher: " + Arrays.toString(a));
        }

        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    Util.swap(a, j, j + 1);
                    parray.setArray(a);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        if (ausgabe != null) {
            ausgabe.println("Nachher: " + Arrays.toString(a));
        }
    }
}