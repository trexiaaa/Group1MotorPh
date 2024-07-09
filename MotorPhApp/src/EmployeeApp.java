import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JTextField;

import CreateAccount.CreateAccount;
import adminDashboard.AdminDashboard;
import employeeDashboard.EmployeeDashboard;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class EmployeeApp {

    private JFrame frmMotorph;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    static Map<String, String[]> employeeMap = new HashMap<>();
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmployeeApp window = new EmployeeApp();
                    window.frmMotorph.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    //Create the application.
    public EmployeeApp() {
        initialize();
        try {
            EmployeeDetails();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading employee details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Initialize the contents of the frame.
    private void initialize() {
        frmMotorph = new JFrame();
        frmMotorph.getContentPane().setBackground(new Color(255, 204, 204));
        frmMotorph.setTitle("MotorPh");
        frmMotorph.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
        frmMotorph.setBounds(600, 200, 712, 644);
        frmMotorph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmMotorph.getContentPane().setLayout(null);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(390, 431, 190, 32);
        frmMotorph.getContentPane().add(txtUsername);
        txtUsername.setColumns(10);
        
        JLabel lblUsername = new JLabel("EID");
        lblUsername.setForeground(new Color(0, 51, 102));
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblUsername.setBounds(182, 429, 123, 30);
        frmMotorph.getContentPane().add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(0, 51, 102));
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblPassword.setBounds(182, 470, 116, 41);
        frmMotorph.getContentPane().add(lblPassword);
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds(390, 473, 190, 30);
        frmMotorph.getContentPane().add(txtPassword);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = new String(txtPassword.getPassword()).trim();
                String username = txtUsername.getText().trim();

                if (employeeMap != null && employeeMap.containsKey(username)) {
                    String storedPassword = employeeMap.get(username)[0]; // Birthday
                    System.out.println("Stored password: " + storedPassword);
                    String storedPosition = getEmployeePosition(username); // Position
                    System.out.println("Stored position: " + storedPosition);

                    if (storedPassword.equals(password)) {
                        // Password matches, now check position
                        if (isHRPosition(storedPosition)) {
                            // Open Admin Dashboard for HR positions
                            JOptionPane.showMessageDialog(null, "Login Successful");

                            AdminDashboard info = new AdminDashboard();
                            AdminDashboard.main(null);

                            frmMotorph.dispose();
                        } else {
                            // Open Employee Dashboard for other positions
                        	
                            JOptionPane.showMessageDialog(null, "Login Successful");

                            frmEmployeeDashboard frmEmployeeDashboard = new frmEmployeeDashboard();
                            try {
								frmEmployeeDashboard.setEmployeeDetails(username);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							//EmployeeDashboard info = new EmployeeDashboard();
                            //EmployeeDashboard.main(null);
                            frmEmployeeDashboard.setVisible(true);

                            frmMotorph.dispose();
                            
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Password", "Login Error", JOptionPane.ERROR_MESSAGE);
                        txtPassword.setText("");
                        txtUsername.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username", "Login Error", JOptionPane.ERROR_MESSAGE);
                    txtPassword.setText("");
                    txtUsername.setText("");
                }
            }
        });
        btnLogin.setBounds(281, 538, 116, 32);
        frmMotorph.getContentPane().add(btnLogin);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jimca\\git\\Group1Homework4\\MotorPhApp\\asfasfsaf-removebg-preview.png"));
        lblNewLabel.setBounds(0, -11, 696, 355);
        frmMotorph.getContentPane().add(lblNewLabel);
        
        JLabel lblMotorPh = new JLabel("MotorPh");
        lblMotorPh.setForeground(new Color(0, 51, 102));
        lblMotorPh.setBackground(new Color(255, 255, 255));
        lblMotorPh.setFont(new Font("Tahoma", Font.BOLD, 50));
        lblMotorPh.setBounds(256, 334, 225, 81);
        frmMotorph.getContentPane().add(lblMotorPh);
    }
    
    public static void EmployeeDetails() throws IOException {
        String file = "src\\EmployeeDetails.csv";
        BufferedReader reader = null;
        String line = "";
        employeeMap = new HashMap<>();
        
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = parseCSVLine(line);
                if (row.length >= 18) {
                	String empID = row [0].trim();
                    String lastName = row[1].trim();
                    String firstName= row[2].trim();
                    String birthday = row[3].trim();
                    String position = row[11].trim();                 
                    
                    System.out.println("Reading Employee: Last Name:" + lastName + ", Birthday:" + birthday + ", Position:" + position);

                    // used more specific key to avoid conflicts on employee with same last name
                    String key = empID; 
                    employeeMap.put(key, new String[]{birthday, position});
                    System.out.println(key);
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
    // Method to retrieve position based on username
    private String getEmployeePosition(String username) {
        if (employeeMap != null && employeeMap.containsKey(username)) {
            return employeeMap.get(username)[1]; // Position is stored at index 1
        }
        return null; // Handle case where username is not found
    }

    // Method to check if position is HR-related
    private boolean isHRPosition(String position) {
        if (position != null) {
            position = position.toLowerCase(); // Convert to lowercase for case-insensitive comparison
            return position.equals("hr manager") || position.equals("hr team leader") || position.equals("hr rank and file");
        }
        return false; // Handle case where position is null
    }
    private static String[] parseCSVLine(String line) {
        // Split by comma, handling quoted values
        // Assumes CSV values are quoted with ""
        return line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    }
}



