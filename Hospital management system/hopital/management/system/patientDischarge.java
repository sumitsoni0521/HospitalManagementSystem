package hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class patientDischarge extends JFrame {

    patientDischarge(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label1 = new JLabel("CHECK-OUT");
        label1.setBounds(100, 20, 150, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Customer Id");
        label2.setBounds(30, 80, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        // room database table //
        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        choice.setFont(new Font("Tahoma", Font.BOLD, 14));
        choice.setForeground(Color.WHITE);
        choice.setBackground(new Color(3, 45, 48));
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Room_Number"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }



        JLabel label3 = new JLabel("Room_No");
        label3.setBounds(30, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(200, 130, 150, 20);
        RNo.setFont(new Font("Tahoma", Font.BOLD, 20));
        RNo.setForeground(Color.WHITE);
        panel.add(RNo);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30, 180, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 20));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200, 180, 250, 20);
        INTime.setFont(new Font("Tahoma", Font.BOLD, 20));
        INTime.setForeground(Color.WHITE);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30, 230, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 20));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        Date date1 = new Date();

        JLabel OutTime = new JLabel("" + date1);
        OutTime.setBounds(200, 230, 250, 20);
        OutTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        OutTime.setForeground(Color.WHITE);
        panel.add(OutTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30, 300, 150, 30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                conn  c = new conn();
                try {
                    c.statement.executeUpdate("delete from patient_info where Room_number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update Room set Available = 'Available' where room_no = '"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }

        });

        JButton Check = new JButton("Check");
        Check.setBounds(170, 300, 150, 30);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    ResultSet resultset = c.statement.executeQuery("select * from patient_info where Room_Number = '"+choice.getSelectedItem()+"'");
                    while (resultset.next()) {
                        RNo.setText(resultset.getString("Room_Number"));
                        INTime.setText(resultset.getString("Time"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }

        });

        JButton back = new JButton("Back");
        back.setBounds(300, 300, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }

        });


        setSize(800,400);
        setLayout(null);
        setLocation(400, 250);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new patientDischarge();
    }
}
