package atmPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;

public class AtmGUIFinal {

	/**
	 * Instance variables
	 */
	private JFrame frmAtmProgram;
	private JTextField txtAtm1H;
	private JTextField txtAtm1F;
	private JTextField txtAtm1T;
	private JTextField txtAtm2H;
	private JTextField txtAtm2F;
	private JTextField txtAtm2T;
	private JTextField txtAtm3H;
	private JTextField txtAtm3F;
	private JTextField txtAtm3T;	
	ATM d1 = new ATM();
	ATM d2 = new ATM();
	ATM d3 = new ATM();
	private JTextField txtATM1R1H;
	private JTextField txtATM1R1F;
	private JTextField txtATM1R1T;
	private JTextField txtATM1TotalAmount;
	private JTextField txtATM2TotalAmount;
	private JTextField txtATM2R2T;
	private JTextField txtATM2R2F;
	private JTextField txtATM2R2H;
	private JTextField txtATM3TotalAmount;
	private JTextField txtATM3R3T;
	private JTextField txtATM3R3F;
	private JTextField txtATM3R3H;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtmGUIFinal window = new AtmGUIFinal();
					window.frmAtmProgram.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AtmGUIFinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAtmProgram = new JFrame();
		frmAtmProgram.setTitle("ATM Program");
		frmAtmProgram.setBounds(100, 100, 729, 482);
		frmAtmProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAtmProgram.getContentPane().setLayout(null);
		
		// Creation and definition of first JPanel
		JPanel ATM1Pane = new JPanel();
		ATM1Pane.setBackground(new Color(51, 204, 204));
		ATM1Pane.setForeground(UIManager.getColor("CheckBoxMenuItem.background"));
		ATM1Pane.setBounds(10, 0, 200, 356);
		frmAtmProgram.getContentPane().add(ATM1Pane);
		ATM1Pane.setLayout(null);
		
		// Creation and definition of the JPanel that contains
		// Suspend label
		JPanel panelSusOrNot = new JPanel();
		panelSusOrNot.setBackground(new Color(51, 204, 51));
		panelSusOrNot.setForeground(new Color(0, 0, 0));
		panelSusOrNot.setBounds(210, 357, 289, 38);
		frmAtmProgram.getContentPane().add(panelSusOrNot);
		panelSusOrNot.setLayout(null);
		
		// Creation and definition of the JLabel 
		JLabel lblSusOrNot = new JLabel("NOT SUSPENDED");
		lblSusOrNot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSusOrNot.setHorizontalAlignment(SwingConstants.CENTER);
		lblSusOrNot.setForeground(new Color(0, 0, 0));
		lblSusOrNot.setBounds(10, 0, 269, 35);
		panelSusOrNot.add(lblSusOrNot);
		
		
		JButton btnATM1WithBills = new JButton("Withdraw Bills");
		btnATM1WithBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
				
					h = Integer.parseInt(JOptionPane.showInputDialog(null, "How many hundred $ bills do you wish to withdraw?"));
					f = Integer.parseInt(JOptionPane.showInputDialog(null, "How many fifty $ bills do you wish to withdraw?"));
					t = Integer.parseInt(JOptionPane.showInputDialog(null, "How many twenty $ bills do you wish to withdraw?"));
					
					txtATM1R1H.setText("-" + Integer.toString(h));
					txtATM1R1F.setText("-" + Integer.toString(f));
					txtATM1R1T.setText("-" + Integer.toString(t));
					txtATM1TotalAmount.setText("-" + Integer.toString(h * 100 + f * 50 + t * 20));
				
					d1.takeOut(h,f,t);
				
