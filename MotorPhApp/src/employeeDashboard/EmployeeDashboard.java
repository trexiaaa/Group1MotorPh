package employeeDashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmployeeDashboard {

	private JFrame frmEmployeeDashboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDashboard window = new EmployeeDashboard();
					window.frmEmployeeDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeDashboard = new JFrame();
		frmEmployeeDashboard.setTitle("Employee Dashboard");
		frmEmployeeDashboard.setBounds(100, 100, 991, 701);
		frmEmployeeDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeDashboard.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee");
		lblNewLabel.setBounds(70, 74, 46, 14);
		frmEmployeeDashboard.getContentPane().add(lblNewLabel);
	}
}
