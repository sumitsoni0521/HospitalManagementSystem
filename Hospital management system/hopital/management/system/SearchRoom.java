package hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table1;

    SearchRoom() {
        // Main Panel setup
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Title Label
        JLabel forl = new JLabel("Search For Room");
        forl.setBounds(250, 11, 186, 31);
        forl.setFont(new Font("Tahoma", Font.BOLD, 20));
        forl.setForeground(Color.WHITE);
        panel.add(forl);

        // Status Label
        JLabel status = new JLabel("Status :");
        status.setBounds(70, 70, 80, 20);
        status.setFont(new Font("Tahoma", Font.BOLD, 14));
        status.setForeground(Color.WHITE);
        panel.add(status);

        // Choice for Availability
        choice = new Choice();
        choice.setBounds(170, 70, 120, 20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        // Table setup
        table1 = new JTable();
        table1.setFont(new Font("Tahoma", Font.BOLD, 14));
        table1.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setBounds(10, 150, 670, 200);
        panel.add(scrollPane);

        // Populate the table with all room data
        try {
            conn c = new conn();
            String qy = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(qy);
            table1.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception E) {
            E.printStackTrace();
        }

        // Column Labels for JTable
        JLabel roomNo = new JLabel("Room Number");
        roomNo.setBounds(10, 120, 150, 20);
        roomNo.setForeground(Color.WHITE);
        roomNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(roomNo);

        JLabel aval = new JLabel("Availability");
        aval.setBounds(175, 120, 150, 20);
        aval.setForeground(Color.WHITE);
        aval.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(aval);

        JLabel priceL = new JLabel("Price");
        priceL.setBounds(353, 120, 150, 20);
        priceL.setForeground(Color.WHITE);
        priceL.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(priceL);

        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(528, 120, 150, 20);
        bedType.setForeground(Color.WHITE);
        bedType.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(bedType);

        // Search Button
        JButton searchb = new JButton("Search");
        searchb.setBounds(200, 370, 120, 30);
        searchb.setBackground(Color.BLACK);
        searchb.setForeground(Color.WHITE);
        panel.add(searchb);
        searchb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String qey = "select * from Room where Available ='" + choice.getSelectedItem() + "'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(qey);

                    // Debugging statement to check if query returns any result
                    if (!resultSet.isBeforeFirst()) { // Check if resultSet is empty
                        JOptionPane.showMessageDialog(null, "No rooms found with status: " + choice.getSelectedItem());
                        table1.setModel(DbUtils.resultSetToTableModel(resultSet)); // Reset table to empty
                    } else {
                        table1.setModel(DbUtils.resultSetToTableModel(resultSet)); // Properly set table model
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        // Back Button
        JButton backb = new JButton("Back");
        backb.setBounds(350, 370, 120, 30);
        backb.setBackground(Color.BLACK);
        backb.setForeground(Color.WHITE);
        panel.add(backb);
        backb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Close the current window
            }
        });

        // Frame settings
        setSize(700, 500);
        setLayout(null);
        setUndecorated(true);
        setLocation(450, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
