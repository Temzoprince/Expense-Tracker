import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Arrays;

public class GUI {
    private JFrame frame;
    private JButton addExpense;
    private JButton deleteAllExpense;
    private JButton deleteIdExpense;
    DataHandle handle = new DataHandle();
    private int row;
    private String rowID;
    private int rowCount = 0;

    FormForAddData addDataWindow;

    public JFrame getFrame() {
        return frame;
    }

    public GUI() {
        frame = new JFrame("Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel buttonPanel = new JPanel();
        addExpense = new JButton("Add Expense");
        deleteAllExpense = new JButton("Delete all Expenses");
        deleteIdExpense = new JButton("Delete an Expense");
        buttonPanel.add(addExpense);
        buttonPanel.add(deleteAllExpense);
        buttonPanel.add(deleteIdExpense);
        frame.add(buttonPanel, BorderLayout.NORTH);

        // Create a DefaultTableModel with data
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Date");
        model.addColumn("Description");
        model.addColumn("Category");
        model.addColumn("Amount");
        model.addColumn("ID");

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-example", "root", "Qassword!23");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from expense");
            //resultSet

            while (resultSet.next()) {
                LocalDate Date = resultSet.getDate("date").toLocalDate();
                String Desc = (resultSet.getString("description"));
                String Category = (resultSet.getString("category"));
                Float Amount = resultSet.getFloat("amount");
                Integer ID = resultSet.getInt("id");

                model.addRow(new Object[]{Date, Desc, Category, Amount, ID});

                String[] haha = {String.valueOf(Date), Desc, Category, String.valueOf(Amount)};
                System.out.println(Date + " " + Desc + " " + Category + " " + Amount);
                System.out.println(Arrays.toString(haha));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a JTable with the model
        JTable table = new JTable(model);

        table.removeColumn(table.getColumnModel().getColumn(4));

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = table.getSelectedRow();
                rowID = model.getValueAt(row, 4).toString();
                System.out.println(rowID);
                System.out.println(row);
                System.out.println("HEHEHEHEHEHEHHEEEEEEEE");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        deleteIdExpense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handle.deleteData(rowID);
                model.removeRow(row);
            }
        });

        deleteAllExpense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handle.deleteAllData();
                rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
            }
        });

        addExpense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.dispose();
                    addDataWindow = new FormForAddData();
                    addDataWindow.getFrame2().setVisible(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });



        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
