package hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employee_info extends JFrame {

    Employee_info() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String qry = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(qry);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception E) {
            E.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(41, 9, 70, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(180, 9, 70, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label2);

        JLabel label3 = new JLabel("Phone_No");
        label3.setBounds(350, 9, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(525, 9, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(730, 9, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar_No");
        label6.setBounds(830, 9, 150, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label6);

        JButton button = new JButton("Back");
        button.setBounds(350, 500, 120, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }

        });

        setSize(1000, 600);
        setLocation(350, 230);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
