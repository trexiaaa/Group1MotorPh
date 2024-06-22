package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class EmployeeRecords extends JFrame {

    private ArrayList<String[]> rawData;
    private JTable table;

    public EmployeeRecords() {
        setTitle("Employee Records");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);

        rawData = dataCollection();

        String[] columnNames = {"Employee #", "Last Name", "First Name", "Status", "Position", "Immediate Supervisor", "Delete"};
        Object[][] data = new Object[rawData.size()][7];

        for (int i = 0; i < rawData.size(); i++) {
            data[i][0] = rawData.get(i)[0]; // Employee #
            data[i][1] = rawData.get(i)[1]; // Last Name
            data[i][2] = rawData.get(i)[2]; // First Name
            data[i][3] = rawData.get(i)[10]; // Status
            data[i][4] = rawData.get(i)[11]; // Position
            data[i][5] = rawData.get(i)[12]; // Immediate Supervisor
            data[i][6] = "Delete"; // Delete button
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6; // Only the delete button column is editable
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0 && row < table.getRowCount()) {
                    if (col == 0) { // Click on Employee ID
                        String selectedID = (String) table.getValueAt(row, 0);
                        new EmployeeProfile(selectedID, EmployeeRecords.this);
                    } else if (col == 6) { // Click on Delete button
                        deleteEmployeeProfile(row);
                    }
                }
            }
        });

        table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
        table.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        rawData = dataCollection();

        for (int i = 0; i < rawData.size(); i++) {
            Object[] rowData = new Object[7];
            rowData[0] = rawData.get(i)[0]; // Employee #
            rowData[1] = rawData.get(i)[1]; // Last Name
            rowData[2] = rawData.get(i)[2]; // First Name
            rowData[3] = rawData.get(i)[10]; // Status
            rowData[4] = rawData.get(i)[11]; // Position
            rowData[5] = rawData.get(i)[12]; // Immediate Supervisor
            rowData[6] = "Delete"; // Delete button
            model.addRow(rowData);
        }
    }

    private ArrayList<String[]> dataCollection() {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/point/eclipse-workspace/Group1-main/Homework_4/src/Employee Details.csv"))) {
            reader.readLine(); // Skip header row
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(parseCSVLine(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
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

    public ArrayList<String[]> getRawData() {
        return rawData;
    }

    private void deleteEmployeeProfile(int row) {
        String employeeID = (String) table.getValueAt(row, 0);

        // Remove from rawData
        rawData.removeIf(data -> data[0].equals(employeeID));

        // Update CSV file
        String csvFilePath = "C:/Users/point/eclipse-workspace/Group1-main/Homework_4/src/Employee Details.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            writer.write("Employee #,Last Name,First Name,Birthday,Address,Phone,SSS #,Philhealth #,TIN #,Pag-ibig #,Status,Position,Immediate Supervisor,Basic Salary,Rice Subsidy,Phone Allowance,Clothing Allowance,Gross Semi-monthly Rate,Hourly Rate\n"); // Write header
            for (String[] info : rawData) {
                writer.write(String.join(",", info) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Refresh table
        refreshTable();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmployeeRecords::new);
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            JButton button = new JButton(label);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                // Do something when button is clicked
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}