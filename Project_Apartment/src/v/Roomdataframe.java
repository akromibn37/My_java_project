package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import m.RoomdataDB;
import m.RoomdataManager;
import m.RoomsummaryDB;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Roomdataframe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_id;
	private JTextField textField_water;
	private JTextField textField_electric;
	private JTextField textField_car;
	private JTextField textField_motor;
	private JComboBox comboBox;
	String month = "January";
	private JComboBox comboBox_1;
	private JButton btnLoad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Roomdataframe frame = new Roomdataframe();
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
	public Roomdataframe() {
		setTitle("RoomData");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 840, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 594, 434);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(table.getSelectedRowCount()<1)
				{
					return;
				}
				int index = 		table.getSelectedRow();
				String id = 		table.getValueAt(index, 0).toString();	
				int water = 		Integer.parseInt(table.getValueAt(index, 2).toString());
				int electric = 		Integer.parseInt(table.getValueAt(index, 3).toString());
				int car = 		Integer.parseInt(table.getValueAt(index, 4).toString());
				int motorcycle = 		Integer.parseInt(table.getValueAt(index, 5).toString());
				String internet = 		table.getValueAt(index, 6).toString();	
				
				textField_id.setText("" + id); 
				textField_water.setText("" + water); 
				textField_electric.setText("" + electric); 
				textField_car.setText("" + car); 
				textField_motor.setText("" + motorcycle); 
				comboBox_1.setSelectedItem(internet);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRowCount()<1)
				{
					return;
				}
				int index = 		table.getSelectedRow();
				String id = 		table.getValueAt(index, 0).toString();	
				int water = 		Integer.parseInt(table.getValueAt(index, 2).toString());
				int electric = 		Integer.parseInt(table.getValueAt(index, 3).toString());
				int car = 		Integer.parseInt(table.getValueAt(index, 4).toString());
				int motorcycle = 		Integer.parseInt(table.getValueAt(index, 5).toString());
				String internet = 		table.getValueAt(index, 6).toString();	
				
				textField_id.setText("" + id); 
				textField_water.setText("" + water); 
				textField_electric.setText("" + electric); 
				textField_car.setText("" + car); 
				textField_motor.setText("" + motorcycle); 
				comboBox_1.setSelectedItem(internet);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Room_id");
		label.setBounds(614, 42, 46, 14);
		contentPane.add(label);
		
		JLabel lblWaterunit = new JLabel("Water(unit)");
		lblWaterunit.setBounds(614, 65, 60, 14);
		contentPane.add(lblWaterunit);
		
		JLabel lblElectricityunit = new JLabel("Electricity(unit)");
		lblElectricityunit.setBounds(614, 84, 78, 14);
		contentPane.add(lblElectricityunit);
		
		JLabel lblCarunit = new JLabel("Car(unit)");
		lblCarunit.setBounds(614, 103, 46, 14);
		contentPane.add(lblCarunit);
		
		JLabel lblMotorcycleunit = new JLabel("Motorcycle(unit)");
		lblMotorcycleunit.setBounds(614, 120, 78, 14);
		contentPane.add(lblMotorcycleunit);
		
		JLabel label_6 = new JLabel("Internet");
		label_6.setBounds(614, 138, 46, 14);
		contentPane.add(label_6);
		
		textField_id = new JTextField();
		textField_id.setForeground(Color.BLACK);
		textField_id.setEditable(false);
		textField_id.setColumns(10);
		textField_id.setBackground(Color.GREEN);
		textField_id.setBounds(702, 42, 101, 17);
		contentPane.add(textField_id);
		
		textField_water = new JTextField();
		textField_water.setColumns(10);
		textField_water.setBounds(702, 64, 101, 17);
		contentPane.add(textField_water);
		
		textField_electric = new JTextField();
		textField_electric.setColumns(10);
		textField_electric.setBounds(702, 83, 101, 17);
		contentPane.add(textField_electric);
		
		textField_car = new JTextField();
		textField_car.setColumns(10);
		textField_car.setBounds(702, 102, 101, 17);
		contentPane.add(textField_car);
		
		textField_motor = new JTextField();
		textField_motor.setColumns(10);
		textField_motor.setBounds(702, 120, 101, 17);
		contentPane.add(textField_motor);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(641, 9, 141, 20);
		contentPane.add(comboBox);
		
		JButton btnAddnewmonth = new JButton("Add new month");
		btnAddnewmonth.setEnabled(false);
		btnAddnewmonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				month = comboBox.getSelectedItem().toString();
				RoomdataManager.addNewMonth(month);
				load();
			}
		});
		btnAddnewmonth.setBounds(641, 280, 120, 23);
		contentPane.add(btnAddnewmonth);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomdataDB x = new RoomdataDB(textField_id.getText().trim(),comboBox.getSelectedItem().toString()
							,Integer.parseInt(textField_water.getText()),Integer.parseInt(textField_electric.getText())
							,Integer.parseInt(textField_car.getText()),Integer.parseInt(textField_motor.getText())
							,comboBox_1.getSelectedItem().toString());
				RoomdataManager.editRoomdata(x);
				RoomsummaryDB total = new RoomsummaryDB();
				total = RoomdataManager.getRoomsummary(x);
				RoomdataManager.editRoomsummary(total);
				load();
				System.out.println(x.room_id);
				textField_id.setText("");
				textField_water.setText("");
				textField_electric.setText("");
				textField_car.setText("");
				textField_motor.setText("");
				comboBox_1.setSelectedIndex(-1);
				
				JOptionPane.showMessageDialog(Roomdataframe.this, "Update Finished!!");
			}
		});
		btnUpdate.setBounds(641, 163, 89, 23);
		contentPane.add(btnUpdate);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		comboBox_1.setBounds(702, 138, 101, 20);
		contentPane.add(comboBox_1);
		
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		btnLoad.setBounds(641, 246, 120, 23);
		contentPane.add(btnLoad);
	}
	
	public void load()
	{
		month = comboBox.getSelectedItem().toString();
		ArrayList<RoomdataDB> list;
		list = RoomdataManager.getAllUser(month);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("room_id");
		model.addColumn("month");
		model.addColumn("water(unit)");
		model.addColumn("electric(unit)");
		model.addColumn("car(unit)");
		model.addColumn("motorcycle(unit)");
		model.addColumn("Internet");
		
		for(RoomdataDB c : list)
		{
//			System.out.println("xxxxxxxxx");
//			System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
			model.addRow(new Object[]{"" + c.room_id,c.month,c.water_unit,c.electric_unit,c.car_unit,c.motor_unit,c.internet});
		}
		table.setModel(model);
	}
}
