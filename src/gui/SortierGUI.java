package gui;

import sortieren.BogoSort;
import sortieren.BubbleSort;
import sortieren.InsertionSort;
import sortieren.SelectionSort;
import util.*;
import java.util.Scanner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private final ArrayPanel pArray;
    private final SortierAusgabe ausgabe;
    private int[] array;
    private Thread t;
    public SortierGUI() {
        array = new int[]{3, 6, 12, 8, 3, 78, 3, 5};
        ausgabe = new SortierAusgabe(taAusgabe);
        pArray = new ArrayPanel(array);
        POut.add(pArray);
        Scanner scanner = new Scanner(System.in);
        bBubble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t = new Thread() {
                    public void run() {
                        BubbleSort bsort = new BubbleSort(array, ausgabe);
                        bsort.sortieren(pArray, ausgabe);
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
                    }


                };
                t.start();
            }
        });

        bGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ArrayGenerator Agenerate = new ArrayGenerator();
               String number = JOptionPane.showInputDialog("Wie groß soll das Array sein? (Zahl eingeben)");
               boolean isnumeric = util.Util.isNumeric(number);
               while(!isnumeric){
                   number = JOptionPane.showInputDialog("Dies war keine Zahl!! Bitte Anzahl erneut eingeben");
                   isnumeric = util.Util.isNumeric(number);
               }
               String max = JOptionPane.showInputDialog("Maximum für die Zahlen festlegen(Zahl eingeben)");
               isnumeric = util.Util.isNumeric(max);
                while(!isnumeric){
                    max = JOptionPane.showInputDialog("Dies war keine Zahl!! Bitte Maximum erneut eingeben");
                    isnumeric = util.Util.isNumeric(max);
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
                    ausgabe.println("Aktion abgebrochen, neuen Button drücken um wieder zu starten");
                }
                array = new int[]{3, 6, 12, 8, 3, 78, 3, 5};
                pArray.setArray(array);
            }
        });



        add(pMain);
        setSize(800, 600);
        setTitle("Mein Fenster 11G4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SortierGUI();
    }
}
