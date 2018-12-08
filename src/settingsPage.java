import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class settingsPage extends JPanel {
    JButton back;

    public settingsPage() {
        setLayout(new BorderLayout(10,10));
        setBackground(new Color(215,234,255));

        JPanel settingsTop = new JPanel();
        settingsTop.setLayout(new BorderLayout(20,20));
        settingsTop.setBackground(new Color(215,234,255));

        JLabel settingsTitle = new JLabel("Settings", SwingConstants.CENTER);
        settingsTitle.setFont(new Font("Arial", Font.BOLD, 30));
        settingsTop.add(settingsTitle, BorderLayout.PAGE_END);

        back = new JButton("back");
        back.setForeground(Color.black);
        back.setBackground(Color.white);
        settingsTop.add(back, BorderLayout.LINE_START);
        add(settingsTop, BorderLayout.NORTH);

        setOpaque(true);
    }
}

class backtoHome implements ActionListener {
    runGame r;

    public backtoHome(runGame r) {
        this.r = r;
    }

    public void actionPerformed(ActionEvent e) {
        r.remove(r.board);
        r.remove(r.settings);
        r.add(r.startPanel);
        r.revalidate();
        r.repaint();
    }
}
