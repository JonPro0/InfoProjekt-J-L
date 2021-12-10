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
    int[] array = new int[]{3, 5,12, 5, 8, 78, 8};
    int[] reset =  new int[]{3, 5,12, 5, 8, 78, 8};
    int[] reset1 = new int[]{3, 5, 12, 5, 8, 78, 8};
    int[] reset2 = new int[]{3, 5, 12, 5, 8, 78, 8};
    public WettkampfGUI(SortierAusgabe ausgabe) {
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
                new Thread() {
                    public void run(){
                        bStart.setVisible(false);
                        wInsertionSort wInsertion = new wInsertionSort(array, ausgabe);
                        long startInsertion = System.currentTimeMillis();
                        wInsertion.sortieren(iArray, ausgabe);
                        iArray.setBackground(Color.green);
                        long endInsertion = System.currentTimeMillis();

                        array = reset;
                        System.out.println(Arrays.toString(array));

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        wSelectionSort wSelection = new wSelectionSort(array, ausgabe);
                        long startSelection = System.currentTimeMillis();
                        wSelection.sortieren(sArray, ausgabe);
                        sArray.setBackground(Color.green);
                        long endSelection = System.currentTimeMillis();

                        array = reset1;
                        System.out.println(Arrays.toString(array));

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        wBubbleSort wBubble = new wBubbleSort(array, ausgabe);
                        long startBubble = System.currentTimeMillis();
                        wBubble.sortieren(bArray, ausgabe);
                        bArray.setBackground(Color.green);
                        long endBubble = System.currentTimeMillis();

                        array = reset2;
                        System.out.println(Arrays.toString(array));

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        wBogoSort wBogo = new wBogoSort(array, ausgabe);
                        long startBogo = System.currentTimeMillis();
                        wBogo.sortieren(boArray, ausgabe);
                        boArray.setBackground(Color.green);
                        long endBogo = System.currentTimeMillis();

                        ausgabe.println("InsertionSort: " + (endInsertion - startInsertion) + "\n"
                                      + "SelectionSort: " + (endSelection - startSelection) + "\n"
                                      + "BubbleSort: "    + (endBubble    - startBubble)    + "\n"
                                      + "BogoSort: "      + ((endBogo      - startBogo) * 100)    );
                    }
                }.start();
            }
        });

        add(pWMain);
        setSize(820, 620);
        setResizable(false);
        setTitle("Wettkampf");
        setLocation(820, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


}
