import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class gameBoard extends JPanel {
    final int width = 55, height = 35;
    int posx = (((378-323)/2) + 323) - (width/2);
    int posy = (((604-556)/2) + 556) - (height/2);
    int centerX, centerY;
    ArrayList<Integer> calcX, calcY; // the first set of x,y coordinates have a size of 114
    ArrayList<int[]> frogPosition;

    public gameBoard() {
       setBackground(new Color(220,221,255));
       JPanel gamepageTop = new JPanel();
       gamepageTop.setLayout(new BorderLayout(20,20));
       add(gamepageTop);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawBoard(g);
        frog(g);
    }

    public void DrawBoard(Graphics g) {
        final int width = 55, height = 35;
        int[] startX = {80,105,120,105,80,65};
        int[] startY = {71,71,95,119,119,95};
        int[] x = {80,105,120,105,80,65};
        int[] y = {71,71,95,119,119,95};
        calcX = new ArrayList();
        calcY = new ArrayList();
        frogPosition = new ArrayList<>();

        g.setColor(new Color(255,165,0));

        // odd rows
        int count = 0;
        int oddRows = 0;
        while (oddRows != 9) {
            if (count == 6) { // if we have 6 hexes then reset coordinates
                count = 0;
                for (int i = 0; i < 6; i++) {
                    x[i] = startX[i];
                    y[i] += 54;
                }
            }
            else {
                centerX = (((x[2]-x[5])/2) + x[5])-(width/2);
                centerY = (((y[4] - y[0])/2) + y[0])-(height/2);
                frogPosition.add(getXY());
                g.drawPolygon(x,y,6); // draws the first hexagon
                while (count < 6) {
                    for (int i = 0; i < 6; i++) {
                        x[i] += 86;
                    }
                    centerX = (((x[2]-x[5])/2) + x[5])-(width/2);
                    centerY = (((y[4] - y[0])/2) + y[0])-(height/2);
                    frogPosition.add(getXY());
                    g.drawPolygon(x,y,6);
                    count++;
                }
                oddRows++;
            }
        }

        // reset coordinates so we can start on the first even row
        for (int i = 0; i < 6; i++) {
            x[i] = startX[i];
            y[i] = startY[i];
            x[i] += 43;
            y[i] += 27;
        }

        // even rows
        count = 0;
        int evenRows = 0;
        while (evenRows != 8) {
            if (count == 5) { // if we have 5 hexes then reset coordinates
                count = 0;
                for (int i = 0; i < 6; i++) {
                    x[i] = startX[i];
                    x[i] += 43;
                    y[i] += 27;
                }
            }
            else {
                centerX = (((x[2]-x[5])/2) + x[5])-(width/2);
                centerY = (((y[4] - y[0])/2) + y[0])-(height/2);
                frogPosition.add(getXY());
                g.drawPolygon(x,y,6);
                while (count < 5) {
                    for (int i = 0; i < 6; i++) {
                        x[i] += 86;
                    }
                    centerX = (((x[2]-x[5])/2) + x[5])-(width/2);
                    centerY = (((y[4] - y[0])/2) + y[0])-(height/2);
                    frogPosition.add(getXY());
                    g.drawPolygon(x,y,6);
                    count++;
                }
                evenRows++;
                for (int i = 0; i < 6; i++) {
                    y[i] += 27;
                }
            }
        }

        // creating the 3 hexagons for the starting area
        g.setColor(Color.blue);
        for (int i = 0; i < 6; i++) {
            x[i] = startX[i];
            y[i] += 27;
            x[i] += 129;
        }
        count = 0;
        while (count < 2) {
            for (int i = 0; i < 6; i++) {
                x[i] += 86;
            }
            centerX = (((x[2]-x[5])/2) + x[5])-(width/2);
            centerY = (((y[4] - y[0])/2) + y[0])-(height/2);
            frogPosition.add(getXY());
            g.drawPolygon(x,y,6);
            count++;
        }
        // reset
        for (int i = 0; i < 6; i++) {
            x[i] = startX[i];
            y[i] += 27;
        }
        // initial point has
        // x-coordinates of [338, 363, 378, 363, 338, 323]
        // y-coordinates of [556, 556, 580, 604, 604, 580]
        for (int i = 0; i < 6; i++) {
            x[i] += 258;
        }
        centerX = (((x[2]-x[5])/2) + x[5])-(width/2);
        centerY = (((y[4] - y[0])/2) + y[0])-(height/2);
        frogPosition.add(getXY());
        g.drawPolygon(x,y,6);

        // these are all the positions the frog can go to
        // the first 63 are the odd rows
        for (int i = 0; i < 114; i++) {
            //System.out.println("frogPos: " + Arrays.toString(frogPosition.get(i)));
        }
    }

    public void frog(Graphics g) {
        g.setColor(new Color(52,169,95));
        g.fillOval(posx, posy, width, height);
    }

    public int[] getXY() {
        calcX.add(centerX);
        calcY.add(centerY);
        int[] position = {calcX.get(calcX.size()-1),calcY.get(calcY.size()-1)};
        return position;
    }
}