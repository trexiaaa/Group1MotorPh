import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frmEmployeeDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelPersonal;
	private JPanel panelWork;
	private JPanel panelSalary;
	private JLayeredPane layeredPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtBirthday;
	private JTextField txtPhoneNum;
	private JTextField txtAddress;
	private JTextField txtEmpId;
	private JTextField txtStatus;
	private JTextField txtPosition;
	private JTextField txtSupervisor;
	private JTextField txtSss;
	private JTextField txtPagibig;
	private JTextField txtTin;
	private JTextField txtPhilhealth;
	private JTextField txtBasicSalary;
	private JTextField txtHourlyRate;
	private JTextField txtRiceSubsidy;
	private JTextField txtPhoneAllowance;
	private JTextField txtClothingAllow;
	private JTextField txtSemiRate;
	private String[] details;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEmployeeDashboard frame = new frmEmployeeDashboard();
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
	public frmEmployeeDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 50, 908, 975);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPersonal = new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelPersonal);
			}
		});
		btnPersonal.setBounds(32, 449, 89, 23);
		contentPane.add(btnPersonal);
		
		JButton btnWork = new JButton("Work");
		btnWork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelWork);
			}
		});
		btnWork.setBounds(32, 483, 89, 23);
		contentPane.add(btnWork);
		
		JButton btnSalary = new JButton("Salary");
		btnSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelSalary);
			}
		});
		btnSalary.setBounds(32, 517, 89, 23);
		contentPane.add(btnSalary);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(166, 429, 628, 491);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelPersonal = new JPanel();
		panelPersonal.setBackground(new Color(255, 204, 204));
		layeredPane.add(panelPersonal, "name_176429764906000");
		panelPersonal.setLayout(null);
		
		JLabel lblPersonal = new JLabel("Personal Information");
		lblPersonal.setForeground(new Color(0, 51, 102));
		lblPersonal.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPersonal.setBounds(30, 11, 299, 41);
		panelPersonal.add(lblPersonal);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(0, 51, 102));
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstName.setBounds(30, 71, 123, 19);
		panelPersonal.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setEditable(false);
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtFirstName.setBounds(180, 67, 410, 27);
		panelPersonal.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(0, 51, 102));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(30, 122, 123, 19);
		panelPersonal.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setEditable(false);
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLastName.setColumns(10);
		txtLastName.setBounds(180, 118, 410, 27);
		panelPersonal.add(txtLastName);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setForeground(new Color(0, 51, 102));
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBirthday.setBounds(30, 175, 123, 19);
		panelPersonal.add(lblBirthday);
		
		txtBirthday = new JTextField();
		txtBirthday.setEditable(false);
		txtBirthday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBirthday.setColumns(10);
		txtBirthday.setBounds(180, 171, 410, 27);
		panelPersonal.add(txtBirthday);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(0, 51, 102));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhoneNumber.setBounds(30, 230, 123, 19);
		panelPersonal.add(lblPhoneNumber);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setEditable(false);
		txtPhoneNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhoneNum.setColumns(10);
		txtPhoneNum.setBounds(180, 226, 410, 27);
		panelPersonal.add(txtPhoneNum);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(0, 51, 102));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(30, 289, 123, 19);
		panelPersonal.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBounds(180, 285, 410, 27);
		panelPersonal.add(txtAddress);
		
		JButton btnEmpSave = new JButton("Save");
		btnEmpSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveEmployeeDetails();
				btnEmpSave.setVisible(false);
			}
		});
		
		btnEmpSave.setBounds(193, 363, 89, 23);
		panelPersonal.add(btnEmpSave);
		
		JButton btnEmpUpdate = new JButton("Update");
		btnEmpUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
     			txtLastName.setEditable(true);
     			txtFirstName.setEditable(true);
     			txtBirthday.setEditable(true);
     			txtAddress.setEditable(true);
     			txtPhoneNum.setEditable(true);
     			btnEmpSave.setVisible(true);
			}
		});
		btnEmpUpdate.setBounds(349, 363, 89, 23);
		panelPersonal.add(btnEmpUpdate);
		
		
		
		panelWork = new JPanel();
		panelWork.setBackground(new Color(255, 204, 204));
		layeredPane.add(panelWork, "name_176407203283100");
		panelWork.setLayout(null);
		
		JLabel lblWork = new JLabel("Work Information");
		lblWork.setForeground(new Color(0, 51, 102));
		lblWork.setBackground(new Color(255, 204, 204));
		lblWork.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblWork.setBounds(31, 3, 265, 46);
		panelWork.add(lblWork);
		
		JLabel lblEmpId = new JLabel("Employee ID");
		lblEmpId.setForeground(new Color(0, 51, 102));
		lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmpId.setBounds(31, 60, 131, 19);
		panelWork.add(lblEmpId);
		
		txtEmpId = new JTextField();
		txtEmpId.setEditable(false);
		txtEmpId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpId.setColumns(10);
		txtEmpId.setBounds(197, 56, 340, 27);
		panelWork.add(txtEmpId);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(0, 51, 102));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatus.setBounds(31, 103, 131, 19);
		panelWork.add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setEditable(false);
		txtStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtStatus.setColumns(10);
		txtStatus.setBounds(197, 99, 340, 27);
		panelWork.add(txtStatus);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setForeground(new Color(0, 51, 102));
		lblPosition.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPosition.setBounds(31, 150, 131, 19);
		panelWork.add(lblPosition);
		
		txtPosition = new JTextField();
		txtPosition.setEditable(false);
		txtPosition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPosition.setColumns(10);
		txtPosition.setBounds(197, 146, 340, 27);
		panelWork.add(txtPosition);
		
		JLabel lblNewLabel_3 = new JLabel("Supervisor");
		lblNewLabel_3.setForeground(new Color(0, 51, 102));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(31, 198, 101, 19);
		panelWork.add(lblNewLabel_3);
		
		txtSupervisor = new JTextField();
		txtSupervisor.setEditable(false);
		txtSupervisor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSupervisor.setColumns(10);
		txtSupervisor.setBounds(197, 194, 340, 27);
		panelWork.add(txtSupervisor);
		
		JLabel lblGovId = new JLabel("Submitted Government ID Numbers");
		lblGovId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblGovId.setForeground(new Color(0, 51, 102));
		lblGovId.setBounds(31, 260, 275, 27);
		panelWork.add(lblGovId);
		
		JLabel lblSss = new JLabel("SSS");
		lblSss.setForeground(new Color(0, 51, 102));
		lblSss.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSss.setBounds(31, 302, 131, 19);
		panelWork.add(lblSss);
		
		txtSss = new JTextField();
		txtSss.setEditable(false);
		txtSss.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSss.setColumns(10);
		txtSss.setBounds(197, 298, 159, 27);
		panelWork.add(txtSss);
		
		JLabel lblPagibig = new JLabel("PAG-IBIG");
		lblPagibig.setForeground(new Color(0, 51, 102));
		lblPagibig.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPagibig.setBounds(31, 345, 131, 19);
		panelWork.add(lblPagibig);
		
		txtPagibig = new JTextField();
		txtPagibig.setEditable(false);
		txtPagibig.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPagibig.setColumns(10);
		txtPagibig.setBounds(197, 341, 159, 27);
		panelWork.add(txtPagibig);
		
		JLabel lblTin = new JLabel("TIN");
		lblTin.setForeground(new Color(0, 51, 102));
		lblTin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTin.setBounds(31, 392, 131, 19);
		panelWork.add(lblTin);
		
		txtTin = new JTextField();
		txtTin.setEditable(false);
		txtTin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTin.setColumns(10);
		txtTin.setBounds(197, 388, 159, 27);
		panelWork.add(txtTin);
		
		JLabel lblPhilhealth = new JLabel("PhilHealth");
		lblPhilhealth.setForeground(new Color(0, 51, 102));
		lblPhilhealth.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhilhealth.setBounds(31, 440, 101, 19);
		panelWork.add(lblPhilhealth);
		
		txtPhilhealth = new JTextField();
		txtPhilhealth.setEditable(false);
		txtPhilhealth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhilhealth.setColumns(10);
		txtPhilhealth.setBounds(197, 436, 159, 27);
		panelWork.add(txtPhilhealth);
		
		panelSalary = new JPanel();
		panelSalary.setBackground(new Color(255, 204, 204));
		panelSalary.setForeground(new Color(0, 0, 0));
		layeredPane.add(panelSalary, "name_176367800508200");
		panelSalary.setLayout(null);
		
		JLabel lblSalaryDetails = new JLabel("Salary Details");
		lblSalaryDetails.setForeground(new Color(0, 51, 102));
		lblSalaryDetails.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSalaryDetails.setBounds(37, 11, 282, 40);
		panelSalary.add(lblSalaryDetails);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setForeground(new Color(0, 51, 102));
		lblBasicSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBasicSalary.setBounds(37, 83, 131, 19);
		panelSalary.add(lblBasicSalary);
		
		txtBasicSalary = new JTextField();
		txtBasicSalary.setEditable(false);
		txtBasicSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBasicSalary.setColumns(10);
		txtBasicSalary.setBounds(203, 79, 159, 27);
		panelSalary.add(txtBasicSalary);
		
		JLabel lblHourlyRate = new JLabel("Hourly Rate");
		lblHourlyRate.setForeground(new Color(0, 51, 102));
		lblHourlyRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHourlyRate.setBounds(37, 126, 131, 19);
		panelSalary.add(lblHourlyRate);
		
		txtHourlyRate = new JTextField();
		txtHourlyRate.setEditable(false);
		txtHourlyRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHourlyRate.setColumns(10);
		txtHourlyRate.setBounds(203, 122, 159, 27);
		panelSalary.add(txtHourlyRate);
		
		JLabel lblRiceSubsidy = new JLabel("Rice Subsidy");
		lblRiceSubsidy.setForeground(new Color(0, 51, 102));
		lblRiceSubsidy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRiceSubsidy.setBounds(37, 173, 131, 19);
		panelSalary.add(lblRiceSubsidy);
		
		txtRiceSubsidy = new JTextField();
		txtRiceSubsidy.setEditable(false);
		txtRiceSubsidy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRiceSubsidy.setColumns(10);
		txtRiceSubsidy.setBounds(203, 169, 159, 27);
		panelSalary.add(txtRiceSubsidy);
		
		JLabel lblPhoneAllowance = new JLabel("Phone Allowance");
		lblPhoneAllowance.setForeground(new Color(0, 51, 102));
		lblPhoneAllowance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhoneAllowance.setBounds(37, 221, 156, 19);
		panelSalary.add(lblPhoneAllowance);
		
		txtPhoneAllowance = new JTextField();
		txtPhoneAllowance.setEditable(false);
		txtPhoneAllowance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhoneAllowance.setColumns(10);
		txtPhoneAllowance.setBounds(203, 217, 159, 27);
		panelSalary.add(txtPhoneAllowance);
		
		JLabel lblClothingAllowance = new JLabel("Clothing Allowance");
		lblClothingAllowance.setForeground(new Color(0, 51, 102));
		lblClothingAllowance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClothingAllowance.setBounds(37, 269, 156, 19);
		panelSalary.add(lblClothingAllowance);
		
		txtClothingAllow = new JTextField();
		txtClothingAllow.setEditable(false);
		txtClothingAllow.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtClothingAllow.setColumns(10);
		txtClothingAllow.setBounds(203, 265, 159, 27);
		panelSalary.add(txtClothingAllow);
		
		JLabel lblSemi = new JLabel("Semi-monthly Rate");
		lblSemi.setForeground(new Color(0, 51, 102));
		lblSemi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSemi.setBounds(37, 312, 156, 19);
		panelSalary.add(lblSemi);
		
		txtSemiRate = new JTextField();
		txtSemiRate.setEditable(false);
		txtSemiRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSemiRate.setColumns(10);
		txtSemiRate.setBounds(203, 308, 159, 27);
		panelSalary.add(txtSemiRate);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jimca\\Pictures\\resized.png"));
		lblNewLabel.setBounds(0, 0, 919, 415);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotorPh = new JLabel("MotorPh");
		lblMotorPh.setBounds(436, 278, 258, 68);
		contentPane.add(lblMotorPh);
		lblMotorPh.setForeground(new Color(0, 51, 102));
		lblMotorPh.setFont(new Font("Tahoma", Font.BOLD, 50));
	
    
	}
	
