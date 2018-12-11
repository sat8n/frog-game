import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class highscorePage extends JPanel {
    JButton back;
    ArrayList<String[]> namesWithScores;

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

        // assigning table values
        String[] columnNames = {"Nickname", "Score"};
        Object[][] data = new Object[namesWithScores.size()][2];
        for (int i = 0; i < namesWithScores.size(); i++) {
            data[i][0] = namesWithScores.get(i)[0];
            data[i][1] = namesWithScores.get(i)[1];
        }

        // creating table
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Helvetica", Font.BOLD, 17));
        TableColumn column = null;
        for (int i = 0; i < 2; i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(170);
        }
        scoreTable.add(table, BorderLayout.CENTER);

        setOpaque(true);
    }
}