import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Dictionary extends JFrame {

	private JPanel contentPane;
	private JTextField txt2;
	private JTextField txt1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dictionary frame = new Dictionary();
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
	public Dictionary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setBounds(153, 46, 103, 25);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\aaa.txt");
				FileOutputStream outs = null;
				PrintWriter pw = null;
				try 
				{
					outs = new FileOutputStream(f,true);
					
					pw = new PrintWriter(outs);
					pw.print(txt1.getText() + "," + txt2.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pw.close();
				
			}
		});
		btnNewButton.setBounds(153, 171, 103, 32);
		contentPane.add(btnNewButton);
		
		txt2 = new JTextField();
		txt2.setBounds(153, 100, 103, 25);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(67, 51, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(67, 105, 46, 14);
		contentPane.add(lblSurname);
	}
}
