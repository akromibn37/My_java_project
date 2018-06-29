package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Globaldata;
import m.SummaryManager;
import m.UserManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Loginframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JPasswordField passwordField;
	private JComboBox comboBox_type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Loginframe frame = new Loginframe();
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
	public Loginframe() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(74, 27, 63, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(74, 57, 63, 14);
		contentPane.add(lblPassword);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblType.setBounds(74, 86, 46, 14);
		contentPane.add(lblType);
		
		textField_username = new JTextField();
		textField_username.setBounds(147, 24, 142, 20);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		comboBox_type = new JComboBox();
		comboBox_type.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		comboBox_type.setBounds(147, 83, 142, 20);
		contentPane.add(comboBox_type);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		btnLogin.setBounds(74, 124, 107, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginframe f = new Loginframe();
				System.exit(0);
			}
		});
		btnCancel.setBounds(191, 124, 107, 23);
		contentPane.add(btnCancel);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					check();
				}
			}
		});
		passwordField.setBounds(147, 51, 142, 20);
		contentPane.add(passwordField);
	}
	public void check()
	{
		if(UserManager.checkLogin(textField_username.getText(), new String(passwordField.getPassword()),comboBox_type.getSelectedItem().toString()) && comboBox_type.getSelectedItem().toString().equals("Admin"))
		{
			Adminframe f = new Adminframe();
			f.setVisible(true);
			Loginframe.this.setVisible(false);
		}
		else if(UserManager.checkLogin(textField_username.getText(), new String(passwordField.getPassword()),comboBox_type.getSelectedItem().toString()) && comboBox_type.getSelectedItem().toString().equals("User"))
		{
			String xmonth = JOptionPane.showInputDialog(Loginframe.this, "Enter month you would like to see?", "Login", JOptionPane.INFORMATION_MESSAGE);
			String xid = SummaryManager.getRoomID(xmonth, Globaldata.Current_renterID);
			if(!xid.equals("0"))
			{
				Invoiceframe f = new Invoiceframe();	
				f.setVisible(true);
				f.loadforuser(xmonth, xid);
				Loginframe.this.setVisible(false);
				System.out.println("comein");
			}
			else
			{
				JOptionPane.showMessageDialog(Loginframe.this, "This id is already checkout or not rent any room yet.");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(Loginframe.this, "Username or password incorrect");
		}
	}
}
