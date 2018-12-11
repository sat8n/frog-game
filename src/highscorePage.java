import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class highscorePage extends JPanel {
    JButton back;
    ArrayList<String[]> namesWithScores;

    public highscorePage() {
        setLayout(new BorderLayout(10,10));
        setBackground(new Color(215,234,255));

        JPanel highscoreTop = new JPanel();
        highscoreTop.setLayout(new BorderLayout(20,20));
        highscoreTop.setBackground(new Color(215,234,255));

        JLabel highscoreTitle = new JLabel("Highscores", SwingConstants.CENTER);
        highscoreTitle.setFont(new Font("Arial", Font.BOLD, 35));
        highscoreTop.add(highscoreTitle, BorderLayout.PAGE_END);

        back = new JButton("back");
        back.setForeground(Color.black);
        back.setBackground(Color.white);
        highscoreTop.add(back, BorderLayout.LINE_START);
        add(highscoreTop, BorderLayout.NORTH);

        namesWithScores = new ArrayList<>();
        try {
            BufferedReader b = new BufferedReader(new FileReader("stats.txt"));
            String line1 = b.readLine();
            String line2 = b.readLine();
            while (line1 != null) {
                String[] combined = {line1, line2};
                namesWithScores.add(combined);
                line1 = b.readLine();
                line2 = b.readLine();
            }
        } catch (FileNotFoundException eq) {
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("rip");
        }

        setOpaque(true);
    }
}

class fromHighscore implements ActionListener {
    runGame r;

    public fromHighscore(runGame r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.remove(r.board);
        r.remove(r.instructions);
        r.remove(r.highscore);
        r.add(r.startPanel);
        r.revalidate();
        r.repaint();
    }
}