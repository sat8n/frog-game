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
        testLayer.add(screen, BorderLayout.CENTER, -1);

        interactive = new Interactive();
        interactive.addMouseListener(new blaster(this));
        testLayer.add(interactive, BorderLayout.CENTER, 0);
        add(testLayer);

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

class blaster implements MouseListener {
    Frame frame;
    public blaster(Frame f) {
        this.frame = f;
    }

    public void mousePressed(MouseEvent e) {
        // we want the frog's tongue to blast out when mouse button is pressed
        this.frame.interactive.tongue.cursorX = e.getX();
        this.frame.interactive.tongue.cursorY = e.getY();
        this.frame.interactive.revalidate();
        this.frame.interactive.repaint();
    }
    public void mouseReleased(MouseEvent e) {
        this.frame.interactive.tongue.cursorX = 900;
        this.frame.interactive.tongue.cursorY = 900;
        this.frame.interactive.revalidate();
        this.frame.interactive.repaint();
    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
}