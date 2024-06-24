package adminDashboard;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class searchResultsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmpID;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtBirthday;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtSSS;
	private JTextField txtPhilHealth;
	private JTextField txtTIN;
	private JTextField txtPagibig;
	private JTextField txtStatus;
	private JTextField txtPosition;
	private JTextField txtSupervisor;
	private JTextField txtBasicSalary;
	private JTextField txtRice;
	private JTextField txtPhoneAllow;
	private JTextField txtClothing;
	private JTextField txtSemiMonthly;
	private JTextField txtHourlyRate;
	
	
	
	private String[] employeeDetails;
	private String[] originalDetails;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchResultsFrame frame = new searchResultsFrame(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public searchResultsFrame(String[] employeeDetails) {
		this.employeeDetails = employeeDetails;
		 
		 setTitle("Employee Details");
         setSize(441, 755);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setLocationRelativeTo(null);
         getContentPane().setLayout(null);
         
         JLabel lblEmpID = new JLabel("Employee ID");
         lblEmpID.setBounds(48, 39, 103, 14);
         getContentPane().add(lblEmpID);
         
         txtEmpID = new JTextField();
         txtEmpID.setEditable(false);
         txtEmpID.setBounds(231, 33, 148, 20);
         getContentPane().add(txtEmpID);
         txtEmpID.setColumns(10);
         txtEmpID.setText(employeeDetails[0]);;
         
         JLabel lblLastName = new JLabel("Last Name");
         lblLastName.setBounds(48, 70, 103, 14);
         getContentPane().add(lblLastName);
         
         txtLastName = new JTextField();
         txtLastName.setEditable(false);
         txtLastName.setColumns(10);
         txtLastName.setBounds(231, 64, 148, 20);
         getContentPane().add(txtLastName);
         txtLastName.setText(employeeDetails[1]);
         
         JLabel lblFirstName = new JLabel("First Name");
         lblFirstName.setBounds(48, 101, 103, 14);
         getContentPane().add(lblFirstName);
         
         txtFirstName = new JTextField();
         txtFirstName.setEditable(false);
         txtFirstName.setColumns(10);
         txtFirstName.setBounds(231, 95, 148, 20);
         getContentPane().add(txtFirstName);
         txtFirstName.setText(employeeDetails[2]);
         
         JLabel lblBirthday = new JLabel("Birthday");
         lblBirthday.setBounds(48, 132, 103, 14);
         getContentPane().add(lblBirthday);
         
         txtBirthday = new JTextField();
         txtBirthday.setEditable(false);
         txtBirthday.setColumns(10);
         txtBirthday.setBounds(231, 126, 148, 20);
         getContentPane().add(txtBirthday);
         txtBirthday.setText(employeeDetails[3]);
         
         JLabel lblAddress = new JLabel("Address");
         lblAddress.setBounds(48, 163, 103, 14);
         getContentPane().add(lblAddress);
         
         txtAddress = new JTextField();
         txtAddress.setEditable(false);
         txtAddress.setColumns(10);
         txtAddress.setBounds(231, 157, 148, 20);
         getContentPane().add(txtAddress);
         txtAddress.setText(employeeDetails[4]);
         
         JLabel lblPhoneNumber = new JLabel("Phone Number");
         lblPhoneNumber.setBounds(48, 194, 103, 14);
         getContentPane().add(lblPhoneNumber);
         
         txtPhone = new JTextField();
         txtPhone.setEditable(false);
         txtPhone.setColumns(10);
         txtPhone.setBounds(231, 188, 148, 20);
         getContentPane().add(txtPhone);
         txtPhone.setText(employeeDetails[5]);
         
         JLabel lblSSS = new JLabel("SSS Number");
         lblSSS.setBounds(48, 225, 103, 14);
         getContentPane().add(lblSSS);
         
         txtSSS = new JTextField();
         txtSSS.setEditable(false);
         txtSSS.setColumns(10);
         txtSSS.setBounds(231, 219, 148, 20);
         getContentPane().add(txtSSS);
         txtSSS.setText(employeeDetails[6]);
         
         JLabel lblPhilHealth = new JLabel("PhilHealth Number");
         lblPhilHealth.setBounds(48, 256, 103, 14);
         getContentPane().add(lblPhilHealth);
      
         txtPhilHealth = new JTextField();
         txtPhilHealth.setEditable(false);
         txtPhilHealth.setColumns(10);
         txtPhilHealth.setBounds(231, 250, 148, 20);
         getContentPane().add(txtPhilHealth);
         txtPhilHealth.setText(employeeDetails[7]);
         
         JLabel lblTIN = new JLabel("TIN Number");
         lblTIN.setBounds(48, 287, 103, 14);
         getContentPane().add(lblTIN);
         
         txtTIN = new JTextField();
         txtTIN.setEditable(false);
         txtTIN.setColumns(10);
         txtTIN.setBounds(231, 281, 148, 20);
         getContentPane().add(txtTIN);
         txtTIN.setText(employeeDetails[8]);
         
         JLabel lblPagibig = new JLabel("Pag-Ibig Number");
         lblPagibig.setBounds(48, 318, 103, 14);
         getContentPane().add(lblPagibig);
         
         txtPagibig = new JTextField();
         txtPagibig.setEditable(false);
         txtPagibig.setColumns(10);
         txtPagibig.setBounds(231, 312, 148, 20);
         getContentPane().add(txtPagibig);
         txtPagibig.setText(employeeDetails[9]);
         
         JLabel lblStatus = new JLabel("Status");
         lblStatus.setBounds(48, 349, 103, 14);
         getContentPane().add(lblStatus);
         
         txtStatus = new JTextField();
         txtStatus.setEditable(false);
         txtStatus.setColumns(10);
         txtStatus.setBounds(231, 343, 148, 20);
         getContentPane().add(txtStatus);
         txtStatus.setText(employeeDetails[10]);
         
         JLabel lblPosition = new JLabel("Position");
         lblPosition.setBounds(48, 380, 103, 14);
         getContentPane().add(lblPosition);
         
         txtPosition = new JTextField();
         txtPosition.setEditable(false);
         txtPosition.setColumns(10);
         txtPosition.setBounds(231, 374, 148, 20);
         getContentPane().add(txtPosition);
         txtPosition.setText(employeeDetails[11]);
         
         JLabel lblSupervisor = new JLabel("Immediate Supervisor");
         lblSupervisor.setBounds(48, 411, 117, 14);
         getContentPane().add(lblSupervisor);
         
         txtSupervisor = new JTextField();
         txtSupervisor.setEditable(false);
         txtSupervisor.setColumns(10);
         txtSupervisor.setBounds(231, 405, 148, 20);
         getContentPane().add(txtSupervisor);
         txtSupervisor.setText(employeeDetails[12]);
         
         JLabel lblBasicSalary = new JLabel("Basic Salary");
         lblBasicSalary.setBounds(48, 442, 103, 14);
         getContentPane().add(lblBasicSalary);
         
         txtBasicSalary = new JTextField();
         txtBasicSalary.setEditable(false);
         txtBasicSalary.setColumns(10);
         txtBasicSalary.setBounds(231, 436, 148, 20);
         getContentPane().add(txtBasicSalary);
         txtBasicSalary.setText(employeeDetails[13]);
         
         JLabel lblRice = new JLabel("Rice Subsidy");
         lblRice.setBounds(48, 473, 103, 14);
         getContentPane().add(lblRice);
         
         txtRice = new JTextField();
         txtRice.setEditable(false);
         txtRice.setColumns(10);
         txtRice.setBounds(231, 467, 148, 20);
         getContentPane().add(txtRice);
         txtRice.setText(employeeDetails[14]);
         
         JLabel lblPhoneAllow = new JLabel("Phone Allowance");
         lblPhoneAllow.setBounds(48, 504, 103, 14);
         getContentPane().add(lblPhoneAllow);
         
         txtPhoneAllow = new JTextField();
         txtPhoneAllow.setEditable(false);
         txtPhoneAllow.setColumns(10);
         txtPhoneAllow.setBounds(231, 498, 148, 20);
         getContentPane().add(txtPhoneAllow);
         txtPhoneAllow.setText(employeeDetails[15]);
         
         JLabel lblClothing = new JLabel("Clothing Allowance");
         lblClothing.setBounds(48, 535, 103, 14);
         getContentPane().add(lblClothing);
         
         txtClothing = new JTextField();
         txtClothing.setEditable(false);
         txtClothing.setColumns(10);
         txtClothing.setBounds(231, 529, 148, 20);
         getContentPane().add(txtClothing);
         txtClothing.setText(employeeDetails[16]);
         
         JLabel lblSemiMonthly = new JLabel("Gross Semi-monthly Rate");
         lblSemiMonthly.setBounds(48, 566, 148, 14);
         getContentPane().add(lblSemiMonthly);
         
         txtSemiMonthly = new JTextField();
         txtSemiMonthly.setEditable(false);
         txtSemiMonthly.setColumns(10);
         txtSemiMonthly.setBounds(231, 560, 148, 20);
         getContentPane().add(txtSemiMonthly);
         txtSemiMonthly.setText(employeeDetails[17]);
         
         JLabel lblHourlyRate = new JLabel("Hourly Rate");
         lblHourlyRate.setBounds(48, 597, 103, 14);
         getContentPane().add(lblHourlyRate);
         
         txtHourlyRate = new JTextField();
         txtHourlyRate.setEditable(false);
         txtHourlyRate.setColumns(10);
         txtHourlyRate.setBounds(231, 591, 148, 20);
         getContentPane().add(txtHourlyRate);
         txtHourlyRate.setText(employeeDetails[18]);
         
         JButton btnSave = new JButton("Save");
         btnSave.setVisible(false);
         btnSave.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		saveEmployeeDetails();
         		btnSave.setVisible(false);
         	}
         });
         btnSave.setBounds(86, 650, 89, 23);
         getContentPane().add(btnSave);
             
         JButton btnUpdate = new JButton("Update");
         btnUpdate.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		txtEmpID.setEditable(false);
     			txtLastName.setEditable(true);
     			txtFirstName.setEditable(true);
     			txtBirthday.setEditable(true);
     			txtAddress.setEditable(true);
     			txtPhone.setEditable(true);
     			txtSSS.setEditable(true);
     			txtPhilHealth.setEditable(true);
     			txtTIN.setEditable(true);
     			txtPagibig.setEditable(true);
     			txtStatus.setEditable(true);
     			txtPosition.setEditable(true);
     			txtSupervisor.setEditable(true);
     			txtBasicSalary.setEditable(true);
     			txtRice.setEditable(true);
     			txtPhoneAllow.setEditable(true);
     			txtClothing.setEditable(true);
     			txtSemiMonthly.setEditable(true);
     			txtHourlyRate.setEditable(true);
     			btnSave.setVisible(true);
         	}
         });
         btnUpdate.setBounds(249, 650, 89, 23);
         getContentPane().add(btnUpdate);
         
         
         
         
      // Populate text fields with employee details if available
 		if (employeeDetails != null && employeeDetails.length >= 19) {
 			txtEmpID.setText(employeeDetails[0]);
 			txtLastName.setText(employeeDetails[1]);
 			txtFirstName.setText(employeeDetails[2]);
 			txtBirthday.setText(employeeDetails[3]);
 			txtAddress.setText(employeeDetails[4]);
 			txtPhone.setText(employeeDetails[5]);
 			txtSSS.setText(employeeDetails[6]);
 			txtPhilHealth.setText(employeeDetails[7]);
 			txtTIN.setText(employeeDetails[8]);
 			txtPagibig.setText(employeeDetails[9]);
 			txtStatus.setText(employeeDetails[10]);
 			txtPosition.setText(employeeDetails[11]);
 			txtSupervisor.setText(employeeDetails[12]);
 			txtBasicSalary.setText(employeeDetails[13]);
 			txtRice.setText(employeeDetails[14]);
 			txtPhoneAllow.setText(employeeDetails[15]);
 			txtClothing.setText(employeeDetails[16]);
 			txtSemiMonthly.setText(employeeDetails[17]);
 			txtHourlyRate.setText(employeeDetails[18]);
 		} else {
 			JOptionPane.showMessageDialog(null, "Invalid employee details provided.");
 			return;
 		}
         
         setVisible(true);
         
     }
	
	
	 private void saveEmployeeDetails() {
		 if (employeeDetails == null || employeeDetails.length < 18) {
		        JOptionPane.showMessageDialog(null, "Invalid employee details provided.");
		        return;
		    }
		                          
		 try {
		        ArrayList<String[]> lines = new ArrayList<>();
		        File file = new File("src\\EmployeeDetails.csv");
		        BufferedReader br = new BufferedReader(new FileReader(file));
		        String line;
		        while ((line = br.readLine()) != null) {
		            String[] details = line.split(",");
		            lines.add(details); // Add each line to the list
		        }
		        br.close();

		        // Ensure employeeDetails is not null and has at least 18 elements
		        if (employeeDetails != null && employeeDetails.length >= 18) {
		            boolean isModified = false;
		            for (String[] details : lines) {
		                if (details[0].trim().equals(employeeDetails[0])) {
		                    // Update the line with new details if modified
		                    if (!details[1].trim().equals(txtLastName.getText().trim())) {
		                        details[1] = txtLastName.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[2].trim().equals(txtFirstName.getText().trim())) {
		                        details[2] = txtFirstName.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[3].trim().equals(txtBirthday.getText().trim())) {
		                        details[3] = txtBirthday.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[4].trim().equals(txtAddress.getText().trim())) {
		                        details[4] = txtAddress.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[5].trim().equals(txtPhone.getText().trim())) {
		                        details[5] = txtPhone.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[6].trim().equals(txtSSS.getText().trim())) {
		                        details[6] = txtSSS.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[7].trim().equals(txtPhilHealth.getText().trim())) {
		                        details[7] = txtPhilHealth.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[8].trim().equals(txtTIN.getText().trim())) {
		                        details[8] = txtTIN.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[9].trim().equals(txtPagibig.getText().trim())) {
		                        details[9] = txtPagibig.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[10].trim().equals(txtStatus.getText().trim())) {
		                        details[10] = txtStatus.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[11].trim().equals(txtPosition.getText().trim())) {
		                        details[11] = txtPosition.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[12].trim().equals(txtSupervisor.getText().trim())) {
		                        details[12] = txtSupervisor.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[13].trim().equals(txtBasicSalary.getText().trim())) {
		                        details[13] = txtBasicSalary.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[14].trim().equals(txtRice.getText().trim())) {
		                        details[14] = txtRice.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[15].trim().equals(txtPhoneAllow.getText().trim())) {
		                        details[15] = txtPhoneAllow.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[16].trim().equals(txtClothing.getText().trim())) {
		                        details[16] = txtClothing.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[17].trim().equals(txtSemiMonthly.getText().trim())) {
		                        details[17] = txtSemiMonthly.getText().trim();
		                        isModified = true;
		                    }
		                    if (!details[18].trim().equals(txtHourlyRate.getText().trim())) {
		                        details[18] = txtHourlyRate.getText().trim();
		                        isModified = true;
		                    }                      

		           
		                }
		            }

		            if (isModified) {
		                // Write updated lines back to the CSV file
		                BufferedWriter bw = new BufferedWriter(new FileWriter("src\\EmployeeDetails.csv"));
		                for (String[] details : lines) {
		                    bw.write(String.join(",", details));
		                    bw.newLine();
		                }
		                bw.close();

		                JOptionPane.showMessageDialog(null, "Employee details saved successfully.");


	            // Update the local copy of employeeDetails with the new values
	            employeeDetails[1] = txtLastName.getText().trim();
	            employeeDetails[2] = txtFirstName.getText().trim();
	            employeeDetails[3] = txtBirthday.getText().trim();
	            employeeDetails[4] = txtAddress.getText().trim();
	            employeeDetails[5] = txtPhone.getText().trim();
	            employeeDetails[6] = txtSSS.getText().trim();
	            employeeDetails[7] = txtPhilHealth.getText().trim();
	            employeeDetails[8] = txtTIN.getText().trim();
	            employeeDetails[9] = txtPagibig.getText().trim();
	            employeeDetails[10] = txtStatus.getText().trim();
	            employeeDetails[11] = txtPosition.getText().trim();
	            employeeDetails[12] = txtSupervisor.getText().trim();
	            employeeDetails[13] = txtBasicSalary.getText().trim();
	            employeeDetails[14] = txtRice.getText().trim();
	            employeeDetails[15] = txtPhoneAllow.getText().trim();
	            employeeDetails[16] = txtClothing.getText().trim();
	            employeeDetails[17] = txtSemiMonthly.getText().trim();
	            employeeDetails[18] = txtHourlyRate.getText().trim();

	            // After saving, reset to non-editable mode and hide Save button
	            txtEmpID.setEditable(false);
	            txtLastName.setEditable(false);
	            txtFirstName.setEditable(false);
	            txtBirthday.setEditable(false);
	            txtAddress.setEditable(false);
	            txtPhone.setEditable(false);
	            txtSSS.setEditable(false);
	            txtPhilHealth.setEditable(false);
     			txtTIN.setEditable(false);
     			txtPagibig.setEditable(false);
     			txtStatus.setEditable(false);
     			txtPosition.setEditable(false);
     			txtSupervisor.setEditable(false);
     			txtBasicSalary.setEditable(false);
     			txtRice.setEditable(false);
     			txtPhoneAllow.setEditable(false);
     			txtClothing.setEditable(false);
     			txtSemiMonthly.setEditable(false);
     			txtHourlyRate.setEditable(false);
     			
	            
	            
		            } else {
		                JOptionPane.showMessageDialog(null, "No changes detected.");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Invalid employee details provided.");
		        }

	        } catch (IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error saving employee details.");
	        }
		
	    } 
	
 }


