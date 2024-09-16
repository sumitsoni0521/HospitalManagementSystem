package hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePatientDetails extends JFrame {
    UpdatePatientDetails() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124, 11, 260, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Name: ");
        label2.setBounds(25, 88, 140, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice pChoice = new Choice();
        pChoice.setBounds(248, 85, 140, 25);
        panel.add(pChoice);
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                pChoice.add(resultSet.getString("Patient_Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room No: ");
        label3.setBounds(25, 129, 140, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248, 129, 140, 20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time: ");
        label4.setBounds(25, 174, 100, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248, 174, 140, 20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount Paid: ");
        label5.setBounds(25, 216, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 216, 140, 20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount: ");
        label6.setBounds(25, 261, 150, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248, 261, 140, 20);
        panel.add(textFieldPending);

        JButton checkb = new JButton("Check");
        checkb.setBounds(281, 378, 89, 23);
        checkb.setBackground(Color.BLACK);
        checkb.setForeground(Color.WHITE);
        panel.add(checkb);
        checkb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String id = pChoice.getSelectedItem();
                String query = "select * from patient_info where Patient_Name = '" + id + "'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_number"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }
                    ResultSet resultSet1 = c.statement
                            .executeQuery("select * from Room where room_no= '" + textFieldR.getText() + "'");
                    while (resultSet.next()) {
                        String Price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(Price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText("" + amountPaid);
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton updateb = new JButton("Update");
        updateb.setBounds(56, 378, 89, 23);
        updateb.setBackground(Color.BLACK);
        updateb.setForeground(Color.WHITE);
        panel.add(updateb);
        updateb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String qry = pChoice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set Room_number ='" + room + "', Time ='" + time
                            + "', Deposite = '" + amount + "' where Patient_Name='" + qry + "'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(168, 378, 89, 23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }

        });

        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdatePatientDetails();
    }
}
