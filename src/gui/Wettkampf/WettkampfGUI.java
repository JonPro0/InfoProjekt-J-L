package gui.Wettkampf;

import gui.ArrayPanel;
import gui.SortierAusgabe;
import gui.Wettkampf.sort.wBubbleSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public WettkampfGUI(SortierAusgabe ausgabe) {
        int[] array = {3, 5,12, 5, 8, 78, 8};
        BubblearrayPanel bArray = new BubblearrayPanel(array);
        pBubble.add(bArray);
        pInsertion.add(new BubblearrayPanel(array));
        pSelection.add(new BubblearrayPanel(array));
        pBogo.add(new BubblearrayPanel(array));


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
                     wBubbleSort wb = new wBubbleSort(array, ausgabe);
                     wb.sortieren(bArray, ausgabe);
                     bArray.setBackground(Color.green);
                 }
                }.start();
            }
        });

        add(pWMain);
        setSize(800, 600);
        setResizable(false);
        setTitle("Wettkampf");
        setLocation(800, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
