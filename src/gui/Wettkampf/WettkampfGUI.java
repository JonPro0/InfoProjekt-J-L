package gui.Wettkampf;

import gui.ArrayPanel;

import javax.swing.*;
import java.awt.*;

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

    public WettkampfGUI() {
        int[] array = {3, 5,12, 5, 8, 78, 8};
        BubblearrayPanel bArray = new BubblearrayPanel(array);
        pBubble.add(new BubblearrayPanel(array));
        pInsertion.add(new BubblearrayPanel(array));
        pSelection.add(new BubblearrayPanel(array));
        pBogo.add(new BubblearrayPanel(array));


        add(pWMain);
        setSize(800, 600);
        setResizable(false);
        setTitle("Wettkampf");
        setLocation(800, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new WettkampfGUI();
    }
}
