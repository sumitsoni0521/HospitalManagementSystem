package hospital.Management.System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame {

    private JTable table;

    public Room() {
        // Frame setup
        setTitle("Room Information");
        setSize(900, 600);
        setUndecorated(true);
        setLocation(300, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Panel setup
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Image setup
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600, 250, 200, 200);
        panel.add(label);

        // Table setup
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 860, 400); // Adjusted size
        panel.add(scrollPane);

        // Load data from database

        // Add labels

        // Back button setup
        JButton back = new JButton("Back");
        back.setBounds(200, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

        // Make frame visible
        setVisible(true);
        loadTableData();
    }

    private void loadTableData() {
        try {
            conn c = new conn();
            String qry = "SELECT * FROM Room";
            ResultSet resultSet = c.statement.executeQuery(qry);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data from database: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Room();
    }
}
