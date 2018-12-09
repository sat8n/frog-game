import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class gameBoard extends JPanel {
    final int width = 55, height = 35;
    int posx, initialX = (((378-323)/2) + 323) - (width/2);
    int posy, initialY = (((604-556)/2) + 556) - (height/2);
    int[] startX = {80,105,120,105,80,65};
    int[] startY = {71,71,95,119,119,95};
    final int flyWidth = 10, flyHeight = 13;
    int centerX, centerY, flyX, flyY;
    ArrayList<Integer> calcX, calcY, flyCalcX, flyCalcY; // the first set of x,y coordinates have a size of 114
    ArrayList<int[]> frogPosition;
    ArrayList<int[]> flyPosition;
    Random r = new Random();
    int randomFly;
    JButton backtoHome;
    int cursorX, cursorY;

    public gameBoard() {
        setBackground(new Color(215,234,255));

        JPanel gamepageTop = new JPanel();
        gamepageTop.setLayout(new BorderLayout(20,20));

        backtoHome = new JButton("quit");
        backtoHome.setForeground(Color.black);
        backtoHome.setBackground(Color.white);
        gamepageTop.add(backtoHome, BorderLayout.CENTER);

        JLabel score = new JLabel("Score: 0", SwingConstants.CENTER);
        gamepageTop.add(score, BorderLayout.EAST);
        gamepageTop.setOpaque(false);
        add(gamepageTop, BorderLayout.NORTH);

        addKeyListener(new frogListener(this));
        setFocusable(true);
        addMouseListener(new tongueBlaster(this));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawBoard(g);
        tongue(g);
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
                g.setColor(new Color(204,229,204));
                g.fillPolygon(x,y,6);
                g.setColor(new Color(224,239,224));
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
                    g.setColor(new Color(204,229,204));
                    g.fillPolygon(x,y,6);
                    g.setColor(new Color(224,239,224));
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
                g.setColor(new Color(204,229,204));
                g.fillPolygon(x,y,6);
                g.setColor(new Color(224,239,224));
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
                    g.setColor(new Color(204,229,204));
                    g.fillPolygon(x,y,6);
                    g.setColor(new Color(224,239,224));
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
        g.setColor(new Color(65,45,34));
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
            g.setColor(new Color(220,201,173));
            g.fillPolygon(x,y,6);
            g.setColor(new Color(234,222,205));
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
        g.setColor(new Color(220,201,173));
        g.fillPolygon(x,y,6);
        g.setColor(new Color(234,222,205));
        g.drawPolygon(x,y,6);

        // bzz bzz
        g.setColor(new Color(64,64,64));
        for (int i = 0; i < 5; i++) {
            randomFly = r.nextInt(114);
            g.fillOval(flyPosition.get(randomFly)[0], flyPosition.get(randomFly)[1], flyWidth, flyHeight);
        }

        // these are all the positions the frog can go to
        // the first 63 are the odd rows
        for (int i = 0; i < 114; i++) {
            //System.out.println("fly: " + Arrays.toString(flyPosition.get(i)));
        }
    }

    private void frog(Graphics g) {
        g.setColor(new Color(0,128,64));
        g.fillOval(posx, posy, width, height);
    }

    private void tongue(Graphics g) {
        g.setColor(Color.pink);
        g.drawLine(posx+30, posy+15, cursorX+7, cursorY+7);
        g.fillOval(cursorX, cursorY, 15, 15);
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

class fromGame implements ActionListener {
    runGame r;

    public fromGame(runGame r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.remove(r.highscore);
        r.remove(r.board);
        r.add(r.startPanel);
        r.revalidate();
        r.repaint();
    }
}

class tongueBlaster implements MouseListener {
    gameBoard board;

    public tongueBlaster(gameBoard b) {
        this.board = b;
    }

    public void mousePressed(MouseEvent e) {
        // we want the frog's tongue to blast out when mouse button is pressed
        board.cursorX = e.getX();
        board.cursorY = e.getY();
        System.out.println("pressed");
        board.revalidate();
        board.repaint();
    }
    public void mouseReleased(MouseEvent e) {
        board.cursorX = 900;
        board.cursorY = 900;
        board.revalidate();
        board.repaint();
    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
}