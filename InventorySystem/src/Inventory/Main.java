package Inventory;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Main {

	private JFrame frame;
	  private JLabel totallbl;
	  private JComboBox comboBox;
	  private JComboBox sndcmb;
	  private JComboBox dcmb;
	  private JComboBox Dr;
	  private JSpinner pqnt;
	  private JSpinner sqnt;
	  private JSpinner dqnt;
	  private JSpinner drqnt;
	  private JLabel mdprice;
	  private JLabel sdprice;
	  private JLabel dprice;
	  private JLabel drprice;
	  
	  private static Connection con;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("org.sqlite.JDBC");
					con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ralp\\Documents\\database.db");
					con.setAutoCommit(false);
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 789, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel menupnl = new JPanel();
		menupnl.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		menupnl.setBackground(new Color(255, 255, 255));
		menupnl.setBounds(0, 0, 99, 391);
		frame.getContentPane().add(menupnl);
		menupnl.setLayout(null);
		
		JLabel productspnl = new JLabel("PRODUCTS");
		productspnl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		productspnl.setBounds(10, 92, 79, 14);
		menupnl.add(productspnl);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\document-removebg-preview.png"));
		lblNewLabel_1.setBounds(10, 11, 70, 58);
		menupnl.add(lblNewLabel_1);
		
		JLabel adminlbl = new JLabel("ADMIN");
		adminlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().SetVisible(true);
				frame.dispose();
			}
		});
		adminlbl.setHorizontalAlignment(SwingConstants.CENTER);
		adminlbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adminlbl.setBounds(10, 351, 79, 14);
		menupnl.add(adminlbl);
		
		JPanel productpnl = new JPanel();
		productpnl.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		productpnl.setBackground(new Color(244,234,183));
		productpnl.setBounds(109, 11, 649, 380);
		frame.getContentPane().add(productpnl);
		productpnl.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 43, 150, 115);
		productpnl.add(panel);
		panel.setLayout(null);
		
		JLabel mdname = new JLabel("");
		mdname.setHorizontalAlignment(SwingConstants.CENTER);
		mdname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mdname.setBounds(10, 79, 130, 14);
		panel.add(mdname);
		
		mdprice = new JLabel("");
		mdprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mdprice.setHorizontalAlignment(SwingConstants.CENTER);
		mdprice.setBounds(55, 95, 46, 14);
		panel.add(mdprice);
		
		JLabel mdicon = new JLabel("");
		mdicon.setBounds(35, 0, 80, 85);
		panel.add(mdicon);
		mdicon.setIcon(new ImageIcon(""));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(170, 43, 150, 115);
		productpnl.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Sdicon = new JLabel("");
		Sdicon.setBounds(40, 0, 80, 85);
		panel_1.add(Sdicon);
		
		JLabel sdname = new JLabel("");
		sdname.setHorizontalAlignment(SwingConstants.CENTER);
		sdname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sdname.setBounds(10, 78, 130, 14);
		panel_1.add(sdname);
		
		sdprice = new JLabel("");
		sdprice.setHorizontalAlignment(SwingConstants.CENTER);
		sdprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sdprice.setBounds(50, 96, 46, 14);
		panel_1.add(sdprice);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(330, 43, 150, 115);
		productpnl.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel dicon = new JLabel("");
		dicon.setBounds(36, 0, 80, 85);
		panel_2.add(dicon);
		
		JLabel dname = new JLabel("");
		dname.setHorizontalAlignment(SwingConstants.CENTER);
		dname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dname.setBounds(10, 78, 130, 14);
		panel_2.add(dname);
		
		dprice = new JLabel("");
		dprice.setHorizontalAlignment(SwingConstants.CENTER);
		dprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dprice.setBounds(46, 96, 46, 14);
		panel_2.add(dprice);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(490, 43, 150, 115);
		productpnl.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel dricon = new JLabel("");
		dricon.setBounds(35, 0, 80, 85);
		panel_3.add(dricon);
		
		JLabel drname = new JLabel("");
		drname.setHorizontalAlignment(SwingConstants.CENTER);
		drname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		drname.setBounds(10, 76, 130, 14);
		panel_3.add(drname);
		
		drprice = new JLabel("");
		drprice.setHorizontalAlignment(SwingConstants.CENTER);
		drprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		drprice.setBounds(56, 96, 46, 14);
		panel_3.add(drprice);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(new Color(158,125,49));
		panel_4.setBounds(0, 348, 649, 31);
		productpnl.add(panel_4);
		panel_4.setLayout(null);
		
	    totallbl = new JLabel("");
		totallbl.setHorizontalAlignment(SwingConstants.CENTER);
		totallbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		totallbl.setBounds(490, 281, 74, 14);
		productpnl.add(totallbl);
		
		
		JLabel lblNewLabel = new JLabel("Pastries");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 18, 150, 21);
		productpnl.add(lblNewLabel);
		
		JLabel lblSandwich = new JLabel("Sandwich");
		lblSandwich.setHorizontalAlignment(SwingConstants.CENTER);
		lblSandwich.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSandwich.setBounds(170, 18, 150, 21);
		productpnl.add(lblSandwich);
		
		JLabel lblDessert = new JLabel("Dessert");
		lblDessert.setHorizontalAlignment(SwingConstants.CENTER);
		lblDessert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDessert.setBounds(330, 18, 150, 21);
		productpnl.add(lblDessert);
		
		JLabel lblDrink = new JLabel("Drink");
		lblDrink.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDrink.setBounds(490, 18, 150, 21);
		productpnl.add(lblDrink);
		
		 comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					String selected = comboBox.getSelectedItem().toString();
					switch(selected) {
					case "----":
						mdicon.setIcon(null);
						mdname.setText("");
						mdprice.setText("");
						break;
					case "Almond Croissant":
						mdicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\images-removebg-preview.png"));
						mdname.setText("Almond Croissant");	
						mdprice.setText("₱125");
						break;
					case "Chocolate Eclair":
						mdicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\How-to-Make-Eclairs-SQUARE-removebg-preview.png"));
						mdname.setText("Chocolate Eclair");
						mdprice.setText("₱280");
						break;
					case "Fruit Tart":
						mdicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\Fruit-tart-2019-Recipe-removebg-preview (1).png"));
						mdname.setText("Fruit Tart");
						mdprice.setText("₱125");
						break;
					case "Tiramisu":
						mdicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\homemade-tiramisu-2-removebg-preview.png"));
						mdname.setText("Tiramisu");
						mdprice.setText("₱350");
						break;
					case "Macaron":
						mdicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\Macaron-Recipe-1200-removebg-preview.png"));
						mdname.setText("Macaron");
						mdprice.setText("₱140");
						break;
					
					}
					updateTotalPrice();
	
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"----", "Almond Croissant", "Chocolate Eclair", "Fruit Tart", "Tiramisu", "Macaron"}));
		comboBox.setBounds(10, 165, 150, 22);
		productpnl.add(comboBox);
		
		
		
		 sndcmb = new JComboBox();
		sndcmb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED) {
					String selected = sndcmb.getSelectedItem().toString();
					switch (selected) {
					case "----":
						Sdicon.setIcon(null);
						sdname.setText("");
						sdprice.setText("");
						break;
					case "Grilled Cheese Sandwich":
						Sdicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\ep-air-fryer-grilled-cheese-vpmf-superJumbo-removebg-preview.png"));
						sdname.setText("Grilled Cheese Sandwich");	
						sdprice.setText("₱100");
						break;
					case "Classic Turkey Club":
						Sdicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\download-removebg-preview (1).png"));
						sdname.setText("Classic Turkey Club");
						sdprice.setText("₱150");
						break;
					case "Panini":
						Sdicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\images__1_-removebg-preview.png"));
						sdname.setText("Panini");
						sdprice.setText("₱125");
						break;
					
					}
					updateTotalPrice();
				}
			}
		});
		sndcmb.setModel(new DefaultComboBoxModel(new String[] {"----", "Grilled Cheese Sandwich", "Classic Turkey Club", "Panini"}));
		sndcmb.setBounds(170, 165, 150, 22);
		productpnl.add(sndcmb);
		
		dcmb = new JComboBox();
		dcmb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.SELECTED) {}
				String selected = dcmb.getSelectedItem().toString();
				switch (selected) {
				case "----":
					dicon.setIcon(null);
					dname.setText("");
					dprice.setText("");
					break;
				case "Chocolate Ice Cream":
					dicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\homemade-chocolate-ice-cream-recipe-7-removebg-preview.png"));
					dname.setText("Chocolate Ice Cream");	
					dprice.setText("₱130");
					break;
				case "Cookies":
					dicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\chocolate_chip_cookie-removebg-preview.png"));
					dname.setText("Cookies");
					dprice.setText("₱50");
					break;
				case "Cupcakes":
					dicon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\Single-Serve-Vanilla-Cupcake-1067x1600-removebg-preview.png"));
					dname.setText("Cupcake");
					dprice.setText("₱75");
					break;
				}
				updateTotalPrice();
			}
		});
		dcmb.setModel(new DefaultComboBoxModel(new String[] {"----", "Chocolate Ice Cream", "Cookies", "Cupcakes"}));
		dcmb.setBounds(330, 165, 150, 22);
		productpnl.add(dcmb);
		
		Dr = new JComboBox();
		Dr.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.SELECTED) {}
				String selected = Dr.getSelectedItem().toString();
				switch (selected) {
				case "----":
					dricon.setIcon(null);
					drname.setText("");
					drprice.setText("");
					break;
				case "Ice Tea":
					dricon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\109190-smooth-sweet-tea-DDMFS-4x3-9e849a386d414cb2b852099f02b6782d-removebg-preview.png"));
					drname.setText("Ice Tea");	
					drprice.setText("₱40");
					break;
				case "Iced Coffee":
					dricon.setIcon(new ImageIcon("C:\\Users\\Ralp\\Downloads\\21667-easy-iced-coffee-ddmfs-4x3-0093-7becf3932bd64ed7b594d46c02d0889f-removebg-preview.png"));
					drname.setText("Iced Coffee");
					drprice.setText("₱50");
					break;
			
				}
				updateTotalPrice();
			}
		});
		Dr.setModel(new DefaultComboBoxModel(new String[] {"----", "Ice Tea", "Iced Coffee"}));
		Dr.setBounds(490, 165, 150, 22);
		productpnl.add(Dr);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 198, 60, 14);
		productpnl.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Quantity:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(180, 198, 60, 14);
		productpnl.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Quantity:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(330, 198, 60, 14);
		productpnl.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Quantity:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(490, 198, 60, 14);
		productpnl.add(lblNewLabel_2_3);
		
		pqnt = new JSpinner();
		pqnt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			    updateTotalPrice();

			}
		});
		pqnt.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		pqnt.setBounds(80, 198, 80, 20);
		productpnl.add(pqnt);
		
		
		sqnt = new JSpinner();
		sqnt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				 updateTotalPrice();
			}
		});
		sqnt.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
		sqnt.setBounds(240, 198, 80, 20);
		productpnl.add(sqnt);
		
		
		dqnt = new JSpinner();
		dqnt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				 updateTotalPrice();
			}
		});
		dqnt.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		dqnt.setBounds(400, 198, 80, 20);
		productpnl.add(dqnt);
		
		drqnt = new JSpinner();
		drqnt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				 updateTotalPrice();
			}
		});
		drqnt.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		drqnt.setBounds(560, 197, 80, 20);
		productpnl.add(drqnt);
		
		JLabel lblNewLabel_3 = new JLabel("TOTAL:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(406, 281, 74, 14);
		productpnl.add(lblNewLabel_3);
		
		JButton btnNewButton_1_1 = new JButton("Order");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(btnNewButton_1_1, "Do you want to continue to order?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if (response == JOptionPane.YES_OPTION) {
					try {
						String query = ("INSERT INTO Admin(Pastries,Sandwich,Dessert,Drink,Total) VALUES (?,?,?,?,?)");
						PreparedStatement pr = con.prepareStatement(query);
						pr.setString(1, comboBox.getSelectedItem().toString());
						pr.setString(2, sndcmb.getSelectedItem().toString());
						pr.setString(3, dcmb.getSelectedItem().toString());
						pr.setString(4, Dr.getSelectedItem().toString());
						pr.setString(5, totallbl.getText());
						pr.executeUpdate();
						con.commit();
					} catch (SQLException r) {
						r.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(406, 306, 234, 31);
		productpnl.add(btnNewButton_1_1);


		
		
	}
	private void updateTotalPrice() {
		  double total = 0.0;

		  
		  if (comboBox.getSelectedItem() != "----") {
		    String priceStr = mdprice.getText().substring(1); 
		    double price = Double.parseDouble(priceStr);
		    int quantity = (int) pqnt.getValue();
		    total += price * quantity;
		  }
		  if (sndcmb.getSelectedItem() !="----") {
			  String priceStr = sdprice.getText().substring(1);
			  double price = Double.parseDouble(priceStr);
			  int quantity = (int) sqnt.getValue();
			  total += price * quantity;
		  }
		  if (dcmb.getSelectedItem() !="----") {
			  String priceStr = dprice.getText().substring(1);
			  double price = Double.parseDouble(priceStr);
			  int quantity = (int) dqnt.getValue();
			  total += price * quantity;
		  }
		  if (Dr.getSelectedItem() !="----") {
			  String priceStr = drprice.getText().substring(1);
			  double price = Double.parseDouble(priceStr);
			  int quantity = (int) drqnt.getValue();
			  total += price * quantity;
		  }
		 
		  totallbl.setText("₱" + String.format("%.2f", total));
		}
	
	}


