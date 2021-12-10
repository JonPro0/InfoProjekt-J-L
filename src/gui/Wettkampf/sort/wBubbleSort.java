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
        ausgabe.println("wBubbleSort gestartet");
    }

    public void sortieren(WArrayPanel parray, SortierAusgabe ausgabe) {
        // Äußere Schleife, separiert unsortierten von sortiertem Bereich
        if (ausgabe != null) {
            ausgabe.println("Vorher: " + Arrays.toString(a));
        }

        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    Util.swap(a, j, j + 1);
                    parray.setArray(a);
                    if(a.length < 40){
                        try{
                            util.Util.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if(a.length < 80){
                        try{
                            util.Util.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try{
                            util.Util.sleep(1);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        if (ausgabe != null) {
            ausgabe.println("Nachher: " + Arrays.toString(a));
        }
    }
}