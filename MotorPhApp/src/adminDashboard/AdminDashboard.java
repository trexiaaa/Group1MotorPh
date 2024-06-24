package adminDashboard;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.List;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CreateAccount.CreateAccount;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
import java.awt.Scrollbar;
import javax.swing.ListSelectionModel;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class AdminDashboard {

	private JFrame frmAdminDashboard;
	private JTable table;
	private JTextField txtSearch;
	private ArrayList<String[]> employeeData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
					window.frmAdminDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminDashboard() {
		initialize();
		loadCSVData("src\\EmployeeDetails.csv");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminDashboard = new JFrame();
		frmAdminDashboard.getContentPane().setBackground(new Color(255, 204, 204));
		frmAdminDashboard.setTitle("Admin Dashboard");
		frmAdminDashboard.setBounds(200, 200, 674, 848);
		frmAdminDashboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdminDashboard.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.PINK));
		panel.setBounds(10, 97, 637, 590);
		frmAdminDashboard.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 614, 566);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number", "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position", "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setMinWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setMinWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(132);
		table.getColumnModel().getColumn(4).setMinWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(92);
		table.getColumnModel().getColumn(5).setMinWidth(92);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setMinWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(89);
		table.getColumnModel().getColumn(7).setMinWidth(89);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setMinWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(90);
		table.getColumnModel().getColumn(9).setMinWidth(90);
		table.getColumnModel().getColumn(10).setPreferredWidth(80);
		table.getColumnModel().getColumn(10).setMinWidth(80);
		table.getColumnModel().getColumn(11).setPreferredWidth(90);
		table.getColumnModel().getColumn(11).setMinWidth(90);
		table.getColumnModel().getColumn(12).setPreferredWidth(140);
		table.getColumnModel().getColumn(12).setMinWidth(120);
		table.getColumnModel().getColumn(13).setPreferredWidth(86);
		table.getColumnModel().getColumn(14).setPreferredWidth(87);
		table.getColumnModel().getColumn(15).setPreferredWidth(97);
		table.getColumnModel().getColumn(16).setPreferredWidth(105);
		table.getColumnModel().getColumn(17).setPreferredWidth(150);
		table.getColumnModel().getColumn(17).setMinWidth(150);
		table.getColumnModel().getColumn(18).setPreferredWidth(67);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.PINK));
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBounds(10, 698, 637, 106);
		frmAdminDashboard.getContentPane().add(panel_1);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount info = new CreateAccount();
            	CreateAccount.main(null);
			}
		});
		btnCreate.setBounds(10, 26, 130, 38);
		panel_1.add(btnCreate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Select a row to delete", "Error", JOptionPane.OK_CANCEL_OPTION);
					return;
				} 
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete selected employee details?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					model.removeRow(selectedRow);
					try {
						deleteDataCsv();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Employee Details Deleted");
				}
				
				
			}
		});
		btnDelete.setBounds(170, 26, 123, 38);
		panel_1.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnUpdate.setBounds(323, 26, 130, 38);
		panel_1.add(btnUpdate);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadCSVData("src\\EmployeeDetails");
			}
		});
		btnRefresh.setBounds(497, 26, 130, 38);
		panel_1.add(btnRefresh);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard window = new AdminDashboard ();
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?", "Sign Out", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
					
					
				}
			}
		});
		btnSignOut.setBounds(550, 11, 89, 23);
		frmAdminDashboard.getContentPane().add(btnSignOut);
		
		JLabel lblNewLabel = new JLabel("MotorPh");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(10, 25, 216, 49);
		frmAdminDashboard.getContentPane().add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(520, 66, 127, 20);
		frmAdminDashboard.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		 JButton btnSearch = new JButton("Search");
	        btnSearch.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String empID = txtSearch.getText().trim();

	                String[] employeeDetails = searchEmployeeID(empID);

	                if (employeeDetails != null) {
	                    searchResultsFrame resultsFrame = new searchResultsFrame(employeeDetails);
	                    resultsFrame.setVisible(true);
	                } else {
	                    JOptionPane.showMessageDialog(null, "No employee found with Employee ID: " + empID);
	                }
	            }
	        });
	        btnSearch.setBounds(421, 65, 89, 23);
	        frmAdminDashboard.getContentPane().add(btnSearch);
	    }

	     //Method to search for an employee by Employee ID.
	     
	    private String[] searchEmployeeID(String empID) {
	        String[] employeeDetails = null;
	        try (BufferedReader br = new BufferedReader(new FileReader("src\\EmployeeDetails.csv"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] details = parseCSVLine(line);
	                if (details[0].trim().equals(empID)) {
	                    employeeDetails = details;
	                    break;
	                }
	              
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return employeeDetails;
	    
	    }
	
	private void loadCSVData(String filePath) {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);
	    try (BufferedReader br = new BufferedReader(new FileReader("src\\EmployeeDetails.csv"))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	        	
	            String[] data = line.split(",");
	        	String repl = line.replaceAll(",(?!(([^\"]*\"){2})*[^\"]*$)", ";x;");
                String[] row = repl.split(",");
                for (int i = 0; i < row.length; i++) {
                    row[i] = sanitize_data(row[i]);
                }
	            model.addRow(row);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(frmAdminDashboard, "Error loading data from CSV file", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void deleteDataCsv() throws IOException {
		try (BufferedWriter writer = new BufferedWriter (new FileWriter("src\\EmployeeDetails.csv"))) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			int rowCount = model.getRowCount();
	        int columnCount = model.getColumnCount();

	        for (int i = 0; i < rowCount; i++) {
	            for (int j = 0; j < columnCount; j++) {
	            	String value = model.getValueAt(i, j).toString();
	                // Check if the value contains commas
	                if (value.contains(",")) {
	                    // Encapsulate the value in double quotes
	                    writer.write("\"" + value + "\"");
	                } else {
	                    writer.write(value);
	                }

	                if (j < columnCount - 1) {
	                    writer.write(",");
	                }
	            }
	            writer.newLine(); 
	        }
		}catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error deleting data", "Error",JOptionPane.ERROR_MESSAGE); 
				
				} 
				
			}
	

	public static String sanitize_data(String info) {
		return info.replace(";x;",",").replace("\"", "");
	}
	
	 private static String[] parseCSVLine(String line) {
	        // Split line by comma but ignore commas inside double quotes
	        // Assumes the CSV format is consistent and properly quoted
	        String[] parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
	        // Remove surrounding quotes if present
	        for (int i = 0; i < parts.length; i++) {
	            parts[i] = parts[i].replaceAll("^\"|\"$", "");
	        }
	        return parts;
	    }

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
