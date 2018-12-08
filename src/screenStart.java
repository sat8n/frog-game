import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class screenStart extends JPanel {
    JButton start_game, settings, highscore;

    public screenStart() {
        setBackground(new Color(215,234,255));
        setLayout(new GridLayout(2,1));

        JLabel gameName = new JLabel("Catch the Flies!", SwingConstants.CENTER);
        gameName.setFont(new Font("Arial", Font.BOLD, 40));
        add(gameName);

        JPanel buttonsStart = new JPanel();
        buttonsStart.setBackground(new Color(215,234,255));
        start_game = new JButton("start game");
        start_game.setForeground(Color.black);
        start_game.setBackground(Color.white);
        buttonsStart.add(start_game);

        settings = new JButton("settings");
        settings.setForeground(Color.black);
        settings.setBackground(Color.white);
        buttonsStart.add(settings);

        highscore = new JButton("highscore");
        highscore.setForeground(Color.black);
        highscore.setBackground(Color.white);
        buttonsStart.add(highscore);
        add(buttonsStart);

        setOpaque(true);
    }
}

class toInfo implements ActionListener {
    runGame r;

    public toInfo(runGame r) {
        this.r = r;
    }
    public void actionPerformed(ActionEvent e) {
        r.remove(r.startPanel);
        r.remove(r.settings);
        r.remove(r.board);
        r.remove(r.highscore);
        r.add(r.instructions);
        r.revalidate();
        r.repaint();
    }
}

class toSettings implements ActionListener {
    runGame r;

    public toSettings(runGame r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.remove(r.startPanel);
        r.remove(r.board);
        r.remove(r.highscore);
        r.add(r.settings);
        r.revalidate();
        r.repaint();
    }
}

class toHighscore implements ActionListener {
    runGame r;

    public toHighscore(runGame r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.remove(r.startPanel);
        r.remove(r.board);
        r.remove(r.settings);
        r.add(r.highscore);
        r.revalidate();
        r.repaint();
    }
}


