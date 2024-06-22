package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Home extends JFrame {

    private JTextField idField, lastNameField, firstNameField, birthdayField, addressField,
            phoneField, sssField, philhealthField, tinField, pagibigField,
            statusField, positionField, supervisorField, salaryField, riceSubsidyField,
            phoneAllowanceField, clothingAllowanceField, grossRateField, hourlyRateField;

    private EmployeeRecords parent; // Reference to EmployeeRecords

    public Home(EmployeeRecords parent) {
        this.parent = parent; // Set the parent reference
        setTitle("Employee Record Creation");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        var panel = new JPanel();
        panel.setLayout(new GridLayout(20, 2, 10, 10));

        // LABELS AND TEXT FIELDS
        var idLabel = new JLabel("Employee ID:", JLabel.RIGHT);
        idField = new JTextField();
        panel.add(idLabel);
        panel.add(idField);

        var lastNameLabel = new JLabel("Last Name:", JLabel.RIGHT);
        lastNameField = new JTextField();
        panel.add(lastNameLabel);
        panel.add(lastNameField);

        var firstNameLabel = new JLabel("First Name:", JLabel.RIGHT);
        firstNameField = new JTextField();
        panel.add(firstNameLabel);
        panel.add(firstNameField);

        var birthdayLabel = new JLabel("Birthday (YYYY-MM-DD):", JLabel.RIGHT);
        birthdayField = new JTextField();
        panel.add(birthdayLabel);
        panel.add(birthdayField);

        var addressLabel = new JLabel("Address:", JLabel.RIGHT);
        addressField = new JTextField();
        panel.add(addressLabel);
        panel.add(addressField);

        var phoneLabel = new JLabel("Phone Number:", JLabel.RIGHT);
        phoneField = new JTextField();
        panel.add(phoneLabel);
        panel.add(phoneField);

        var sssLabel = new JLabel("SSS #:", JLabel.RIGHT);
        sssField = new JTextField();
        panel.add(sssLabel);
        panel.add(sssField);

        var philhealthLabel = new JLabel("Philhealth #:", JLabel.RIGHT);
        philhealthField = new JTextField();
        panel.add(philhealthLabel);
        panel.add(philhealthField);

        var tinLabel = new JLabel("TIN #:", JLabel.RIGHT);
        tinField = new JTextField();
        panel.add(tinLabel);
        panel.add(tinField);

        var pagibigLabel = new JLabel("Pag-ibig #:", JLabel.RIGHT);
        pagibigField = new JTextField();
        panel.add(pagibigLabel);
        panel.add(pagibigField);

        var statusLabel = new JLabel("Status:", JLabel.RIGHT);
        statusField = new JTextField();
        panel.add(statusLabel);
        panel.add(statusField);

        var positionLabel = new JLabel("Position:", JLabel.RIGHT);
        positionField = new JTextField();
        panel.add(positionLabel);
        panel.add(positionField);

        var supervisorLabel = new JLabel("Immediate Supervisor:", JLabel.RIGHT);
        supervisorField = new JTextField();
        panel.add(supervisorLabel);
        panel.add(supervisorField);

        var salaryLabel = new JLabel("Basic Salary:", JLabel.RIGHT);
        salaryField = new JTextField();
        panel.add(salaryLabel);
        panel.add(salaryField);

        var riceSubsidyLabel = new JLabel("Rice Subsidy:", JLabel.RIGHT);
        riceSubsidyField = new JTextField();
        panel.add(riceSubsidyLabel);
        panel.add(riceSubsidyField);

        var phoneAllowanceLabel = new JLabel("Phone Allowance:", JLabel.RIGHT);
        phoneAllowanceField = new JTextField();
        panel.add(phoneAllowanceLabel);
        panel.add(phoneAllowanceField);

        var clothingAllowanceLabel = new JLabel("Clothing Allowance:", JLabel.RIGHT);
        clothingAllowanceField = new JTextField();
        panel.add(clothingAllowanceLabel);
        panel.add(clothingAllowanceField);

        var grossRateLabel = new JLabel("Gross Semi-monthly Rate:", JLabel.RIGHT);
        grossRateField = new JTextField();
        panel.add(grossRateLabel);
        panel.add(grossRateField);

        var hourlyRateLabel = new JLabel("Hourly Rate:", JLabel.RIGHT);
        hourlyRateField = new JTextField();
        panel.add(hourlyRateLabel);
        panel.add(hourlyRateField);

        var createButton = new JButton("Create Employee");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idField.getText();
                    String lastName = lastNameField.getText();
                    String firstName = firstNameField.getText();
                    String birthday = birthdayField.getText();
                    String address = addressField.getText();
                    String phone = phoneField.getText();
                    String sss = sssField.getText();
                    String philhealth = philhealthField.getText();
                    String tin = tinField.getText();
                    String pagibig = pagibigField.getText();
                    String status = statusField.getText();
                    String position = positionField.getText();
                    String supervisor = supervisorField.getText();
                    double salary = Double.parseDouble(salaryField.getText());
                    double riceSubsidy = Double.parseDouble(riceSubsidyField.getText());
                    double phoneAllowance = Double.parseDouble(phoneAllowanceField.getText());
                    double clothingAllowance = Double.parseDouble(clothingAllowanceField.getText());
                    double grossRate = Double.parseDouble(grossRateField.getText());
                    double hourlyRate = Double.parseDouble(hourlyRateField.getText());

                    // Create and add employee to CSV
                    Employee employee = new Employee(id, lastName, firstName, birthday, address, phone, sss, philhealth, tin, pagibig, status, position, supervisor, salary, riceSubsidy, phoneAllowance, clothingAllowance, grossRate, hourlyRate);
                    addEmployeeToCSV(employee);
                    JOptionPane.showMessageDialog(null, "Employee Created Successfully!");

                    // Clear fields after creation
                    clearFields();

                    // Show the new employee profile
                    EmployeeProfile profile = new EmployeeProfile(id, parent);
                    profile.setVisible(true);

                    // Refresh the parent table
                    parent.refreshTable();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error creating employee. Please check the details.");
                    ex.printStackTrace();
                }
            }
        });

        panel.add(new JLabel());  // Empty label for spacing
        panel.add(createButton);

        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Change the FileReader path to your specific folder where the CSV file is located
    private void addEmployeeToCSV(Employee employee) {
        String filePath = "C:/Users/point/eclipse-workspace/Group1-main/Homework_4/src/Employee Details.csv";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(employee.getEmployeeID()).append(',')
                    .append(employee.getLastName()).append(',')
                    .append(employee.getFirstName()).append(',')
                    .append(employee.getBirthday()).append(',')
                    .append(employee.getAddress()).append(',')
                    .append(employee.getPhone()).append(',')
                    .append(employee.getSss()).append(',')
                    .append(employee.getPhilhealth()).append(',')
                    .append(employee.getTin()).append(',')
                    .append(employee.getPagibig()).append(',')
                    .append(employee.getStatus()).append(',')
                    .append(employee.getPosition()).append(',')
                    .append(employee.getSupervisor()).append(',')
                    .append(String.valueOf(employee.getSalary())).append(',')
                    .append(String.valueOf(employee.getRiceSubsidy())).append(',')
                    .append(String.valueOf(employee.getPhoneAllowance())).append(',')
                    .append(String.valueOf(employee.getClothingAllowance())).append(',')
                    .append(String.valueOf(employee.getGrossRate())).append(',')
                    .append(String.valueOf(employee.getHourlyRate())).append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        idField.setText("");
        lastNameField.setText("");
        firstNameField.setText("");
        birthdayField.setText("");
        addressField.setText("");
        phoneField.setText("");
        sssField.setText("");
        philhealthField.setText("");
        tinField.setText("");
        pagibigField.setText("");
        statusField.setText("");
        positionField.setText("");
        supervisorField.setText("");
        salaryField.setText("");
        riceSubsidyField.setText("");
        phoneAllowanceField.setText("");
        clothingAllowanceField.setText("");
        grossRateField.setText("");
        hourlyRateField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EmployeeRecords recordsWindow = new EmployeeRecords();
                new Home(recordsWindow);
            }
        });
    }
}