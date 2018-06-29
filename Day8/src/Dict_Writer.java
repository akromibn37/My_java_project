import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Dict_Writer extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2; 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dict_Writer frame = new Dict_Writer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 
	public Dict_Writer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWord = new JLabel("word");
		lblWord.setBounds(51, 54, 56, 16);
		contentPane.add(lblWord);
		
		JLabel lblMeaning = new JLabel("meaning");
		lblMeaning.setBounds(51, 83, 56, 16);
		contentPane.add(lblMeaning);
		
		txt1 = new JTextField();
		txt1.setBounds(164, 51, 116, 22);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(164, 80, 116, 22);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrintWriter pw;
				try {
					File f = new File("D://dict.txt") ;
					
					FileOutputStream outs = new FileOutputStream(f,true);
					OutputStreamWriter ww= new OutputStreamWriter(outs,"utf8"); // ทำให้ใช้ ภาษา ไทยได้
					BufferedWriter bw= new BufferedWriter(ww); 
					pw = new PrintWriter(bw);
					pw.println(txt1.getText().trim().toLowerCase()+","+ txt2.getText());
					pw.close();
				} catch (FileNotFoundException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnOk.setBounds(119, 127, 97, 25);
		contentPane.add(btnOk);
	}
}
