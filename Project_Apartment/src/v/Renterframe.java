package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import m.RenterDB;
import m.RenterManager;
import m.UserDB;
import m.UserManager;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Renterframe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_personal_id;
	private JTextField textField_name;
	private JTextField textField_surname;
	private JTextField textField_phone;
	private JTextField textField_housenumber;
	private JTextField textField_road;
	private JTextField textField_soi;
	private JTextField textField_tambon;
	private JTextField textField_district;
	private JTextField textField_province;
	private JTextField textField_occupation;
	private JTextField textField_company_name;
	private JTextField textField_renter_id;
	private JTextField textField_postal_code;
	private JComboBox comboBox_salary;
	private ImagePanel imagepanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Renterframe frame = new Renterframe();
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
	public Renterframe() {
		setTitle("Renter");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1300, 678);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1042, 618);
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
				String personal_id = table.getValueAt(index, 1).toString();
		        String name = table.getValueAt(index, 2).toString();	        
		        String surname = table.getValueAt(index, 3).toString();
		        String phone = table.getValueAt(index, 4).toString();
		        String house_number = table.getValueAt(index, 5).toString();
		        String road = table.getValueAt(index, 6).toString();		        
		        String soi = table.getValueAt(index, 7).toString();
		        String tambon = table.getValueAt(index, 8).toString();
		        String district = table.getValueAt(index, 9).toString();
		        String province = table.getValueAt(index, 10).toString();	        
		        String postal_code = table.getValueAt(index, 11).toString();
		        String occupation = table.getValueAt(index, 12).toString();
		        String company_name = table.getValueAt(index, 13).toString();
		        String salary = table.getValueAt(index, 14).toString();		
		        BufferedImage buff = list.get(index).image;
		        if(buff != null)
		        {
		        	imagepanel.setImage(buff);
		        }
		        else
		        {
		        	imagepanel.setImage(null);
		        }
				
				textField_renter_id.setText("" + id); 
				textField_personal_id.setText("" + personal_id); 
				textField_name.setText("" + name); 
				textField_surname.setText("" + surname);
				textField_phone.setText("" + phone); 
				textField_housenumber.setText("" + house_number); 
				textField_road.setText("" + road); 
				textField_soi.setText("" + soi);
				textField_tambon.setText("" + tambon); 
				textField_district.setText("" + district); 
				textField_province.setText("" + province); 
				textField_postal_code.setText("" + postal_code);
				textField_occupation.setText("" + occupation); 
				textField_company_name.setText("" + company_name); 
				comboBox_salary.setSelectedItem(salary);				
				
				
				//System.out.println(data.renter_id + "," + data.personal_id + "," + data.name + "," + data.surname + "," + data.phone + "," + data.house_number + "," + data.road + "," + data.soi + "," + data.tambon + "," + data.district + "," + data.province + "," + data.postal_code + "," + data.occupation + "," +data.company_name+ "," + data.salary);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Personal id");
		label.setBounds(1062, 42, 80, 14);
		contentPane.add(label);
		
		textField_personal_id = new JTextField();
		textField_personal_id.setToolTipText("");
		textField_personal_id.setColumns(10);
		textField_personal_id.setBounds(1152, 39, 125, 20);
		contentPane.add(textField_personal_id);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(1062, 70, 46, 14);
		contentPane.add(label_1);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(1152, 67, 125, 20);
		contentPane.add(textField_name);
		
		JLabel label_2 = new JLabel("Surname");
		label_2.setBounds(1062, 100, 46, 14);
		contentPane.add(label_2);
		
		textField_surname = new JTextField();
		textField_surname.setColumns(10);
		textField_surname.setBounds(1152, 97, 125, 20);
		contentPane.add(textField_surname);
		
		JLabel label_3 = new JLabel("Phone");
		label_3.setBounds(1062, 128, 46, 14);
		contentPane.add(label_3);
		
		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBounds(1152, 125, 125, 20);
		contentPane.add(textField_phone);
		
		JLabel label_4 = new JLabel("HouseNumber");
		label_4.setBounds(1062, 156, 67, 14);
		contentPane.add(label_4);
		
		textField_housenumber = new JTextField();
		textField_housenumber.setColumns(10);
		textField_housenumber.setBounds(1152, 153, 125, 20);
		contentPane.add(textField_housenumber);
		
		JLabel label_5 = new JLabel("Road");
		label_5.setBounds(1062, 184, 46, 14);
		contentPane.add(label_5);
		
		textField_road = new JTextField();
		textField_road.setColumns(10);
		textField_road.setBounds(1152, 181, 125, 20);
		contentPane.add(textField_road);
		
		JLabel label_6 = new JLabel("Soi");
		label_6.setBounds(1062, 212, 46, 14);
		contentPane.add(label_6);
		
		textField_soi = new JTextField();
		textField_soi.setColumns(10);
		textField_soi.setBounds(1152, 209, 125, 20);
		contentPane.add(textField_soi);
		
		JLabel label_7 = new JLabel("Tambon");
		label_7.setBounds(1062, 240, 46, 14);
		contentPane.add(label_7);
		
		textField_tambon = new JTextField();
		textField_tambon.setColumns(10);
		textField_tambon.setBounds(1152, 237, 125, 20);
		contentPane.add(textField_tambon);
		
		JLabel label_8 = new JLabel("District");
		label_8.setBounds(1062, 268, 46, 14);
		contentPane.add(label_8);
		
		textField_district = new JTextField();
		textField_district.setColumns(10);
		textField_district.setBounds(1152, 265, 125, 20);
		contentPane.add(textField_district);
		
		JLabel label_9 = new JLabel("Province");
		label_9.setBounds(1062, 296, 46, 14);
		contentPane.add(label_9);
		
		textField_province = new JTextField();
		textField_province.setColumns(10);
		textField_province.setBounds(1152, 293, 125, 20);
		contentPane.add(textField_province);
		
		JLabel label_10 = new JLabel("Occupation");
		label_10.setBounds(1062, 352, 80, 14);
		contentPane.add(label_10);
		
		textField_occupation = new JTextField();
		textField_occupation.setColumns(10);
		textField_occupation.setBounds(1152, 349, 125, 20);
		contentPane.add(textField_occupation);
		
		JLabel label_11 = new JLabel("Company Name");
		label_11.setBounds(1062, 380, 80, 14);
		contentPane.add(label_11);
		
		textField_company_name = new JTextField();
		textField_company_name.setColumns(10);
		textField_company_name.setBounds(1152, 377, 125, 20);
		contentPane.add(textField_company_name);
		
		JLabel label_12 = new JLabel("Salary");
		label_12.setBounds(1062, 408, 80, 14);
		contentPane.add(label_12);
		
		comboBox_salary = new JComboBox();
		comboBox_salary.setModel(new DefaultComboBoxModel(new String[] {"10,000 - 20,000", "20,001 - 30,000", "30,001 - 40,000", "40,001 - 50,000", "50,001 - 60,000", "More than 60,000 "}));
		comboBox_salary.setBounds(1152, 408, 125, 20);
		contentPane.add(comboBox_salary);
		
		JButton btnEditData = new JButton("Edit Data");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(data.renter_id + "," + data.personal_id + "," + data.name + "," + data.surname + "," + data.phone + "," + data.house_number + "," + data.road + "," + data.soi + "," + data.tambon + "," + data.district + "," + data.province + "," + data.postal_code + "," + data.occupation + "," +data.company_name+ "," + data.salary);
				int id = Integer.parseInt(textField_renter_id.getText()); 
				String personal_id = textField_personal_id.getText();
				String name =textField_name.getText();
				String surname =textField_surname.getText();
				String phone = textField_phone.getText(); 
				String house_number =textField_housenumber.getText(); 
				String road = textField_road.getText();
				String soi = textField_soi.getText();
				String tambon = textField_tambon.getText();
				String district = textField_district.getText();
				String province = textField_province.getText();
				String postal_code = textField_postal_code.getText();
				String occupation = textField_occupation.getText(); 
				String company_name = textField_company_name.getText();
				String salary = comboBox_salary.getSelectedItem().toString();					
				
				RenterDB data = new RenterDB(id,personal_id,name,surname,phone,house_number,road,soi,tambon,district,province,postal_code,occupation,company_name,salary);
				RenterManager.editUser(data);
				load();
				
				textField_renter_id.setText(""); 
				textField_personal_id.setText(""); 
				textField_name.setText(""); 
				textField_surname.setText("");
				textField_phone.setText(""); 
				textField_housenumber.setText(""); 
				textField_road.setText(""); 
				textField_soi.setText("");
				textField_tambon.setText(""); 
				textField_district.setText(""); 
				textField_province.setText(""); 
				textField_postal_code.setText("");
				textField_occupation.setText(""); 
				textField_company_name.setText(""); 
				comboBox_salary.setSelectedIndex(-1);
				JOptionPane.showMessageDialog(Renterframe.this, "Upadte Finished!!");
			}
		});
		btnEditData.setBounds(1103, 572, 157, 23);
		contentPane.add(btnEditData);
		
		JButton btnNewButton = new JButton("Delete Renter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = JOptionPane.showInputDialog(Renterframe.this, "Enter Delete Password", "Delete", JOptionPane.QUESTION_MESSAGE);
				if(result.equals("1234"))
				{
					int result1 = JOptionPane.showConfirmDialog(Renterframe.this, "Are you sure?","confirm",JOptionPane.YES_NO_OPTION);
					if(result1 == JOptionPane.YES_OPTION)
					{						
						if(!textField_renter_id.getText().matches("\\d+"))
						{
							JOptionPane.showMessageDialog(Renterframe.this, "Please Select one row on table!!");
						}
						else
						{
							int renter_id  = Integer.parseInt(textField_renter_id.getText().toString().trim());
							RenterManager.deleteUser(renter_id);
							load();
				
							textField_renter_id.setText(""); 
							textField_personal_id.setText(""); 
							textField_name.setText(""); 
							textField_surname.setText("");
							textField_phone.setText(""); 
							textField_housenumber.setText(""); 
							textField_road.setText(""); 
							textField_soi.setText("");
							textField_tambon.setText(""); 
							textField_district.setText(""); 
							textField_province.setText(""); 
							textField_postal_code.setText("");
							textField_occupation.setText(""); 
							textField_company_name.setText(""); 
							comboBox_salary.setSelectedIndex(-1);
							JOptionPane.showMessageDialog(Renterframe.this, "Delete Finished!!");
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(Renterframe.this, "Wrong password cannot delete.", "Delete", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(1102, 606, 158, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblRenterId = new JLabel("Renter id");
		lblRenterId.setBounds(1062, 14, 80, 14);
		contentPane.add(lblRenterId);
		
		textField_renter_id = new JTextField();
		textField_renter_id.setEditable(false);
		textField_renter_id.setColumns(10);
		textField_renter_id.setBounds(1152, 11, 125, 20);
		contentPane.add(textField_renter_id);
		
		JLabel label_13 = new JLabel("Postal code");
		label_13.setBounds(1062, 324, 80, 14);
		contentPane.add(label_13);
		
		textField_postal_code = new JTextField();
		textField_postal_code.setColumns(10);
		textField_postal_code.setBounds(1152, 321, 125, 20);
		contentPane.add(textField_postal_code);
		
		imagepanel = new ImagePanel();
		imagepanel.setBounds(1130, 452, 109, 109);
		contentPane.add(imagepanel);
		load();
	}
	
	ArrayList<RenterDB> list;
	public void load()
	{
		
		list = RenterManager.getAllUser();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("personal_id");
		model.addColumn("name");
		model.addColumn("surname");
		model.addColumn("phone");
		model.addColumn("house_number");
		model.addColumn("road");
		model.addColumn("soi");
		model.addColumn("tambon");
		model.addColumn("district");
		model.addColumn("province");
		model.addColumn("postal_code");
		model.addColumn("occupation");
		model.addColumn("company_name");
		model.addColumn("salary");
		model.addColumn("check-in");
		model.addColumn("check-out");
		
		
		for(RenterDB x : list)
		{
//			System.out.println("xxxxxxxxx");
//			System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
			model.addRow(new Object[]{"" + x.renter_id,x.personal_id,x.name ,x.surname, x.phone,x.house_number,x.road
											,x.soi,x.tambon,x.district,x.province,x.postal_code
											,x.occupation,x.company_name,x.salary,x.checkin,x.checkout});
		}
		table.setModel(model);
	}
}
