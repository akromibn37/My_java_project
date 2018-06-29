package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import m.CustomerDB;
import m.CustomerManager;
import m.ProductDB;
import m.ProductManager;
import m.UserDB;
import m.UserManager;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_password;
	private JTextField textField_username;
	private JTextField textField_id;
	private JComboBox comboBox_usertype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UserFrame frame = new UserFrame();
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
	public UserFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 791, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 445, 433);
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
			
			textField_id.setText("" + id); 
			textField_username.setText("" + username); 
			textField_password.setText("" + password); 
			comboBox_usertype.setSelectedItem(usertype);
			
			
		}
	});
		scrollPane.setViewportView(table);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(465, 22, 78, 14);
		contentPane.add(lblId);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(465, 49, 78, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(465, 75, 78, 14);
		contentPane.add(lblPassword);
		
		JLabel lblUsertype = new JLabel("usertype");
		lblUsertype.setBounds(465, 105, 106, 14);
		contentPane.add(lblUsertype);
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(598, 74, 149, 23);
		contentPane.add(textField_password);
		
		textField_username = new JTextField();
		textField_username.setColumns(10);
		textField_username.setBounds(598, 46, 149, 23);
		contentPane.add(textField_username);
		
		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setColumns(10);
		textField_id.setBackground(Color.YELLOW);
		textField_id.setBounds(598, 18, 149, 23);
		contentPane.add(textField_id);
		
		JButton button_save = new JButton("SAVE NEW");
		button_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDB x = new UserDB(0
						,textField_username.getText().trim()
						,textField_password.getText().trim()
						,comboBox_usertype.getSelectedItem().toString());
				UserManager.saveNewUser(x);
				load();
				textField_id.setText("");
				textField_username.setText("");
				textField_password.setText("");
				comboBox_usertype.setSelectedIndex(-1);
				JOptionPane.showMessageDialog(UserFrame.this, "Finished!!");
			}
		});
		button_save.setBounds(465, 158, 89, 23);
		contentPane.add(button_save);
		
		JButton button_edit = new JButton("EDIT");
		button_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDB x = new UserDB(Integer.parseInt(textField_id.getText().trim().toString())
						,textField_username.getText().trim()
						,textField_password.getText().trim()
						,comboBox_usertype.getSelectedItem().toString());
					
				UserManager.editUser(x);;
				load();
				textField_id.setText("");
				textField_username.setText("");
				textField_password.setText("");
				comboBox_usertype.setSelectedIndex(-1);
				JOptionPane.showMessageDialog(UserFrame.this, "Finished!!");
			}
		});
		button_edit.setBounds(561, 158, 89, 23);
		contentPane.add(button_edit);
		
		JButton button_delete = new JButton("DELETE");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(UserFrame.this, "Are you sure?","confirm",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{
					int k = 0;
					if(!textField_id.getText().matches("\\d+"))
					{
						JOptionPane.showMessageDialog(UserFrame.this, "Please Select one row on table!!");
					}
					UserDB x =new UserDB();
					x.Id = Integer.parseInt(textField_id.getText().trim()); 
					UserManager.deleteUser(x);
					load();
					textField_id.setText("");
					textField_username.setText("");
					textField_password.setText("");
					comboBox_usertype.setSelectedIndex(-1);
					JOptionPane.showMessageDialog(UserFrame.this, "Finished!!");
				}
			}
		});
		button_delete.setBounds(658, 158, 89, 23);
		contentPane.add(button_delete);
		
		comboBox_usertype = new JComboBox();
		comboBox_usertype.setModel(new DefaultComboBoxModel(new String[] {"admin", "user"}));
		comboBox_usertype.setBounds(598, 102, 149, 23);
		contentPane.add(comboBox_usertype);
		load();
	}
	ArrayList<UserDB> list;
	private JTable table;
	public void load()
	{
		list = UserManager.getAllUser();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("username");
		model.addColumn("password");
		model.addColumn("usertype");
		
		for(UserDB c : list)
		{
//			System.out.println("xxxxxxxxx");
//			System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
			model.addRow(new Object[]{"" + c.Id,c.username,c.password,c.usertype});
		}
		table.setModel(model);
	}
}
