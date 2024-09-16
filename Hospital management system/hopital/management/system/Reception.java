package hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    // Global var.
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;

    Reception() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1525, 670);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150);
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1300, 0, 250, 250);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image2 = i11.getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(image2);
        JLabel label2 = new JLabel(i21);
        label2.setBounds(1000, 50, 300, 100);
        panel1.add(label2);

        btn1 = new JButton("Add new Patient");
        btn1.setBounds(30, 15, 200, 30);
        btn1.setBackground(new Color(246, 215, 118));
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new NewPatient();
            }

        });
        panel1.add(btn1);

        btn2 = new JButton("Room");
        btn2.setBounds(30, 58, 200, 30);
        btn2.setBackground(new Color(246, 215, 118));
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });
        panel1.add(btn2);

        btn3 = new JButton("Department");
        btn3.setBounds(30, 100, 200, 30);
        btn3.setBackground(new Color(246, 215, 118));
        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }

        });
        panel1.add(btn3);

        btn4 = new JButton("All Employee Info");
        btn4.setBounds(270, 15, 200, 30);
        btn4.setBackground(new Color(246, 215, 118));
        btn4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }

        });
        panel1.add(btn4);

        btn5 = new JButton("Patient Info");
        btn5.setBounds(270, 58, 200, 30);
        btn5.setBackground(new Color(246, 215, 118));
        btn5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AllPatientInfo();
            }

        });
        panel1.add(btn5);

        btn6 = new JButton("Patient Discharge");
        btn6.setBounds(270, 100, 200, 30);
        btn6.setBackground(new Color(246, 215, 118));
        btn6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new patientDischarge();
            }

        });
        panel1.add(btn6);

        btn7 = new JButton("Update Patient Info");
        btn7.setBounds(510, 15, 200, 30);
        btn7.setBackground(new Color(246, 215, 118));
        btn7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdatePatientDetails();
            }

        });
        panel1.add(btn7);

        btn8 = new JButton("Hospital Ambulance");
        btn8.setBounds(510, 58, 200, 30);
        btn8.setBackground(new Color(246, 215, 118));
        btn8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }

        });
        panel1.add(btn8);

        btn9 = new JButton("Search Room");
        btn9.setBounds(510, 100, 200, 30);
        btn9.setBackground(new Color(246, 215, 118));
        btn9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }

        });
        panel1.add(btn9);

        btn10 = new JButton("Logout");
        btn10.setBounds(750, 15, 200, 30);
        btn10.setBackground(new Color(246, 215, 118));
        btn10.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }

        });
        panel1.add(btn10);

        setSize(1950, 1090);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        // setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
