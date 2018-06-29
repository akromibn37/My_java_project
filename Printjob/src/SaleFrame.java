import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaleFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_name;
	private JTextField textField_totalsell;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SaleFrame frame = new SaleFrame();
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
	public SaleFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 71, 404, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField_name = new JTextField();
		textField_name.setBounds(77, 11, 86, 20);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_totalsell = new JTextField();
		textField_totalsell.setBounds(77, 40, 86, 20);
		contentPane.add(textField_totalsell);
		textField_totalsell.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 14, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblTotalsale = new JLabel("Totalsell");
		lblTotalsale.setBounds(21, 43, 46, 14);
		contentPane.add(lblTotalsale);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		btnAdd.setBounds(183, 10, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(282, 10, 89, 23);
		contentPane.add(btnPrint);
	}
	
	ArrayList<Salesman> cc = new ArrayList<Salesman>();
	public void add()
	{
		//cc = new ArrayList<Salesman>();
		Salesman a = new Salesman();
		a.name = textField_name.getText();
		a.totalsell = Integer.parseInt(textField_totalsell.getText());
		cc.add(a);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Totalsell");
		
		for(Salesman c : cc)
		{
			model.addRow(new Object[]{"" + c.name,c.totalsell});
		}
		table.setModel(model);
		
		
		
	}
}
