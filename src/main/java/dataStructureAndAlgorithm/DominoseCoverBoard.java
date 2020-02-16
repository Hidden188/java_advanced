package dataStructureAndAlgorithm;

import dataStructureAndAlgorithm.Element;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;

public class DominoseCoverBoard extends JFrame {

    private static final long serialVersionUID = 1L;
    int size = 16;
    private Element[][] elements = new Element[size][size];
    Color[] colors = new Color[220];
    JFrame jf = new JFrame();

    public void makeColor() {
        int num = 0;
        for (int i = 0; i < 255; i += 50)
            for (int j = 0; j < 255; j += 50)
                for (int k = 0; k < 255; k += 50) {
                    Color c = new Color(i, j, k);
                    colors[num++] = c;
                }
    }

    public void Application() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                elements[i][j] = new Element();
            }
    }

    public void create() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                jf.add(elements[i][j].getJ());
            }
        jf.setVisible(true);
        jf.setSize(512, 512);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paintFrame() {
        makeColor();
        elements[6][10].setFlag(true);
        jf.setLayout(new GridLayout(size, size));
        search(0, 0, size);
    }

    public void search(int m, int n, int length) {
        if (length == 1)
            return;
        int subLength = length / 2;
        int n1 = 0, n2 = 0, n3 = 0, n4 = 0;
        for (int i = 0; i < subLength; i++)
            for (int j = 0; j < subLength; j++) {
                if (elements[m + i][n + j].isFlag())
                    n1++;
                if (elements[m + i][n + subLength + j].isFlag())
                    n2++;
                if (elements[m + subLength + i][n + j].isFlag())
                    n3++;
                if (elements[m + subLength + i][n + subLength + j].isFlag())
                    n4++;
            }
        Random r = new Random();
        int color_num = r.nextInt(216);
        Color c = colors[color_num];
        if (n1 == 1) {
            elements[m + subLength - 1][n + subLength].getJ().setBackground(c);
            elements[m + subLength][n + subLength - 1].getJ().setBackground(c);
            elements[m + subLength][n + subLength].getJ().setBackground(c);
            elements[m + subLength - 1][n + subLength].setFlag(true);
            elements[m + subLength][n + subLength - 1].setFlag(true);
            elements[m + subLength][n + subLength].setFlag(true);
        }
        if (n2 == 1) {
            elements[m + subLength - 1][n + subLength - 1].getJ().setBackground(c);
            elements[m + subLength][n + subLength - 1].getJ().setBackground(c);
            elements[m + subLength][n + subLength].getJ().setBackground(c);
            elements[m + subLength - 1][n + subLength - 1].setFlag(true);
            elements[m + subLength][n + subLength - 1].setFlag(true);
            elements[m + subLength][n + subLength].setFlag(true);
        }
        if (n3 == 1) {
            elements[m + subLength - 1][n + subLength - 1].getJ().setBackground(c);
            elements[m + subLength - 1][n + subLength].getJ().setBackground(c);
            elements[m + subLength][n + subLength].getJ().setBackground(c);
            elements[m + subLength - 1][n + subLength - 1].setFlag(true);
            elements[m + subLength - 1][n + subLength].setFlag(true);
            elements[m + subLength][n + subLength].setFlag(true);
        }
        if (n4 == 1) {
            elements[m + subLength - 1][n + subLength - 1].getJ().setBackground(c);
            elements[m + subLength - 1][n + subLength].getJ().setBackground(c);
            elements[m + subLength][n + subLength - 1].getJ().setBackground(c);
            elements[m + subLength - 1][n + subLength - 1].setFlag(true);
            elements[m + subLength - 1][n + subLength].setFlag(true);
            elements[m + subLength][n + subLength - 1].setFlag(true);
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        create();
        search(m, n, subLength);
        search(m, n + subLength, subLength);
        search(m + subLength, n, subLength);
        search(m + subLength, n + subLength, subLength);
    }

    public static void main(String[] args) {
        DominoseCoverBoard app = new DominoseCoverBoard();
        app.paintFrame();
        
    }

}