public void switchPanels(JPanel panel) {   
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
}
public void setEmployeeDetails(String username) throws FileNotFoundException, IOException {
    details = EmployeeApp.employeeMap.get(username);
	String line = "";
	
	
	try (BufferedReader reader = new BufferedReader (new FileReader("src\\EmployeeDetails.csv"))) {
		reader.readLine();
		
		while ((line = reader.readLine()) != null) {
			details = parseCSVLine(line);
   
			if (details != null && details.length >= 19 && details[0].equals(username)) {
				//System.out.println("Found details: " + java.util.Arrays.toString(details));
				
			        txtEmpId.setText(details[0]);
				    txtLastName.setText(details[1]);
				    txtFirstName.setText(details[2]);
				    txtBirthday.setText(details[3]);
				    txtAddress.setText(details[4]);
				    txtPhoneNum.setText(details[5]);
				    txtSss.setText(details[6]);
				    txtPhilhealth.setText(details[7]);
				    txtTin.setText(details[8]);
				    txtPagibig.setText(details[9]);
				    txtStatus.setText(details[10]);
				    txtPosition.setText(details[11]);
				    txtSupervisor.setText(details[12]);
				    txtBasicSalary.setText(details[13]);
				    txtRiceSubsidy.setText(details[14]);
				    txtPhoneAllowance.setText(details[15]);
				    txtClothingAllow.setText(details[16]);
				    txtSemiRate.setText(details[17]);
				    txtHourlyRate.setText(details[18]);

    	

	                return; // Exit method after setting details
	            }
	          }
 
	       // Handle case where details  are not found
	        System.out.println("Employee details not found for username: " + username);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

private void saveEmployeeDetails() {
	 if (details == null || details.length < 19) {
	        JOptionPane.showMessageDialog(null, "Invalid employee details provided.");
	        return;
	    }
	 
	// Validate birthday format
	 String birthday = txtBirthday.getText().trim();
	    if (!birthday.matches("^(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])/\\d{4}$")) {
	        JOptionPane.showMessageDialog(null, "Please enter birthday in MM/DD/YYYY format.", "Error", JOptionPane.ERROR_MESSAGE);
	           txtLastName.setEditable(false);
	           txtFirstName.setEditable(false);
	           txtBirthday.setEditable(false);
	           txtAddress.setEditable(false);
	           txtPhoneNum.setEditable(false);
	        return;
	        
	           
	        
	    }
	    
	 // Validate phone number
	 String phoneNumber = txtPhoneNum.getText().trim();
	    if (!phoneNumber.matches("\\d+")) {
	        JOptionPane.showMessageDialog(null, "Please enter a valid phone number.", "Error", JOptionPane.ERROR_MESSAGE);
	        txtLastName.setEditable(false);
	           txtFirstName.setEditable(false);
	           txtBirthday.setEditable(false);
	           txtAddress.setEditable(false);
	           txtPhoneNum.setEditable(false);
	        return;
	    }
	    
	    
	                          
	 try {
	        ArrayList<String[]> lines = new ArrayList<>();
	        File file = new File("src\\EmployeeDetails.csv");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] empdetails = line.split(",");
	            lines.add(empdetails); // Add each line to the list
	        }
	        br.close();

	        // Ensure employeeDetails is not null and has at least 18 elements
	        if (details != null && details.length >= 18) {
	            boolean isModified = false;
	            for (String[] empdetails : lines) {
	                if (empdetails[0].trim().equals(details[0])) {
	                    // Update the line with new details if modified
	                    if (!empdetails[1].trim().equals(txtLastName.getText().trim())) {
	                    	empdetails[1] = txtLastName.getText().trim();
	                        isModified = true;
	                    }
	                    if (!empdetails[2].trim().equals(txtFirstName.getText().trim())) {
	                    	empdetails[2] = txtFirstName.getText().trim();
	                        isModified = true;
	                    }
	                    if (!empdetails[3].trim().equals(txtBirthday.getText().trim())) {
	                    	empdetails[3] = txtBirthday.getText().trim();
	                        isModified = true;
	                    }
	                    if (!empdetails[4].trim().equals(txtAddress.getText().trim())) {
	                    	empdetails[4] = txtAddress.getText().trim();
	                        isModified = true;
	                    }
	                    if (!empdetails[5].trim().equals(txtPhoneNum.getText().trim())) {
	                    	empdetails[5] = txtPhoneNum.getText().trim();
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
	                details[1] = txtLastName.getText().trim();
	                details[2] = txtFirstName.getText().trim();
	                details[3] = txtBirthday.getText().trim();
	                details[4] = txtAddress.getText().trim();
	                details[5] = txtPhoneNum.getText().trim();
          

           // After saving, reset to non-editable mode and hide Save button
           
           txtLastName.setEditable(false);
           txtFirstName.setEditable(false);
           txtBirthday.setEditable(false);
           txtAddress.setEditable(false);
           txtPhoneNum.setEditable(false);
          
			
           
           
	            } else {
	                JOptionPane.showMessageDialog(null, "No changes detected.");
	                
		            txtLastName.setEditable(false);
		            txtFirstName.setEditable(false);
		            txtBirthday.setEditable(false);
		            txtAddress.setEditable(false);
		            txtPhoneNum.setEditable(false);
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Invalid employee details provided.");
	        }

       } catch (IOException e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Error saving employee details.");
       }
	
   } 



private static String[] parseCSVLine(String line) {
    List<String> values = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean inQuotes = false;

    for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        if (c == '"') {
            inQuotes = !inQuotes;
        } else if (c == ',' && !inQuotes) {
            values.add(sb.toString().trim());
            sb.setLength(0); // Clear the StringBuilder for the next value
        } else {
            sb.append(c);
        }
    }

    // Add the last value
    values.add(sb.toString().trim());

    // Print debug information
   // System.out.println("Parsed values: " + values);

    return values.toArray(new String[0]);
}
public static String sanitize_data(String info) {
	return info.replace(";x;",",").replace("\"", "");
}
}


