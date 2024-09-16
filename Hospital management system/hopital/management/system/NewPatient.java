package hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class NewPatient extends JFrame implements ActionListener {

    // Global declare var
    @SuppressWarnings("rawtypes")
    JComboBox ID;
    JTextField Number, Patient_Name, Patient_Disease, Deposite;
    JRadioButton male, female;
    Choice Room_Number;
    JLabel Time;
    JButton add, back;

    NewPatient() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("New Patient Form");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);

        JLabel IDlab = new JLabel("ID: ");
        IDlab.setBounds(35, 76, 200, 14);
        IDlab.setFont(new Font("Tahoma", Font.BOLD, 14));
        IDlab.setForeground(Color.WHITE);
        panel.add(IDlab);

        ID = new JComboBox<>(new String[] { "Aadhar Card", "Voter Id", "Driving License" });
        ID.setBounds(271, 73, 150, 20);
        ID.setBackground(new Color(3, 45, 48));
        ID.setForeground(Color.WHITE);
        ID.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(ID);// we use choice option here also we create a table on mysql and fetch from
                      // there like c1.

        JLabel labelNumber = new JLabel("Number: ");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        Number = new JTextField();
        Number.setBounds(271, 111, 150, 20);
        panel.add(Number);

        JLabel labelName1 = new JLabel("Name: ");
        labelName1.setBounds(35, 151, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        Patient_Name = new JTextField();
        Patient_Name.setBounds(271, 151, 150, 20);
        panel.add(Patient_Name);

        JLabel labelGender = new JLabel("Gender: ");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Tahoma", Font.BOLD, 14));
        male.setForeground(Color.WHITE);
        male.setBackground(new Color(109, 164, 170));
        male.setBounds(271, 191, 80, 15);
        panel.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma", Font.BOLD, 14));
        female.setForeground(Color.WHITE);
        female.setBackground(new Color(109, 164, 170));
        female.setBounds(350, 191, 80, 15);
        panel.add(female);

        JLabel labelDisease = new JLabel("Disease: ");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        Patient_Disease = new JTextField();
        Patient_Disease.setBounds(271, 231, 150, 20);
        panel.add(Patient_Disease);

        JLabel labelRoom = new JLabel("Room No: ");
        labelRoom.setBounds(35, 259, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        // room database table //
        Room_Number = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()) {
                Room_Number.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Room_Number.setBounds(271, 259, 150, 20);
        Room_Number.setFont(new Font("Tahoma", Font.BOLD, 14));
        Room_Number.setForeground(Color.WHITE);
        Room_Number.setBackground(new Color(3, 45, 48));
        panel.add(Room_Number);

        JLabel labelDate = new JLabel("Time: ");
        labelDate.setBounds(35, 285, 200, 14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        Date date1 = new Date();

        Time = new JLabel("" + date1);
        Time.setBounds(271, 285, 250, 14);
        Time.setFont(new Font("Tahoma", Font.BOLD, 14));
        Time.setForeground(Color.WHITE);
        panel.add(Time);

        JLabel labelDeposite = new JLabel("Deposite: ");
        labelDeposite.setBounds(35, 316, 200, 17);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDeposite.setForeground(Color.WHITE);
        panel.add(labelDeposite);

        Deposite = new JTextField();
        Deposite.setBounds(271, 316, 150, 20);
        panel.add(Deposite);

        add = new JButton("Add");
        add.setBounds(100, 400, 200, 20);
        add.setFont(new Font("Tahoma", Font.BOLD, 14));
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(260, 400, 200, 20);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        setSize(800, 500);
        setLayout(null);
        setLocation(300, 195);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            conn c = new conn();
            String radioBtn = null;
            if (male.isSelected()) {
                radioBtn = "Male";
            } else if (female.isSelected()) {
                radioBtn = "Female";
            }
            String s1 = (String) ID.getSelectedItem();
            String s2 = Number.getText();
            String s4 = Patient_Name.getText();
            String s3 = radioBtn;
            String s5 = Patient_Disease.getText();
            String s6 = Room_Number.getSelectedItem();
            String s7 = Time.getText();
            String s8 = Deposite.getText();

            try {
                // Insert query
                String query = "INSERT INTO patient_info VALUES('" + s1 + "','" + s2 + "','" + s4 + "','" + s3 + "','"
                        + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                c.statement.executeUpdate(query);

                // Corrected update query
                String q1 = "UPDATE Room SET Available = 'Occupied' WHERE room_no = '" + s6 + "'";
                c.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null, "Added Successfully"); // Should work properly now
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewPatient();
    }
}
