package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

import m.OwnerManager;
import m.RenterDB;
import m.RenterManager;
import m.RoomdataDB;
import m.RoomdataManager;
import m.RoomsummaryDB;
import m.UserDB;
import m.UserManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class RenterRegisframe extends JFrame {

	private JPanel contentPane;
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
	private JTextField textField_username;
	private JPasswordField passwordField;
	private JTextField textField_postal_code;
	private JComboBox comboBox_room_id;
	private JComboBox comboBox_renter_type;
	private JComboBox comboBox_month;
	private JComboBox comboBox_salary;
	private ImagePanel imagepanel;
	private JButton btnbrowseimage;
	private JTextField textField_water;
	private JTextField textField_electric;
	private JTextField textField_car;
	private JTextField textField_motorcycle;
	private JComboBox comboBox_internet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					RenterRegisframe frame = new RenterRegisframe();
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
	public RenterRegisframe() {
		setTitle("Renter Register");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 796, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewRenterRegistration = new JLabel("Renter Registration");
		lblNewRenterRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewRenterRegistration.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewRenterRegistration.setBounds(277, 11, 231, 36);
		contentPane.add(lblNewRenterRegistration);
		
		JLabel lblName = new JLabel("Personal id");
		lblName.setBounds(55, 109, 80, 14);
		contentPane.add(lblName);
		
		textField_personal_id = new JTextField();
		textField_personal_id.setEditable(false);
		textField_personal_id.setBounds(145, 106, 200, 20);
		contentPane.add(textField_personal_id);
		textField_personal_id.setColumns(10);
		
		JLabel label = new JLabel("Name");
		label.setBounds(55, 137, 46, 14);
		contentPane.add(label);
		
		textField_name = new JTextField();
		textField_name.setEditable(false);
		textField_name.setColumns(10);
		textField_name.setBounds(145, 134, 200, 20);
		contentPane.add(textField_name);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(55, 167, 46, 14);
		contentPane.add(lblSurname);
		
		textField_surname = new JTextField();
		textField_surname.setEditable(false);
		textField_surname.setColumns(10);
		textField_surname.setBounds(145, 164, 200, 20);
		contentPane.add(textField_surname);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(55, 195, 46, 14);
		contentPane.add(lblPhone);
		
		textField_phone = new JTextField();
		textField_phone.setEditable(false);
		textField_phone.setColumns(10);
		textField_phone.setBounds(145, 192, 200, 20);
		contentPane.add(textField_phone);
		
		JLabel lblHousenumber = new JLabel("HouseNumber");
		lblHousenumber.setBounds(55, 223, 67, 14);
		contentPane.add(lblHousenumber);
		
		textField_housenumber = new JTextField();
		textField_housenumber.setEditable(false);
		textField_housenumber.setColumns(10);
		textField_housenumber.setBounds(145, 220, 200, 20);
		contentPane.add(textField_housenumber);
		
		JLabel lblRoad = new JLabel("Road");
		lblRoad.setBounds(55, 251, 46, 14);
		contentPane.add(lblRoad);
		
		textField_road = new JTextField();
		textField_road.setEditable(false);
		textField_road.setColumns(10);
		textField_road.setBounds(145, 248, 200, 20);
		contentPane.add(textField_road);
		
		JLabel lblSoi = new JLabel("Soi");
		lblSoi.setBounds(55, 279, 46, 14);
		contentPane.add(lblSoi);
		
		textField_soi = new JTextField();
		textField_soi.setEditable(false);
		textField_soi.setColumns(10);
		textField_soi.setBounds(145, 276, 200, 20);
		contentPane.add(textField_soi);
		
		JLabel lblTambon = new JLabel("Tambon");
		lblTambon.setBounds(55, 307, 46, 14);
		contentPane.add(lblTambon);
		
		textField_tambon = new JTextField();
		textField_tambon.setEditable(false);
		textField_tambon.setColumns(10);
		textField_tambon.setBounds(145, 304, 200, 20);
		contentPane.add(textField_tambon);
		
		JLabel lblDistrict = new JLabel("District");
		lblDistrict.setBounds(55, 335, 46, 14);
		contentPane.add(lblDistrict);
		
		textField_district = new JTextField();
		textField_district.setEditable(false);
		textField_district.setColumns(10);
		textField_district.setBounds(145, 332, 200, 20);
		contentPane.add(textField_district);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setBounds(55, 363, 46, 14);
		contentPane.add(lblProvince);
		
		textField_province = new JTextField();
		textField_province.setEditable(false);
		textField_province.setColumns(10);
		textField_province.setBounds(145, 360, 200, 20);
		contentPane.add(textField_province);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setBounds(54, 420, 80, 14);
		contentPane.add(lblOccupation);
		
		textField_occupation = new JTextField();
		textField_occupation.setEditable(false);
		textField_occupation.setColumns(10);
		textField_occupation.setBounds(144, 417, 200, 20);
		contentPane.add(textField_occupation);
		
		JLabel lblCompany = new JLabel("Company Name");
		lblCompany.setBounds(54, 448, 80, 14);
		contentPane.add(lblCompany);
		
		textField_company_name = new JTextField();
		textField_company_name.setEditable(false);
		textField_company_name.setColumns(10);
		textField_company_name.setBounds(144, 445, 200, 20);
		contentPane.add(textField_company_name);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(54, 476, 80, 14);
		contentPane.add(lblSalary);
		
		comboBox_salary = new JComboBox();
		comboBox_salary.setEnabled(false);
		comboBox_salary.setModel(new DefaultComboBoxModel(new String[] {"10,000 - 20,000", "20,001 - 30,000", "30,001 - 40,000", "40,001 - 50,000", "50,001 - 60,000", "More than 60,000 "}));
		comboBox_salary.setBounds(144, 476, 200, 20);
		contentPane.add(comboBox_salary);
		
		JLabel lblCreateUserId = new JLabel("Create User id");
		lblCreateUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateUserId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCreateUserId.setBounds(530, 120, 110, 26);
		contentPane.add(lblCreateUserId);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(441, 160, 67, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(441, 188, 67, 14);
		contentPane.add(lblPassword);
		
		textField_username = new JTextField();
		textField_username.setEditable(false);
		textField_username.setColumns(10);
		textField_username.setBounds(531, 157, 200, 20);
		contentPane.add(textField_username);
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setBounds(531, 185, 200, 20);
		contentPane.add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if((comboBox_renter_type.getSelectedItem().toString().equals("New Renter") && !textField_personal_id.getText().equals("") 
						&& !textField_name.getText().equals("") && !textField_surname.getText().equals("")
						&& !textField_occupation.getText().equals("")&& !textField_username.getText().equals("")
						&& !textField_phone.getText().equals("") && !comboBox_room_id.getSelectedItem().toString().equals("") && !comboBox_month.getSelectedItem().toString().equals("")
						/*&& !passwordField.getText().toString().equals("")*/&& imagepanel.getImage() != null
						&& !textField_water.getText().equals("") && !textField_electric.getText().equals("")
						&& !textField_car.getText().equals("")&& !textField_motorcycle.getText().equals("") && !comboBox_internet.getSelectedItem().toString().equals(""))
						||(comboBox_renter_type.getSelectedItem().toString().equals("Old Renter"))
						&& !textField_personal_id.getText().equals("") && !comboBox_room_id.getSelectedItem().toString().equals("")
						&& !comboBox_month.getSelectedItem().toString().equals("") /*&& !passwordField.getText().toString().equals("")*/
						&& !textField_water.getText().equals("") && !textField_electric.getText().equals("")
						&& !textField_car.getText().equals("")&& !textField_motorcycle.getText().equals("") && !comboBox_internet.getSelectedItem().toString().equals(""))
				{
					String rid = comboBox_room_id.getSelectedItem().toString();
					String monthx = comboBox_month.getSelectedItem().toString();
					boolean isoccu = RenterManager.IsOccupy(rid, monthx);
					System.out.println(isoccu);
					if(!isoccu)
					{
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
						Date checkin = new Date(Calendar.getInstance().getTime().getTime());
				
				
						String room_id = comboBox_room_id.getSelectedItem().toString();
						String xmonth = comboBox_month.getSelectedItem().toString(); 
						String username = textField_username.getText();
						String pass = passwordField.getPassword().toString();
						int water = Integer.parseInt(textField_water.getText());
						int electric = Integer.parseInt(textField_electric.getText());
						int car = Integer.parseInt(textField_car.getText());
						int motorcycle = Integer.parseInt(textField_motorcycle.getText());
						String internet = comboBox_internet.getSelectedItem().toString();
						BufferedImage ximage = (BufferedImage) imagepanel.getImage();
				
						RenterDB data = new RenterDB(0,personal_id,name,surname,phone,house_number,road,soi,tambon,district,province,postal_code,occupation,company_name,salary,checkin,ximage);
//						System.out.println(data.renter_id + "," + data.personal_id + "," + data.name + "," + data.surname + "," + data.phone + "," + data.house_number + "," + data.road + "," + data.soi + "," + data.tambon + "," + data.district + "," + data.province + "," + data.postal_code + "," + data.occupation + "," +data.company_name+ "," + data.salary + "," + data.checkin+","+data.checkout);
//						RenterManager.saveNewUser(data);
						int renter_id = RenterManager.saveNewUser(data);						
						JOptionPane.showMessageDialog(RenterRegisframe.this, "New Renter Added!!");
						System.out.println(renter_id);
						
						UserDB newuser = new UserDB(0,username,pass,"User",renter_id);
						UserManager.saveNewUser(newuser);
						JOptionPane.showMessageDialog(RenterRegisframe.this, "New User Added!!");
						
						RenterManager.InsertRenterToRoom(room_id, renter_id,xmonth);
						
						RoomdataDB x = new RoomdataDB(room_id,xmonth,water,electric,car,motorcycle,internet);
						RoomdataManager.editRoomdata(x);
						RoomsummaryDB total = new RoomsummaryDB();
						total = RoomdataManager.getRoomsummary(x);
						RoomdataManager.editRoomsummary(total);
					
						OwnerManager.editcheckin(xmonth);
								
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
						comboBox_room_id.setSelectedIndex(-1);
						comboBox_month.setSelectedIndex(-1);
						textField_username.setText(""); 
						passwordField.setText("");
						textField_water.setText("");
						textField_electric.setText("");
						textField_car.setText("");
						textField_motorcycle.setText("");
						comboBox_internet.setSelectedIndex(-1);
						imagepanel.setImage(null);
					}
					else
					{
						JOptionPane.showMessageDialog(RenterRegisframe.this, "This room has been occupied,Selected another room.","Registration Warning",JOptionPane.WARNING_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(RenterRegisframe.this, "Fill all data","Registration Warning",JOptionPane.WARNING_MESSAGE);
				}
			}			

			
		});
		btnRegister.setEnabled(false);
		btnRegister.setBounds(481, 230, 115, 23);
		contentPane.add(btnRegister);
		
		JLabel Room_id = new JLabel("Room_id");
		Room_id.setBounds(54, 510, 67, 14);
		contentPane.add(Room_id);
		
		comboBox_renter_type = new JComboBox();
		comboBox_renter_type.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_renter_type.getSelectedItem().toString().equals("New Renter"))
				{
					textField_personal_id.setEditable(true);
					textField_name.setEditable(true);
					textField_surname.setEditable(true);
					textField_phone.setEditable(true);
					textField_housenumber.setEditable(true);
					textField_road.setEditable(true);
					textField_soi.setEditable(true);
					textField_tambon.setEditable(true);
					textField_district.setEditable(true);
					textField_province.setEditable(true);
					textField_postal_code.setEditable(true);
					textField_occupation.setEditable(true);
					textField_company_name.setEditable(true);
					textField_username.setEditable(true);
					comboBox_room_id.setEnabled(true);;
					passwordField.setEditable(true);
					comboBox_salary.setEnabled(true);
					comboBox_month.setEnabled(true);
					btnRegister.setEnabled(true);
					btnbrowseimage.setEnabled(true);
					textField_water.setEnabled(true);
					textField_electric.setEnabled(true);
					textField_car.setEnabled(true);
					textField_motorcycle.setEnabled(true);
					comboBox_internet.setEnabled(true);
					
					
				}
				else if(comboBox_renter_type.getSelectedItem().toString().equals("Old Renter"))
				{	
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
					textField_username.setText("");					
					passwordField.setText("");
					
					textField_name.setEditable(false);
					textField_surname.setEditable(false);
					textField_phone.setEditable(false);
					textField_housenumber.setEditable(false);
					textField_road.setEditable(false);
					textField_soi.setEditable(false);
					textField_tambon.setEditable(false);
					textField_district.setEditable(false);
					textField_province.setEditable(false);
					textField_postal_code.setEditable(false);
					textField_occupation.setEditable(false);
					textField_company_name.setEditable(false);
					textField_username.setEditable(false);					
					passwordField.setEditable(false);
					comboBox_salary.setEnabled(false);
					textField_personal_id.setEditable(true);
					comboBox_room_id.setEnabled(true);
					comboBox_month.setEnabled(true);
					btnRegister.setEnabled(true);
					textField_water.setEnabled(true);
					textField_electric.setEnabled(true);
					textField_car.setEnabled(true);
					textField_motorcycle.setEnabled(true);
					comboBox_internet.setEnabled(true);
				}
				else
				{
					textField_personal_id.setEditable(false);
					textField_name.setEditable(false);
					textField_surname.setEditable(false);
					textField_phone.setEditable(false);
					textField_housenumber.setEditable(false);
					textField_road.setEditable(false);
					textField_soi.setEditable(false);
					textField_tambon.setEditable(false);
					textField_district.setEditable(false);
					textField_province.setEditable(false);
					textField_postal_code.setEditable(false);
					textField_occupation.setEditable(false);
					textField_company_name.setEditable(false);
					textField_username.setEditable(false);
					comboBox_room_id.setEnabled(false);
					passwordField.setEditable(false);
					comboBox_salary.setEnabled(false);
					comboBox_month.setEnabled(false);
					btnRegister.setEnabled(false);
					btnbrowseimage.setEnabled(false); 
					textField_water.setEnabled(false);
					textField_electric.setEnabled(false);
					textField_car.setEnabled(false);
					textField_motorcycle.setEnabled(false);
					comboBox_internet.setEnabled(false);
				}
			}
		});
		comboBox_renter_type.setModel(new DefaultComboBoxModel(new String[] {"", "New Renter", "Old Renter"}));
		comboBox_renter_type.setBounds(372, 62, 115, 20);
		contentPane.add(comboBox_renter_type);
		
		JLabel lblNewLabel = new JLabel("Renter Type");
		lblNewLabel.setBounds(277, 65, 67, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RenterRegisframe.this.setVisible(false);
			}
		});
		btnCancel.setBounds(606, 230, 115, 23);
		contentPane.add(btnCancel);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(416, 93, 334, 207);
		contentPane.add(separator);
		
		JLabel lblPostalcode = new JLabel("Postal code");
		lblPostalcode.setBounds(55, 391, 80, 14);
		contentPane.add(lblPostalcode);
		
		textField_postal_code = new JTextField();
		textField_postal_code.setEditable(false);
		textField_postal_code.setColumns(10);
		textField_postal_code.setBounds(145, 388, 200, 20);
		contentPane.add(textField_postal_code);
		
		comboBox_room_id = new JComboBox();
		comboBox_room_id.setEnabled(false);
		comboBox_room_id.setModel(new DefaultComboBoxModel(new String[] {"", "101", "102", "103", "104", "105", "201", "202", "203", "204", "205", "301", "302", "303", "304", "305", "401", "402", "403", "404", "405", "501", "502", "503", "504", "505"}));
		comboBox_room_id.setBounds(145, 507, 200, 20);
		contentPane.add(comboBox_room_id);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(55, 65, 67, 14);
		contentPane.add(lblMonth);
		
		comboBox_month = new JComboBox();
		comboBox_month.setEnabled(false);
		comboBox_month.setModel(new DefaultComboBoxModel(new String[] {"", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_month.setBounds(150, 62, 115, 20);
		contentPane.add(comboBox_month);
		
		imagepanel = new ImagePanel();
		imagepanel.setForeground(Color.BLACK);
		imagepanel.setBounds(505, 335, 179, 207);
		contentPane.add(imagepanel);
		imagepanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnbrowseimage = new JButton("Browse Image");
		btnbrowseimage.setEnabled(false);
		btnbrowseimage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.addChoosableFileFilter(new OpenFileFilter("jpeg","Photo in JPEG format") );
				fc.addChoosableFileFilter(new OpenFileFilter("jpg","Photo in JPEG format") );
				fc.addChoosableFileFilter(new OpenFileFilter("png","PNG image") );
				fc.addChoosableFileFilter(new OpenFileFilter("svg","Scalable Vector Graphic") );
				int returnVal = fc.showOpenDialog(RenterRegisframe.this);
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
					File f = fc.getSelectedFile();
					try {
						BufferedImage bimg = ImageIO.read(f);
						imagepanel.setImage(bimg);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnbrowseimage.setBounds(542, 565, 115, 23);
		contentPane.add(btnbrowseimage);
		
		JLabel label_2 = new JLabel("Water(unit)");
		label_2.setBounds(55, 538, 60, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Electricity(unit)");
		label_3.setBounds(55, 569, 78, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Car(unit)");
		label_4.setBounds(55, 600, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Motorcycle(unit)");
		label_5.setBounds(55, 633, 78, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Internet");
		label_6.setBounds(55, 664, 46, 14);
		contentPane.add(label_6);
		
		textField_water = new JTextField();
		textField_water.setEnabled(false);
		textField_water.setColumns(10);
		textField_water.setBounds(145, 535, 200, 20);
		contentPane.add(textField_water);
		
		comboBox_internet = new JComboBox();
		comboBox_internet.setEnabled(false);
		comboBox_internet.setModel(new DefaultComboBoxModel(new String[] {"", "Yes", "No"}));
		comboBox_internet.setBounds(145, 661, 200, 20);
		contentPane.add(comboBox_internet);
		
		textField_electric = new JTextField();
		textField_electric.setEnabled(false);
		textField_electric.setColumns(10);
		textField_electric.setBounds(145, 566, 200, 20);
		contentPane.add(textField_electric);
		
		textField_car = new JTextField();
		textField_car.setEnabled(false);
		textField_car.setColumns(10);
		textField_car.setBounds(145, 597, 200, 20);
		contentPane.add(textField_car);
		
		textField_motorcycle = new JTextField();
		textField_motorcycle.setEnabled(false);
		textField_motorcycle.setColumns(10);
		textField_motorcycle.setBounds(145, 630, 200, 20);
		contentPane.add(textField_motorcycle);
	}
}

class OpenFileFilter extends FileFilter {

    String description = "";
    String fileExt = "";

    public OpenFileFilter(String extension) {
        fileExt = extension;
    }

    public OpenFileFilter(String extension, String typeDescription) {
        fileExt = extension;
        this.description = typeDescription;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        return (f.getName().toLowerCase().endsWith(fileExt));
    }

    @Override
    public String getDescription() {
        return description;
    }

	public boolean accept2(File f) {
		// TODO Auto-generated method stub
		return false;
	}
}
