package v;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import m.UserDB;
import m.UserDBManager;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_username;
	private JPasswordField passwordField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 336, 386);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if(index == -1)
				{
					return ;
				}
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				txt_id.setText("" + model.getValueAt(index, 0));
				txt_username.setText("" + model.getValueAt(index, 1));
				passwordField.setText("" + model.getValueAt(index, 2));
				comboBox.setSelectedItem("" + model.getValueAt(index, 3));
			}
		});
		table.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(389, 28, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(389, 53, 60, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(389, 78, 46, 14);
		contentPane.add(lblPassword);
		
		JLabel lblUserType = new JLabel("User type");
		lblUserType.setBounds(389, 103, 60, 14);
		contentPane.add(lblUserType);
		
		txt_id = new JTextField();
		txt_id.setEditable(false);
		txt_id.setBounds(474, 25, 114, 20);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.setBounds(474, 50, 114, 20);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(475, 75, 113, 17);
		contentPane.add(passwordField);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"admin", "user"}));
		comboBox.setBounds(475, 100, 113, 20);
		contentPane.add(comboBox);
		
		JButton btnInsertNewUser = new JButton("Insert new user");
		btnInsertNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDB x =new UserDB();
				x.Username = txt_username.getText();
				x.Password = new String(passwordField.getPassword());
				x.Usertype = (String)comboBox.getSelectedItem();
				
				UserDBManager.addNewUser(x);
				JOptionPane.showMessageDialog(UserFrame.this, "Insert Finish!!");
				
				load_data();
			}
		});
		btnInsertNewUser.setBounds(389, 151, 109, 23);
		contentPane.add(btnInsertNewUser);
		
		JButton btnEditUser = new JButton("edit user");
		btnEditUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDB x =new UserDB();
				x.id = Integer.parseInt(txt_id.getText().trim()); 
				x.Username = txt_username.getText();
				x.Password = new String(passwordField.getPassword());
				x.Usertype = (String)comboBox.getSelectedItem();
				
				UserDBManager.updateUser(x);
				JOptionPane.showMessageDialog(UserFrame.this, "Update Finish!!");
				
				load_data();
			}
		});
		btnEditUser.setBounds(389, 185, 109, 23);
		contentPane.add(btnEditUser);
		
		JButton btnNewButton = new JButton("delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(UserFrame.this, "Are you sure?","confirm",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{
					int k = 0;
					if(!txt_id.getText().matches("\\d+"))
					{
						JOptionPane.showMessageDialog(UserFrame.this, "Please Select one row on table!!");
					}
					UserDB x =new UserDB();
					x.id = Integer.parseInt(txt_id.getText().trim()); 
					UserDBManager.deleteUser(x);
					load_data();
				}
			}
		});
		btnNewButton.setBounds(389, 221, 109, 23);
		contentPane.add(btnNewButton);
		load_data();
	}
	
	ArrayList<UserDB> allUsers;
	private JComboBox comboBox;
	public void load_data()
	{
		allUsers = UserDBManager.getAllUsers();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("name");
		model.addColumn("lastname");
		model.addColumn("phone");
		
		for(UserDB x : allUsers)
		{
			model.addRow(new Object[]{"" + x.id,x.Username,x.Password,x.Usertype});
		}
//		for(int i =0;i<allUsers.size();i++)
//		{
//			UserDB y = allUsers.get(i);
//		}
		table.setModel(model);
		
	}
}
