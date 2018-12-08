import javax.swing.*;
import java.awt.*;

public class runGame extends JFrame {
    screenStart startPanel;
    gameBoard board;
    settingsPage settings;

    public runGame() {
        setTitle("Frogger 1705063");

        startPanel = new screenStart();
        add(startPanel);
        startPanel.start_game.addActionListener(new gameStart(this));
        startPanel.settings.addActionListener(new toSettings(this));

        settings = new settingsPage();
        settings.back.addActionListener(new backtoHome(this));

        board = new gameBoard();

        setPreferredSize(new Dimension(700,700));
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new runGame();
    }
}
