import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameStats extends JPanel {
    JButton backHome;

    public gameStats() {
        setLayout(new BorderLayout(10,10));
        setBackground(new Color(215,234,255));

        JPanel statsTop = new JPanel();
        statsTop.setLayout(new BorderLayout(20,100));
        statsTop.setBackground(new Color(215,234,255));
        JPanel statsBottom = new JPanel();
        statsBottom.setLayout(new BorderLayout(20,20));
        statsBottom.setBackground(new Color(215,234,255));

        JLabel statsTitle = new JLabel("Gameplay Stats", SwingConstants.CENTER);
        statsTitle.setFont(new Font("Arial", Font.BOLD, 35));
        statsTop.add(statsTitle, BorderLayout.NORTH);

        backHome = new JButton("back to start screen");
        backHome.setForeground(Color.black);
        backHome.setBackground(Color.white);
        statsBottom.add(backHome, BorderLayout.SOUTH);

        add(statsTop, BorderLayout.NORTH);
        add(statsBottom, BorderLayout.CENTER);

        setOpaque(true);
    }
}

class backToHome implements ActionListener {
    runGame r;

    public backToHome(runGame r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.remove(r.board);
        r.remove(r.instructions);
        r.remove(r.highscore);
        r.remove(r.stats);
        r.add(r.startPanel);
        r.revalidate();
        r.repaint();
    }
}
