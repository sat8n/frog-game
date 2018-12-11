import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class highscorePage extends JPanel {
    JButton back;
    ArrayList<String[]> namesWithScores;
    JTable table;
    DefaultTableModel model;

    public highscorePage() {
        setLayout(new BorderLayout(10,10));
        setBackground(new Color(215,234,255));

        JPanel highscoreTop = new JPanel();
        highscoreTop.setLayout(new BorderLayout(20,20));
        highscoreTop.setBackground(new Color(215,234,255));

        JLabel highscoreTitle = new JLabel("Highscores", SwingConstants.CENTER);
        highscoreTitle.setFont(new Font("Helvetica", Font.BOLD, 35));
        highscoreTop.add(highscoreTitle, BorderLayout.PAGE_END);

        back = new JButton("back to start");
        back.setFont(new Font("Helvetica", Font.BOLD, 15));
        back.setForeground(Color.black);
        back.setBackground(Color.white);
        highscoreTop.add(back, BorderLayout.LINE_START);
        add(highscoreTop, BorderLayout.NORTH);

        // arraylist to store players' nicknames and scores
        namesWithScores = new ArrayList<>();
        try {
            BufferedReader b = new BufferedReader(new FileReader("stats.txt"));
            String line1 = b.readLine();
            String line2 = b.readLine();
            while (line1 != null) {
                String[] combined = {line1, line2};
                namesWithScores.add(combined);
                line1 = b.readLine();
                line2 = b.readLine();
            }
        } catch (FileNotFoundException eq) {
            JOptionPane.showMessageDialog(null, "File Not Found");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: IOException");
        }

        JPanel scoreTable = new JPanel();
        scoreTable.setOpaque(false);
        add(scoreTable, BorderLayout.CENTER);

        // creating table
        String[] columnNames = {"Nickname", "Score"};
        table = new JTable(new DefaultTableModel(columnNames, (namesWithScores.size())/2));
        model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < namesWithScores.size(); i++) {
            model.addRow(namesWithScores.get(i));
        }

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scoreTable.add(table, BorderLayout.CENTER);

        setOpaque(true);
    }
}