package gui;

import gui.Wettkampf.BubblearrayPanel;
import gui.Wettkampf.WettkampfGUI;
import gui.Wettkampf.sort.wBubbleSort;
import sortieren.BogoSort;
import sortieren.BubbleSort;
import sortieren.InsertionSort;
import sortieren.SelectionSort;
import util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class SortierGUI extends JFrame {
    private JPanel pMain;
    private JTextArea taAusgabe;
    private JButton bBubble;
    private JPanel pButtons;
    private JPanel pOutput;
    private JPanel POut;
    private JButton bInsertion;
    private JButton bSelection;
    private JButton bBogo;
    private JButton bGenerate;
    private JButton bReset;
    private JButton bWettkampf;
    private final ArrayPanel pArray;
    private final SortierAusgabe ausgabe;
    private int[] array;
    private Thread t;

    public SortierGUI() {
        array = new int[]{3, 6, 12, 8, 3, 78, 3, 5};
        ausgabe = new SortierAusgabe(taAusgabe);
        pArray = new ArrayPanel(array);
        POut.add(pArray);
        bBubble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t = new Thread() {
                    public void run() {
                        BubbleSort bsort = new BubbleSort(array, ausgabe);
                        bsort.sortieren(pArray, ausgabe);
                        pArray.setBackground(Color.green);
                    }
                };
                t.start();
            }
        });

        bInsertion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t = new Thread() {
                    public void run() {
                        InsertionSort Isort = new InsertionSort(array, ausgabe);
                        Isort.sortieren(pArray, ausgabe);
                        pArray.setBackground(Color.green);

                    }
                };
                t.start();
            }
        });

        bSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t = new Thread() {
                    public void run() {
                        SelectionSort Ssort = new SelectionSort(array, ausgabe);
                        Ssort.sortieren(pArray, ausgabe);
                        pArray.setBackground(Color.green);
                    }
                };
                t.start();
            }
        });

        bBogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                t = new Thread() {
                    public void run(){
                        BogoSort Bsort = new BogoSort(array, ausgabe);
                        Bsort.sortieren(pArray, ausgabe);
                        pArray.setBackground(Color.green);
                    }


                };
                t.start();
            }
        });

        bGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pArray.setBackground(Color.BLACK);
               ArrayGenerator Agenerate = new ArrayGenerator();
               String number = JOptionPane.showInputDialog("Wie groß soll das Array sein? (Zahl eingeben)");
               boolean isnumeric = util.Util.isNumeric(number);
               while(!isnumeric){
                   number = JOptionPane.showInputDialog("Dies war keine Zahl!! Bitte Anzahl erneut eingeben");
                   isnumeric = util.Util.isNumeric(number);
               }
              //
                while (!util.Util.validateNumber(Integer.parseInt(number))) {
                    number = JOptionPane.showInputDialog("Deine Zahl war zu groß! Bitte Anzahl kleiner als 1200 eingeben");
                }



               String max = JOptionPane.showInputDialog("Maximum für die Zahlen festlegen(Zahl eingeben)");
               isnumeric = util.Util.isNumeric(max);
                while(!isnumeric){
                    max = JOptionPane.showInputDialog("Dies war keine Zahl!! Bitte Maximum erneut eingeben");
                    isnumeric = util.Util.isNumeric(max);
                }
                while(Integer.parseInt(max) > Integer.MAX_VALUE){
                    max = JOptionPane.showInputDialog("Deine Zahl war zu groß! Bitte Maximum erneut eingeben");
                }

               array = ArrayGenerator.randomNumbers(Integer.parseInt(number), Integer.parseInt(max));
               pArray.setArray(array);

            }
        });

        bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(t != null){
                    t.stop();
                    ausgabe.println("Array zurückgesetzt! Neuen Button drücken, um wieder zu starten.");
                }
                pArray.setBackground(Color.BLACK);
                array = new int[]{3, 6, 12, 8, 3, 78, 3, 5};
                pArray.setArray(array);
            }
        });

        bWettkampf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                WettkampfGUI wgui = new WettkampfGUI();
                wBubbleSort wbubble = new wBubbleSort(array, ausgabe);
                BubblearrayPanel bubblearrayPanel = new BubblearrayPanel(array);
                wbubble.sortieren(bubblearrayPanel, ausgabe);
            }
        });



        add(pMain);
        setSize(800, 600);
        setResizable(false);
        setTitle("Mein Fenster 11G4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SortierGUI();
    }
}
