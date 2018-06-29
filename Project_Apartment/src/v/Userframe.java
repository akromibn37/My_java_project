package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import m.UserDB;
import m.UserManager;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Userframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField_password;
	private JTextField textField_username;
	private JTextField textField_id;
	private JTextField textField_renter_id;
	private JTable table;
	private JComboBox comboBox_usertype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Userframe frame = new Userframe();
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
	public Userframe() {
		setTitle("All User");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 841, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 575, 422);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRowCount()<1)
				{
					return;
				}
				int index = 		table.getSelectedRow();
				int id = 			Integer.parseInt(table.getValueAt(index, 0).toString());
				String username = 		table.getValueAt(index, 1).toString();
				String password = 		table.getValueAt(index, 2).toString();
				String usertype = 		table.getValueAt(index, 3).toString();
				int renter_id = 		Integer.parseInt(table.getValueAt(index, 4).toString());
				
				textField_id.setText("" + id); 
				textField_username.setText("" + username); 
				textField_password.setText("" + password); 
				textField_renter_id.setText("" + renter_id);
				comboBox_usertype.setSelectedItem(usertype);
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("id");
		label.setBounds(595, 11, 61, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("username");
		label_1.setBounds(595, 45, 61, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("password");
		label_2.setBounds(595, 70, 61, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("usertype");
		label_3.setBounds(595, 119, 61, 14);
		contentPane.add(label_3);
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(666, 66, 149, 23);
		contentPane.add(textField_password);
		
		textField_username = new JTextField();
		textField_username.setColumns(10);
		textField_username.setBounds(666, 39, 149, 23);
		contentPane.add(textField_username);
		
		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setColumns(10);
		textField_id.setBackground(Color.YELLOW);
		textField_id.setBounds(666, 11, 149, 23);
		contentPane.add(textField_id);
		
		JButton buttonSave = new JButton("SAVE NEW");
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDB x = new UserDB(0
						,textField_username.getText().trim()
						,textField_password.getText().trim()
						,comboBox_usertype.getSelectedItem().toString(),Integer.parseInt(textField_renter_id.getText().trim()));
				UserManager.saveNewUser(x);
				load();
				textField_id.setText("");
				textField_username.setText("");
				textField_password.setText("");
				comboBox_usertype.setSelectedIndex(-1);
				textField_renter_id.setText("");
				JOptionPane.showMessageDialog(Userframe.this, "Finished!!");
			}
		});
		buttonSave.setBounds(607, 158, 89, 23);
		contentPane.add(buttonSave);
		
		JButton buttonEdit = new JButton("EDIT");
		buttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDB x = new UserDB(Integer.parseInt(textField_id.getText().trim())
						,textField_username.getText().trim()
						,textField_password.getText().trim()
						,comboBox_usertype.getSelectedItem().toString(),Integer.parseInt(textField_renter_id.getText().trim()));
				UserManager.editUser(x);
				load();
				textField_id.setText("");
				textField_username.setText("");
				textField_password.setText("");
				comboBox_usertype.setSelectedIndex(-1);
				textField_renter_id.setText("");
				JOptionPane.showMessageDialog(Userframe.this, "Finished!!");
			}
		});
		buttonEdit.setBounds(726, 158, 89, 23);
		contentPane.add(buttonEdit);
		
		JButton buttonDelete = new JButton("DELETE");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(Userframe.this, "Are you sure?","confirm",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{
					int k = 0;
					if(!textField_id.getText().matches("\\d+"))
					{
						JOptionPane.showMessageDialog(Userframe.this, "Please Select one row on table!!");
					}
					UserDB x =new UserDB();
					x.id = Integer.parseInt(textField_id.getText().trim()); 
					UserManager.deleteUser(x);
					load();
					textField_id.setText("");
					textField_username.setText("");
					textField_password.setText("");
					comboBox_usertype.setSelectedIndex(-1);
					textField_renter_id.setText("");
					JOptionPane.showMessageDialog(Userframe.this, "Finished!!");
				}
			}
		});
		buttonDelete.setBounds(666, 192, 89, 23);
		contentPane.add(buttonDelete);
		
		comboBox_usertype = new JComboBox();
		comboBox_usertype.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		comboBox_usertype.setBounds(666, 120, 149, 23);
		contentPane.add(comboBox_usertype);
		
		JLabel lblRenterid = new JLabel("renter_id");
		lblRenterid.setBounds(595, 94, 61, 14);
		contentPane.add(lblRenterid);
		
		textField_renter_id = new JTextField();
		textField_renter_id.setEnabled(false);
		textField_renter_id.setColumns(10);
		textField_renter_id.setBounds(666, 91, 149, 23);
		contentPane.add(textField_renter_id);
		load();
	}
	
	public void load()
	{
		ArrayList<UserDB> list;
		list = UserManager.getAllUser();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("username");
		model.addColumn("password");
		model.addColumn("usertype");
		model.addColumn("renter_id");
		
		for(UserDB c : list)
		{
//			System.out.println("xxxxxxxxx");
//			System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
			model.addRow(new Object[]{"" + c.id,c.username,c.password,c.usertype,c.renter_id});
		}
		table.setModel(model);
	}
}