					txtAtm1H.setText(Integer.toString(d1.getHundreds()));
					txtAtm1F.setText(Integer.toString(d1.getFifties()));
					txtAtm1T.setText(Integer.toString(d1.getTwenties()));				
				}
			}
		});
		btnATM1WithBills.setBounds(10, 168, 180, 23);
		ATM1Pane.add(btnATM1WithBills);
		
		JButton btnATM1WithAmt = new JButton("Withdraw Amount");
		btnATM1WithAmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
					int amount;
					
					h = d1.getHundreds();
					f = d1.getFifties();
					t = d1.getTwenties();
					
					amount = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the amount you wish to withdraw?"));
										
					d1.takeOut(amount);
					
					h -= d1.getHundreds();
					f -= d1.getFifties();
					t -= d1.getTwenties();
					
					if (h == 0) {
						if (f == 0) {
							if (t == 0) {
								JOptionPane.showMessageDialog(null, "ATM 1 does not possess enough dollar bills to satisfy your requested withdraw amount!");
							}
						}
					}
					
					txtATM1R1H.setText("-" + Integer.toString(h));
					txtATM1R1F.setText("-" + Integer.toString(f));
					txtATM1R1T.setText("-" + Integer.toString(t));
					txtATM1TotalAmount.setText("-" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					txtAtm1H.setText(Integer.toString(d1.getHundreds()));
					txtAtm1F.setText(Integer.toString(d1.getFifties()));
					txtAtm1T.setText(Integer.toString(d1.getTwenties()));
					
					
				}
			}
		});
		btnATM1WithAmt.setBounds(10, 194, 180, 23);
		ATM1Pane.add(btnATM1WithAmt);
		
		JLabel lblATM1 = new JLabel("ATM 1");
		lblATM1.setForeground(SystemColor.desktop);
		lblATM1.setHorizontalAlignment(SwingConstants.CENTER);
		lblATM1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblATM1.setBounds(0, 0, 200, 30);
		ATM1Pane.add(lblATM1);
		
		JLabel lblAtm1H = new JLabel("Hundred $ Bills:");
		lblAtm1H.setBounds(10, 41, 98, 14);
		ATM1Pane.add(lblAtm1H);
		
		JLabel lblAtm1F = new JLabel("Fifty $ Bills:");
		lblAtm1F.setBounds(10, 66, 98, 14);
		ATM1Pane.add(lblAtm1F);
		
		JLabel lblAtm1T = new JLabel("Twenty $ Bills:");
		lblAtm1T.setBounds(10, 91, 98, 14);
		ATM1Pane.add(lblAtm1T);
		
		txtAtm1H = new JTextField();
		txtAtm1H.setEditable(false);
		txtAtm1H.setBounds(118, 38, 72, 20);
		ATM1Pane.add(txtAtm1H);
		txtAtm1H.setColumns(10);
		// Atm 1 hundreds TextField shows '0'
		txtAtm1H.setText(Integer.toString(d1.getHundreds()));
		
		
		txtAtm1F = new JTextField();
		txtAtm1F.setEditable(false);
		txtAtm1F.setColumns(10);
		txtAtm1F.setBounds(118, 63, 72, 20);
		ATM1Pane.add(txtAtm1F);
		// Atm 1 fifties TextField shows '0'
		txtAtm1F.setText(Integer.toString(d1.getFifties()));
		
		
		txtAtm1T = new JTextField();
		txtAtm1T.setEditable(false);
		txtAtm1T.setColumns(10);
		txtAtm1T.setBounds(118, 88, 72, 20);
		ATM1Pane.add(txtAtm1T);
		// Atm 1 twenties TextField shows '0'
		txtAtm1T.setText(Integer.toString(d1.getTwenties()));
		
		
		JButton btnATM1AddBills = new JButton("Add Bills");
		btnATM1AddBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {		
						int h;
						int f;
						int t;
							
						h = Integer.parseInt(JOptionPane.showInputDialog(null, "Please deposit hundred $ bills:"));
						f = Integer.parseInt(JOptionPane.showInputDialog(null, "Please deposit fifty $ bills:"));
						t = Integer.parseInt(JOptionPane.showInputDialog(null, "Please deposit twenty $ bills:"));
						
						txtATM1R1H.setText("+" + Integer.toString(h));
						txtATM1R1F.setText("+" + Integer.toString(f));
						txtATM1R1T.setText("+" + Integer.toString(t));
						txtATM1TotalAmount.setText("+" + Integer.toString(h * 100 + f * 50 + t * 20));
						
						h += d1.getHundreds();
						f += d1.getFifties();
						t += d1.getTwenties();
						
						d1.setHundreds(h);
						d1.setFifties(f);
						d1.setTwenties(t);
						
						txtAtm1H.setText(Integer.toString(d1.getHundreds()));
						txtAtm1F.setText(Integer.toString(d1.getFifties()));
						txtAtm1T.setText(Integer.toString(d1.getTwenties()));
					}
				}
				catch (Exception fail) {
					JOptionPane.showMessageDialog(null, "Something went wrong! Try using positive numbers next time?" );
				}
			}
		});
		btnATM1AddBills.setBounds(10, 142, 180, 23);
		ATM1Pane.add(btnATM1AddBills);
		
		JButton btnATM1PlusATM2 = new JButton("+ ATM 2");
		btnATM1PlusATM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
					
					h = d2.getHundreds();
					f = d2.getFifties();
					t = d2.getTwenties();
					
					d1.putIn(d2);
					
					txtATM1R1H.setText("+" + Integer.toString(h));
					txtATM1R1F.setText("+" + Integer.toString(f));
					txtATM1R1T.setText("+" + Integer.toString(t));
					txtATM1TotalAmount.setText("+" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					txtAtm1H.setText(Integer.toString(d1.getHundreds()));
					txtAtm1F.setText(Integer.toString(d1.getFifties()));
					txtAtm1T.setText(Integer.toString(d1.getTwenties()));
				}
			}
		});
		btnATM1PlusATM2.setBounds(10, 116, 93, 23);
		ATM1Pane.add(btnATM1PlusATM2);
		
		JButton btnATM1PlusATM3 = new JButton("+ ATM 3");
		btnATM1PlusATM3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
					
					h = d3.getHundreds();
					f = d3.getFifties();
					t = d3.getTwenties();
					
					d1.putIn(d3);
					
					txtATM1R1H.setText("+" + Integer.toString(h));
					txtATM1R1F.setText("+" + Integer.toString(f));
					txtATM1R1T.setText("+" + Integer.toString(t));
					txtATM1TotalAmount.setText("+" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					txtAtm1H.setText(Integer.toString(d1.getHundreds()));
					txtAtm1F.setText(Integer.toString(d1.getFifties()));
					txtAtm1T.setText(Integer.toString(d1.getTwenties()));
				}
			}
		});
		btnATM1PlusATM3.setBounds(102, 116, 88, 23);
		ATM1Pane.add(btnATM1PlusATM3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 220, 180, 136);
		ATM1Pane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(90, 5, 0, 0);
		panel.add(label);
		
		JLabel lblATM1R1H = new JLabel("Hundred $ Bills:");
		lblATM1R1H.setBounds(10, 22, 91, 14);
		panel.add(lblATM1R1H);
		
		JLabel lblATM1R1F = new JLabel("Fifty $ Bills:");
		lblATM1R1F.setBounds(10, 44, 80, 14);
		panel.add(lblATM1R1F);
		
		JLabel lblATM1R1T = new JLabel("Twenty $ Bills:");
		lblATM1R1T.setBounds(10, 66, 80, 14);
		panel.add(lblATM1R1T);
		
		JLabel lblATM1TotalAmount = new JLabel("Total Amount:");
		lblATM1TotalAmount.setBounds(10, 102, 80, 14);
		panel.add(lblATM1TotalAmount);
		
		txtATM1R1H = new JTextField();
		txtATM1R1H.setEditable(false);
		txtATM1R1H.setBounds(100, 19, 76, 20);
		panel.add(txtATM1R1H);
		txtATM1R1H.setColumns(10);
		
		txtATM1R1F = new JTextField();
		txtATM1R1F.setEditable(false);
		txtATM1R1F.setColumns(10);
		txtATM1R1F.setBounds(100, 41, 76, 20);
		panel.add(txtATM1R1F);
		
		txtATM1R1T = new JTextField();
		txtATM1R1T.setEditable(false);
		txtATM1R1T.setColumns(10);
		txtATM1R1T.setBounds(100, 63, 76, 20);
		panel.add(txtATM1R1T);
		
		txtATM1TotalAmount = new JTextField();
		txtATM1TotalAmount.setEditable(false);
		txtATM1TotalAmount.setBounds(100, 99, 76, 20);
		panel.add(txtATM1TotalAmount);
		txtATM1TotalAmount.setColumns(10);
		
		JLabel lblReceipt = new JLabel("Receipt");
		lblReceipt.setBounds(10, 5, 46, 14);
		panel.add(lblReceipt);
		lblReceipt.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel ATM2Pane = new JPanel();
		ATM2Pane.setBackground(new Color(51, 204, 204));
		ATM2Pane.setBounds(256, 0, 200, 356);
		frmAtmProgram.getContentPane().add(ATM2Pane);
		ATM2Pane.setLayout(null);
		
		JButton btnATM2WithBills = new JButton("Withdraw Bills");
		btnATM2WithBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
				
					h = Integer.parseInt(JOptionPane.showInputDialog(null, "How many hundred $ bills do you wish to withdraw?"));
					f = Integer.parseInt(JOptionPane.showInputDialog(null, "How many fifty $ bills do you wish to withdraw?"));
					t = Integer.parseInt(JOptionPane.showInputDialog(null, "How many twenty $ bills do you wish to withdraw?"));
					
					txtATM2R2H.setText("-" + Integer.toString(h));
					txtATM2R2F.setText("-" + Integer.toString(f));
					txtATM2R2T.setText("-" + Integer.toString(t));
					txtATM2TotalAmount.setText("-" + Integer.toString(h * 100 + f * 50 + t * 20));
				
					d2.takeOut(h,f,t);
					
					txtAtm2H.setText(Integer.toString(d2.getHundreds()));
					txtAtm2F.setText(Integer.toString(d2.getFifties()));
					txtAtm2T.setText(Integer.toString(d2.getTwenties()));
				}	
			}
		});
		btnATM2WithBills.setBounds(10, 168, 178, 23);
		ATM2Pane.add(btnATM2WithBills);
		
		JButton btnATM2WithAmt = new JButton("Withdraw Amount");
		btnATM2WithAmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
					int amount;
					
					h = d2.getHundreds();
					f = d2.getFifties();
					t = d2.getTwenties();
					
					amount = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the amount you wish to withdraw?"));
					
					d2.takeOut(amount);
					
					h -= d2.getHundreds();
					f -= d2.getFifties();
					t -= d2.getTwenties();
					
					if (h == 0) {
						if (f == 0) {
							if (t == 0) {
								JOptionPane.showMessageDialog(null, "ATM 2 does not possess enough dollar bills to satisfy your requested withdraw amount!");
							}
						}
					}
					
					txtATM2R2H.setText("-" + Integer.toString(h));
					txtATM2R2F.setText("-" + Integer.toString(f));
					txtATM2R2T.setText("-" + Integer.toString(t));
					txtATM2TotalAmount.setText("-" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					txtAtm2H.setText(Integer.toString(d2.getHundreds()));
					txtAtm2F.setText(Integer.toString(d2.getFifties()));
					txtAtm2T.setText(Integer.toString(d2.getTwenties()));
				}
			}
		});
		btnATM2WithAmt.setBounds(10, 194, 178, 23);
		ATM2Pane.add(btnATM2WithAmt);
		
		JLabel lblATM2 = new JLabel("ATM 2");
		lblATM2.setHorizontalAlignment(SwingConstants.CENTER);
		lblATM2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblATM2.setBounds(0, 0, 200, 30);
		ATM2Pane.add(lblATM2);
		
		JLabel lblAtm2T = new JLabel("Twenty $ Bills:");
		lblAtm2T.setBounds(10, 91, 96, 14);
		ATM2Pane.add(lblAtm2T);
		
		JLabel lblAtm2F = new JLabel("Fifty $ Bills:");
		lblAtm2F.setBounds(10, 66, 96, 14);
		ATM2Pane.add(lblAtm2F);
		
		JLabel lblAtm2H = new JLabel("Hundred $ Bills:");
		lblAtm2H.setBounds(10, 41, 96, 14);
		ATM2Pane.add(lblAtm2H);
		
		txtAtm2H = new JTextField();
		txtAtm2H.setEditable(false);
		txtAtm2H.setColumns(10);
		txtAtm2H.setBounds(116, 38, 72, 20);
		ATM2Pane.add(txtAtm2H);
		// Atm 2 hundreds TextField shows '0'
		txtAtm2H.setText(Integer.toString(d2.getHundreds()));
		
		
		txtAtm2F = new JTextField();
		txtAtm2F.setEditable(false);
		txtAtm2F.setColumns(10);
		txtAtm2F.setBounds(116, 63, 72, 20);
		ATM2Pane.add(txtAtm2F);
		// Atm 2 fifties TextField shows '0'
		txtAtm2F.setText(Integer.toString(d2.getFifties()));
		
		
		txtAtm2T = new JTextField();
		txtAtm2T.setEditable(false);
		txtAtm2T.setColumns(10);
		txtAtm2T.setBounds(116, 88, 72, 20);
		ATM2Pane.add(txtAtm2T);
		// Atm 2 twenties TextField shows '0'
		txtAtm2T.setText(Integer.toString(d2.getTwenties()));
		
		
		//FIXME: Should we throw an Exception for negative numbers? If so, then how do we throw an exception?
		//       Or could we use an if statement to re-ask the number?
		JButton btnATM2AddBills = new JButton("Add Bills");
		btnATM2AddBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
										
					h = Integer.parseInt(JOptionPane.showInputDialog(null, "Please deposit hundred $ bills:"));
					f = Integer.parseInt(JOptionPane.showInputDialog(null, "Please deposit fifty $ bills:"));
					t = Integer.parseInt(JOptionPane.showInputDialog(null, "Please deposit twenty $ bills:"));
					
					txtATM2R2H.setText("+" + Integer.toString(h));
					txtATM2R2F.setText("+" + Integer.toString(f));
					txtATM2R2T.setText("+" + Integer.toString(t));
					txtATM2TotalAmount.setText("+" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					h += d2.getHundreds();
					f += d2.getFifties();
					t += d2.getTwenties();
					
					d2.setHundreds(h);
					d2.setFifties(f);
					d2.setTwenties(t);
					
					txtAtm2H.setText(Integer.toString(d2.getHundreds()));
					txtAtm2F.setText(Integer.toString(d2.getFifties()));
					txtAtm2T.setText(Integer.toString(d2.getTwenties()));
				}
			}
		});
		btnATM2AddBills.setBounds(10, 142, 178, 23);
		ATM2Pane.add(btnATM2AddBills);
		
		JButton btnATM2PlusATM1 = new JButton("+ ATM 1");
		btnATM2PlusATM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
					
					h = d1.getHundreds();
					f = d1.getFifties();
					t = d1.getTwenties();
					
					d2.putIn(d1);
					
					txtATM2R2H.setText("+" + Integer.toString(h));
					txtATM2R2F.setText("+" + Integer.toString(f));
					txtATM2R2T.setText("+" + Integer.toString(t));
					txtATM2TotalAmount.setText("+" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					txtAtm2H.setText(Integer.toString(d2.getHundreds()));
					txtAtm2F.setText(Integer.toString(d2.getFifties()));
					txtAtm2T.setText(Integer.toString(d2.getTwenties()));
				}
			}
		});
		btnATM2PlusATM1.setBounds(10, 116, 89, 23);
		ATM2Pane.add(btnATM2PlusATM1);
		
		JButton btnATM2PlusATM3 = new JButton("+ ATM 3");
		btnATM2PlusATM3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
					
					h = d3.getHundreds();
					f = d3.getFifties();
					t = d3.getTwenties();
					
					d2.putIn(d3);
					
					txtATM2R2H.setText("+" + Integer.toString(h));
					txtATM2R2F.setText("+" + Integer.toString(f));
					txtATM2R2T.setText("+" + Integer.toString(t));
					txtATM2TotalAmount.setText("+" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					txtAtm2H.setText(Integer.toString(d2.getHundreds()));
					txtAtm2F.setText(Integer.toString(d2.getFifties()));
					txtAtm2T.setText(Integer.toString(d2.getTwenties()));
				}
			}
		});
		btnATM2PlusATM3.setBounds(99, 116, 89, 23);
		ATM2Pane.add(btnATM2PlusATM3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 221, 180, 135);
		ATM2Pane.add(panel_1);
		panel_1.setLayout(null);
		
		txtATM2TotalAmount = new JTextField();
		txtATM2TotalAmount.setEditable(false);
		txtATM2TotalAmount.setColumns(10);
		txtATM2TotalAmount.setBounds(100, 101, 76, 20);
		panel_1.add(txtATM2TotalAmount);
		
		JLabel lblATM2TotalAmount = new JLabel("Total Amount:");
		lblATM2TotalAmount.setBounds(10, 104, 80, 14);
		panel_1.add(lblATM2TotalAmount);
		
		JLabel lblATM2R2T = new JLabel("Twenty $ Bills:");
		lblATM2R2T.setBounds(10, 70, 80, 14);
		panel_1.add(lblATM2R2T);
		
		txtATM2R2T = new JTextField();
		txtATM2R2T.setEditable(false);
		txtATM2R2T.setColumns(10);
		txtATM2R2T.setBounds(100, 67, 76, 20);
		panel_1.add(txtATM2R2T);
		
		txtATM2R2F = new JTextField();
		txtATM2R2F.setEditable(false);
		txtATM2R2F.setColumns(10);
		txtATM2R2F.setBounds(100, 45, 76, 20);
		panel_1.add(txtATM2R2F);
		
		txtATM2R2H = new JTextField();
		txtATM2R2H.setEditable(false);
		txtATM2R2H.setColumns(10);
		txtATM2R2H.setBounds(100, 23, 76, 20);
		panel_1.add(txtATM2R2H);
		
		JLabel lblATM2R2H = new JLabel("Hundred $ Bills:");
		lblATM2R2H.setBounds(10, 26, 91, 14);
		panel_1.add(lblATM2R2H);
		
		JLabel lblATM2R2F = new JLabel("Fifty $ Bills:");
		lblATM2R2F.setBounds(10, 48, 80, 14);
		panel_1.add(lblATM2R2F);
		
		JLabel label_1 = new JLabel("Receipt");
		label_1.setBounds(10, 4, 46, 14);
		panel_1.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel ATM3Pane = new JPanel();
		ATM3Pane.setBackground(new Color(51, 204, 204));
		ATM3Pane.setBounds(499, 0, 204, 356);
		frmAtmProgram.getContentPane().add(ATM3Pane);
		ATM3Pane.setLayout(null);
		
		JButton btnATM3WithBills = new JButton("Withdraw Bills");
		btnATM3WithBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
					
					h = Integer.parseInt(JOptionPane.showInputDialog(null, "How many hundred $ bills do you wish to withdraw?"));
					f = Integer.parseInt(JOptionPane.showInputDialog(null, "How many fifty $ bills do you wish to withdraw?"));
					t = Integer.parseInt(JOptionPane.showInputDialog(null, "How many twenty $ bills do you wish to withdraw?"));
					
					txtATM3R3H.setText("-" + Integer.toString(h));
					txtATM3R3F.setText("-" + Integer.toString(f));
					txtATM3R3T.setText("-" + Integer.toString(t));
					txtATM3TotalAmount.setText("-" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					d3.takeOut(h,f,t);
					
					txtAtm3H.setText(Integer.toString(d3.getHundreds()));
					txtAtm3F.setText(Integer.toString(d3.getFifties()));
					txtAtm3T.setText(Integer.toString(d3.getTwenties()));
				}
			}
		});
		btnATM3WithBills.setBounds(10, 168, 184, 23);
		ATM3Pane.add(btnATM3WithBills);
		
		JButton btnATM3WithAmt = new JButton("Withdraw Amount");
		btnATM3WithAmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
					int amount;
					
					h = d3.getHundreds();
					f = d3.getFifties();
					t = d3.getTwenties();
					
					amount = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the amount you wish to withdraw?"));
					
					d3.takeOut(amount);
					
					h -= d3.getHundreds();
					f -= d3.getFifties();
					t -= d3.getTwenties();
					
					if (h == 0) {
						if (f == 0) {
							if (t == 0) {
								JOptionPane.showMessageDialog(null, "ATM 3 does not possess enough dollar bills to satisfy your requested withdraw amount!");
							}
						}
					}
					
					txtATM3R3H.setText("-" + Integer.toString(h));
					txtATM3R3F.setText("-" + Integer.toString(f));
					txtATM3R3T.setText("-" + Integer.toString(t));
					txtATM3TotalAmount.setText("-" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					txtAtm3H.setText(Integer.toString(d3.getHundreds()));
					txtAtm3F.setText(Integer.toString(d3.getFifties()));
					txtAtm3T.setText(Integer.toString(d3.getTwenties()));
				}
			}
		});
		btnATM3WithAmt.setBounds(10, 194, 184, 23);
		ATM3Pane.add(btnATM3WithAmt);
		
		JLabel lblATM3 = new JLabel("ATM 3");
		lblATM3.setHorizontalAlignment(SwingConstants.CENTER);
		lblATM3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblATM3.setBounds(0, 0, 204, 30);
		ATM3Pane.add(lblATM3);
		
		JLabel lblAtm3T = new JLabel("Twenty $ Bills:");
		lblAtm3T.setBounds(10, 91, 93, 14);
		ATM3Pane.add(lblAtm3T);
		
		JLabel lblAtm3F = new JLabel("Fifty $ Bills:");
		lblAtm3F.setBounds(10, 66, 93, 14);
		ATM3Pane.add(lblAtm3F);
		
		JLabel lblAtm3H = new JLabel("Hundred $ Bills:");
		lblAtm3H.setBounds(10, 41, 93, 14);
		ATM3Pane.add(lblAtm3H);
		
		txtAtm3H = new JTextField();
		txtAtm3H.setEditable(false);
		txtAtm3H.setColumns(10);
		txtAtm3H.setBounds(122, 38, 72, 20);
		ATM3Pane.add(txtAtm3H);
		// Atm 3 hundreds TextField shows '0'
		txtAtm3H.setText(Integer.toString(d3.getHundreds()));
		
		
		txtAtm3F = new JTextField();
		txtAtm3F.setEditable(false);
		txtAtm3F.setColumns(10);
		txtAtm3F.setBounds(122, 63, 72, 20);
		ATM3Pane.add(txtAtm3F);
		// Atm 3 hundreds TextField shows '0'
		txtAtm3F.setText(Integer.toString(d3.getHundreds()));
		
		
		txtAtm3T = new JTextField();
		txtAtm3T.setEditable(false);
		txtAtm3T.setColumns(10);
		txtAtm3T.setBounds(122, 88, 72, 20);
		ATM3Pane.add(txtAtm3T);
		// Atm 3 hundreds TextField shows '0'
		txtAtm3T.setText(Integer.toString(d3.getHundreds()));
		
		
		//FIXME: Should we throw an Exception for negative numbers? If so, then how do we throw an exception?
		//       Or could we use an if statement to re-ask the number?
		JButton btnATM3AddBills = new JButton("Add Bills");
		btnATM3AddBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
										
					h = Integer.parseInt(JOptionPane.showInputDialog(null, "Please deposit hundred $ bills:"));
					f = Integer.parseInt(JOptionPane.showInputDialog(null, "Please deposit fifty $ bills:"));
					t = Integer.parseInt(JOptionPane.showInputDialog(null, "Please deposit twenty $ bills:"));
					
					txtATM3R3H.setText("+" + Integer.toString(h));
					txtATM3R3F.setText("+" + Integer.toString(f));
					txtATM3R3T.setText("+" + Integer.toString(t));
					txtATM3TotalAmount.setText("+" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					h += d3.getHundreds();
					f += d3.getFifties();
					t += d3.getTwenties();
					
					d3.setHundreds(h);
					d3.setFifties(f);
					d3.setTwenties(t);
					
					txtAtm3H.setText(Integer.toString(d3.getHundreds()));
					txtAtm3F.setText(Integer.toString(d3.getFifties()));
					txtAtm3T.setText(Integer.toString(d3.getTwenties()));
				}
			}
		});
		btnATM3AddBills.setBounds(10, 142, 184, 23);
		ATM3Pane.add(btnATM3AddBills);
		
		JButton btnATM3PlusATM1 = new JButton("+ ATM 1");
		btnATM3PlusATM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
					
					h = d1.getHundreds();
					f = d1.getFifties();
					t = d1.getTwenties();
					
					d3.putIn(d1);
					
					txtATM3R3H.setText("+" + Integer.toString(h));
					txtATM3R3F.setText("+" + Integer.toString(f));
					txtATM3R3T.setText("+" + Integer.toString(t));
					txtATM3TotalAmount.setText("+" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					txtAtm3H.setText(Integer.toString(d3.getHundreds()));
					txtAtm3F.setText(Integer.toString(d3.getFifties()));
					txtAtm3T.setText(Integer.toString(d3.getTwenties()));
				}
			}
		});
		btnATM3PlusATM1.setBounds(10, 116, 93, 23);
		ATM3Pane.add(btnATM3PlusATM1);
		
		JButton btnATM3PlusATM2 = new JButton("+ ATM 2");
		btnATM3PlusATM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (lblSusOrNot.getText().equals("NOT SUSPENDED")) {
					int h;
					int f;
					int t;
					
					h = d2.getHundreds();
					f = d2.getFifties();
					t = d2.getTwenties();
					
					d3.putIn(d2);
					
					txtATM3R3H.setText("+" + Integer.toString(h));
					txtATM3R3F.setText("+" + Integer.toString(f));
					txtATM3R3T.setText("+" + Integer.toString(t));
					txtATM3TotalAmount.setText("+" + Integer.toString(h * 100 + f * 50 + t * 20));
					
					txtAtm3H.setText(Integer.toString(d3.getHundreds()));
					txtAtm3F.setText(Integer.toString(d3.getFifties()));
					txtAtm3T.setText(Integer.toString(d3.getTwenties()));
				}
			}
		});
		btnATM3PlusATM2.setBounds(101, 116, 93, 23);
		ATM3Pane.add(btnATM3PlusATM2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 221, 180, 135);
		ATM3Pane.add(panel_2);
		panel_2.setLayout(null);
		
		txtATM3TotalAmount = new JTextField();
		txtATM3TotalAmount.setEditable(false);
		txtATM3TotalAmount.setColumns(10);
		txtATM3TotalAmount.setBounds(100, 101, 76, 20);
		panel_2.add(txtATM3TotalAmount);
		
		JLabel lblATM3TotalAmount = new JLabel("Total Amount:");
		lblATM3TotalAmount.setBounds(10, 104, 80, 14);
		panel_2.add(lblATM3TotalAmount);
		
		JLabel lblATM3R3T = new JLabel("Twenty $ Bills:");
		lblATM3R3T.setBounds(10, 69, 80, 14);
		panel_2.add(lblATM3R3T);
		
		txtATM3R3T = new JTextField();
		txtATM3R3T.setEditable(false);
		txtATM3R3T.setColumns(10);
		txtATM3R3T.setBounds(100, 66, 76, 20);
		panel_2.add(txtATM3R3T);
		
		txtATM3R3F = new JTextField();
		txtATM3R3F.setEditable(false);
		txtATM3R3F.setColumns(10);
		txtATM3R3F.setBounds(100, 44, 76, 20);
		panel_2.add(txtATM3R3F);
		
		txtATM3R3H = new JTextField();
		txtATM3R3H.setEditable(false);
		txtATM3R3H.setColumns(10);
		txtATM3R3H.setBounds(100, 22, 76, 20);
		panel_2.add(txtATM3R3H);
		
		JLabel lblATM3R3H = new JLabel("Hundred $ Bills:");
		lblATM3R3H.setBounds(10, 25, 91, 14);
		panel_2.add(lblATM3R3H);
		
		JLabel lblATM3R3F = new JLabel("Fifty $ Bills:");
		lblATM3R3F.setBounds(10, 47, 80, 14);
		panel_2.add(lblATM3R3F);
		
		JLabel label_2 = new JLabel("Receipt");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 3, 46, 14);
		panel_2.add(label_2);
		
		JPanel panelBtnOnOff = new JPanel();
		panelBtnOnOff.setBounds(210, 395, 289, 48);
		frmAtmProgram.getContentPane().add(panelBtnOnOff);
		panelBtnOnOff.setLayout(null);
		
		JButton btnSusToggleOn = new JButton("ON");
		btnSusToggleOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATM.suspend(true);
				
				panelSusOrNot.setBackground(new Color(255, 0, 0));
				lblSusOrNot.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSusOrNot.setHorizontalAlignment(SwingConstants.CENTER);
				lblSusOrNot.setText("SUSPENDED");
			}
		});
		btnSusToggleOn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSusToggleOn.setBounds(0, 0, 147, 37);
		panelBtnOnOff.add(btnSusToggleOn);
		
		JButton btnSusToggleOff = new JButton("OFF");
		btnSusToggleOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ATM.suspend(false);
				
				panelSusOrNot.setBackground(new Color(51, 204, 51));
				lblSusOrNot.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSusOrNot.setHorizontalAlignment(SwingConstants.CENTER);
				lblSusOrNot.setText("NOT SUSPENDED");				
			}
		});
		btnSusToggleOff.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSusToggleOff.setBounds(147, 0, 142, 37);
		panelBtnOnOff.add(btnSusToggleOff);
		
		
		
	}
}
