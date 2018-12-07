import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class gameBoard extends JPanel {
    private final int width = 55, height = 35;
    int posx = (((378-323)/2) + 323) - (width/2);
    int posy = (((604-556)/2) + 556) - (height/2);
    private int[] startX = {80,105,120,105,80,65};
    private int[] startY = {71,71,95,119,119,95};
    private final int flyWidth = 10, flyHeight = 13;
    private int centerX, centerY, flyX, flyY;
    private ArrayList<Integer> calcX, calcY, flyCalcX, flyCalcY; // the first set of x,y coordinates have a size of 114
    ArrayList<int[]> frogPosition;
    private ArrayList<int[]> flyPosition;
    private Random r = new Random();

    public gameBoard() {
       setBackground(new Color(220,221,255));
       JPanel gamepageTop = new JPanel();
       gamepageTop.setLayout(new BorderLayout(20,20));
       gamepageTop.setBackground(new Color(220,221,255));
       JButton backtoHome = new JButton("quit");
       backtoHome.setForeground(Color.black);
       backtoHome.setBackground(Color.white);
       gamepageTop.add(backtoHome, BorderLayout.CENTER);
       JLabel score = new JLabel("Score: 0", SwingConstants.CENTER);
       gamepageTop.add(score, BorderLayout.EAST);
       add(gamepageTop, BorderLayout.PAGE_START);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawBoard(g);
        frog(g);
    }

    private void DrawBoard(Graphics g) {
        final int width = 55, height = 35;
        int[] x = {80,105,120,105,80,65};
        int[] y = {71,71,95,119,119,95};
        calcX = new ArrayList<>();
        calcY = new ArrayList<>();
        flyCalcX = new ArrayList<>();
        flyCalcY = new ArrayList<>();
        frogPosition = new ArrayList<>();
        flyPosition = new ArrayList<>();

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
                flyX = (((x[2]-x[5])/2) + x[5])-(flyWidth/2);
                flyY = (((y[4] - y[0])/2) + y[0])-(flyHeight/2);
                flyPosition.add(getFlyXY());
                g.drawPolygon(x,y,6); // draws the first hexagon
                while (count < 6) {
                    for (int i = 0; i < 6; i++) {
                        x[i] += 86;
                    }
                    centerX = (((x[2]-x[5])/2) + x[5])-(width/2);
                    centerY = (((y[4] - y[0])/2) + y[0])-(height/2);
                    frogPosition.add(getXY());
                    flyX = (((x[2]-x[5])/2) + x[5])-(flyWidth/2);
                    flyY = (((y[4] - y[0])/2) + y[0])-(flyHeight/2);
                    flyPosition.add(getFlyXY());
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
                flyX = (((x[2]-x[5])/2) + x[5])-(flyWidth/2);
                flyY = (((y[4] - y[0])/2) + y[0])-(flyHeight/2);
                flyPosition.add(getFlyXY());
                g.drawPolygon(x,y,6);
                while (count < 5) {
                    for (int i = 0; i < 6; i++) {
                        x[i] += 86;
                    }
                    centerX = (((x[2]-x[5])/2) + x[5])-(width/2);
                    centerY = (((y[4] - y[0])/2) + y[0])-(height/2);
                    frogPosition.add(getXY());
                    flyX = (((x[2]-x[5])/2) + x[5])-(flyWidth/2);
                    flyY = (((y[4] - y[0])/2) + y[0])-(flyHeight/2);
                    flyPosition.add(getFlyXY());
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
            flyX = (((x[2]-x[5])/2) + x[5])-(flyWidth/2);
            flyY = (((y[4] - y[0])/2) + y[0])-(flyHeight/2);
            flyPosition.add(getFlyXY());
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
        flyX = (((x[2]-x[5])/2) + x[5])-(flyWidth/2);
        flyY = (((y[4] - y[0])/2) + y[0])-(flyHeight/2);
        flyPosition.add(getFlyXY());
        g.drawPolygon(x,y,6);

        // bzz bzz
        g.setColor(new Color(64,64,64));
        for (int i = 0; i < 5; i++) {
            int randomFly = r.nextInt(114);
            g.fillOval(flyPosition.get(randomFly)[0], flyPosition.get(randomFly)[1], flyWidth, flyHeight);
        }

        // these are all the positions the frog can go to
        // the first 63 are the odd rows
        for (int i = 0; i < 114; i++) {
            //System.out.println("fly: " + Arrays.toString(flyPosition.get(i)));
        }
    }

    private void frog(Graphics g) {
        g.setColor(new Color(52,169,95));
        g.fillOval(posx, posy, width, height);
    }

    private int[] getXY() {
        calcX.add(centerX);
        calcY.add(centerY);
        int[] position = {calcX.get(calcX.size()-1),calcY.get(calcY.size()-1)};
        return position;
    }

    private int[] getFlyXY() {
        flyCalcX.add(flyX);
        flyCalcY.add(flyY);
        int[] position = {flyCalcX.get(flyCalcX.size()-1), flyCalcY.get(calcY.size()-1)};
        return position;
    }
}