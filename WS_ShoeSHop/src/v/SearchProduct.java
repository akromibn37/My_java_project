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
import m.ProductDB;
import m.ProductManager;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField_search;
	private JTable table;
	private JButton button_Search;
	private JButton button_Select;
	private JScrollPane scrollPane;
	SelectProductI xSelectProductI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchProduct frame = new SearchProduct();
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
	public SearchProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_search = new JTextField();
		textField_search.setColumns(10);
		textField_search.setBounds(10, 12, 156, 20);
		contentPane.add(textField_search);
		
		button_Search = new JButton("Search");
		button_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		button_Search.setBounds(188, 11, 89, 23);
		contentPane.add(button_Search);
		
		button_Select = new JButton("Select");
		button_Select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount() == 0)
				{
					JOptionPane.showMessageDialog(SearchProduct.this, "Please select 1 row");
					
					return;
				}
				
				if(xSelectProductI != null)
				{
					if(list != null)
					{
						xSelectProductI.select(list.get(table.getSelectedRow()));
						setVisible(false);
					}
				}
			}
		});
		button_Select.setBounds(294, 11, 89, 23);
		contentPane.add(button_Select);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 414, 198);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	ArrayList<ProductDB> list;
	
	public void search()
	{
		list = ProductManager.SearchProduct(textField_search.getText());
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("product_id");
		model.addColumn("product_name");
		model.addColumn("price_per_unit");
		model.addColumn("product_description");
		
		for(ProductDB c : list)
		{
//			System.out.println("xxxxxxxxx");
//			System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
			model.addRow(new Object[]{"" + c.product_id,c.product_name,c.price_per_unit,c.product_description});
		}
		table.setModel(model);
	}
	
	
	public void setSelectProductI(SelectProductI x)
	{
		xSelectProductI = x;
	}
}

interface SelectProductI
{
	public void select(ProductDB x);
}


