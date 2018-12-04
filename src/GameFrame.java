import javax.swing.*;
import java.awt.*;

public class GameFrame {
    JFrame frame;
    JButton start_game, settings, highscore, backtoHome;
    JLabel gameName;
    JPanel startScreen, gamePage, settingsPage, infoPage;

    public GameFrame() {
        frame = new JFrame("Game 1705063");
        frame.getContentPane().setBackground(new Color(255,233,137));

        frame.setPreferredSize(new Dimension(600,600));
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
