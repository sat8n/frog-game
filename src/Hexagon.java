import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Hexagon extends Shapes {
    final int flyWidth = 10, flyHeight = 13;
    int centerX, centerY, flyX, flyY;
    ArrayList<Integer> calcX, calcY, flyCalcX, flyCalcY;
    ArrayList<int[]> frogPosition;
    ArrayList<int[]> flyPosition;
    Random r = new Random();
    int randomFly;
    ArrayList flyLog;

    public Hexagon() {
        this.calcX = new ArrayList<>();
        this.calcY = new ArrayList<>();
        this.frogPosition = new ArrayList<>();

        this.flyCalcX = new ArrayList<>();
        this.flyCalcY = new ArrayList<>();
        this.flyPosition = new ArrayList<>();
    }

    // oof this whole paintComponent block is a mess
    public void paintComponent(Graphics g) {
        int[] x = {80,105,120,105,80,65};
        int[] y = {71,71,95,119,119,95};

        // odd rows
        int count = 0;
        int oddRows = 0;
        while (oddRows != 9) {
            if (count == 6) { // if we have 6 hexes then reset coordinates
                count = 0;
                for (int i = 0; i < 6; i++) {
                    x[i] = this.startX[i];
                    y[i] += 54;
                }
            }
            else {
                this.centerX = (((x[2]-x[5])/2) + x[5])-(this.width/2);
                this.centerY = (((y[4] - y[0])/2) + y[0])-(this.height/2);
                this.frogPosition.add(getXY());
                g.setColor(new Color(204,229,204));
                g.fillPolygon(x,y,6);
                g.setColor(new Color(224,239,224));
                g.drawPolygon(x,y,6); // draws the first hexagon
                this.flyX = (((x[2]-x[5])/2) + x[5])-(this.flyWidth/2);
                this.flyY = (((y[4] - y[0])/2) + y[0])-(this.flyHeight/2);
                this.flyPosition.add(getFlyXY());
                while (count < 6) {
                    for (int i = 0; i < 6; i++) {
                        x[i] += 86;
                    }
                    this.centerX = (((x[2]-x[5])/2) + x[5])-(this.width/2);
                    this.centerY = (((y[4] - y[0])/2) + y[0])-(this.height/2);
                    this.frogPosition.add(getXY());
                    g.setColor(new Color(204,229,204));
                    g.fillPolygon(x,y,6);
                    g.setColor(new Color(224,239,224));
                    g.drawPolygon(x,y,6);
                    this.flyX = (((x[2]-x[5])/2) + x[5])-(this.flyWidth/2);
                    this.flyY = (((y[4] - y[0])/2) + y[0])-(this.flyHeight/2);
                    this.flyPosition.add(getFlyXY());
                    count++;
                }
                oddRows++;
            }
        }

        // reset coordinates so we can start on the first even row
        for (int i = 0; i < 6; i++) {
            x[i] = this.startX[i];
            y[i] = this.startY[i];
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
                    x[i] = this.startX[i];
                    x[i] += 43;
                    y[i] += 27;
                }
            }
            else {
                this.centerX = (((x[2]-x[5])/2) + x[5])-(this.width/2);
                this.centerY = (((y[4] - y[0])/2) + y[0])-(this.height/2);
                this.frogPosition.add(getXY());
                g.setColor(new Color(204,229,204));
                g.fillPolygon(x,y,6);
                g.setColor(new Color(224,239,224));
                g.drawPolygon(x,y,6);
                this.flyX = (((x[2]-x[5])/2) + x[5])-(this.flyWidth/2);
                this.flyY = (((y[4] - y[0])/2) + y[0])-(this.flyHeight/2);
                this.flyPosition.add(getFlyXY());
                while (count < 5) {
                    for (int i = 0; i < 6; i++) {
                        x[i] += 86;
                    }
                    this.centerX = (((x[2]-x[5])/2) + x[5])-(this.width/2);
                    this.centerY = (((y[4] - y[0])/2) + y[0])-(this.height/2);
                    this.frogPosition.add(getXY());
                    g.setColor(new Color(204,229,204));
                    g.fillPolygon(x,y,6);
                    g.setColor(new Color(224,239,224));
                    g.drawPolygon(x,y,6);
                    this.flyX = (((x[2]-x[5])/2) + x[5])-(this.flyWidth/2);
                    this.flyY = (((y[4] - y[0])/2) + y[0])-(this.flyHeight/2);
                    this.flyPosition.add(getFlyXY());
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
            x[i] = this.startX[i];
            y[i] += 27;
            x[i] += 129;
        }
        count = 0;
        while (count < 2) {
            for (int i = 0; i < 6; i++) {
                x[i] += 86;
            }
            this.centerX = (((x[2]-x[5])/2) + x[5])-(this.width/2);
            this.centerY = (((y[4] - y[0])/2) + y[0])-(this.height/2);
            this.frogPosition.add(getXY());
            g.setColor(new Color(220,201,173));
            g.fillPolygon(x,y,6);
            g.setColor(new Color(234,222,205));
            g.drawPolygon(x,y,6);
            this.flyX = (((x[2]-x[5])/2) + x[5])-(this.flyWidth/2);
            this.flyY = (((y[4] - y[0])/2) + y[0])-(this.flyHeight/2);
            this.flyPosition.add(getFlyXY());
            count++;
        }
        // reset
        for (int i = 0; i < 6; i++) {
            x[i] = this.startX[i];
            y[i] += 27;
        }

        // initial point has
        // x-coordinates of [338, 363, 378, 363, 338, 323]
        // y-coordinates of [556, 556, 580, 604, 604, 580]
        for (int i = 0; i < 6; i++) {
            x[i] += 258;
        }
        this.centerX = (((x[2]-x[5])/2) + x[5])-(this.width/2);
        this.centerY = (((y[4] - y[0])/2) + y[0])-(this.height/2);
        this.frogPosition.add(getXY());
        g.setColor(new Color(220,201,173));
        g.fillPolygon(x,y,6);
        g.setColor(new Color(234,222,205));
        g.drawPolygon(x,y,6);
        this.flyX = (((x[2]-x[5])/2) + x[5])-(this.flyWidth/2);
        this.flyY = (((y[4] - y[0])/2) + y[0])-(this.flyHeight/2);
        this.flyPosition.add(getFlyXY());

        // bzz bzz
        flyLog = new ArrayList<>();
        for (int i = 0; i < 7; i++) { // we want 7 flies to appear on the board (if the player picked easy difficulty)
            randomFly = r.nextInt(114);
            g.setColor(new Color(64,64,64));
            g.fillOval(flyPosition.get(randomFly)[0], flyPosition.get(randomFly)[1], flyWidth, flyHeight);
            g.setColor(new Color(109,109,109));
            g.fillRoundRect((flyPosition.get(randomFly)[0]-5), (flyPosition.get(randomFly)[1]+4), 7,5,2,2);
            g.fillRoundRect((flyPosition.get(randomFly)[0]+9), (flyPosition.get(randomFly)[1]+4), 7,5,2,2);
            flyLog.add(randomFly);
        }
    }

    public int[] getXY() {
        this.calcX.add(this.centerX);
        this.calcY.add(this.centerY);
        int[] position = {this.calcX.get(this.calcX.size()-1),this.calcY.get(this.calcY.size()-1)};
        return position;
    }

    public int[] getFlyXY() {
        this.flyCalcX.add(this.flyX);
        this.flyCalcY.add(this.flyY);
        int[] position = {this.flyCalcX.get(this.flyCalcX.size()-1), this.flyCalcY.get(this.flyCalcY.size()-1)};
        return position;
    }
}
