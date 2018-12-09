import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class highscorePage extends JPanel {
    JButton back;

    public highscorePage() {
        setLayout(new BorderLayout(10,10));
        setBackground(new Color(215,234,255));

        JPanel highscoreTop = new JPanel();
        highscoreTop.setLayout(new BorderLayout(20,20));
        highscoreTop.setBackground(new Color(215,234,255));

        JLabel highscoreTitle = new JLabel("Highscore", SwingConstants.CENTER);
        highscoreTitle.setFont(new Font("Arial", Font.BOLD, 30));
        highscoreTop.add(highscoreTitle, BorderLayout.PAGE_END);

        back = new JButton("back");
        back.setForeground(Color.black);
        back.setBackground(Color.white);
        highscoreTop.add(back, BorderLayout.LINE_START);
        add(highscoreTop, BorderLayout.NORTH);

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
        r.remove(r.highscore);
        r.add(r.startPanel);
        r.revalidate();
        r.repaint();
    }
}
