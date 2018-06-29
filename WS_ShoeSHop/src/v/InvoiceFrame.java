package v;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import m.CompanyInfoDB;
import m.CompanyInfoManager;
import m.CustomerDB;
import m.ProductDB;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import m.*;

public class InvoiceFrame extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	CustomerDB xCustomer;
	public JScrollPane scrollPane;
	
	ArrayList<InvoiceDetail> detailList;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					InvoiceFrame frame = new InvoiceFrame();
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
	public InvoiceFrame() 
	{		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		setBounds(0, 0, 804, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panel.setBounds(0, 60, getWidth()-20, getHeight()-100);
			}
		});
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 60, 782, 668);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0E43\u0E1A\u0E40\u0E2A\u0E23\u0E47\u0E08\u0E23\u0E31\u0E1A\u0E40\u0E07\u0E34\u0E19");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("AngsanaUPC", Font.BOLD, 30));
		lblNewLabel.setBounds(186, 0, 152, 68);
		panel.add(lblNewLabel);
		
		JLabel lblCompanyInfo = new JLabel("Company Info");
		lblCompanyInfo.setFont(new Font("AngsanaUPC", Font.PLAIN, 16));
		lblCompanyInfo.setBounds(56, 91, 511, 14);
		panel.add(lblCompanyInfo);
		
		JLabel lblCustomerInfo = new JLabel("Customer Info");
		lblCustomerInfo.setBounds(168, 116, 399, 14);
		panel.add(lblCustomerInfo);
		
		JLabel label = new JLabel("\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14");
		label.setFont(new Font("AngsanaUPC", Font.PLAIN, 17));
		label.setBounds(57, 159, 78, 22);
		panel.add(label);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(429, 67, 138, 14);
		panel.add(lblDate);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 186, 511, 421);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("AngsanaUPC", Font.PLAIN, 17));
		scrollPane.setViewportView(table);
		
		JButton btnSelectCustomer = new JButton("Select Customer");
		btnSelectCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCustomer cc = new SearchCustomer();
				cc.setSelectCustomerI(new SelectCustomerI() {
					
					@Override
					public void select(CustomerDB x) {
						xCustomer = x;
						String s = x.name + " " +x.surname + "(" + x.phone + ") (id " + x.id + ")";
						lblCustomerInfo.setText(s);
						
					}
				});
				cc.setVisible(true);
			}
		});
		btnSelectCustomer.setBounds(10, 11, 111, 23);
		contentPane.add(btnSelectCustomer);
		
		JButton btnNewButton = new JButton("Select Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchProduct ss = new SearchProduct();
				ss.setSelectProductI(new SelectProductI() {
					
					@Override
					public void select(ProductDB x) {
						
						setDetail(x);
					}			
					
				});
				ss.setVisible(true);
			
			}
		});
		btnNewButton.setBounds(131, 11, 118, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(xCustomer == null)
				{
					
				}
				InvoiceManeger.saveInvoice(xCustomer, detailList);
			}
		});
		btnSave.setBounds(259, 11, 118, 23);
		contentPane.add(btnSave);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setPrintable(new InvoicePrint(InvoiceFrame.this));
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
		btnPrint.setBounds(387, 11, 111, 23);
		contentPane.add(btnPrint);
		
		CompanyInfoDB x = CompanyInfoManager.getCompanyInfo();
		String CompanyInfo = x.company_name + " ที่อยู่ :" + x.address + " โทร." +x.phone + " email : " + x.email;
		lblCompanyInfo.setText(CompanyInfo);
		lblDate.setText(new SimpleDateFormat().format(Calendar.getInstance().getTime()).toString());
		
		JLabel label_1 = new JLabel("\u0E44\u0E14\u0E49\u0E23\u0E31\u0E1A\u0E40\u0E07\u0E34\u0E19\u0E08\u0E32\u0E01");
		label_1.setFont(new Font("AngsanaUPC", Font.PLAIN, 17));
		label_1.setBounds(56, 116, 86, 14);
		panel.add(label_1);
		detailList = new ArrayList<InvoiceDetail>();
	}
	public void setDetail(ProductDB xProduct)
	{
		InvoiceDetail x = new InvoiceDetail();
		x.no = detailList.size() +1;
		x.price_per_unit = xProduct.price_per_unit;
		x.productName = xProduct.product_name;
		x.qty =2;
		x.totalPrice =x.price_per_unit*x.qty;
		x.product = xProduct;
		detailList.add(x);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("no");
		model.addColumn("image");
		model.addColumn("price_per_unit");
		model.addColumn("productName");
		model.addColumn("qty");
		model.addColumn("totalPrice");
		
		for(InvoiceDetail c : detailList)
		{
//			System.out.println("xxxxxxxxx");
//			System.out.println(c.product_id+" " +c.product_name +" "+c.price_per_unit+" "+c.product_description);
			model.addRow(new Object[]{c.no,c.product.product_image,c.price_per_unit,c.productName,c.qty,c.totalPrice});
		}
		table.setModel(model);
		table.getColumn("image").setCellRenderer(new InvoiceDetailTableRenderer());
		
		for(int i = 0;i<table.getRowCount();i++ )
		{
			table.setRowHeight(i,120);
		}
	}
}

