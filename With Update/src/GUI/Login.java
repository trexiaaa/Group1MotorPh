package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {
        setTitle("Employee Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        var panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        var usernameLabel = new JLabel("Username (Last Name):", JLabel.RIGHT);
        usernameField = new JTextField();
        panel.add(usernameLabel);
        panel.add(usernameField);

        var passwordLabel = new JLabel("Password (Birthday YYYY-MM-DD):", JLabel.RIGHT);
        passwordField = new JPasswordField();
        panel.add(passwordLabel);
        panel.add(passwordField);

        var loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });

        var signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open EmployeeRecords window for viewing and new user registration
                EmployeeRecords recordsWindow = new EmployeeRecords();
                new Home(recordsWindow);
                dispose();
            }
        });

        panel.add(loginButton);
        panel.add(signUpButton);

        getContentPane().add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void authenticateUser() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        boolean isAuthenticated = false;
        String employeeID = null;

        // Change the FileReader path to your specific folder where the CSV file is located
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/point/eclipse-workspace/Group1-main/Homework_4/src/Employee Details.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(",");
                if (info[1].trim().equals(username) && info[3].trim().equals(password)) {
                    isAuthenticated = true;
                    employeeID = info[0];  // Capture employee ID
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (isAuthenticated) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            // Open EmployeeProfile window
            EmployeeRecords recordsWindow = new EmployeeRecords();
            new EmployeeProfile(employeeID, recordsWindow);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}