import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class highscorePage extends JPanel {
    JButton back;
    ArrayList<String> namesWithScores;
    ArrayList<String> playerNames;
    ArrayList<Integer> playerScores;

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
            String line = b.readLine();
            while (line != null) {
                namesWithScores.add(line);
                line = b.readLine();
            }
        } catch (FileNotFoundException eq) {
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("rip");
        }

        // even numbers have the player's names
        playerNames = new ArrayList<>();
        for (int i = 0; i < namesWithScores.size(); i+= 2) {
            playerNames.add(namesWithScores.get(i));
        }
        // odd numbers have the player's scores
        playerScores = new ArrayList<>();
        for (int i = 1; i < namesWithScores.size(); i+=2) {
            playerScores.add(Integer.parseInt(namesWithScores.get(i)));
        }
        for (int i = 0; i < playerNames.size(); i++) {
            System.out.println("Nickname: " + playerNames.get(i));
            System.out.println("Score: " + playerScores.get(i));
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