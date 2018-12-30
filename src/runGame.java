import javax.swing.*;
import java.awt.*;

public class runGame extends JFrame {
    screenStart startPanel;
    gameBoard board;
    highscorePage highscore;
    infoPage instructions;
    gameStats stats;

    public runGame() {
        setTitle("Frogger");
        setBackground(new Color(215,234,255));

        // JPanel for the start screen
        startPanel = new screenStart();
        add(startPanel);
        startPanel.start_game.addActionListener(new toInfo(this));
        startPanel.highscore.addActionListener(new toHighscore(this));

        // JPanel for the highscore page
        highscore = new highscorePage();
        highscore.back.addActionListener(new backToStart(this));

        // JPanel for the game's instructions
        instructions = new infoPage();
        instructions.start.addActionListener(new gameStart(this));

        // JPanel for the game
        board = new gameBoard();
        board.quit.addActionListener(new backToStart(this));
        board.addKeyListener(new frogListener(this));
        board.setFocusable(true);
        board.addMouseListener(new flyBlaster(this));

        // JPanel for the gameplay statistics (shown after completing a round of the game)
        stats = new gameStats();
        stats.submit.addActionListener(new submit(this));

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