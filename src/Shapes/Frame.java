package Shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame {
    Screen screen;

    public Frame() {
        setTitle("test abstract");
        setBackground(new Color(215,234,255));

        JLayeredPane testLayer = new JLayeredPane();
        testLayer.setBounds(0,0,700,700);
        testLayer.setLayout(new BorderLayout());

        screen = new Screen();
        screen.addKeyListener(new testHandler(this));
        screen.setFocusable(true);
        screen.addMouseListener(new frogBlaster(this));
        add(screen);

        setPreferredSize(new Dimension(700,700));
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}

class testHandler implements KeyListener {
    Frame frame;

    public testHandler (Frame f) {
        this.frame = f;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (this.frame.screen.frog.posy > 105) {
                this.frame.screen.frog.posy -= 54;
            }
            this.frame.screen.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (this.frame.screen.frog.posy < 456) {
                this.frame.screen.frog.posy += 54;
            }
            this.frame.screen.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (this.frame.screen.frog.posx > 65 && this.frame.screen.frog.posy >= 78) {
                this.frame.screen.frog.posx -= 43;
                this.frame.screen.frog.posy -= 27;
            }
            this.frame.screen.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (this.frame.screen.frog.posx < 581 && this.frame.screen.frog.posy >= 78) {
                this.frame.screen.frog.posx += 43;
                this.frame.screen.frog.posy -= 27;
            }
            this.frame.screen.repaint();
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
}

class frogBlaster implements MouseListener {
    Frame frame;

    public frogBlaster(Frame f) {
        this.frame = f;
    }
    public void mousePressed(MouseEvent e) {
        // if X and Y of cursor is at a certain distance from the frog when it was pressed
        // and there was a fly, then score += 1 and repaint()

        // player can only click between current hexagon and the 2 side hexagons:
        // left: (e.getX() <= this.frame.screen.frog.posx) && (e.getX() >= (this.frame.screen.frog.posx-86))
        // right: (e.getX() >= this.frame.screen.frog.posx) && (e.getX() <= (this.frame.screen.frog.posx+132))
        // restricting y to only go up: (e.getY() <= this.frame.screen.frog.posy) && (e.getY() >= (this.frame.screen.frog.posy-108))
        if ( ( ((e.getX() <= this.frame.screen.frog.posx) && (e.getX() >= (this.frame.screen.frog.posx-86))) || ((e.getX() >= this.frame.screen.frog.posx) && (e.getX() <= (this.frame.screen.frog.posx+132))) ) && ((e.getY() <= this.frame.screen.frog.posy) && (e.getY() >= (this.frame.screen.frog.posy-108))) ) {
            System.out.println(e.getX() + " " + e.getY());
        }
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
}