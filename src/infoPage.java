import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;

public class infoPage extends JPanel {
    JButton start;
    BufferedImage example;

    public infoPage() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(new Color(215,234,255));

        JPanel instructions = new JPanel(new GridLayout(3,1));
        instructions.setOpaque(false);

        JLabel infoTitle = new JLabel("Instructions", SwingConstants.CENTER);
        infoTitle.setFont(new Font("Helvetica", Font.BOLD, 35));

        start = new JButton("start");
        start.setFont(new Font("Helvetica", Font.BOLD, 20));
        start.setForeground(Color.black);
        start.setBackground(new Color(215,234,255));

        // game instructions
        String infoText = "<html>" +
                "1. Use the arrow keys to move around the board." +
                "<br/>" +
                "2. Click on the flies when the frog is in range. Each fly gets you 5 points." +
                "<br/>" +
                "3. The frog's \"tongue\" can reach the hexagons surrounding the frog." +
                "<br/>" +
                "The image shows the frog's range. Its range is within the poorly drawn yellow blob." +
                "<br/>" +
                "4. Catch as many flies as you can before the 30-second timer runs out." +
                "<br/>" +
                "<br/>" +
                "</html>";
        JLabel info = new JLabel(infoText,SwingConstants.CENTER);
        info.setFont(new Font("Helvetica", Font.PLAIN, 18));

        try {
            example = ImageIO.read(new File("Screenshots/Example.PNG"));
        } catch (IOException ex) {
            String errorText = "<html>" +
                    "1. Use the arrow keys to move around the board." +
                    "<br/>" +
                    "2. Click on the flies when the frog is in range. Each fly gets you 5 points." +
                    "<br/>" +
                    "3. The frog's \"tongue\" can reach the hexagons surrounding the frog." +
                    "<br/>" +
                    "The image shows the frog's range. Its range is within the poorly drawn yellow blob." +
                    "<br/>" +
                    "<font color='red'>Error loading image.</font>" +
                    "<br/>" +
                    "4. Catch as many flies as you can before the 30-second timer runs out." +
                    "<br/>" +
                    "<br/>" +
                    "</html>";
            info.setText(errorText);
        }

        instructions.add(infoTitle);
        instructions.add(info);
        instructions.add(start);
        add(instructions);

        setOpaque(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(example, 400,0, 300,300,this);
    }
}

class gameStart implements ActionListener {
    runGame r;
    Timer timer;

    public gameStart(runGame r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.remove(r.startPanel);
        r.remove(r.instructions);
        r.remove(r.stats);
        r.remove(r.highscore);
        r.add(r.board);
        r.board.requestFocusInWindow();

        // setting frog's x,y position to the start
        r.board.frog.posx = r.board.frog.initialX;
        r.board.frog.posy = r.board.frog.initialY;

        // setting score to 0
        r.board.score.setText("Score: 0");

        // setting statistics to 0
        r.stats.moves = 0;
        r.stats.points = 0;

        // 30 second timer for game
        timer = new Timer(30000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r.remove(r.highscore);
                r.remove(r.board);
                r.remove(r.instructions);
                r.remove(r.startPanel);
                r.add(r.stats); // once timer runs out, move player to stats panel

                r.stats.frogMoves.setText("" + r.stats.moves);
                r.stats.fliesCaught.setText("" + r.stats.points);
                r.stats.nicknameInput.setText("");
                JOptionPane.showMessageDialog(null, "Timer has ended");

                r.revalidate();
                r.repaint();
                timer.stop();
            }
        });
        timer.start();

        r.revalidate();
        r.repaint();
    }
}