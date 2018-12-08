import javax.swing.*;
import java.awt.*;

public class runGame extends JFrame {
    screenStart startPanel;
    gameBoard board;
    settingsPage settings;
    highscorePage highscore;
    infoPage instructions;

    public runGame() {
        setTitle("Frogger 1705063");

        startPanel = new screenStart();
        add(startPanel);
        startPanel.start_game.addActionListener(new toInfo(this));
        startPanel.settings.addActionListener(new toSettings(this));
        startPanel.highscore.addActionListener(new toHighscore(this));

        settings = new settingsPage();
        settings.back.addActionListener(new fromSettings(this));

        highscore = new highscorePage();
        highscore.back.addActionListener(new fromHighscore(this));

        instructions = new infoPage();
        instructions.start.addActionListener(new gameStart(this));

        board = new gameBoard();
        board.backtoHome.addActionListener(new fromGame(this));

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
