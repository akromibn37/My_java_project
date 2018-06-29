package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import m.RenterManager;
import m.RoomsummaryDB;
import m.SummaryManager;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

public class Invoiceframe extends JFrame {

	private JPanel contentPane;
	private JButton btnPay;
	private JButton btnPrint;
	private JLabel label;
	private JLabel label_2;
	private JLabel label_price;
	private JLabel label_4;
	private JLabel label_water;
	private JLabel label_6;
	private JLabel label_electric;
	private JLabel label_8;
	private JLabel label_car;
	private JLabel label_motor;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_internet;
	private JLabel label_14;
	private JLabel label_total;
	private JLabel label_month;
	private JLabel label_17;
	JPanel panel;
	private JLabel lblBaht;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_roomnumber;
	private JLabel label_1;
	private JLabel label_occupy;
	private JLabel label_5;
	private JLabel label_pay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoiceframe frame = new Invoiceframe();
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
	public Invoiceframe() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 365, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnPay = new JButton("Pay");
		btnPay.setEnabled(false);
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RenterManager.UpdatePayment(label_roomnumber.getText().toString(),label_month.getText().toString());
				load(label_month.getText().toString(),label_roomnumber.getText().toString());
			}
		});
		btnPay.setBounds(104, 385, 147, 23);
		contentPane.add(btnPay);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				PrinterJob job = PrinterJob.getPrinterJob();
				
				PageFormat pf = job.defaultPage();
			    Paper paper = new Paper();
			    double margin = 0; // half inch
			    paper.setSize(250, 350);
			    paper.setImageableArea(margin, margin,300, 400);
			    pf.setPaper(paper);
				job.setPrintable(new InvoicePrint(Invoiceframe.this),pf);
				boolean doPrint = job.printDialog();
				if(doPrint)
				{
					try {
						job.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnPrint.setBounds(104, 419, 147, 23);
		contentPane.add(btnPrint);
		
		label_1 = new JLabel("Occupy");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1.setBounds(84, 325, 58, 34);
		contentPane.add(label_1);
		
		label_occupy = new JLabel("");
		label_occupy.setHorizontalAlignment(SwingConstants.CENTER);
		label_occupy.setForeground(new Color(0, 0, 153));
		label_occupy.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_occupy.setBackground(new Color(51, 204, 51));
		label_occupy.setBounds(136, 325, 72, 20);
		contentPane.add(label_occupy);
		
		label_5 = new JLabel("Pay");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_5.setBounds(94, 352, 44, 34);
		contentPane.add(label_5);
		
		label_pay = new JLabel("");
		label_pay.setHorizontalAlignment(SwingConstants.CENTER);
		label_pay.setForeground(new Color(0, 0, 153));
		label_pay.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_pay.setBackground(new Color(51, 204, 51));
		label_pay.setBounds(136, 354, 72, 20);
		contentPane.add(label_pay);
		
		panel = new JPanel();
		panel.setBounds(22, 11, 300, 303);
		contentPane.add(panel);
		panel.setLayout(null);
		
		label_17 = new JLabel("Month");
		label_17.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_17.setBounds(102, 11, 44, 34);
		panel.add(label_17);
		
		label_month = new JLabel("hhh");
		label_month.setForeground(new Color(0, 0, 153));
		label_month.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_month.setBackground(new Color(51, 204, 51));
		label_month.setBounds(155, 18, 97, 20);
		panel.add(label_month);
		
		label = new JLabel("Room");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(102, 41, 44, 34);
		panel.add(label);
		
		label_18 = new JLabel("Baht");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_18.setBounds(237, 72, 44, 34);
		panel.add(label_18);
		
		label_2 = new JLabel("Price");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_2.setBounds(102, 72, 44, 34);
		panel.add(label_2);
		
		label_price = new JLabel("");
		label_price.setForeground(new Color(0, 0, 153));
		label_price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_price.setBackground(new Color(51, 204, 51));
		label_price.setBounds(155, 78, 72, 20);
		panel.add(label_price);
		
		lblBaht = new JLabel("Baht");
		lblBaht.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaht.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblBaht.setBounds(237, 41, 44, 34);
		panel.add(lblBaht);
		
		label_4 = new JLabel("Water");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_4.setBounds(102, 102, 44, 34);
		panel.add(label_4);
		
		label_water = new JLabel("");
		label_water.setForeground(new Color(0, 0, 153));
		label_water.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_water.setBackground(new Color(51, 204, 51));
		label_water.setBounds(155, 109, 72, 20);
		panel.add(label_water);
		
		label_19 = new JLabel("Baht");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_19.setBounds(237, 102, 44, 34);
		panel.add(label_19);
		
		label_6 = new JLabel("Electricity");
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_6.setBounds(87, 134, 60, 34);
		panel.add(label_6);
		
		label_electric = new JLabel("");
		label_electric.setForeground(new Color(0, 0, 153));
		label_electric.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_electric.setBackground(new Color(51, 204, 51));
		label_electric.setBounds(155, 140, 72, 20);
		panel.add(label_electric);
		
		label_20 = new JLabel("Baht");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_20.setBounds(237, 134, 44, 34);
		panel.add(label_20);
		
		label_8 = new JLabel("Car");
		label_8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_8.setBounds(102, 167, 44, 34);
		panel.add(label_8);
		
		label_car = new JLabel("");
		label_car.setForeground(new Color(0, 0, 153));
		label_car.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_car.setBackground(new Color(51, 204, 51));
		label_car.setBounds(155, 171, 72, 20);
		panel.add(label_car);
		
		label_21 = new JLabel("Baht");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_21.setBounds(237, 167, 44, 34);
		panel.add(label_21);
		
		label_11 = new JLabel("Motorcycle");
		label_11.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_11.setBounds(72, 202, 74, 27);
		panel.add(label_11);
		
		label_motor = new JLabel("");
		label_motor.setForeground(new Color(0, 0, 153));
		label_motor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_motor.setBackground(new Color(51, 204, 51));
		label_motor.setBounds(155, 202, 72, 20);
		panel.add(label_motor);
		
		label_22 = new JLabel("Baht");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_22.setBounds(237, 198, 44, 34);
		panel.add(label_22);
		
		label_12 = new JLabel("Internet");
		label_12.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_12.setBounds(88, 229, 58, 34);
		panel.add(label_12);
		
		label_internet = new JLabel("");
		label_internet.setForeground(new Color(0, 0, 153));
		label_internet.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_internet.setBackground(new Color(51, 204, 51));
		label_internet.setBounds(155, 233, 72, 20);
		panel.add(label_internet);
		
		label_23 = new JLabel("Baht");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_23.setBounds(237, 229, 44, 34);
		panel.add(label_23);
		
		label_14 = new JLabel("Total");
		label_14.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_14.setBounds(102, 259, 44, 34);
		panel.add(label_14);
		
		label_total = new JLabel("");
		label_total.setForeground(new Color(0, 0, 153));
		label_total.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_total.setBackground(new Color(51, 204, 51));
		label_total.setBounds(155, 264, 72, 20);
		panel.add(label_total);
		
		label_24 = new JLabel("Baht");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_24.setBounds(237, 259, 44, 34);
		panel.add(label_24);
		
		label_roomnumber = new JLabel("");
		label_roomnumber.setForeground(new Color(0, 0, 153));
		label_roomnumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_roomnumber.setBackground(new Color(51, 204, 51));
		label_roomnumber.setBounds(155, 49, 72, 20);
		panel.add(label_roomnumber);
		
		
	}
	
	public void load(String xmonth,String xid)
	{
		RoomsummaryDB list = new RoomsummaryDB();
		list = SummaryManager.getUser(xmonth, xid);
		label_roomnumber.setText(list.room_id);
		label_price.setText(Integer.toString(list.room_price));
		label_water.setText(Integer.toString(list.water_sum));
		label_electric.setText(Integer.toString(list.electric_sum));
		label_car.setText(Integer.toString(list.car_sum));
		label_motor.setText(Integer.toString(list.motor_sum));
		label_internet.setText(Integer.toString(list.internet_sum));
		label_total.setText(Integer.toString(list.total));
		label_occupy.setText(list.occupy_status);
		label_pay.setText(list.pay_status);	
		label_month.setText(list.month);
		
		if(list.occupy_status.equals("Yes") && list.pay_status.equals("No"))
		{
			btnPay.setEnabled(true);
			btnPrint.setEnabled(true);
		}
		else
		{
			btnPay.setEnabled(false);
			btnPrint.setEnabled(false);
		}
		
	}
	
	public void loadforuser(String xmonth,String xid)
	{
		RoomsummaryDB list = new RoomsummaryDB();
		list = SummaryManager.getUser(xmonth, xid);
		label_roomnumber.setText(list.room_id);
		label_price.setText(Integer.toString(list.room_price));
		label_water.setText(Integer.toString(list.water_sum));
		label_electric.setText(Integer.toString(list.electric_sum));
		label_car.setText(Integer.toString(list.car_sum));
		label_motor.setText(Integer.toString(list.motor_sum));
		label_internet.setText(Integer.toString(list.internet_sum));
		label_total.setText(Integer.toString(list.total));
		label_occupy.setText(list.occupy_status);
		label_pay.setText(list.pay_status);	
		label_month.setText(list.month);
				
		btnPay.setEnabled(false);
		btnPrint.setEnabled(false);		
	}
}

class InvoicePrint implements Printable
{
	Invoiceframe xFrame;
	public InvoicePrint(Invoiceframe frame)
	{
		xFrame = frame;
	}
	@Override
	public int print(Graphics g,PageFormat pf,int page) throws PrinterException
	{
		if(page > 0)
		{
			return NO_SUCH_PAGE;
		}
		Graphics2D g2d = (Graphics2D) g;
//		g2d.translate(pf.getImageableX(), pf.getImageableY());
		int x = xFrame.panel.getComponentCount();
		System.out.println(x);
		for(int i=0;i< xFrame.panel.getComponentCount() ;i++)
		{
			Component c = xFrame.panel.getComponent(i);
			if(c instanceof JLabel)
			{
				JLabel l = (JLabel) c;
				g2d.setFont(l.getFont());
				g2d.drawString(l.getText(), 
						(int)(l.getLocation().getX()-50), 
						(int)(l.getLocation().getY()+ l.getHeight()));
				System.out.println(l.getText().toString());
			}
		}	
		
		return PAGE_EXISTS;
	}
}

