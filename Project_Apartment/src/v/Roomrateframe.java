package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import m.RoomrateDB;
import m.RoomrateManager;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Roomrateframe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_id;
	private JTextField textField_price;
	private JTextField textField_water;
	private JTextField textField_electric;
	private JTextField textField_car;
	private JTextField textField_motor;
	private JTextField textField_internet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Roomrateframe frame = new Roomrateframe();
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
	public Roomrateframe() {
		setTitle("Roomrate");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1033, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 807, 459);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRowCount()<1)
				{
					return;
				}
				int index = 	table.getSelectedRow();
				String id = 	table.getValueAt(index, 0).toString();
				int price = 	Integer.parseInt(table.getValueAt(index, 1).toString());
				int water = 	Integer.parseInt(table.getValueAt(index, 2).toString());
				int electricity = 	Integer.parseInt(table.getValueAt(index, 3).toString());
				int car = 	Integer.parseInt(table.getValueAt(index, 4).toString());
				int motor = 	Integer.parseInt(table.getValueAt(index, 5).toString());
				int internet = 	Integer.parseInt(table.getValueAt(index, 6).toString());
				
				
				textField_id.setText("" + id); 
				textField_price.setText("" + price); 
				textField_water.setText("" + water); 
				textField_electric.setText("" + electricity); 
				textField_car.setText("" + car); 
				textField_motor.setText("" + motor); 
				textField_internet.setText("" + internet);				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomrateDB x = new RoomrateDB(textField_id.getText()
						,Integer.parseInt(textField_price.getText().trim())
						,Integer.parseInt(textField_water.getText().trim())
						,Integer.parseInt(textField_electric.getText().trim())
						,Integer.parseInt(textField_car.getText().trim())
						,Integer.parseInt(textField_motor.getText().trim())
						,Integer.parseInt(textField_internet.getText().trim()));
				
				RoomrateManager.editUser(x);
				load();
				textField_id.setText("");
				textField_price.setText("");
				textField_water.setText("");
				textField_electric.setText("");
				textField_car.setText("");
				textField_motor.setText("");
				textField_internet.setText("");
				
				JOptionPane.showMessageDialog(Roomrateframe.this, "Update Finished!!");
				
			}
		});
		btnUpdate.setBounds(827, 165, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblRoomid = new JLabel("Room_id");
		lblRoomid.setBounds(827, 24, 46, 14);
		contentPane.add(lblRoomid);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(827, 44, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblWater = new JLabel("Water");
		lblWater.setBounds(827, 64, 46, 14);
		contentPane.add(lblWater);
		
		JLabel lblElectric = new JLabel("Electricity");
		lblElectric.setBounds(827, 83, 46, 14);
		contentPane.add(lblElectric);
		
		JLabel lblCar = new JLabel("Car");
		lblCar.setBounds(827, 102, 46, 14);
		contentPane.add(lblCar);
		
		JLabel lblMotorcycle = new JLabel("Motorcycle");
		lblMotorcycle.setBounds(827, 119, 52, 14);
		contentPane.add(lblMotorcycle);
		
		JLabel lblInterner = new JLabel("Internet");
		lblInterner.setBounds(827, 137, 46, 14);
		contentPane.add(lblInterner);
		
		textField_id = new JTextField();
		textField_id.setBackground(Color.GREEN);
		textField_id.setForeground(Color.BLACK);
		textField_id.setEditable(false);
		textField_id.setColumns(10);
		textField_id.setBounds(897, 22, 101, 17);
		contentPane.add(textField_id);
		
		textField_price = new JTextField();
		textField_price.setColumns(10);
		textField_price.setBounds(897, 41, 101, 17);
		contentPane.add(textField_price);
		
		textField_water = new JTextField();
		textField_water.setColumns(10);
		textField_water.setBounds(897, 61, 101, 17);
		contentPane.add(textField_water);
		
		textField_electric = new JTextField();
		textField_electric.setColumns(10);
		textField_electric.setBounds(897, 80, 101, 17);
		contentPane.add(textField_electric);
		
		textField_car = new JTextField();
		textField_car.setColumns(10);
		textField_car.setBounds(897, 99, 101, 17);
		contentPane.add(textField_car);
		
		textField_motor = new JTextField();
		textField_motor.setColumns(10);
		textField_motor.setBounds(897, 117, 101, 17);
		contentPane.add(textField_motor);
		
		textField_internet = new JTextField();
		textField_internet.setColumns(10);
		textField_internet.setBounds(897, 137, 101, 17);
		contentPane.add(textField_internet);
		load();
	}
	ArrayList<RoomrateDB> list;
	public void load()
	{
		list = RoomrateManager.getAllRate();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("room_id");
		model.addColumn("price");
		model.addColumn("water_price");
		model.addColumn("electricity_price");
		model.addColumn("car_price");
		model.addColumn("motorcycle_price");
		model.addColumn("internet_price");
		
		for(RoomrateDB c : list)
		{
//			System.out.println("xxxxxxxxx");
//			System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
			model.addRow(new Object[]{"" + c.id,c.room_price,c.water_price,c.electricity_price,c.car_price,c.motor_price,c.internet_price});
		}
		table.setModel(model);
	}
}
