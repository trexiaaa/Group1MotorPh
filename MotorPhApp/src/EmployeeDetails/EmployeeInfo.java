package EmployeeDetails;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.table.DefaultTableModel;

public class EmployeeInfo {

	private JFrame frmEmployeeDetails;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo window = new EmployeeInfo();
					window.frmEmployeeDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeDetails = new JFrame();
		frmEmployeeDetails.setTitle("Employee Details");
		frmEmployeeDetails.setBounds(100, 100, 805, 561);
		frmEmployeeDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeDetails.getContentPane().setLayout(null);
		
		JLabel lblEmpID = new JLabel("Employee ID:");
		lblEmpID.setBounds(24, 33, 80, 14);
		frmEmployeeDetails.getContentPane().add(lblEmpID);
		
		JTextArea txtAreaEmpID = new JTextArea();
		
		
		txtAreaEmpID.setBounds(202, 28, 129, 19);
		frmEmployeeDetails.getContentPane().add(txtAreaEmpID);
		
		JLabel lblNewLabel = new JLabel("Employee Name: ");
		lblNewLabel.setBounds(24, 58, 109, 14);
		frmEmployeeDetails.getContentPane().add(lblNewLabel);
		
		JTextArea textAreaName = new JTextArea();
		textAreaName.setBounds(202, 53, 129, 19);
		frmEmployeeDetails.getContentPane().add(textAreaName);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(24, 83, 46, 14);
		frmEmployeeDetails.getContentPane().add(lblBirthday);
		
		JTextArea textAreaBirthday = new JTextArea();
		textAreaBirthday.setBounds(202, 78, 129, 22);
		frmEmployeeDetails.getContentPane().add(textAreaBirthday);
		
		table = new JTable();
		table.setBounds(37, 135, 721, 355);
		frmEmployeeDetails.getContentPane().add(table);
		
		
	}
	public static void EmployeeDetails() throws IOException {
        String file = "src\\EmployeeDetails.csv";
        BufferedReader reader = null;
        String line = "";
        
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length >= 19) { // Assuming relevant columns are at least the first 4
                    String lastName = row[1].trim();
                    String birthday = row[3].trim();
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
