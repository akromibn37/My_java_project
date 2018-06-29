package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import m.CompanyInfoDB;
import m.CompanyInfoManager;
import m.CustomerDB;
import m.CustomerManager;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompanyInfoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Companyname;
	private JTextField textField_Address;
	private JTextField textField_Phone;
	private JTextField textField_Email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyInfoFrame frame = new CompanyInfoFrame();
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
	public CompanyInfoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setBounds(27, 42, 85, 14);
		contentPane.add(lblCompanyName);
		
		textField_Companyname = new JTextField();
		textField_Companyname.setBounds(122, 39, 205, 20);
		contentPane.add(textField_Companyname);
		textField_Companyname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(27, 70, 85, 14);
		contentPane.add(lblAddress);
		
		textField_Address = new JTextField();
		textField_Address.setColumns(10);
		textField_Address.setBounds(122, 67, 205, 20);
		contentPane.add(textField_Address);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(27, 98, 85, 14);
		contentPane.add(lblPhone);
		
		textField_Phone = new JTextField();
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(122, 95, 205, 20);
		contentPane.add(textField_Phone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(27, 126, 85, 14);
		contentPane.add(lblEmail);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(122, 123, 205, 20);
		contentPane.add(textField_Email);
		
		btnSave = new JButton("Edit");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xCompanyInfoDB.company_name = textField_Companyname.getText();
				xCompanyInfoDB.address = textField_Address.getText();
				xCompanyInfoDB.phone = textField_Phone.getText();
				xCompanyInfoDB.email = textField_Email.getText();
				CompanyInfoManager.editCompanyInfo(xCompanyInfoDB);
			}
		});
		btnSave.setBounds(131, 165, 89, 23);
		contentPane.add(btnSave);
		
		btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xCompanyInfoDB.company_name = textField_Companyname.getText();
				xCompanyInfoDB.address = textField_Address.getText();
				xCompanyInfoDB.phone = textField_Phone.getText();
				xCompanyInfoDB.email = textField_Email.getText();
				CompanyInfoManager.savenewCompanyInfo(xCompanyInfoDB);
			}
		});
		btnSave_1.setBounds(238, 165, 89, 23);
		contentPane.add(btnSave_1);
		load_data();
	}
	CompanyInfoDB xCompanyInfoDB;
	private JButton btnSave;
	private JButton btnSave_1;
	public void load_data()
	{
		xCompanyInfoDB = CompanyInfoManager.getCompanyInfo();
		textField_Companyname.setText(xCompanyInfoDB.company_name);
		textField_Address.setText(xCompanyInfoDB.address);
		textField_Phone.setText(xCompanyInfoDB.phone);
		textField_Email.setText(xCompanyInfoDB.email);
	
	
	}

}
