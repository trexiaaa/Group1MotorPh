package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class EmployeeProfile extends JFrame {

    private JPanel profilePanel;
    private String employeeID;
    private EmployeeRecords parent;
    private ArrayList<JTextField> textFields;
    private String[] currentInfo;
    private JButton editButton;
    private JButton saveButton;

    public EmployeeProfile(String employeeID, EmployeeRecords parent) {
        this.employeeID = employeeID;
        this.parent = parent;
        this.textFields = new ArrayList<>();

        setTitle("Employee Profile");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(0, 2, 10, 10)); // 2 columns with spaces between components
        profilePanel.setBackground(new Color(240, 240, 255)); // Light blue background

        JScrollPane scrollPane = new JScrollPane(profilePanel);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        loadEmployeeProfile(employeeID);

        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleEditMode();
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmployeeProfile();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadEmployeeProfile(String employeeID) {
        String line;
        String csvFilePath = "C:/Users/point/eclipse-workspace/Group1-main/Homework_4/src/Employee Details.csv"; // CSV file path
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = reader.readLine()) != null) {
                String[] info = parseCSVLine(line);
                if (info[0].trim().equals(employeeID.trim())) {
                    currentInfo = info;
                    profilePanel.removeAll(); // Clear previous content
                    appendToPane("Employee ID: ", info[0], false); // Non-editable
                    appendToPane("Last Name: ", info[1], true);
                    appendToPane("First Name: ", info[2], true);
                    appendToPane("Birthday: ", info[3], true);
                    appendToPane("Address: ", info[4], true);
                    appendToPane("Phone: ", info[5], true);
                    appendToPane("SSS #: ", info[6], true);
                    appendToPane("Philhealth #: ", info[7], true);
                    appendToPane("TIN #: ", info[8], true);
                    appendToPane("Pag-ibig #: ", info[9], true);
                    appendToPane("Status: ", info[10], true);
                    appendToPane("Position: ", info[11], true);
                    appendToPane("Immediate Supervisor: ", info[12], true);
                    appendToPane("Basic Salary: ", info[13], true);
                    appendToPane("Rice Subsidy: ", info[14], true);
                    appendToPane("Phone Allowance: ", info[15], true);
                    appendToPane("Clothing Allowance: ", info[16], true);
                    appendToPane("Gross Semi-monthly Rate: ", info[17], true);
                    appendToPane("Hourly Rate: ", info[18], true);
                    profilePanel.revalidate();
                    profilePanel.repaint();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendToPane(String label, String value, boolean editable) {
        JLabel jLabel = new JLabel(label);
        JTextField textField = new JTextField(value);
        textField.setEditable(editable);
        textField.setBorder(null);
        if (!editable) {
            textField.setBackground(profilePanel.getBackground()); // Make non-editable fields match panel background
        }
        profilePanel.add(jLabel);
        profilePanel.add(textField);
        textFields.add(textField);
    }

    private void toggleEditMode() {
        boolean isEditable = textFields.get(1).isEditable(); // Assuming index 1 is the first editable field after Employee ID
        for (int i = 1; i < textFields.size(); i++) { // Start from index 1 to skip Employee ID
            textFields.get(i).setEditable(!isEditable);
        }
        editButton.setEnabled(!isEditable); // Disable edit button when in edit mode
        saveButton.setEnabled(isEditable); // Enable save button when in edit mode
    }

    private void updateEmployeeProfile() {
        String csvFilePath = "C:/Users/point/eclipse-workspace/Group1-main/Homework_4/src/Employee Details.csv";
        ArrayList<String[]> updatedData = new ArrayList<>();

        // Update the currentInfo with edited values
        for (int i = 1; i < currentInfo.length; i++) {
            currentInfo[i] = textFields.get(i).getText().trim();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            // Write header
            writer.write("Employee #,Last Name,First Name,Birthday,Address,Phone,SSS #,Philhealth #,TIN #,Pag-ibig #,Status,Position,Immediate Supervisor,Basic Salary,Rice Subsidy,Phone Allowance,Clothing Allowance,Gross Semi-monthly Rate,Hourly Rate\n");
            // Write updated info
            writer.write(String.join(",", currentInfo) + "\n");

            // Append the rest of the data
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = parseCSVLine(line);
                if (!info[0].equals(employeeID)) {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Refresh the main table and the profile display
        parent.refreshTable();
        loadEmployeeProfile(employeeID);

        // Reset buttons
        editButton.setEnabled(true);
        saveButton.setEnabled(false);
    }

    private String[] parseCSVLine(String line) {
        ArrayList<String> fields = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                fields.add(currentField.toString());
                currentField = new StringBuilder();
            } else {
                currentField.append(c);
            }
        }
        fields.add(currentField.toString());

        return fields.toArray(new String[0]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeProfile("1", new EmployeeRecords())); // Example with employee ID "1"
    }
}