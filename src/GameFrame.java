import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame {
    JFrame frame;
    JButton start_game, settings, highscore, backtoHome;
    JLabel gameName;
    JPanel startScreen, gamePage, settingsPage, infoPage;

    public GameFrame() {
        frame = new JFrame("Game 1705063");
        frame.getContentPane().setBackground(new Color(255,233,137));

        /**
         * This is a panel for the start screen.
         * The panel will contain the name of the game, and shows a series of buttons
         * that will let the user navigate between the game, settings, and high-score
         */
        startScreen = new JPanel(new GridLayout(2,1));
        startScreen.setBackground(new Color(255,233,137));
        gameName = new JLabel("Game Name", SwingConstants.CENTER);
        gameName.setFont(new Font("Arial", Font.BOLD, 40));
        startScreen.add(gameName);

        JPanel buttonsStart = new JPanel();
        buttonsStart.setBackground(new Color(255,233,137));
        start_game = new JButton("start game");
        start_game.setForeground(Color.black);
        start_game.setBackground(Color.white);
        start_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // we want to only show the instructions panel when
                // the "start game" button is pressed
                // i referred to this code:
                // https://stackoverflow.com/questions/13110094/how-do-i-hide-the-current-jpanel-and-show-a-new-one-with-a-button-in-java
                frame.remove(startScreen);
                frame.remove(settingsPage);
                frame.remove(gamePage);
                frame.add(infoPage);
                frame.revalidate();
                frame.repaint();
            }
        });
        buttonsStart.add(start_game);

        settings = new JButton("settings");
        settings.setForeground(Color.black);
        settings.setBackground(Color.white);
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // similarly, we want the settings panel to be the only panel visible
                // when the "settings" button is pressed
                frame.remove(startScreen);
                frame.remove(gamePage);
                frame.remove(infoPage);
                frame.add(settingsPage);
                frame.revalidate();
                frame.repaint();
            }
        });
        buttonsStart.add(settings);

        highscore = new JButton("highscore");
        highscore.setForeground(Color.black);
        highscore.setBackground(Color.white);
        highscore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonsStart.add(highscore);
        startScreen.add(buttonsStart);

        startScreen.setOpaque(true);
        frame.add(startScreen);

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
