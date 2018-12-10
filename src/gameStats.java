import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameStats extends JPanel {
    JLabel frogMoves, fliesCaught;
    JTextField nicknameInput;
    JButton submit;
    int moves, points;

    public gameStats() {
        setLayout(new GridLayout(3,1));
        setBackground(new Color(215,234,255));

        JLabel statsTitle = new JLabel("Gameplay Stats", SwingConstants.CENTER);
        statsTitle.setFont(new Font("Arial", Font.BOLD, 35));
        add(statsTitle);

        JPanel statistics = new JPanel(new GridLayout(3,2));
        statistics.setBackground(new Color(215,234,255));

        JLabel row1 = new JLabel("Number of times frog moved: ", SwingConstants.CENTER);
        row1.setFont(new Font("Arial", Font.PLAIN, 15));
        frogMoves = new JLabel("10", SwingConstants.CENTER);
        frogMoves.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel row2 = new JLabel("Number of flies collected: ", SwingConstants.CENTER);
        row2.setFont(new Font("Arial", Font.PLAIN, 15));
        fliesCaught = new JLabel("35", SwingConstants.CENTER);
        fliesCaught.setFont(new Font("Arial", Font.PLAIN, 15));

        JLabel row3 = new JLabel("Please enter nickname: ", SwingConstants.CENTER);
        row3.setFont(new Font("Arial", Font.PLAIN, 15));
        nicknameInput = new JTextField("", 10);
        nicknameInput.setFont(new Font("Arial", Font.PLAIN, 15));

        statistics.add(row1);
        statistics.add(frogMoves);
        statistics.add(row2);
        statistics.add(fliesCaught);
        statistics.add(row3);
        statistics.add(nicknameInput);
        add(statistics);

        submit = new JButton("submit");
        submit.setFont(new Font("Arial", Font.BOLD, 25));
        submit.setForeground(Color.black);
        submit.setBackground(new Color(215,234,255));
        add(submit);

        setOpaque(true);
    }
}

class submit implements ActionListener {
    runGame r;

    public submit(runGame r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.stats.nicknameInput.getText();

        r.remove(r.board);
        r.remove(r.instructions);
        r.remove(r.highscore);
        r.remove(r.stats);
        r.add(r.startPanel);

        r.revalidate();
        r.repaint();
    }
}
