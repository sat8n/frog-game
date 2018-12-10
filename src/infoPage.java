import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class infoPage extends JPanel {
    JButton start;

    public infoPage() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(new Color(215,234,255));

        JPanel instructions = new JPanel(new GridLayout(3,1));
        instructions.setBackground(new Color(215,234,255));

        JLabel infoTitle = new JLabel("Instructions", SwingConstants.CENTER);
        infoTitle.setFont(new Font("Arial", Font.BOLD, 30));

        start = new JButton("start");
        start.setForeground(Color.black);
        start.setBackground(new Color(215,234,255));

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
        instructions.add(start);

        add(Box.createRigidArea(new Dimension(0,100)));
        add(instructions);
        add(Box.createRigidArea(new Dimension(0,100)));

        setOpaque(true);
    }
}

class gameStart implements ActionListener {
    runGame r;

    public gameStart(runGame r) {
        this.r = r;
    }
    public void actionPerformed(ActionEvent e) {
        r.remove(r.startPanel);
        r.remove(r.highscore);
        r.remove(r.instructions);
        r.add(r.board);
        r.board.requestFocusInWindow();
        r.board.frog.posx = r.board.frog.initialX;
        r.board.frog.posy = r.board.frog.initialY;
        r.revalidate();
        r.repaint();
    }
}