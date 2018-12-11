import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class runGame extends JFrame {
    screenStart startPanel;
    gameBoard board;
    highscorePage highscore;
    infoPage instructions;
    gameStats stats;

    public runGame() {
        setTitle("Frogger 1705063");
        setBackground(new Color(215,234,255));

        startPanel = new screenStart();
        add(startPanel);
        startPanel.start_game.addActionListener(new toInfo(this));
        startPanel.highscore.addActionListener(new toHighscore(this));

        highscore = new highscorePage();
        highscore.back.addActionListener(new fromHighscore(this));

        instructions = new infoPage();
        instructions.start.addActionListener(new gameStart(this));

        board = new gameBoard();
        board.quit.addActionListener(new fromGame(this));
        board.addKeyListener(new frogListener(this));
        board.setFocusable(true);
        board.addMouseListener(new flyBlaster(this));

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