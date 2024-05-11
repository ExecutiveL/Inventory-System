package Inventory;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblPassword;
	private static Connection con;
	private JPasswordField passwordField;

	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(244,234,183));
		frame.setBounds(100, 100, 301, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 107, 77, 34);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 118, 162, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(10, 149, 105, 34);
		frame.getContentPane().add(lblPassword);
		passwordField = new JPasswordField();
		passwordField.setBounds(113, 160, 162, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ralp\\Documents\\database.db");
				 
					String query = "SELECT * FROM ID Where User = ? and Pass= ?";
					 try (PreparedStatement preparedstatement = con.prepareStatement(query)) {
	                      preparedstatement.setString(1, textField.getText());
	                      preparedstatement.setString(2, new String (passwordField.getPassword()));
	                      ResultSet resultSet = preparedstatement.executeQuery();
	                      
	                if (resultSet.next()) {
	              	 
	                       new Admin().setVisible(true);
	                
	                      JOptionPane.showMessageDialog(null, "Login Succesfully");
	                      
	                      frame.dispose();
	                } else {
	                	JOptionPane.showMessageDialog(null, "Incorrect Credentials","ERROR",JOptionPane.ERROR_MESSAGE);
	                }     
	                }
	               } catch (Exception r) {
	           		r.printStackTrace(); 
	                      
				}
			}
		});
		btnNewButton.setBounds(85, 250, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\document-removebg-preview.png"));
		lblNewLabel_1.setBounds(97, 0, 105, 113);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
	}
  public void SetVisible(boolean visible) {
	  frame.setVisible(visible);
  }
}
