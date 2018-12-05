import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame {
    JFrame frame;
    JButton start_game, settings, highscore, backtoHome;
    JLabel gameName;
    JPanel startScreen, gamePage, settingsPage, infoPage;
    final int width = 55, height = 35;
    int posx = 300 - (width/2);
    int posy = 500 - (height/2);

    public GameFrame() {
        frame = new JFrame("Frogger 1705063");
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

        /**
         * This is a panel for the game instructions.
         * The user will be directed here when they click on 'start game' at the start screen
         * This will be shown before the actual game starts, so that the user knows how to play
         */
        infoPage = new JPanel();
        infoPage.setBackground(Color.pink);
        infoPage.setLayout(new BoxLayout(infoPage, BoxLayout.PAGE_AXIS));
        JPanel instructions = new JPanel(new GridLayout(3,1));
        instructions.setBackground(Color.yellow);

        JLabel infoTitle = new JLabel("Instructions", SwingConstants.CENTER);
        infoTitle.setFont(new Font("Arial", Font.BOLD, 30));
        start_game = new JButton("start");
        start_game.setForeground(Color.black);
        start_game.setBackground(Color.white);
        start_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(startScreen);
                frame.remove(settingsPage);
                frame.remove(infoPage);
                frame.add(gamePage);
                frame.revalidate();
                frame.repaint();
            }
        });
        String infoText = "<html>" +
                "1. Use the left and right arrow keys to move left and right" +
                "<br/>" +
                "2. This is basically a game of frogger, get from one side to the other safely" +
                "<br/>" +
                "3. Good luck!" +
                "<br/>" +
                "<br/>" +
                "</html>";
        JLabel info = new JLabel(infoText,SwingConstants.CENTER);
        info.setFont(new Font("Arial", Font.PLAIN, 17));

        instructions.add(infoTitle);
        instructions.add(info);
        instructions.add(start_game);
        infoPage.add(Box.createRigidArea(new Dimension(0,100)));
        infoPage.add(instructions);
        infoPage.add(Box.createRigidArea(new Dimension(0,100)));

        infoPage.setOpaque(true);

        /**
         * This is a panel for the settings page.
         * Not really sure what to include in the settings yet
         * Maybe the ability to change the frog's colour ?
         */
        settingsPage = new JPanel(new BorderLayout(10,10));
        settingsPage.setBackground(Color.blue);

        JPanel settingsTop = new JPanel();
        settingsTop.setLayout(new BorderLayout(20,20));
        settingsTop.setBackground(new Color(255,233,137));
        JLabel settingsTitle = new JLabel("Settings", SwingConstants.CENTER);
        settingsTitle.setFont(new Font("Arial", Font.BOLD, 30));
        settingsTop.add(settingsTitle, BorderLayout.PAGE_END);
        backtoHome = new JButton("back");
        backtoHome.setForeground(Color.black);
        backtoHome.setBackground(Color.white);
        backtoHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(settingsPage);
                frame.remove(gamePage);
                frame.add(startScreen);
                frame.revalidate();
                frame.repaint();
            }
        });
        settingsTop.add(backtoHome, BorderLayout.LINE_START);
        settingsPage.add(settingsTop, BorderLayout.NORTH);

        settingsPage.setOpaque(true);

        /**
         * This is a panel for the game
         * At the moment the game looks a bit like frogger
         * So maybe the game might be frogger?? but with a satanic aspect
         * The satanic aspect will be added later (hopefully)
         */
        gamePage = new JPanel() {
            @Override
            public void paintComponent(Graphics g) { // we want to separate the paintComponent too
                super.paintComponent(g);

                // hexagons - find a way to make the code neater
                // we want to create a few rows to hexagons

                // ribbit
                g.setColor(new Color(52,169,95));
                g.fillRect(posx, posy, width, height);
            }
        };
        frame.addKeyListener(new frogListener(this));
        frame.setFocusable(true);
        gamePage.setBackground(new Color(220,221,255));

        JPanel gamepageTop = new JPanel();
        gamepageTop.setLayout(new BorderLayout(20,20));
        gamepageTop.setBackground(new Color(255,208,0));
        backtoHome = new JButton("quit");
        backtoHome.setForeground(Color.black);
        backtoHome.setBackground(Color.white);
        backtoHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(settingsPage);
                frame.remove(gamePage);
                frame.add(startScreen);
                frame.revalidate();
                frame.repaint();
            }
        });
        gamepageTop.add(backtoHome, BorderLayout.CENTER);
        gamePage.add(gamepageTop, BorderLayout.PAGE_START);

        gamePage.setOpaque(true);

        // basic frame stuff here
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

/**
 * This frogListener class will be moved to a new .java file in the future
 *
 */
class frogListener implements KeyListener {
    GameFrame theFrame;

    public frogListener(GameFrame f) {
        this.theFrame = f;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (theFrame.posx > 50) {
                theFrame.posx -= 5;
            }
            theFrame.gamePage.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (theFrame.posx < 500) {
                theFrame.posx += 5;
            }
            theFrame.gamePage.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (theFrame.posy > 80) {
                theFrame.posy -= 7;
            }
            theFrame.gamePage.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (theFrame.posy < 481) {
                theFrame.posy += 7;
            }
            theFrame.gamePage.repaint();
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
}
