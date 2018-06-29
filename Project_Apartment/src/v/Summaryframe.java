package v;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import m.RoomdataDB;
import m.RoomdataManager;
import m.RoomsummaryDB;
import m.SummaryManager;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class Summaryframe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private JLabel lblOccupied;
	private JLabel lblVacant;
	private JTextField textField_occupied;
	private JTextField textField_vacant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Summaryframe frame = new Summaryframe();
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
	public Summaryframe() {
		setTitle("Summary");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 915, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 699, 537);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnViewAll = new JButton("View All");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadall();
			}
		});
		btnViewAll.setBounds(745, 168, 132, 23);
		contentPane.add(btnViewAll);
		
		JButton buttonViewPay = new JButton("View Pay Status");
		buttonViewPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadpaystatus();
			}
		});
		buttonViewPay.setBounds(745, 202, 132, 23);
		contentPane.add(buttonViewPay);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(745, 26, 132, 20);
		contentPane.add(comboBox);
		
		lblOccupied = new JLabel("Occupied");
		lblOccupied.setBounds(745, 57, 46, 14);
		contentPane.add(lblOccupied);
		
		lblVacant = new JLabel("Vacant");
		lblVacant.setBounds(745, 82, 46, 14);
		contentPane.add(lblVacant);
		
		textField_occupied = new JTextField();
		textField_occupied.setEditable(false);
		textField_occupied.setBounds(801, 54, 46, 17);
		contentPane.add(textField_occupied);
		textField_occupied.setColumns(10);
		
		textField_vacant = new JTextField();
		textField_vacant.setEditable(false);
		textField_vacant.setColumns(10);
		textField_vacant.setBounds(801, 79, 46, 17);
		contentPane.add(textField_vacant);
	}
	public void loadall()
	{
		String month = comboBox.getSelectedItem().toString();
		ArrayList<RoomsummaryDB> list;
		
		list = SummaryManager.getAllUser(month);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Room Id");
		model.addColumn("Month");		
		model.addColumn("Price");
		model.addColumn("Water");
		model.addColumn("Electric");
		model.addColumn("Car");
		model.addColumn("Motorcycle");
		model.addColumn("Internet");
		model.addColumn("Total");
		model.addColumn("Occupy");
		
		
		int i = 0;
		for(RoomsummaryDB c : list)
		{
//			System.out.println("xxxxxxxxx");
//			System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
			model.addRow(new Object[]{"" + c.room_id,c.month,c.room_price,c.water_sum,c.electric_sum,c.car_sum,c.motor_sum,c.internet_sum,c.total,c.occupy_status});
			if(c.occupy_status.equals("Yes"))
			{
				i++;			
			}
			
		}
		table.setModel(model);
		int j = 25-i;
		textField_occupied.setText(Integer.toString(i));	
		textField_occupied.setBackground(new Color(0,200,140));
		textField_vacant.setText(Integer.toString(j));
		textField_vacant.setBackground(new Color(0,255,0));
		
		table = ColorTableRow.getNewRenderedTable(table);
	}
	
	public void loadpaystatus()
	{
		String month = comboBox.getSelectedItem().toString();
		ArrayList<RoomsummaryDB> list;
		
		list = SummaryManager.getAllUser(month);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Room Id");
		model.addColumn("Month");
		model.addColumn("Total");			
		model.addColumn("Pay");
		
		int i = 0;
		for(RoomsummaryDB c : list)
		{
			if(c.occupy_status.equals("Yes"))
			{
//				System.out.println("xxxxxxxxx");
//				System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
				model.addRow(new Object[]{"" + c.room_id,c.month,c.total,c.pay_status});
				if(c.pay_status.equals("No"))
				{
					
				}
				i++;
			}
		}
		table.setModel(model);
		int j = 25-i;
		textField_occupied.setText(Integer.toString(i));		
		textField_occupied.setBackground(new Color(0,200,140));
		textField_vacant.setText(Integer.toString(j));
		textField_vacant.setBackground(new Color(0,255,0));
		table = ColorTableRow.getNewerRenderedTable(table);
	}
}




