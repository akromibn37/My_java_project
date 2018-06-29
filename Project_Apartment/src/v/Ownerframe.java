package v;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import m.OwnerDB;
import m.OwnerManager;
import m.RoomsummaryDB;
import m.SummaryManager;
import m.UserDB;
import m.UserManager;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class Ownerframe extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Ownerframe frame = new Ownerframe();
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
	public Ownerframe() {
		setTitle("Owner Status");
		setBounds(100, 100, 504, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 468, 385);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		load();
	}
	public void load()
	{
		String[] month = new String[]{"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String[] room_id = new String[]{"101", "102", "103", "104", "105", "201", "202", "203", "204", "205", "301", "302", "303", "304", "305", "401", "402", "403", "404", "405", "501", "502", "503", "504", "505"};
		ArrayList<RoomsummaryDB> aa = new ArrayList<RoomsummaryDB>();
		
		int occupied = 0;
		int vacant = 0;
		int total = 0;
		
		for(int i = 0;i<month.length;i++)
		{
			occupied = 0;
			vacant = 0;
			total = 0;
			
			aa = SummaryManager.getAllUserForOwner(month[i]);
			for(int j = 0;j<aa.size();j++)
			{
				total += aa.get(j).total;
				if(aa.get(j).occupy_status.equals("Yes"))
				{
					occupied++;
				}
				else if(aa.get(j).occupy_status.equals("No"))
				{
					vacant++;
				}
			}				
			
			OwnerManager.editdata(occupied, vacant, total, month[i]);
		}
		
		ArrayList<OwnerDB> list;
		list = OwnerManager.getAllUser();		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Month_id");
		model.addColumn("Month");
		model.addColumn("Occupy");
		model.addColumn("Vacant");
		model.addColumn("Total");
		model.addColumn("Check-in");
		model.addColumn("Check-out");
		
		for(OwnerDB c : list)
		{
//			System.out.println("xxxxxxxxx");
//			System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
			model.addRow(new Object[]{"" + c.month_id,c.month,c.occupied,c.vacant,c.total,c.checkin,c.checkout});
		}
		table.setModel(model);
	}
}
