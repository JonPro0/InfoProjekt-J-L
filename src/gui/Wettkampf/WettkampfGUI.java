package gui.Wettkampf;

import gui.SortierAusgabe;
import gui.Wettkampf.sort.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class WettkampfGUI extends JFrame {
    private JPanel pWMain;
    private JPanel pBubble;
    private JPanel pInsertion;
    private JPanel pSelection;
    private JPanel pBogo;
    private JTextArea bogoSortTextArea;
    private JTextArea selectionSortTextArea;
    private JTextArea insertionSortTextArea;
    private JTextArea bubbleSortTextArea;
    private JButton bStart;
    private JButton bstart = new JButton();
    int[] array;
    int[] reset;
    int[] reset1;
    int[] reset2;
    public WettkampfGUI(SortierAusgabe ausgabe, int[] arr) {
        this.array = arr;
        this.reset = arr;
        this.reset1 = arr;
        this.reset2 = arr;
        WArrayPanel bArray = new WArrayPanel(array);
        pBubble.add(bArray);
        WArrayPanel iArray = new WArrayPanel(array);
        pInsertion.add(iArray);
        WArrayPanel sArray = new WArrayPanel(array);
        pSelection.add(sArray);
        WArrayPanel boArray = new WArrayPanel(array);
        pBogo.add(boArray);


        bstart.setLocation(1200, 300);
        bstart.setText("Starten");
        bstart.setSize(400, 400);
        bstart.setVisible(true);


        bStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bStart.setVisible(false);
                new Thread() {
                    public void run(){

                        wInsertionSort wInsertion = new wInsertionSort(array, ausgabe);
                        long startInsertion = System.currentTimeMillis();
                        wInsertion.sortieren(iArray, ausgabe);
                        iArray.setBackground(Color.green);
                        long endInsertion = System.currentTimeMillis();

                        ausgabe.println("InsertionSort: " + (endInsertion - startInsertion));

                    }
                }.start();
                new Thread(){
                    public void run(){
                        wSelectionSort wSelection = new wSelectionSort(reset, ausgabe);
                        long startSelection = System.currentTimeMillis();
                        wSelection.sortieren(sArray, ausgabe);
                        sArray.setBackground(Color.green);
                        long endSelection = System.currentTimeMillis();

                        ausgabe.println("SelectionSort: " + (endSelection - startSelection));
                    }
                }.start();
                new Thread() {
                    public void run(){
                        wBubbleSort wBubble = new wBubbleSort(reset1, ausgabe);
                        long startBubble = System.currentTimeMillis();
                        wBubble.sortieren(bArray, ausgabe);
                        bArray.setBackground(Color.green);
                        long endBubble = System.currentTimeMillis();

                        ausgabe.println("BubbleSort: "    + (endBubble    - startBubble));
                    }
                }.start();
                new Thread(){
                    public void run(){
                        wBogoSort wBogo = new wBogoSort(reset2, ausgabe);
                        long startBogo = System.currentTimeMillis();
                        wBogo.sortieren(boArray, ausgabe);
                        boArray.setBackground(Color.green);
                        long endBogo = System.currentTimeMillis();

                        ausgabe.println("BogoSort: "      + ((endBogo      - startBogo))    );
                    }
                }.start();
            }
        });

        /* + "\n"
                +  + "\n"
                +     + "\n"
                + */

        add(pWMain);
        setSize(820, 620);
        setResizable(false);
        setTitle("Wettkampf");
        setLocation(820, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


}
