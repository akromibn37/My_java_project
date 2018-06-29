package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import m.AdminDB;
import m.AdminManager;
import m.OwnerManager;
import m.RenterManager;

import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Adminframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField_101;
	private JTextField textField_102;
	private JTextField textField_103;
	private JTextField textField_104;
	private JTextField textField_105;
	private JTextField textField_201;
	private JTextField textField_202;
	private JTextField textField_203;
	private JTextField textField_204;
	private JTextField textField_205;
	private JTextField textField_301;
	private JTextField textField_302;
	private JTextField textField_303;
	private JTextField textField_304;
	private JTextField textField_305;
	private JTextField textField_401;
	private JTextField textField_402;
	private JTextField textField_403;
	private JTextField textField_404;
	private JTextField textField_405;
	private JTextField textField_501;
	private JTextField textField_502;
	private JTextField textField_503;
	private JTextField textField_504;
	private JTextField textField_505;
	private JComboBox comboBox;
	private JButton btnViewRenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Adminframe frame = new Adminframe();
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
	public Adminframe() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String month = comboBox.getSelectedItem().toString();
				loadone(month);
			}
		});
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCheckIn = new JButton("Check-in");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RenterRegisframe f =new RenterRegisframe();
				f.setVisible(true);
			}
		});
		btnCheckIn.setBounds(391, 64, 102, 23);
		contentPane.add(btnCheckIn);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(365, 20, 146, 23);
		contentPane.add(lblTime);
		lblTime.setText(new SimpleDateFormat().format(Calendar.getInstance().getTime()).toString());
		
		JButton btnCheckOut = new JButton("Check-out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String xx = JOptionPane.showInputDialog(Adminframe.this, "Room number", "Check-Out", JOptionPane.QUESTION_MESSAGE);
				if(isNumeric(xx))
				{
					if(RenterManager.Isroom(xx))
					{
						String mm = JOptionPane.showInputDialog(Adminframe.this, "Month", "Check-Out", JOptionPane.QUESTION_MESSAGE);
						if(RenterManager.checkPayment(xx, mm))
						{
							String rt_id = RenterManager.GetRenterID(xx, mm);
							RenterManager.UpdateCheckout(xx, mm, rt_id);
							OwnerManager.editcheckout(mm);
							System.out.println("Finished");
						}
						else
						{
							 JOptionPane.showMessageDialog(Adminframe.this, "Cannot find month Or Payment is not cleared,Clear Payment first", "Check-Out", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(Adminframe.this, "Sorry,We not have this room", "Check-Out", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(Adminframe.this, "Enter only number","Check-Out",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCheckOut.setBounds(391, 98, 102, 23);
		contentPane.add(btnCheckOut);
		
		JButton btnFillData = new JButton("Fill data");
		btnFillData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Roomdataframe f =new Roomdataframe();
				f.setVisible(true);
			}
		});
		btnFillData.setBounds(391, 132, 102, 23);
		contentPane.add(btnFillData);
		
		comboBox = new JComboBox();		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String month = comboBox.getSelectedItem().toString();
				loadone(month);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(98, 21, 141, 20);
		contentPane.add(comboBox);
		
		JButton btnChangeRate = new JButton("Change Rate");
		btnChangeRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Roomrateframe f =new Roomrateframe();
				f.setVisible(true);
			}
		});
		btnChangeRate.setBounds(391, 166, 102, 23);
		contentPane.add(btnChangeRate);
		
		JButton btnSummary = new JButton("Summary");
		btnSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Summaryframe f =new Summaryframe();
				f.setVisible(true);
			}
		});
		btnSummary.setBounds(391, 200, 102, 23);
		contentPane.add(btnSummary);
		
		JButton btnViewUser = new JButton("View User");
		btnViewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Userframe f =new Userframe();
				f.setVisible(true);
			}
		});
		btnViewUser.setBounds(391, 234, 102, 23);
		contentPane.add(btnViewUser);
		
		textField_101 = new JTextField();
		textField_101.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "101";
				f.load(xmonth, xid);
			}
		});
		textField_101.setEditable(false);
		textField_101.setHorizontalAlignment(SwingConstants.CENTER);
		textField_101.setText("101");
		textField_101.setBounds(10, 65, 65, 20);
		contentPane.add(textField_101);
		textField_101.setColumns(10);
		
		textField_102 = new JTextField();
		textField_102.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "102";
				f.load(xmonth, xid);
			}
		});
		textField_102.setEditable(false);
		textField_102.setText("102");
		textField_102.setHorizontalAlignment(SwingConstants.CENTER);
		textField_102.setColumns(10);
		textField_102.setBounds(74, 65, 65, 20);
		contentPane.add(textField_102);
		
		textField_103 = new JTextField();
		textField_103.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "103";
				f.load(xmonth, xid);
			}
		});
		textField_103.setEditable(false);
		textField_103.setText("103");
		textField_103.setHorizontalAlignment(SwingConstants.CENTER);
		textField_103.setColumns(10);
		textField_103.setBounds(138, 65, 65, 20);
		contentPane.add(textField_103);
		
		textField_104 = new JTextField();
		textField_104.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "104";
				f.load(xmonth, xid);
			}
		});
		textField_104.setEditable(false);
		textField_104.setText("104");
		textField_104.setHorizontalAlignment(SwingConstants.CENTER);
		textField_104.setColumns(10);
		textField_104.setBounds(201, 65, 65, 20);
		contentPane.add(textField_104);
		
		textField_105 = new JTextField();
		textField_105.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "105";
				f.load(xmonth, xid);
			}
		});
		textField_105.setEditable(false);
		textField_105.setText("105");
		textField_105.setHorizontalAlignment(SwingConstants.CENTER);
		textField_105.setColumns(10);
		textField_105.setBounds(265, 65, 65, 20);
		contentPane.add(textField_105);
		
		textField_201 = new JTextField();
		textField_201.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "201";
				f.load(xmonth, xid);
			}
		});
		textField_201.setEditable(false);
		textField_201.setText("201");
		textField_201.setHorizontalAlignment(SwingConstants.CENTER);
		textField_201.setColumns(10);
		textField_201.setBounds(10, 98, 65, 20);
		contentPane.add(textField_201);
		
		textField_202 = new JTextField();
		textField_202.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "202";
				f.load(xmonth, xid);
			}
		});
		textField_202.setEditable(false);
		textField_202.setText("202");
		textField_202.setHorizontalAlignment(SwingConstants.CENTER);
		textField_202.setColumns(10);
		textField_202.setBounds(74, 98, 65, 20);
		contentPane.add(textField_202);
		
		textField_203 = new JTextField();
		textField_203.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "203";
				f.load(xmonth, xid);
			}
		});
		textField_203.setEditable(false);
		textField_203.setText("203");
		textField_203.setHorizontalAlignment(SwingConstants.CENTER);
		textField_203.setColumns(10);
		textField_203.setBounds(138, 98, 65, 20);
		contentPane.add(textField_203);
		
		textField_204 = new JTextField();
		textField_204.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "204";
				f.load(xmonth, xid);
			}
		});
		textField_204.setEditable(false);
		textField_204.setText("204");
		textField_204.setHorizontalAlignment(SwingConstants.CENTER);
		textField_204.setColumns(10);
		textField_204.setBounds(201, 98, 65, 20);
		contentPane.add(textField_204);
		
		textField_205 = new JTextField();
		textField_205.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "205";
				f.load(xmonth, xid);
			}
		});
		textField_205.setEditable(false);
		textField_205.setText("205");
		textField_205.setHorizontalAlignment(SwingConstants.CENTER);
		textField_205.setColumns(10);
		textField_205.setBounds(265, 98, 65, 20);
		contentPane.add(textField_205);
		
		textField_301 = new JTextField();
		textField_301.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "301";
				f.load(xmonth, xid);
			}
		});
		textField_301.setEditable(false);
		textField_301.setText("301");
		textField_301.setHorizontalAlignment(SwingConstants.CENTER);
		textField_301.setColumns(10);
		textField_301.setBounds(10, 132, 65, 20);
		contentPane.add(textField_301);
		
		textField_302 = new JTextField();
		textField_302.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "302";
				f.load(xmonth, xid);
			}
		});
		textField_302.setEditable(false);
		textField_302.setText("302");
		textField_302.setHorizontalAlignment(SwingConstants.CENTER);
		textField_302.setColumns(10);
		textField_302.setBounds(74, 132, 65, 20);
		contentPane.add(textField_302);
		
		textField_303 = new JTextField();
		textField_303.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "303";
				f.load(xmonth, xid);
			}
		});
		textField_303.setEditable(false);
		textField_303.setText("303");
		textField_303.setHorizontalAlignment(SwingConstants.CENTER);
		textField_303.setColumns(10);
		textField_303.setBounds(138, 132, 65, 20);
		contentPane.add(textField_303);
		
		textField_304 = new JTextField();
		textField_304.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "304";
				f.load(xmonth, xid);
			}
		});
		textField_304.setEditable(false);
		textField_304.setText("304");
		textField_304.setHorizontalAlignment(SwingConstants.CENTER);
		textField_304.setColumns(10);
		textField_304.setBounds(201, 132, 65, 20);
		contentPane.add(textField_304);
		
		textField_305 = new JTextField();
		textField_305.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "305";
				f.load(xmonth, xid);
			}
		});
		textField_305.setEditable(false);
		textField_305.setText("305");
		textField_305.setHorizontalAlignment(SwingConstants.CENTER);
		textField_305.setColumns(10);
		textField_305.setBounds(265, 132, 65, 20);
		contentPane.add(textField_305);
		
		textField_401 = new JTextField();
		textField_401.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "401";
				f.load(xmonth, xid);
			}
		});
		textField_401.setEditable(false);
		textField_401.setText("401");
		textField_401.setHorizontalAlignment(SwingConstants.CENTER);
		textField_401.setColumns(10);
		textField_401.setBounds(10, 166, 65, 20);
		contentPane.add(textField_401);
		
		textField_402 = new JTextField();
		textField_402.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "402";
				f.load(xmonth, xid);
			}
		});
		textField_402.setEditable(false);
		textField_402.setText("402");
		textField_402.setHorizontalAlignment(SwingConstants.CENTER);
		textField_402.setColumns(10);
		textField_402.setBounds(74, 166, 65, 20);
		contentPane.add(textField_402);
		
		textField_403 = new JTextField();
		textField_403.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "403";
				f.load(xmonth, xid);
			}
		});
		textField_403.setEditable(false);
		textField_403.setText("403");
		textField_403.setHorizontalAlignment(SwingConstants.CENTER);
		textField_403.setColumns(10);
		textField_403.setBounds(138, 166, 65, 20);
		contentPane.add(textField_403);
		
		textField_404 = new JTextField();
		textField_404.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "404";
				f.load(xmonth, xid);
			}
		});
		textField_404.setEditable(false);
		textField_404.setText("404");
		textField_404.setHorizontalAlignment(SwingConstants.CENTER);
		textField_404.setColumns(10);
		textField_404.setBounds(201, 166, 65, 20);
		contentPane.add(textField_404);
		
		textField_405 = new JTextField();
		textField_405.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "405";
				f.load(xmonth, xid);
			}
		});
		textField_405.setEditable(false);
		textField_405.setText("405");
		textField_405.setHorizontalAlignment(SwingConstants.CENTER);
		textField_405.setColumns(10);
		textField_405.setBounds(265, 166, 65, 20);
		contentPane.add(textField_405);
		
		textField_501 = new JTextField();
		textField_501.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "501";
				f.load(xmonth, xid);
			}
		});
		textField_501.setEditable(false);
		textField_501.setText("501");
		textField_501.setHorizontalAlignment(SwingConstants.CENTER);
		textField_501.setColumns(10);
		textField_501.setBounds(10, 200, 65, 20);
		contentPane.add(textField_501);
		
		textField_502 = new JTextField();
		textField_502.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "502";
				f.load(xmonth, xid);
			}
		});
		textField_502.setEditable(false);
		textField_502.setText("502");
		textField_502.setHorizontalAlignment(SwingConstants.CENTER);
		textField_502.setColumns(10);
		textField_502.setBounds(74, 200, 65, 20);
		contentPane.add(textField_502);
		
		textField_503 = new JTextField();
		textField_503.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "503";
				f.load(xmonth, xid);
			}
		});
		textField_503.setEditable(false);
		textField_503.setText("503");
		textField_503.setHorizontalAlignment(SwingConstants.CENTER);
		textField_503.setColumns(10);
		textField_503.setBounds(138, 200, 65, 20);
		contentPane.add(textField_503);
		
		textField_504 = new JTextField();
		textField_504.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "504";
				f.load(xmonth, xid);
			}
		});
		textField_504.setEditable(false);
		textField_504.setText("504");
		textField_504.setHorizontalAlignment(SwingConstants.CENTER);
		textField_504.setColumns(10);
		textField_504.setBounds(201, 200, 65, 20);
		contentPane.add(textField_504);
		
		textField_505 = new JTextField();
		textField_505.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Invoiceframe f =new Invoiceframe();
				f.setVisible(true);
				String xmonth = comboBox.getSelectedItem().toString();
				String xid = "505";
				f.load(xmonth, xid);
			}
		});
		textField_505.setEditable(false);
		textField_505.setText("505");
		textField_505.setHorizontalAlignment(SwingConstants.CENTER);
		textField_505.setColumns(10);
		textField_505.setBounds(265, 200, 65, 20);
		contentPane.add(textField_505);
		
		btnViewRenter = new JButton("View Renter");
		btnViewRenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Renterframe f =new Renterframe();
				f.setVisible(true);
			}
		});
		btnViewRenter.setBounds(391, 268, 102, 23);
		contentPane.add(btnViewRenter);
		
		JButton btnOwnerSummary = new JButton("Owner Summary");
		btnOwnerSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ownerframe f = new Ownerframe();
				f.load();
				f.setVisible(true);
			}
		});
		btnOwnerSummary.setBounds(98, 268, 141, 23);
		contentPane.add(btnOwnerSummary);
		
		String months = "January";
		loadone(months);
	}
	public boolean isNumeric(String s) {
	    return s.matches("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)");
	}
	
	public void loadone(String month)
	{
		ArrayList<AdminDB> list;
		list = AdminManager.CheckOccupy(month);
		
		textField_101.setBackground(Color.WHITE);
		textField_102.setBackground(Color.WHITE);
		textField_103.setBackground(Color.WHITE);
		textField_104.setBackground(Color.WHITE);
		textField_105.setBackground(Color.WHITE);
		textField_201.setBackground(Color.WHITE);
		textField_202.setBackground(Color.WHITE);
		textField_203.setBackground(Color.WHITE);
		textField_204.setBackground(Color.WHITE);
		textField_205.setBackground(Color.WHITE);
		textField_301.setBackground(Color.WHITE);
		textField_302.setBackground(Color.WHITE);
		textField_303.setBackground(Color.WHITE);
		textField_304.setBackground(Color.WHITE);
		textField_305.setBackground(Color.WHITE);
		textField_401.setBackground(Color.WHITE);
		textField_402.setBackground(Color.WHITE);
		textField_403.setBackground(Color.WHITE);
		textField_404.setBackground(Color.WHITE);
		textField_405.setBackground(Color.WHITE);
		textField_501.setBackground(Color.WHITE);
		textField_502.setBackground(Color.WHITE);
		textField_503.setBackground(Color.WHITE);
		textField_504.setBackground(Color.WHITE);
		textField_505.setBackground(Color.WHITE);
		
		int i =0;
		while(i<25)
		{
			if(list.get(i).Status.equals("Yes"))
			{
				switch(i)
			      {
			         case 0 :
			            textField_101.setBackground(new Color(0, 200, 0));
			            break;
			         case 1 :
			        	 textField_102.setBackground(new Color(0, 200, 0));
				         break;
			         case 2 :
			        	 textField_103.setBackground(new Color(0, 200, 0));
				         break;
			         case 3 :
			        	 textField_104.setBackground(new Color(0, 200, 0));
				         break;
			         case 4 :
			        	 textField_105.setBackground(new Color(0, 200, 0));
				         break;
			         case 5 :
				         textField_201.setBackground(new Color(0, 200, 0));
				         break;
				     case 6 :
				         textField_202.setBackground(new Color(0, 200, 0));
					     break;
				     case 7 :
				         textField_203.setBackground(new Color(0, 200, 0));
					     break;
				     case 8 :
				         textField_204.setBackground(new Color(0, 200, 0));
					     break;
				     case 9 :
				         textField_205.setBackground(new Color(0, 200, 0));
					     break;
				     case 10 :
				         textField_301.setBackground(new Color(0, 200, 0));
				         break;
				     case 11 :
				       	 textField_302.setBackground(new Color(0, 200, 0));
					     break;
				     case 12 :
				       	 textField_303.setBackground(new Color(0, 200, 0));
					     break;
				     case 13 :
				       	 textField_304.setBackground(new Color(0, 200, 0));
					     break;
				     case 14 :
				       	 textField_305.setBackground(new Color(0, 200, 0));
					     break;
				     case 15 :
					     textField_401.setBackground(new Color(0, 200, 0));
					     break;
					 case 16 :
					     textField_402.setBackground(new Color(0, 200, 0));
					     break;
					 case 17 :
					     textField_403.setBackground(new Color(0, 200, 0));
					     break;
					 case 18 :
					     textField_404.setBackground(new Color(0, 200, 0));
					     break;
					 case 19 :
					     textField_405.setBackground(new Color(0, 200, 0));
					     break;
					 case 20 :
				         textField_501.setBackground(new Color(0, 200, 0));
				         break;
				     case 21 :
				         textField_502.setBackground(new Color(0, 200, 0));
					     break;
				     case 22 :
				         textField_503.setBackground(new Color(0, 200, 0));
					     break;
				     case 23 :
				         textField_504.setBackground(new Color(0, 200, 0));
					     break;
				     case 24 :
				       	 textField_505.setBackground(new Color(0, 200, 0));
					     break;
			      }
				
			}
			i++;
		}
	}
}
