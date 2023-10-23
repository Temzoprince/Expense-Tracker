import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormForAddData {

    private JFrame frame2;
    private JTextField Date;
    private JTextField Description;
    private JTextField Category;
    private JTextField Amount;

    String dateToAdd;
    String descriptionToAdd;
    String categoryToAdd;
    double amountToAdd;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormForAddData window = new FormForAddData();
                    window.frame2.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public FormForAddData() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */JTable table = new JTable();

    private void initialize() {


        frame2 = new JFrame();
        frame2.setBounds(430, 200, 500, 300);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.getContentPane().setLayout(null);


        Date = new JTextField();
        Date.setBounds(10, 11, 133, 20);
        frame2.getContentPane().add(Date);
        Date.setColumns(10);

        Description = new JTextField();
        Description.setBounds(10, 42, 133, 20);
        frame2.getContentPane().add(Description);
        Description.setColumns(10);

        Category = new JTextField();
        Category.setBounds(10, 73, 133, 20);
        frame2.getContentPane().add(Category);
        Category.setColumns(10);

        Amount = new JTextField();
        Amount.setBounds(10, 104, 133, 20);
        frame2.getContentPane().add(Amount);
        Amount.setColumns(10);

        JLabel lblDate = new JLabel("Date (yyyy-mm-dd)");
        lblDate.setBounds(151, 11, 115, 20);
        frame2.getContentPane().add(lblDate);

        JLabel lblDescription = new JLabel("Description");
        lblDescription.setBounds(151, 42, 95, 20);
        frame2.getContentPane().add(lblDescription);

        JLabel lblCategory = new JLabel("Category");
        lblCategory.setBounds(151, 73, 95, 20);
        frame2.getContentPane().add(lblCategory);

        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setBounds(151, 104, 95, 20);
        frame2.getContentPane().add(lblAmount);


        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dateToAdd = Date.getText();
                descriptionToAdd = Description.getText();
                categoryToAdd = Category.getText();
                amountToAdd = Double.parseDouble(Amount.getText());
                System.out.println("Amount " + amountToAdd);

                JOptionPane.showMessageDialog(frame2, "Expense Added!");
                frame2.dispose();

                System.out.println(amountToAdd);

                DataHandle handle = new DataHandle();
                handle.addData(dateToAdd, descriptionToAdd, categoryToAdd, amountToAdd);

                try {
                    GUI startup = new GUI();
                    startup.getFrame().setVisible(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }

                System.out.println("Data Added");

            }
        });
        btnAdd.setBounds(230, 89, 89, 23);
        frame2.getContentPane().add(btnAdd);


    }
    public JFrame getFrame2() {
        return frame2;
    }
    public String getDateToAdd() {
        return dateToAdd;
    }

    public String getDescriptionToAdd() {
        return descriptionToAdd;
    }

    public String getCategoryToAdd() {
        return categoryToAdd;
    }

    public double getAmountToAdd() {
        return amountToAdd;
    }
}
