package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import m.CustomerDB;
import m.CustomerManager;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_id;
	private JTextField textField_name;
	private JTextField textField_surname;
	private JTextField textField_phone;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 708, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 445, 433);
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
				String name = 		table.getValueAt(index, 1).toString();
				String surname = 	table.getValueAt(index, 2).toString();
				String phone = 		table.getValueAt(index, 3).toString();
				
				textField_id.setText("" + id); 
				textField_name.setText("" + name); 
				textField_surname.setText("" + surname); 
				textField_phone.setText("" + phone); 
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(455, 11, 46, 14);
		contentPane.add(lblId);
		
		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setBackground(Color.YELLOW);
		textField_id.setBounds(511, 7, 149, 17);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(511, 35, 149, 17);
		contentPane.add(textField_name);
		
		textField_surname = new JTextField();
		textField_surname.setColumns(10);
		textField_surname.setBounds(511, 63, 149, 17);
		contentPane.add(textField_surname);
		
		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBounds(511, 91, 149, 17);
		contentPane.add(textField_phone);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(455, 38, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("surname");
		lblSurname.setBounds(455, 64, 46, 14);
		contentPane.add(lblSurname);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(455, 94, 46, 14);
		contentPane.add(lblPhone);
		
		JButton btnSaveNew = new JButton("SAVE NEW");
		btnSaveNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDB x = new CustomerDB(0,textField_name.getText().trim(),textField_surname.getText().trim(),textField_phone.getText().trim());
				CustomerManager.saveNewCustomer(x);
				load();
				textField_id.setText("");
				textField_name.setText("");
				textField_surname.setText("");
				textField_phone.setText("");
				JOptionPane.showMessageDialog(CustomerFrame.this, "Finished!!");
			}
		});
		btnSaveNew.setBounds(455, 131, 89, 23);
		contentPane.add(btnSaveNew);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDB x = new CustomerDB(Integer.parseInt(textField_id.getText().trim().toString())
						,textField_name.getText().trim()
						,textField_surname.getText().trim()
						,textField_phone.getText().trim());
					
				CustomerManager.editCustomer(x);
				load();
				textField_id.setText("");
				textField_name.setText("");
				textField_surname.setText("");
				textField_phone.setText("");
				JOptionPane.showMessageDialog(CustomerFrame.this, "Finished!!");
				
			}
		});
		btnEdit.setBounds(455, 162, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(CustomerFrame.this, "Are you sure?","confirm",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{
					int k = 0;
					if(!textField_id.getText().matches("\\d+"))
					{
						JOptionPane.showMessageDialog(CustomerFrame.this, "Please Select one row on table!!");
					}
					CustomerDB x =new CustomerDB();
					x.id = Integer.parseInt(textField_id.getText().trim()); 
					CustomerManager.deleteCustomer(x);
					load();
					textField_id.setText("");
					textField_name.setText("");
					textField_surname.setText("");
					textField_phone.setText("");
					JOptionPane.showMessageDialog(CustomerFrame.this, "Finished!!");
				}
			}
		});
		btnDelete.setBounds(455, 196, 89, 23);
		contentPane.add(btnDelete);	
		load();
		
	}
	ArrayList<CustomerDB> list;
	public void load()
	{
		list = CustomerManager.getAllCustomer();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("name");
		model.addColumn("surname");
		model.addColumn("phone");
		
		for(CustomerDB c : list)
		{
//			System.out.println("xxxxxxxxx");
			System.out.println(c.id+" " +c.name +" "+c.surname+" "+c.phone);
			model.addRow(new Object[]{"" + c.id,c.name,c.surname,c.phone});
		}
		table.setModel(model);
	}
}
