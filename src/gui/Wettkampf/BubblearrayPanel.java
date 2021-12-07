package gui.Wettkampf;

import gui.SortierAusgabe;

import javax.swing.*;
import java.awt.*;

public class BubblearrayPanel extends JPanel {
    private static final String uiClassID = "BubblearrayPanel";
    private int[] array;
    private int maxValue = 1;

    public BubblearrayPanel() {
        this(new int[]{3, 1, 12, 25, 20, 5, 30, 5, 4, 5, 2, 8, 10, 6, 7, 9});
    }
    public BubblearrayPanel(int[] array) {
        super(true);
        setPreferredSize(new Dimension(400, 300));
        setBackground(Color.BLACK);
        setArray(array);
    }

    public void setArray(int[] array) {
        this.array = array;
        maxValue = array[0];
        for (int e : array) {
            maxValue = Math.max(maxValue, e);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Rectangle r = g.getClipBounds();

        double colWidth = r.width / (double) array.length;


        for (int i = 0; i < array.length; i++) {
            int hoehe = array[i] * r.height / maxValue;
            if(i%2 == 0){
                g.setColor(Color.WHITE);
                g.fillRect(r.x + (int) Math.round(i * colWidth), r.y + r.height - hoehe, (int) Math.round(colWidth), hoehe);
            } else {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(r.x + (int) Math.round(i * colWidth), r.y + r.height - hoehe, (int) Math.round(colWidth), hoehe);
            }
        }

        g.setColor(Color.BLACK);
        g.drawRect(r.x, r.y, r.width - 1, r.height - 1);
    }

}