class InvoiceDetailTableRenderer extends DefaultTableCellRenderer implements TableCellRenderer
{
	@Override
	public Component getTableCellRendererComponent
		(JTable talbe,Object value,boolean isSelected,boolean hasFocus,int row,int col)
	{
		ImageComponent i = new ImageComponent();
		i.image = (BufferedImage)value;
		return i;		
	}
}

class ImageComponent extends JComponent
{
	public BufferedImage image;
	
	public void paint(Graphics g)
	{
		if(image != null)
		{
			g.drawImage(image, 0, 0, 120, 120, 0, 0, image.getWidth(), image.getHeight(), this);
		}
	}
}

class InvoicePrint implements Printable
{
	InvoiceFrame xFrame;
	public InvoicePrint(InvoiceFrame frame)
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
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		
		for(int i=0;i< xFrame.panel.getComponentCount() ;i++)
		{
			Component c = xFrame.panel.getComponent(i);
			if(c instanceof JLabel)
			{
				JLabel l = (JLabel) c;
				g2d.setFont(l.getFont());
				g2d.drawString(l.getText(), 
						(int)(l.getLocation().getX()-50), 
						(int)(l.getLocation().getY() + l.getHeight()));
			}
		}
		int x = 10;
		int y = (int)(xFrame.scrollPane.getLocation().getY()+40); 
		
		for(int i = 0;i< xFrame.table.getColumnCount(); i++)
		{
			g2d.setFont(xFrame.table.getFont());
			g2d.drawString(xFrame.table.getColumnName(i), 
					x,y);
			
			x+= xFrame.table.getColumn(xFrame.table.getColumnName(i)).getWidth();
		}
		
		y += 40;
		for(int j = 0;j< xFrame.table.getRowCount(); j++)
		{
			x = 10;
			for(int i = 0;i< xFrame.table.getColumnCount(); i++)
			{
				if(xFrame.table.getColumnName(i).equals("image"))
				{
					BufferedImage image = (BufferedImage) xFrame.table.getValueAt(j, i);
					g.drawImage(image, x, y, x+120, y+120, 0, 0, image.getWidth(), image.getHeight(), null);
				}
				else
				{
					g2d.setFont(xFrame.table.getFont());
					g2d.drawString("" + xFrame.table.getValueAt(j, i),x,y);
				}
				x+= xFrame.table.getColumn(xFrame.table.getColumnName(i)).getWidth();
			}
			y += xFrame.table.getRowHeight(j);
		}
		
		return PAGE_EXISTS;
	}
}
