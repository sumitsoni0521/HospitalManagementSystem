package hospital.Management.System;

import javax.swing.*;
import java.awt.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0, 40, 700, 350);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String qeri = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(qeri);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception E) {
            E.printStackTrace();
        }

        JLabel label = new JLabel("Department");
        label.setBounds(25, 11, 105, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(355, 11, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JButton b1 = new JButton("Back");
        b1.setBounds(400, 410, 130, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }

        });

        setSize(700, 500);
        setLayout(null);
        setLocation(350, 250);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
