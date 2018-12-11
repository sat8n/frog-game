import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        JLabel highscoreTitle = new JLabel("Highscores: Top 10", SwingConstants.CENTER);
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
        table = new JTable(new DefaultTableModel(columnNames, 10));
        model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < namesWithScores.size(); i++) {
            model.addRow(namesWithScores.get(i));
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);

        // setting column width
        TableColumn column = null;
        for (int i = 0; i < 2; i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(170);
        }
        table.setRowHeight(30);
        table.setFont(new Font("Helvetica", Font.BOLD,20));
        scoreTable.add(new JScrollPane(table), BorderLayout.CENTER);

        setOpaque(true);
    }
}