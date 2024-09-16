package hospital.Management.System;

import javax.swing.*;
import java.awt.*;

import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ambulance extends JFrame {

    Ambulance() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 40, 980, 450);
        table.setBackground(new Color(98, 156, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String qre = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(qre);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception E) {
            E.printStackTrace();
        }

        JLabel Nlabel = new JLabel("Name");
        Nlabel.setBounds(13, 11, 100, 14);
        Nlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Nlabel);

        JLabel Glabel = new JLabel("Gender");
        Glabel.setBounds(208, 11, 100, 14);
        Glabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Glabel);

        JLabel Clabel = new JLabel("Car Name");
        Clabel.setBounds(402, 11, 100, 14);
        Clabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Clabel);

        JLabel Alabel = new JLabel("Available");
        Alabel.setBounds(599, 11, 100, 14);
        Alabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Alabel);

        JLabel Lolabel = new JLabel("Location");
        Lolabel.setBounds(795, 11, 100, 14);
        Lolabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Lolabel);

        JButton button = new JButton("Back");
        button.setBounds(400, 510, 120, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }

        });

        setSize(900, 600);
        setLayout(null);
        setLocation(300, 175);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ambulance();
    }
}
