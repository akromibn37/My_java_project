import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Dictionary1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea txtArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dictionary1 frame = new Dictionary1();
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
	public Dictionary1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWord = new JLabel("word");
		lblWord.setBounds(62, 55, 46, 14);
		contentPane.add(lblWord);
		
		JLabel lblMeaning = new JLabel("meaning");
		lblMeaning.setBounds(62, 81, 46, 14);
		contentPane.add(lblMeaning);
		
		textField = new JTextField();
		textField.setBounds(130, 52, 108, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOkButton = new JButton("OK");
		btnOkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mytext_tosearch = textField.getText().trim().toUpperCase();
				File f = new File("dictionary2.txt");
				Scanner sc = null;
				boolean isFound = false; 
				
				try
				{
					System.out.println("start read File");
					sc = new Scanner(f,"UTF8");
					while(sc.hasNext())
					{
						String word =sc.nextLine();						
						String meaning =  sc.nextLine();
						//System.out.println(meaning);
						if(word.equals(mytext_tosearch))
						{
							txtArea.setText(meaning);						
							isFound = true;
							break;
						}
					}
					if(!isFound)
					{
						JOptionPane.showMessageDialog(Dictionary1.this,"Word NOT FOUND" );
					}
					System.out.println("end read file");
				}catch(FileNotFoundException e1)
				{
					System.out.println("this is error");
					e1.printStackTrace();
				}
				finally
				{
					System.out.println("This is finally");
					if(sc != null)
					{
					sc.close();
					}
				}
				
			}
		});
		btnOkButton.setBounds(278, 51, 89, 23);
		contentPane.add(btnOkButton);
		
		txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		txtArea.setBackground(Color.YELLOW);
		txtArea.setForeground(Color.BLACK);
		txtArea.setBounds(128, 83, 239, 148);
		contentPane.add(txtArea);
		
		JLabel lblThisIsMy = new JLabel("This is my Dictionary");
		lblThisIsMy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThisIsMy.setBounds(92, 11, 200, 20);
		contentPane.add(lblThisIsMy);
	}
}
