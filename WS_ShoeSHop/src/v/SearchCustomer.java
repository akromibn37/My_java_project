package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import m.CustomerDB;
import m.CustomerManager;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textField_search;
	private JTable table;
	SelectCustomerI xSelectCustomerI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCustomer frame = new SearchCustomer();
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
	public SearchCustomer() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_search = new JTextField();
		textField_search.setBounds(10, 11, 156, 20);
		contentPane.add(textField_search);
		textField_search.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(188, 10, 89, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 414, 198);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount() == 0)
				{
					JOptionPane.showMessageDialog(SearchCustomer.this, "Please select 1 row");
					
					return;
				}
				
				if(xSelectCustomerI != null)
				{
					if(list != null)
					{
						xSelectCustomerI.select(list.get(table.getSelectedRow()));
						setVisible(false);
					}
				}
			}
		});
		btnSelect.setBounds(294, 10, 89, 23);
		contentPane.add(btnSelect);
		load_data();
	}
	
	ArrayList<CustomerDB> list;
	private JButton btnSelect;
	public void load_data()
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
	
	public void search()
	{
		list = CustomerManager.SearchCustomer(textField_search.getText());
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
	public void setSelectCustomerI(SelectCustomerI x)
	{
		xSelectCustomerI = x;
	}
}

interface SelectCustomerI
{
	public void select(CustomerDB x);
}
