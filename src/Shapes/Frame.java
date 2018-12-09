package Shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame {
    Screen screen;
    Interactive interactive;

    public Frame() {
        setTitle("test abstract");
        setBackground(new Color(215,234,255));

        JLayeredPane testLayer = new JLayeredPane();
        testLayer.setBounds(0,0,700,700);
        testLayer.setLayout(new BorderLayout());

        screen = new Screen();
        screen.addKeyListener(new testHandler(this));
        screen.setFocusable(true);
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
            this.frame.screen.repaint(this.frame.screen.frog.posx, this.frame.screen.frog.posy, 60,486);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (this.frame.screen.frog.posy < 456) {
                this.frame.screen.frog.posy += 54;
            }
            //this.frame.screen.repaint(this.frame.screen.frog.posx, this.frame.screen.frog.posy, 60,this.frame.screen.frog.posy+486);
            this.frame.screen.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (this.frame.screen.frog.posx > 65 && this.frame.screen.frog.posy >= 78) {
                this.frame.screen.frog.posx -= 43;
                this.frame.screen.frog.posy -= 27;
            }
            this.frame.screen.repaint(this.frame.screen.frog.posx, this.frame.screen.frog.posy, 516,81);
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