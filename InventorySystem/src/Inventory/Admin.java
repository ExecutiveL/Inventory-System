package Inventory;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin {

	private JFrame frame;
    private static Connection con;
    private DefaultTableModel model;
    private JTable table;
    private JLabel earn;
    private JLabel transact;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		
		initialize();
		connectToDatabase();
		UpdateTable();
		total();
		transact();
		connectToDatabase();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 808, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 100, 410);
		panel.setBackground(new Color(248,218,123));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\document-removebg-preview.png"));
		lblNewLabel.setBounds(10, 11, 80, 77);
		panel.add(lblNewLabel);
		
		JPanel Dashboardpnl = new JPanel();
		Dashboardpnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		Dashboardpnl.setBounds(110, 11, 672, 388);
		frame.getContentPane().add(Dashboardpnl);
		Dashboardpnl.setBackground(new Color(230,190,98));
		Dashboardpnl.setLayout(null);
		
		
		JPanel prd = new JPanel();
		prd.setBounds(10, 11, 632, 95);
		prd.setBorder(new LineBorder(new Color(0, 0, 0)));
		prd.setBackground(new Color(232,215,156));
		Dashboardpnl.add(prd);
		prd.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("No. Products");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 36, 103, 14);
		prd.add(lblNewLabel_2);
		
		JLabel nopr = new JLabel("13");
		nopr.setHorizontalAlignment(SwingConstants.CENTER);
		nopr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nopr.setBounds(123, 36, 77, 14);
		prd.add(nopr);
		
		JPanel earnings = new JPanel();
		earnings.setBounds(10, 117, 632, 95);
		earnings.setBorder(new LineBorder(new Color(0, 0, 0)));
		earnings.setBackground(new Color(232,215,156));
		Dashboardpnl.add(earnings);
		earnings.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Total Earnings:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 36, 114, 25);
		earnings.add(lblNewLabel_2_1);
		
		earn = new JLabel("0");
		earn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		earn.setBounds(134, 41, 77, 14);
		earnings.add(earn);
		
		JPanel transaction = new JPanel();
		transaction.setBounds(10, 223, 632, 95);
		transaction.setBorder(new LineBorder(new Color(0, 0, 0)));
		transaction.setBackground(new Color(232,215,156));
		Dashboardpnl.add(transaction);
		transaction.setLayout(null);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Total Transactions:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 31, 141, 33);
		transaction.add(lblNewLabel_2_1_1);
		
		transact = new JLabel("0");
		transact.setHorizontalAlignment(SwingConstants.CENTER);
		transact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		transact.setBounds(161, 40, 77, 14);
		transaction.add(transact);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(168,152,100));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 329, 672, 59);
		Dashboardpnl.add(panel_1);
		
		
		
		JPanel Historypnl = new JPanel();
		Historypnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		Historypnl.setBounds(110, 11, 672, 388);
		frame.getContentPane().add(Historypnl);
		Historypnl.setBackground(new Color(230,190,98));
		Historypnl.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DashBoard");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Historypnl.setVisible(false);
				Dashboardpnl.setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 99, 80, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("History");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Historypnl.setVisible(true);
				Dashboardpnl.setVisible(false);
			}
		});
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 146, 80, 25);
		panel.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 652, 366);
        Historypnl.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID", "Pastries", "Sandwich", "Dessert", "Drink", "Total"
        	}
        ));
        table.getTableHeader().setReorderingAllowed(false);
        table.setFocusable(false);
        table.setRowSelectionAllowed(true);

        scrollPane.setViewportView(table);
	}
	 private void connectToDatabase() {
	        try {
	            Class.forName("org.sqlite.JDBC");
	            con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ralp\\Documents\\database.db");
	            con.setAutoCommit(false);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to connect to the database", e);
	        }
	    }
	 
	 private void UpdateTable() {
	        try (Statement statement = con.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT * FROM Admin")) {

	            model = new DefaultTableModel();
	            table.setModel(model);

	            ResultSetMetaData metaData = resultSet.getMetaData();
	            int columnCount = metaData.getColumnCount();

	            for (int column = 1; column <= columnCount; column++) {
	                model.addColumn(metaData.getColumnName(column));
	            }

	            while (resultSet.next()) {
	                Object[] rowData = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                    rowData[i - 1] = resultSet.getObject(i);
	                }
	                model.addRow(rowData);
	            }

	        } catch (SQLException e) {
	            throw new RuntimeException("Failed to update table", e);
	        }
	    }
		
			
	 private void total() {
	        try (Statement st = con.createStatement();
	             ResultSet rs = st.executeQuery("SELECT SUM (CAST(SUBSTR(Total, 2) AS REAL)) FROM Admin")) {

	            if (rs.next()) {
	                double sum = rs.getDouble(1);
	                earn.setText(String.valueOf(sum));
	            }

	        } catch (SQLException e) {
	            throw new RuntimeException("Failed to calculate total earnings", e);
	        }
	    }

 
	 private void transact() {
	        try (Statement st = con.createStatement();
	             ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Admin")) {

	            if (rs.next()) {
	                int row = rs.getInt(1);
	                transact.setText(String.valueOf(row));
	            }

	        } catch (SQLException e) {
	            throw new RuntimeException("Failed to calculate total transactions", e);
	        }
	    }

	    public void setVisible(boolean b) {
	        frame.setVisible(b);
	    }
	}